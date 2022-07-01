package demo009.menu.impl;

import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Niederlassung;

public class CommandEinstellen implements Command {

	@Override
	public String menuItemName() {
		return "Arbeitende einstellen";
	}

	@Override
	public void execute(ApplicationContext context) {
		// TODO Auto-generated method stub
		System.out.println("========== "+menuItemName());
		
		Scanner myScanner = new Scanner(System.in);

		for(int i = 0; i < context.getNiederlassungen().size(); i++) {
			
			Niederlassung nl = context.getNiederlassungen().get(i);
			
			System.out.println("aktuelle Mitarbeiter in " + nl.getOrt() + ": "
					+ nl.getArbeiter());

		
			System.out.println("einzustellende Mitarbeiter: ");
			int neueMitarbeiter = Integer.parseInt(myScanner.nextLine());
		
			nl.einstellen(neueMitarbeiter);
		}
	}
}
