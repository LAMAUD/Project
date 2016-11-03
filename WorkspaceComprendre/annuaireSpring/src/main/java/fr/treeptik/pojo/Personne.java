package fr.treeptik.pojo;

import java.io.Serializable;
import java.util.List;

public class Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nom;
	private String prenom;
	private List<Numero> lstNumeros;

	public Personne() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Numero> getLstNumeros() {
		return lstNumeros;
	}

	public void setLstNumeros(List<Numero> lstNumeros) {
		this.lstNumeros = lstNumeros;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", lstNumeros=" + lstNumeros + "]";
	}

}
