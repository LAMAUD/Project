package fr.cla.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cla.DAO.DAOUser;
import fr.cla.pojo.User;
import fr.cla.service.ServiceUser;

@Service
public class ServiceImplUser implements ServiceUser {

    @Autowired
    DAOUser dao;

    public void createUser( User user ) {

        dao.save( user );

    }

}
