package fr.cla.dao.interf;

import fr.cla.dao.Exception.DAOException;
import fr.cla.pojo.User;

public interface UserDAO {
	
	void create (User user) throws DAOException;
	User read(String id) throws DAOException;

}
