package fr.treeptik.model;

import java.util.Arrays;
import java.util.Date;

/**
 * @author herve
 * 
 */
public class UnBean2 {
	private String chaine;
	private int entier;
	private float reel;
	private boolean booleen;
	private char caractere;
	private java.util.Locale localisation;
	private java.net.URL url;
	private java.io.File fichier;
	private byte[] tab2bytes;
	private String[] tab2chaines;
	private Date date;

	// définition des accesseurs et modificateurs de chaque attribut
	public String getChaine() {
		return chaine;
	}

	public void setChaine(String chaine) {
		this.chaine = chaine;
	}

	public int getEntier() {
		return entier;
	}

	public void setEntier(int entier) {
		this.entier = entier;
	}

	public float getReel() {
		return reel;
	}

	public void setReel(float reel) {
		this.reel = reel;
	}

	public boolean isBooleen() {
		return booleen;
	}

	public void setBooleen(boolean booleen) {
		this.booleen = booleen;
	}

	public char getCaractere() {
		return caractere;
	}

	public void setCaractere(char caractere) {
		this.caractere = caractere;
	}

	public java.util.Locale getLocalisation() {
		return localisation;
	}

	public void setLocalisation(java.util.Locale localisation) {
		this.localisation = localisation;
	}

	public java.net.URL getUrl() {
		return url;
	}

	public void setUrl(java.net.URL url) {
		this.url = url;
	}

	public java.io.File getFichier() {
		return fichier;
	}

	public void setFichier(java.io.File fichier) {
		this.fichier = fichier;
	}

	public byte[] getTab2bytes() {
		return tab2bytes;
	}

	public void setTab2bytes(byte[] tab2bytes) {
		this.tab2bytes = tab2bytes;
	}

	public String[] getTab2chaines() {
		return tab2chaines;
	}

	public void setTab2chaines(String[] tab2chaines) {
		this.tab2chaines = tab2chaines;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UnBean2 [chaine=" + chaine + ", entier=" + entier + ", reel="
				+ reel + ", booleen=" + booleen + ", caractere=" + caractere
				+ ", localisation=" + localisation + ", url=" + url
				+ ", fichier=" + fichier + ", tab2bytes="
				+ Arrays.toString(tab2bytes) + ", tab2chaines="
				+ Arrays.toString(tab2chaines) + ", date=" + date + "]";
	}

}
