package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Client;

public interface ClientDAO {

	Client save(Client client) throws DAOException;

	List<Client> findAll() throws DAOException;

	void delete(Client client) throws DAOException;

	Client findOne(Integer id) throws DAOException;

	Client findByName(String clientNom) throws DAOException;

	Long countByName(String clientNom) throws DAOException;

	Long countByNameAndId(String clientNom, Integer id) throws DAOException;

}
