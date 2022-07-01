package demo009.menu.impl;

import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Lager;
import demo009.model.Niederlassung;

public class CommandLoehneFestlegen implements Command {

	@Override
	public String menuItemName() {
		return "Löhne festlegen";
	}

	@Override
	public void execute(ApplicationContext context) {
		// TODO Auto-generated method stub
		System.out.println("========== "+menuItemName());
				
		Scanner myScanner = new Scanner(System.in);
		
		for(int i = 0; i < context.getNiederlassungen().size(); i++) {
			
			Niederlassung nl = context.getNiederlassungen().get(i);
			System.out.println(nl.getOrt() + " : " + nl.getLohn());
				
			String newuserInput = myScanner.nextLine();
			nl.setLohn(Integer.parseInt(newuserInput));
		}
		
		Lager l = context.getLager();
		System.out.println(l.getOrt() + " : " + l.getLohn());
		
		String newuserInput = myScanner.nextLine();
		l.setLohn(Integer.parseInt(newuserInput));
		
	}
}
