package com.desafio.desafio;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ApiControl {
	
	public HttpHeaders makeHeader() {
		HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setContentType(MediaType.APPLICATION_JSON);
		authHeaders.set("Accept", "application/json");
		authHeaders.set("client_id", Auth.clientId);
		authHeaders.set("access_token", Auth.accessToken);
		return authHeaders;
	}
	

}
