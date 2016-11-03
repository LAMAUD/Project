package fr.cla.DAO.Impl;

import org.springframework.stereotype.Repository;

import fr.cla.DAO.DAOUser;
import fr.cla.pojo.User;

@Repository
public class DAOImplUser extends GenericDAOImpl<User> implements DAOUser {

    public DAOImplUser() {
        super();
        // TODO Auto-generated constructor stub
    }

}
