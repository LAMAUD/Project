package fr.treeptik.controller.impl;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.treeptik.controller.NumeroController;
import fr.treeptik.service.NumeroService;

@Controller
public class NumeroControllerImpl implements NumeroController {

	@Autowired
	private NumeroService service;

	public NumeroControllerImpl() {

	}

	@Override
	public void creer() {
		service.creer();
	}

	@Override
	public String saisieNumero() {
		System.out.println("Numéro :");
		String numero;
		Scanner scanner = new Scanner(System.in);
		numero = scanner.nextLine();
		scanner.close();
		return numero;
	}

	@Override
	public String saisieDescription() {
		System.out.println("Description :");
		String desc;
		Scanner scanner = new Scanner(System.in);
		desc = scanner.nextLine();
		scanner.close();
		return desc;

	}

}
