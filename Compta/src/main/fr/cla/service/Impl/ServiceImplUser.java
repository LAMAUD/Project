package fr.cla.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cla.DAO.Impl.DAOImplUser;
import fr.cla.pojo.User;
import fr.cla.service.ServiceUser;

@Service
public class ServiceImplUser implements ServiceUser {

    @Autowired
    private DAOImplUser dAOImplUser;

    public void createUser( User user ) {

        dAOImplUser.save( user );

    }

}
