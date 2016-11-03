package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Client;

@Component
public class ClientValidator implements Validator {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Client.class);
	}

	@Override
	public void validate(Object client, Errors errors) {

		Client c = (Client) client;

		if (c.getNom() == null) {
			errors.rejectValue("nom", "hack", "Le nom est nul");
		}

		Integer id = c.getId();
		if (id != null) {

			try {
				Long countByNameAndId = clientDAO.countByNameAndId(c.getNom(),
						id);

				if (countByNameAndId != 0) {
					errors.rejectValue("nom", "hack", "Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Long countByNameAndId = clientDAO.countByName(c.getNom());

				if (countByNameAndId != 0) {
					errors.rejectValue("nom", "hack", "Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}

}
