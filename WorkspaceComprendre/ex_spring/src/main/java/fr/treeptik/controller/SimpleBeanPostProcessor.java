package fr.treeptik.processor;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import fr.treeptik.model.User;


// Implement l'interface BeanPostProcessor

@Component
public class SimpleBeanPostProcessor implements BeanPostProcessor {
	
	//positionne leur date de création à la date du jour
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof User) {
			((User) bean).setCreationDate(new Date());
		}
		return bean;
	}

	// Aucune opération n’est effectuée
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
}
