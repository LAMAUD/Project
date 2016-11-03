package fr.treeptik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.controller.NumeroController;
import fr.treeptik.dao.NumeroDAO;
import fr.treeptik.pojo.Numero;
import fr.treeptik.service.NumeroService;

@Service
public class NumeroServiceImpl implements NumeroService {

	@Autowired
	private NumeroDAO dao;
	
	@Autowired
	private NumeroController controller;

	public NumeroServiceImpl() {

	}

	@Override
	public void creer() {
		Numero numero = new Numero();
		numero.setNumero(controller.saisieNumero());
		numero.setDescription(controller.saisieDescription());
		dao.creer(numero);
		
	}

}
