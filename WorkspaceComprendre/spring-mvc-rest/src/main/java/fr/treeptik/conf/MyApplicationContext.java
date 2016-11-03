package fr.treeptik.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // Annotation pour la gestion de la conf pour Spring
@EnableWebMvc // Utilisation du MVC
@Import(value = { DatabaseConfiguration.class, SecurityConfiguration.class, DispatcherServletConfiguration.class })  // Class qui sont chargée : pour la database, le contexte de sécurité, pour la servlet (dispatcher)
@ComponentScan(basePackages = { "fr.treeptik" }) // les fichiers à scanner
@PropertySource(value = "classpath:/config.properties") // fichiers properties
public class MyApplicationContext  {


}