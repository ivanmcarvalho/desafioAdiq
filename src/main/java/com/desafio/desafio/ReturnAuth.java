package com.desafio.desafio;

public class ReturnAuth {
	private String accessToken;
	private String tokenType;
	private String expiresIn;
	private String scope;

	// Getter Methods
	public String getAccessToken() {
		return accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public String getScope() {
		return scope;
	}

	// Setter Methods

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
