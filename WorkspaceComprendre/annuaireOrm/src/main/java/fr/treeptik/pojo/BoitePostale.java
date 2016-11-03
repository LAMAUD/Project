package fr.treeptik.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BoitePostale implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String codePostal;
	private String cedex;
	
	@OneToOne(mappedBy="boitePostale")
	private Adresse adresse;
	
	public BoitePostale() {
		
	}
	
	public BoitePostale(Integer id, String codePostal, String cedex) {
		this.id = id;
		this.codePostal = codePostal;
		this.cedex = cedex;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getCedex() {
		return cedex;
	}
	
	public void setCedex(String cedex) {
		this.cedex = cedex;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
		
	@Override
	public String toString() {
		return "BoitePostale [id=" + id + ", codePostal=" + codePostal
				+ ", cedex=" + cedex + "]";
	}
	

}
