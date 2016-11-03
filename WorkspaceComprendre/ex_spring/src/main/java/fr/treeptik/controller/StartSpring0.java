package fr.treeptik.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.treeptik.model.ResourceInjected;
import fr.treeptik.model.StructureDeDonnees;
import fr.treeptik.model.UnBean2;

public class StartSpring0 {
	
	
	
	

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContextResource.xml");
		ResourceInjected r = context.getBean("res", ResourceInjected.class);
		System.out.println(r);

		// firstApplicationContextTest();

		// injectionStructureDeDonneesTest();

		// injectionBySettersTest();

		// injectionByConstructorTest();

		// injectionDeCollaborateurTest();

	}

	/**
	 * voir xml correspondant
	 */
	private static void firstApplicationContextTest() {
		// Chargement statique du contexte via XML
		// variable context de Type ApplicationContext
		// implémentation FileSystemXmlApplicationContext

		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"applicationContext0.xml");

		// getBean ne connaît pas par avance la classe de l’objet
		User user = (User) context.getBean("user");
		// User user = context.getBean("user",User.class);
		System.out.println("Utilisateur : " + user.getFirstName() + " "
				+ user.getLastName() + " date :" + user.getCreationDate());
	}

	/**
	 * voir xml correspondant
	 */
	private static void injectionBySettersTest() {
		// Chargement statique du contexte via XML
		// variable context de Type ApplicationContext
		// implémentation FileSystemXmlApplicationContext

		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"injectionBySetters.xml");

		// getBean ne connaît pas par avance la classe de l’objet
		UnBean2 unBean2 = (UnBean2) context.getBean("monBean2");
		System.out.println(unBean2);
	}

	/**
	 * voir xml correspondant
	 */
	private static void injectionByConstructorTest() {
		// Chargement statique du contexte via XML
		// variable context de Type ApplicationContext
		// implémentation FileSystemXmlApplicationContext

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"injectionByConstructor.xml");

		// getBean ne connaît pas par avance la classe de l’objet
		UnBean1 unBean1 = (UnBean1) context.getBean("monBean");
		System.out.println("Mon Trop Beau Bean : " + unBean1.getChaine() + " "
				+ unBean1.getEntier());
	}

	private static void injectionStructureDeDonneesTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"injectionStructureDonnees.xml");
		StructureDeDonnees struct = context.getBean("structurededonnees",
				StructureDeDonnees.class);

		System.out.println(struct);
	}

	private static void injectionDeCollaborateurTest() {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"injectionDeCollaborateur.xml");
		UserManagerImpl userManganerImpl = context.getBean("userManager1",
				UserManagerImpl.class);

		System.out.println(userManganerImpl);
	}

}
