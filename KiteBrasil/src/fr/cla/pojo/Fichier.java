package fr.cla.pojo;

import java.io.Serializable;

import javax.servlet.http.Part;

public class Fichier implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3567505290256368156L;

    private String            description;
    private String            nom;
    private Part              part;

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

    public Part getPart() {
        return part;
    }

    public void setPart( Part part ) {
        this.part = part;
    }

}
