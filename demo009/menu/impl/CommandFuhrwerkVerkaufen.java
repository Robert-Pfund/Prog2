package demo009.menu.impl;

import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Fuhrpark;

public class CommandFuhrwerkVerkaufen implements Command {

	Scanner myScanner = new Scanner(System.in);

	@Override
	public String menuItemName() {
		return "Fuhrwerke verkaufen";
	}
	
	@Override
	public void execute(ApplicationContext context) {
		
		Fuhrpark fp = context.getFuhrpark();
		
		System.out.println("Aktuelle Anzahl an Fahrzeugen: " + fp.getAnzahlFuhrwerke());
		System.out.print("zuverkaufende Fuhrwerke: ");
		int zuVerkaufendeFuhrwerke = Integer.parseInt(myScanner.nextLine());
		
		int verkauferloes = zuVerkaufendeFuhrwerke * fp.getPreisFuhrwerk();
		
		context.guthabenPlus(verkauferloes);
				
		fp.addFuhrwerke(zuVerkaufendeFuhrwerke * -1);
	}	
	
	
}
