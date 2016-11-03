package fr.treeptik.pojo;

import java.io.Serializable;
import java.util.List;

public class Annuaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private List<Personne> lstPersonnes;

	public Annuaire() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Personne> getLstPersonnes() {
		return lstPersonnes;
	}

	public void setLstPersonnes(List<Personne> lstPersonnes) {
		this.lstPersonnes = lstPersonnes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Annuaire [id=" + id + ", lstPersonnes=" + lstPersonnes + "]";
	}

}
