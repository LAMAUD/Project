package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Client;

@Repository
public class ClientJPADAO implements ClientDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Client save(Client client) throws DAOException {
		try {
			if (client.getId() != null) {
				entityManager.merge(client);
			} else {
				entityManager.persist(client);
			}
		} catch (PersistenceException e) {
			throw new DAOException("erreur save client", e);
		}
		return client;
	}

	@Override
	public Client findOne(Integer id) throws DAOException {
		Client client;
		try {
			client = entityManager.find(Client.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save client", e);
		}
		return client;
	}

	@Override
	public void delete(Client client) throws DAOException {
		try {
			entityManager.remove(client);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save client", e);
		}

	}

	@Override
	public List<Client> findAll() throws DAOException {
		try {
			return entityManager.createQuery("select c from Client c",
					Client.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur save client", e);
		}

	}

	@Override
	public Client findByName(String clientNom) throws DAOException {
		try {
			return entityManager
					.createQuery("select c from Client c WHERE c.nom LIKE ?1",
							Client.class).setParameter(1, clientNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName client", e);
		}
	}

	@Override
	public Long countByName(String clientNom) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(c) from Client c WHERE c.nom LIKE ?1",
							Long.class).setParameter(1, clientNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName client", e);
		}

	}
	
	@Override
	public Long countByNameAndId(String clientNom, Integer id) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(c) from Client c WHERE c.nom LIKE ?1 and c.id<> ?2",
							Long.class).setParameter(1, clientNom).setParameter(2, id)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName client", e);
		}

	}
}
