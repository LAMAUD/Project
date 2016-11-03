package fr.treeptik.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.service.ClientService;

@Controller
@RequestMapping("/restfull")
public class RestController {

	Logger logger = Logger.getLogger(RestController.class);

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public @ResponseBody List<Client> listAll() throws ServiceException {
		return clientService.findAll();
	}

	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public @ResponseBody Client findById(@PathVariable("id") Integer id)
			throws ServiceException {
		Client client = new Client();
		client.setId(id);
		Client findOne = clientService.findOne(client);
		System.out.println(findOne);
		return findOne;
	}

	@RequestMapping(value = "/find/nom/{nom}/age/{age}/id/{id}", method = RequestMethod.GET)
	public @ResponseBody Client findOne(@PathVariable("id") Integer id,
			@PathVariable("nom") String nom, @PathVariable("age") Integer age)
			throws ServiceException {
		logger.debug(nom + " " + age);
		Client client = new Client();
		client.setId(id);
		Client findOne = clientService.findOne(client);
		System.out.println(findOne);
		return findOne;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Client addClient(@RequestBody Client client)
			throws ServiceException {
		return clientService.save(client);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public @ResponseBody Client updateClient(@RequestBody Client client,
			@PathVariable("id") Integer id, BindingResult result)
			throws ServiceException {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());

			}
		}
		client.setId(id);
		return clientService.update(client);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteClient(@PathVariable("id") Integer id,
			BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());

			}
		}
		try {
			Client client = new Client();
			client.setId(id);
			clientService.remove(client);
		} catch (ServiceException e) {
			return "error";
		}
		return "Successfull";
	}
}
