package fr.treeptik.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.model.Client;

@Component
public class ClientValidator implements Validator {

	@Override
	public boolean supports(Class<?> client) {
		return client.getClass().equals(Client.class);
	}

	@Override
	public void validate(Object client, Errors errors) {
		Client clie = (Client) client;
		if (clie.getAge() < 0 || clie.getAge() > 90) {
			errors.rejectValue("age", "erreur.age");

		}

	}

}
