package fr.treeptik.runtime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.treeptik.presentation.NumeroPresentation;
import fr.treeptik.presentation.impl.NumeroPresentationConsole;

@Component
public class Runtime {

	private static NumeroPresentation presentation;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/WEB-INF/applicationContext.xml");
		presentation = context.getBean("numeroPresentationConsole", NumeroPresentationConsole.class);
		presentation.home();

	}

}
