package fr.cla.pojo;

import java.io.Serializable;

public class User implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 37698613339020794L;
	
	private String nom;
	private String email;
	private String password;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
