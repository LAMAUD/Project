package fr.cla.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

import fr.cla.dao.Exception.DAOConfigurationException;

public class DAOFactory {

    private static final String FICHIER_PROPERTIES       = "/WEB-INF/properties/messages.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
    
    private String              url;
    private String              username;
    private String              password;
    
    
	public DAOFactory(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DAOFactory getInstance() throws DAOConfigurationException {
		
		Properties properties = new Properties();
		
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );
        
        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }
        
        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }
        
        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }
        
        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
		
	}
	
	   public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* Méthode chargée de fournir une connexion à la base de données */
       public Connection getConnection() throws SQLException {
       return (Connection) DriverManager.getConnection( url, username, password );
   }
       
       /*
        * Méthodes de récupération de l'implémentation des différents DAO (un seul
        * pour le moment)
        */
//       public UtilisateurDao getUtilisateurDao() {
//           return new UtilisateurDaoImpl( this );
//       }
}
