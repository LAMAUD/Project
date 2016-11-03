package fr.treeptik.presentation.impl;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.treeptik.controller.NumeroController;
import fr.treeptik.presentation.NumeroPresentation;

@Component
public class NumeroPresentationConsole implements NumeroPresentation {

	@Autowired
	private NumeroController controller;

	private Scanner scanner;

	public NumeroPresentationConsole() {
		scanner = new Scanner(System.in);
	}

	public void menu() {
		System.out.println("C. Créer un numero");
		System.out.println("Q. Quitter");
	}

	public void router(String saisie) {
		saisie = saisie.toUpperCase();
		switch (saisie) {
		case "C":
			System.out.println("creer");
			controller.creer();
			break;
		default:
			break;
		}
	}

	@Override
	public void home() {
		String saisie;
		do {
			this.menu();
			saisie = scanner.nextLine();
			this.router(saisie);
		} while (!saisie.equalsIgnoreCase("Q"));
		scanner.close();
	}
}
