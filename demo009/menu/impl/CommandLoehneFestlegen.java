package demo009.menu.impl;

import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Lager;
import demo009.model.Niederlassung;

public class CommandLoehneFestlegen implements Command {

	@Override
	public String menuItemName() {
		return "L�hne festlegen";
	}

	@Override
	public void execute(ApplicationContext context) {
		// TODO Auto-generated method stub
		System.out.println("========== "+menuItemName());
				
		Scanner myScanner = new Scanner(System.in);
		
		for(int i = 0; i < context.getNiederlassungen().size(); i++) {
			
			Niederlassung nl = context.getNiederlassungen().get(i);
			System.out.println(nl.getOrt() + " : " + nl.getLohn());
			
			System.out.println("Soll der Lohn angepasst werden? (y/n)");
			String newuserInput1 = myScanner.nextLine();

			if(newuserInput1.equals("y")) {
				
				String newuserInput2 = myScanner.nextLine();
				nl.setLohn(Integer.parseInt(newuserInput2));
			}		
		}
		
		Lager l = context.getLager();
		System.out.println(l.getOrt() + " : " + l.getLohn());
		
		System.out.println("Soll die Lohn angepasst werden? (y/n)");
		String newuserInput1 = myScanner.nextLine();
		
		if(newuserInput1.equals("y")) {
			String newuserInput = myScanner.nextLine();
			l.setLohn(Integer.parseInt(newuserInput));
		}
		
		
	}
}
