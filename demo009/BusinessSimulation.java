package demo009;

import demo009.menu.Menu;
import demo009.menu.Submenu;
import demo009.menu.impl.CommandAnfordern;
import demo009.menu.impl.CommandDatenSpeichern;
import demo009.menu.impl.CommandEinstellen;
import demo009.menu.impl.CommandEntlassen;
import demo009.menu.impl.CommandFuhrwerkKaufen;
import demo009.menu.impl.CommandFuhrwerkVerkaufen;
import demo009.menu.impl.CommandLoehneFestlegen;
import demo009.menu.impl.CommandPrintGuthaben;
import demo009.menu.impl.CommandPrintLager;
import demo009.menu.impl.CommandPrintNiederlassungen;
import demo009.menu.impl.CommandVerkaufen;
import demo009.misc.DisplayService;
import demo009.model.Fuhrpark;
import demo009.model.Lager;
import demo009.model.Niederlassung;
import demo009.model.Warenart;

public class BusinessSimulation {

	// ApplicationContext enthaelt alle Objekte, die für den Spielstand des
	// aktuellen Spiels relevant sind. Auch technische Aspekte des Spiels
	// koennen darin enthalten sein.
	ApplicationContext appContext;
	
	Menu mainMenu;
	
	public BusinessSimulation() {
		this.appContext = new ApplicationContext();
	}
	
	public void play() {

		initStartzustand();
		
		mainMenu = initMainMenu();
		
		int runde=1;
		while(true) {
			System.out.println("=====================================");
			System.out.println("========== Runde "+runde+" ==========");
			
			//DisplayService.anzeigenNiederlassungen(appContext);
			// TODO Aktuellen Bestand im Lager ausgeben
			DisplayService.anzeigenLager(appContext);
			// TODO aktuelle Liste der Niederlassungen ausgeben
			DisplayService.anzeigenNiederlassungen(appContext);
			// TODO Guthaben ausgeben
			DisplayService.anzeigenGuthaben(appContext);
			
			// mit Hilfe des Menus kann der Spieler seine Ressourcen verwalten
			mainMenu.showMenu();
			
			// Produktion durchfuehren
			// produzierte Menge vor dem nächsten Rundenbeginn bei allen Niederlassungen abholen und einlagern
			int produzierteMenge;
			Warenart produzierteWarenart;
			System.out.println("========== Produzierte Mengen");
			for (Niederlassung niederlassung : appContext.getNiederlassungen()) {
				niederlassung.produzieren();
				produzierteMenge=niederlassung.abholen();
				produzierteWarenart=niederlassung.getWarenart();
				appContext.getLager().einlagern(produzierteWarenart, produzierteMenge);
				System.out.printf("Ort: %10s Ware: %10s produzierte Menge: %d\n",
						niederlassung.getOrt(),niederlassung.getWarenartString(),produzierteMenge);
			}
			
			// aufraeumen am Ende der Runde
			appContext.geplanteTransporteZuruecksetzen();
			runde++;
		}
	}
	
	private void initStartzustand() {
		// Niederlassungen als Startkapital anlegen
		appContext.addNiederlassung(new Niederlassung("Einbeck", 2, Warenart.BIER, 1));
		appContext.addNiederlassung(new Niederlassung("Hamburg", 3, Warenart.KORN, 1));
		
		// es gibt ein zentrales Lager in Augsburg
		appContext.setLager(new Lager("Augsburg", 1));
		
		// Fuhrpark ist anfangs mit einem Fuhrwerk bestueckt und Preis pro
		// Fuhrwerk ist 20 Taler
		appContext.setFuhrpark(new Fuhrpark(1, 20));
		
	}
	
	private Menu initMainMenu() {
		
		// Untermenu für die Verwaltung der Niederlassungen und Transporte
		Submenu subNiederlassung = new Submenu("Niederlassungen, Anforderungen verwalten", appContext, "Zurück");
		subNiederlassung.setCommand(new CommandAnfordern());
		subNiederlassung.setCommand(new CommandEinstellen());
		subNiederlassung.setCommand(new CommandEntlassen());
		subNiederlassung.setCommand(new CommandLoehneFestlegen());
		
		// Untermenu für die Verwaltung der Fuhrwerke
		Submenu subFuhrpark = new Submenu("Fuhrpark verwalten", appContext, "Zurück");
		subFuhrpark.setCommand(new CommandFuhrwerkKaufen());
		subFuhrpark.setCommand(new CommandFuhrwerkVerkaufen());
		// TODO CommandFuhrwerkeReparieren
		
		// Untermenu für Speichern/Verwalten der Daten
		Submenu subSpeichern = new Submenu("Spielstand speichern", appContext, "Zurück");
		subSpeichern.setCommand(new CommandDatenSpeichern());
		
		// Hauptmenu
		Menu mainMenu = new Menu("Hauptmenu", appContext, "Runde beenden");
		mainMenu.setCommand(new CommandVerkaufen());
		mainMenu.setCommand(subNiederlassung);
		mainMenu.setCommand(subFuhrpark);
		mainMenu.setCommand(new CommandPrintNiederlassungen());
		mainMenu.setCommand(new CommandPrintLager());
		mainMenu.setCommand(new CommandPrintGuthaben());
		
		mainMenu.setCommand(subSpeichern);
		
		return mainMenu;
	}

}
