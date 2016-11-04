package fr.cla.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.cla.pojo.User;

public interface DAOUser extends JpaRepository<User, Long> {

    @Query( "select u from User u WHERE u.nom LIKE ?1" )
    User findByName( @Param( "1" ) String userNom );
}
