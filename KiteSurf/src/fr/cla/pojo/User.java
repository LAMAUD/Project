package fr.cla.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4259541263736557902L;

	private Long id;
	private String email;
	private String pass;
	private String nom;
	private Timestamp dateInscription;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Timestamp dateInscription) {
		this.dateInscription = dateInscription;
	}

}
