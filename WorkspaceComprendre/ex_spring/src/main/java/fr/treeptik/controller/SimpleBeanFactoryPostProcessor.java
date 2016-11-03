package fr.treeptik.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

public class SimpleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory.getBeanDefinitionCount()
				+ " bean(s) défini(s)");
		
		
		
		String[] names = beanFactory.getBeanDefinitionNames();
		
		for (String string : names) {
			System.out.println(string);
		}
		System.out.println(beanFactory.getBeansWithAnnotation(Service.class)
				+ " bean(s) défini(s)");
	}
}
