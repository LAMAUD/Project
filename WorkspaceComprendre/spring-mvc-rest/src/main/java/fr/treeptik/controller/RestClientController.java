package fr.treeptik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.treeptik.dao.RoleDAO;
import fr.treeptik.exception.ControllerException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.model.Role;
import fr.treeptik.service.ClientService;
import fr.treeptik.validator.ClientValidator;

@Controller
@RequestMapping(value = "/rest")
public class RestClientController {

	private final static Logger LOGGER = Logger
			.getLogger(RestClientController.class);

	@Autowired
	private ClientValidator clientValidator;

	@Autowired
	private ClientService clientService;

	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String initForm(Model model) throws ControllerException {
		List<Role> roles;
		try {
			roles = roleDAO.findAll();
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage());
			throw new ControllerException(e.getMessage(), e);
		}
		model.addAttribute("client", new Client());
		model.addAttribute("roles", roles);
		return "client";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(Model model, @PathVariable("id") Integer id)
			throws ControllerException {
		try {
			Client client = clientService.findById(id);
			model.addAttribute("client", client);
			List<Role> roles = roleDAO.findAll();
			model.addAttribute("roles", roles);

		} catch (NumberFormatException | ServiceException | DataAccessException e) {
			LOGGER.error(e.getMessage());
			throw new ControllerException(e.getMessage(), e);
		}
		return "client";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listClient(Model model, HttpServletRequest request)
			throws ServiceException {

		String clientNom = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		if (request.getSession().getAttribute("userSessionId") == null) {
			Client client = clientService.findByName(clientNom);
			request.getSession().setAttribute("userSessionId", client.getId());
		}

		List<Client> clients = clientService.findAll();
		model.addAttribute("clients", clients);
		return "list-client";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id)
			throws ControllerException {
		try {
			clientService.remove(id);
		} catch (NumberFormatException | ServiceException e) {
			LOGGER.error(e.getMessage());
			throw new ControllerException(e.getMessage(), e);
		}
		return "redirect:/rest/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute @Valid Client client, Model model,
			BindingResult result) throws ControllerException {
		try {
			clientValidator.validate(client, result);

			if (result.hasErrors()) {
				// for (ObjectError objectError : result.getAllErrors()) {
				// LOGGER.info(objectError.getDefaultMessage());
				// }
				try {
					client.setPassword(null);

					List<Role> roles = roleDAO.findAll();
					model.addAttribute("client", client);
					model.addAttribute("roles", roles);
				} catch (DataAccessException e) {
					LOGGER.error(e.getMessage());
					throw new ControllerException(e.getMessage(), e);
				}
				return "client";
			}
			client = clientService.save(client);
		} catch (ServiceException e) {
			LOGGER.error(e.getMessage());
			throw new ControllerException(e.getMessage(), e);
		}
		return "redirect:/rest/list";
	}

}
