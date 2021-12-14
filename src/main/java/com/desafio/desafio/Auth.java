package com.desafio.desafio;

import java.net.URI;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



public class Auth {
	
	private String authorization;	
	private String urlProducao = "https://ecommerce.adiq.io";
	private String urlHomologacao = "https://ecommerce-hml.adiq.io";
	static  String clientId;
	static  String accessToken;
	static  String resposta;
	static  String tokenType;
	static  String expiresIn;
	static  String scope;
	static  String urlApi;	
	static  boolean autorizado = false;

	Auth(String grantType, String clienteId, String clientSecret, String emproducao) {
		authorization = "Basic " + Base64.getEncoder().encodeToString((clienteId + ":" + clientSecret).getBytes());
		ReturnAuth returnAuth = new ReturnAuth();
		HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setContentType(MediaType.APPLICATION_JSON);
		authHeaders.set("Accept", "application/json");
		authHeaders.setBasicAuth("Authorization", authorization);
		UriComponentsBuilder apiUriBuilder = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("ecommerce-hml.adiq.io")
				.path("auth/oauth2/v1/token");		
				//apiUriBuilder.queryParam("grantType", "client_credentials");
				URI pullsUri = apiUriBuilder.build().encode().toUri();


		RestTemplate rest = new RestTemplate();
		String restBody = "{\r\n  \"grantType\": \"" + grantType + "\"\r\n}"; 
		HttpEntity<String> authEntity = new HttpEntity<String>(restBody, authHeaders);
		urlApi   = emproducao.equals("S") ? urlProducao : urlHomologacao;  
		clientId = clienteId;
		try {
	
			ResponseEntity<ReturnAuth> entity = rest.exchange(pullsUri, HttpMethod.POST, authEntity, ReturnAuth.class);
			resposta    = entity.getStatusCode().toString();			
			accessToken = entity.getBody().getAccessToken();
			tokenType   = entity.getBody().getTokenType();
			expiresIn   = entity.getBody().getExpiresIn();
			scope	    = entity.getBody().getScope();			
			autorizado  = true;
			
		} catch (RestClientException e) {
			
			resposta    = e.getMessage(); 
			accessToken = "Dados de acesso não liberados";
			autorizado  = false;
			
		}
		
	}

}
