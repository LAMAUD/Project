package fr.cla.pojo;

import java.io.Serializable;


public class Client implements Serializable{

	
	public Client() {
		super();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4259541263736557902L;
	
	private String nom;
	private String prenom;
	String adresse;
	String telNumber;
	String mail;
	
	
	
	
	

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
