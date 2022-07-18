package com.alkemyApi.seguridad;

public class JWTAuthResonseModel {

	private String tokenDeAcceso;
	private String tipoDeToken = "Bearer";

	public JWTAuthResonseModel(String tokenDeAcceso) {
		super();
		this.tokenDeAcceso = tokenDeAcceso;
	}

	public JWTAuthResonseModel(String tokenDeAcceso, String tipoDeToken) {
		super();
		this.tokenDeAcceso = tokenDeAcceso;
		this.tipoDeToken = tipoDeToken;
	}

	public String getTokenDeAcceso() {
		return tokenDeAcceso;
	}

	public void setTokenDeAcceso(String tokenDeAcceso) {
		this.tokenDeAcceso = tokenDeAcceso;
	}

	public String getTipoDeToken() {
		return tipoDeToken;
	}

	public void setTipoDeToken(String tipoDeToken) {
		this.tipoDeToken = tipoDeToken;
	}
}
