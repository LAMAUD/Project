package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	public Client findById(Integer id) throws ServiceException {
		try {
			return clientDAO.findOne(id);

		} catch (DAOException e) {
			throw new ServiceException("Erreur find client", e);
		}
	}

	@Transactional
	@Override
	public Client save(Client client) throws ServiceException {
		try {
			return clientDAO.save(client);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save client", e);
		}
	}

	@Transactional
	@Override
	public void remove(Integer id) throws ServiceException {
		try {
			Client client = clientDAO.findOne(id);
			clientDAO.delete(client);
		} catch (DAOException e) {
			throw new ServiceException("Erreur delete client", e);

		}
	}

	@Override
	public List<Client> findAll() throws ServiceException {
		try {
			return clientDAO.findAll();

		} catch (DAOException e) {
			throw new ServiceException("Erreur save client", e);
		}
	}

	@Override
	public Client findByName(String clientNom) throws ServiceException {
		try {
			return clientDAO.findByName(clientNom);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save client", e);
		}
	}
}
