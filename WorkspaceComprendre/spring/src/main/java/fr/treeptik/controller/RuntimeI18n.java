package fr.treeptik.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.treeptik.model.Commentaire;
import fr.treeptik.service.impl.CommentaireServiceImpl;

public class RuntimeI18n {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"applicationContext.xml");
		commentaireService = context.getBean("commentaireServiceImpl",
				CommentaireServiceImpl.class);
		
		// Article article = new Article();
		// Auteur auteur = new Auteur();
		// auteur.setName("Beaudelaire");
		
		Commentaire commentaire = new Commentaire();
		
		commentaire.setId(1L);
		commentaire.setText("Hack.sign");
		
		commentaireService.create(commentaire);
		
	}
	

}
