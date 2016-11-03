package fr.treeptik.model;

import java.io.Serializable;
import java.util.Date;

public class Commentaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String text;
	private Date date;

	public Commentaire() {

	}

	public Commentaire(String text) {
		this.text = text;
	}

	public Commentaire(Long id, String text) {
		this.id = id;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", text=" + text + ", date=" + date
				+ "]";
	}

	

}
