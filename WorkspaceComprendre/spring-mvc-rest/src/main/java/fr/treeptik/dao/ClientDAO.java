package fr.treeptik.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.model.Client;

public interface ClientDAO extends JpaRepository<Client, Integer>{

	Client findByNom(String clientNom) throws DataAccessException;

	Long countByNom(String clientNom) throws DataAccessException;
	
	@Query("select count(c) from Client c Where c.nom = :nom and c.id != :id")
	public Long countByNameAndId(@Param("nom") String nom, @Param("id") Integer id) throws DataAccessException;

}
