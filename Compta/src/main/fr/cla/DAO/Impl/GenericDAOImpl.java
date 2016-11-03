package fr.cla.DAO.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.cla.DAO.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    @PersistenceContext
    EntityManager    entityManager;

    private Class<T> type;

    public void save( T t ) {
        entityManager.persist( t );
    }

}
