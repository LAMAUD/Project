package fr.cla.pojo;

import java.io.Serializable;

public class Fichier implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3567505290256368156L;

    private String            description;
    private String            nom;

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

}
