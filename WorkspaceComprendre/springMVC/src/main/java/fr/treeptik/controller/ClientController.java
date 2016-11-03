package fr.treeptik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.dao.RoleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.model.Role;
import fr.treeptik.service.ClientService;
import fr.treeptik.validator.ClientValidator;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

	private final static Logger LOGGER = Logger.getLogger(ClientController.class);

	@Autowired
	private ClientValidator clientValidator;

	@Autowired
	private ClientService clientService;

	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping(value = "/client.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {
		ModelAndView modelAndView = new ModelAndView("client");
		modelAndView.addObject("client", new Client());
		
		List<Role> roles = roleDAO.findAll();
		modelAndView.addObject("roles", roles);
		
		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {
		
//		ModelAndView modelAndView = new ModelAndView("client", "client", client);
		ModelAndView modelAndView = new ModelAndView("client");
		
		Client client = clientService.findById(id);
		modelAndView.addObject("client", client);
		
		List<Role> roles = roleDAO.findAll();
		modelAndView.addObject("roles", roles);
		
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listClient(HttpServletRequest request) throws ServiceException {
		String clientNom = SecurityContextHolder.getContext().getAuthentication().getName();
		if (request.getSession().getAttribute("userSessionId") == null) {
			Client client = clientService.findByName(clientNom);
			request.getSession().setAttribute("userSessionId", client.getId());
		}
		return new ModelAndView("list-client", "clients", clientService.findAll());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		clientService.remove(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView saveClient(@Valid Client client, BindingResult result)
			throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("client");

		clientValidator.validate(client, result);

//		if (result.hasErrors()) {
//			for (ObjectError objectError : result.getAllErrors()) {
//				LOGGER.info(objectError.getDefaultMessage());
//			}
//			client.setNom(null);
//			client.setPassword(null);
//			client.setRole(null);
//			
//			List<Role> roles = roleDAO.findAll();
//			modelAndView.addObject("client",client);
//			modelAndView.addObject("roles", roles);
//			return modelAndView;
//		}
		client = clientService.save(client);
		modelAndView = new ModelAndView("redirect:list.do");
		return modelAndView;
	}

}
