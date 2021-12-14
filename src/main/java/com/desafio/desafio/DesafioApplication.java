package com.desafio.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DesafioApplication.class, args);
		
		RestTemplate template = new RestTemplate();
		
		//https://viacep.com.br/ws/03614010/json
		
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("viacep.com.br/ws")
				.path("03614010/json")
				.build();
				
		
		ResponseEntity<Viacep> entity = template.getForEntity(uri.toUriString(), Viacep.class);
		
		System.out.println("Logradouro.: " + entity.getBody().getLogradouro());
		System.out.println("Complemento: " + entity.getBody().getComplemento());
		System.out.println("Bairro.....: " + entity.getBody().getBairro());
		System.out.println("CEP........: " + entity.getBody().getCep());
		System.out.println("Localidade.: " + entity.getBody().getLocalidade() + "/" +
											entity.getBody().getUf()
		                  );
		System.out.println("DDD........: " + entity.getBody().getDdd());
		System.out.println("GIA........: " + entity.getBody().getGia());
		System.out.println("SIAFI......: " + entity.getBody().getSiafi());
		
	}

}
