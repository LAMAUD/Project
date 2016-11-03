package fr.treeptik.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import fr.treeptik.dao.CommentaireDAO;
import fr.treeptik.model.Commentaire;

@Repository
public class CommentaireDAOJPA implements CommentaireDAO {

	private Resource resource;

	@PostConstruct
	private void openDatabase() {
		//
	}

	@PreDestroy
	private void closeDatabase() {
		//
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public Commentaire create(Commentaire commentaire) {
		System.out.println(commentaire);
		return commentaire;
	}

}
