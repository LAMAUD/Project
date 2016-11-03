package fr.treeptik.dao;

import fr.treeptik.dao.impl.jpa.NumeroDAOJPA;

public class DAOFactory {
	
	public static NumeroDAO createNumeroDAO() {
		return new NumeroDAOJPA();
	}

}
