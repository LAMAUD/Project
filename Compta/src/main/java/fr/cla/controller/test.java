package fr.cla.controller;

import fr.cla.pojo.User;
import fr.cla.service.ServiceUser;
import fr.cla.service.Impl.ServiceImplUser;

public class test {

    public static void main( String[] args ) {

        User user = new User();
        user.setCountry( "France" );
        user.setName( "LAMAUD" );

        ServiceUser serviceUser = new ServiceImplUser();
        serviceUser.createUser( user );
    }

}
