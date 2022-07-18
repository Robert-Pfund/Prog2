package demo009.menu.impl;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.misc.DisplayService;


public class CommandPrintLager implements Command {

	@Override
	public String menuItemName() {
		return "Lager ausgeben";
	}

	@Override
	public void execute(ApplicationContext context) {
		
		DisplayService.anzeigenLager(context);
	}
	
}



