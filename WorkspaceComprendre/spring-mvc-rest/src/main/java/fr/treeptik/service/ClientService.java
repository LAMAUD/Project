package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;

public interface ClientService {

	Client findById(Integer id) throws ServiceException;

	Client save(Client client) throws ServiceException;

	void remove(Integer id) throws ServiceException;

	List<Client> findAll() throws ServiceException;

	Client findByName(String clientNom) throws ServiceException;


	
	
}
