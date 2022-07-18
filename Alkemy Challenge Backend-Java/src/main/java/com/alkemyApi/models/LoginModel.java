package com.alkemyApi.models;



public class LoginModel {

	
	
	private String nombreDeUsuario;
	
	private String password;
	
	private String email;

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getPassword() {
		return password;
	}
	
	
	public LoginModel() {}
	



	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginModel(String nombreDeUsuario, String password, String email) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.password = password;
		this.email = email;
	}
	
	
}
