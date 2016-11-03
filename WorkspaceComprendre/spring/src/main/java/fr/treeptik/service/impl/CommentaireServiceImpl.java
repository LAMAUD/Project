package fr.treeptik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.CommentaireDAO;
import fr.treeptik.model.Commentaire;
import fr.treeptik.service.CommentaireService;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireDAO articleDAO;

	@Override
	public Commentaire create(Commentaire commentaire) {
		return articleDAO.create(commentaire);
	}

}
