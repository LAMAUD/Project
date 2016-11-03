package fr.treeptik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.treeptik.model.Commentaire;
import fr.treeptik.service.CommentaireService;
import fr.treeptik.service.impl.CommentaireServiceImpl;

@Component
public class Runtime {

	@Autowired
	private static CommentaireService commentaireService;

	public static void main(String[] args) {

		// Article article = new Article();
		// article.setTitle("Titre 1");
		// System.out.println(article);

		// @SuppressWarnings("resource")
		// ApplicationContext context = new
		// FileSystemXmlApplicationContext("applicationContext.xml");
		// article = context.getBean("article", Article.class);
		//
		// auteur.setId(1L);
		// auteur.setName("Beaudelaire");
		//
		// commentaire.setText("Hack.sign!");
		//
		// article.setAuteur(auteur);
		//
		// List<Commentaire> lstCom = new ArrayList<>();
		// lstCom.add(commentaire);
		//
		// article.setLstCommentaires(lstCom);
		// System.out.println(article);

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
