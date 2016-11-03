package fr.treeptik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.service.ClientService;

@Controller
@RequestMapping("/rest")
public class ClientRestController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/client/list.do", method = RequestMethod.GET)
	public ModelAndView showAjaxPage() {
		return new ModelAndView("simple-ajax")
				.addObject("client", new Client());
	}

	@RequestMapping(value = "/id/{id}/find.do", method = RequestMethod.GET)
	public @ResponseBody
	Client findOne(@PathVariable("id") Integer id) throws ServiceException {
		Client client = new Client();
		client.setId(id);
		return clientService.findOne(client);
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	@ResponseBody
	public Client addClient(@RequestBody Client client) throws ServiceException {
		return clientService.save(client);

	}

	@RequestMapping(value = "/findAll.do", method = RequestMethod.GET)
	public @ResponseBody
	List<Client> findAll() throws ServiceException {
		return clientService.findAll();
	}
}
