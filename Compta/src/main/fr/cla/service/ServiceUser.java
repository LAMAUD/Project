package fr.cla.service;

import javax.transaction.Transactional;

import fr.cla.pojo.User;

public interface ServiceUser {

    @Transactional
    void createUser( User user );

}
