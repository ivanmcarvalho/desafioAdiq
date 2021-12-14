package com.desafio.desafio;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

public class CheckPayment {
	
		
	CheckPayment(String paymentId) {
		ApiControl api = new ApiControl();
		HttpHeaders authHeaders = api.makeHeader();
		UriComponentsBuilder apiUriBuilder = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("ecommerce-hml.adiq.io")
				.path("/v1/payments/" + paymentId);		
				//apiUriBuilder.queryParam("grantType", "client_credentials");
				URI pullsUri = apiUriBuilder.build().encode().toUri();

				
		RestTemplate rest = new RestTemplate();
		String restBody = ""; 
		HttpEntity<String> authEntity = new HttpEntity<String>(restBody, authHeaders);
		try {
			
			ResponseEntity<String> entity = rest.exchange(pullsUri, HttpMethod.GET, authEntity, String.class);
			
			Gson gson = new Gson();
	        String jsonInString = entity.getBody();
	        RootPayment erros = gson.fromJson(jsonInString, RootPayment.class);
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        String dataFormatada = dateFormat.format(erros.getPaymentAuthorization().getTransactionDate());
	        String response = "Pag Id: " + erros.getPaymentAuthorization().getPaymentId() + "\n" +
	        		          "Status: " + erros.getPaymentAuthorization().getStatusDescription() + "\n" +
	        		          "Data..: " + dataFormatada;
	        
	        JOptionPane.showMessageDialog(null, response);
	        
	        //Erros[] erros= gson.fromJson(jsonInString, Erros[].class);

		} catch (RestClientException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
		
		/*
		 * {
           "paymentAuthorization":{
              "paymentId":"020080286103040952150000006201850000000000",
              "statusDescription":"Autorizada e disponível para captura",
              "transactionDate":"2019-06-27T16:34:28.508Z"
           }
        }
		 */
		
	}

}
