package fr.treeptik.i18n.messages;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.treeptik.model.Auteur;

//import fr.treeptik.model.User;

public class Testi18n {
	
	public static void main(String[] args) {

//		messageFrOREn();
//
//		noSuchMessageException();
//
//		messageWithParam();

		ApplicationContext context = new FileSystemXmlApplicationContext("config-i18n-messageSource.xml");
		TestMessageSource test = (TestMessageSource) context.getBean("testMessageSource");
		test.printMessage();
	}

	private static void messageWithParam() {
		/**
		 * Message avec tableau de paramètres
		 */

		ApplicationContext context = new FileSystemXmlApplicationContext("config-i18n-messageSource.xml");

		Auteur user = new Auteur();
		user.setId(1L);
		user.setName("Emile");
		
		String message = context.getMessage("register.user.already.exists", new Object[] { user.getName(), user.getId() }, null);
		System.out.println(message);
	}

	private static void noSuchMessageException() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"config-i18n-messageSource.xml");

		/**
		 * Dans l’appel précédent, si le MessageSource n’est pas en mesure de
		 * résoudre le message qu’on lui demande, il lance une
		 * NoSuchMessageException. Ce comportement peut être évité en passant
		 * une valeur par défaut pour le message :
		 **/
//		String msg = context.getMessage("unknown.message", null, null);
		String msg = context.getMessage("unknown.message", null, "Message inconnu !", null);
		System.out.println(msg);
	}

	private static void messageFrOREn() {
		ApplicationContext context = new FileSystemXmlApplicationContext("config-i18n-messageSource.xml");
		
		String bienvenue = context.getMessage("welcome.to.treeptik", null, null);
		System.out.println(bienvenue);

		Locale locale = new Locale("en");
		bienvenue = context.getMessage("welcome.to.treeptik", null, locale);
		System.out.println(bienvenue);

	}

}
