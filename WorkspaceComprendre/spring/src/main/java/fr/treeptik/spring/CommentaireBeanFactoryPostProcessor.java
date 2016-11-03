package fr.treeptik.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class CommentaireBeanFactoryPostProcessor implements
		BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
			throws BeansException {

//		System.out.println(arg0.getSingletonCount());
//
//		String[] singletonNames = arg0.getSingletonNames();
//		for (String single : singletonNames) {
//			System.out.println(single);
//		}

	}

}
