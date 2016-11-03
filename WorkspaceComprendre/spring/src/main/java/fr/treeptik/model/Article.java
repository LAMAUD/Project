package fr.treeptik.model;

import java.io.Serializable;
import java.util.List;

public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private Auteur auteur;
	private List<Commentaire> lstCommentaires;

	public Article() {

	}

	public Article(Long id, String title, List<Commentaire> lstCommentaires) {
		this.id = id;
		this.title = title;
		this.lstCommentaires = lstCommentaires;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Commentaire> getLstCommentaires() {
		return lstCommentaires;
	}

	public void setLstCommentaires(List<Commentaire> lstCommentaires) {
		this.lstCommentaires = lstCommentaires;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", lstCommentaires="
				+ lstCommentaires + ", auteur=" + auteur + "]";
	}

}
