package fr.treeptik.conf;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationConfiguration implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext(); // demarage de la conf.
		rootContext.register(MyApplicationContext.class); // lecture de notre config preso // classe à créer soit meme
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1); // ordre
		dispatcher.addMapping("/"); // mapping
		dispatcher.setAsyncSupported(true); // supporter les appels & reponses asynchrones

		FilterRegistration.Dynamic security = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy()); // filtre de sécurité
		EnumSet<DispatcherType> securityDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);
		security.addMappingForUrlPatterns(securityDispatcherTypes, false, "/*");
		security.setAsyncSupported(true);
		
		servletContext.addListener(new ContextLoaderListener(rootContext)); // ajout du listener
	}

}