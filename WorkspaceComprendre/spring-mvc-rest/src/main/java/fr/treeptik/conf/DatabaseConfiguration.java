package fr.treeptik.conf;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = { "fr.treeptik.dao" }) // gestion par spring data
public class DatabaseConfiguration {

	private final static Logger LOGGER = Logger.getLogger(DatabaseConfiguration.class);

	@Inject
	private Environment env; // recuperer les properties d'un fichier de conf env.getProperty()

	@Value("classpath:init.sql")
	private Resource dataScript; // fichier d'init de la bdd

	@Bean
	public DataSource dataSource() {

		LOGGER.debug("Configuring Datasource");

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// on peut récupérer toutes les propriétés injectées dans le context
		// spring (provenant du fichier config.properties) via une méthode
		// getProperty() de l'objet Environment (on peut utiliser cette façon de
		// récupérer les propriétés partout dans le projet
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));


		return dataSource;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(
			final DataSource dataSource) { // corresponds à <jdbc:initialize-database>
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator()); // cf. populator juste en dessous !
		return initializer;
	}

	private DatabasePopulator databasePopulator() { // exécution de script
		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setSqlScriptEncoding("utf-8");
		populator.addScript(dataScript);
		return populator;
	}

	/*
	 * De la même manière, on injecte tous les autres beans de configurations
	 * (entityManagerFactory, transactionManager etc...). On retrouve exactement
	 * les mêmes éléments que dans le fichier de configuration
	 * applicationContext.xml
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() { // correspond au bean de l'EntityManagerFactory
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceUnitName("persistenceUnit");
		lcemfb.setDataSource(dataSource());
		lcemfb.setJpaDialect(new HibernateJpaDialect());
		lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lcemfb.setPackagesToScan("fr.treeptik.model");
		lcemfb.afterPropertiesSet(); // valider la conf.
		return lcemfb.getObject();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return jpaVendorAdapter;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() { // le tx dans le XML
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
		return jpaTransactionManager;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

}