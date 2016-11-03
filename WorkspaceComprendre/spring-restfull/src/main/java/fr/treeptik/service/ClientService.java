package fr.treeptik.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Transactional
	@RolesAllowed(value = { "ROLE_ADMIN" })
	public Client save(Client client) throws ServiceException {
		try {
			return clientDAO.save(client);
		} catch (DAOException e) {
			throw new ServiceException("erreur save", e);
		}
	}

	@Transactional
	public Client update(Client client) throws ServiceException {
		try {
			return clientDAO.update(client);
		} catch (DAOException e) {
			throw new ServiceException("erreur update", e);

		}
	}

	@Transactional
	public void remove(Client client) throws ServiceException {
		try {
			client = clientDAO.findOne(client);
			clientDAO.remove(client);

		} catch (DAOException e) {
			throw new ServiceException("erreur remove", e);

		}
	}

	public List<Client> findAll() throws ServiceException {
		try {
			return clientDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("erreur findAll", e);

		}
	}

	public Client findOne(Client client) throws ServiceException {
		try {
			return clientDAO.findOne(client);
		} catch (DAOException e) {
			throw new ServiceException("erreur findone", e);

		}
	}

}
