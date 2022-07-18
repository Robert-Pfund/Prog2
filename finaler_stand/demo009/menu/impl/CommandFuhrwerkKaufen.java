package demo009.menu.impl;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Fuhrpark;

import java.util.*;

public class CommandFuhrwerkKaufen implements Command {
	
	Scanner myScanner = new Scanner(System.in);

	@Override
	public String menuItemName() {
		return "Fuhrwerke kaufen";
	}
	
	@Override
	public void execute(ApplicationContext context) {
		
		Fuhrpark fp = context.getFuhrpark();
		
		System.out.println("Aktuelle Anzahl an Fahrzeugen: " + fp.getAnzahlFuhrwerke());
		System.out.print("Anzahl der zu kaufenden Fuhrwerke: ");
		int neueFuhrwerke = Integer.parseInt(myScanner.nextLine());
		
		context.guthabenMinus(neueFuhrwerke * fp.getPreisFuhrwerk());
		
		fp.addFuhrwerke(neueFuhrwerke);
	}	
}
