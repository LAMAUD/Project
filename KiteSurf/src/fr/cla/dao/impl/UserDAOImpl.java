package fr.cla.dao.impl;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import fr.cla.dao.DAOFactory;
import fr.cla.dao.Exception.DAOException;
import fr.cla.dao.interf.UserDAO;
import fr.cla.pojo.User;

public class UserDAOImpl implements UserDAO{

	private DAOFactory          daoFactory;

	UserDAOImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	@Override
	public void create(User user) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User read(String id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*
	 * Initialise la requête préparée basée sur la connexion passée en argument,
	 * avec la requête SQL et les objets donnés.
	 */
	public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = (PreparedStatement) connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

}
