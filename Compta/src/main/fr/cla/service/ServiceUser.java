package fr.cla.service;

import org.springframework.transaction.annotation.Transactional;

import fr.cla.pojo.User;

public interface ServiceUser {

    @Transactional
    void createUser( User user );

}
