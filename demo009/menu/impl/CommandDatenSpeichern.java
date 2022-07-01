package demo009.menu.impl;

import  java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Fuhrpark;
import demo009.model.Lager;
import demo009.model.Niederlassung;
import demo009.model.Warenart;
 

public class CommandDatenSpeichern implements Command {
	
	@Override
	public String menuItemName() {
		
		return "Spielstand speichern";
	}
	
	@Override
	public void execute(ApplicationContext context) {
		
		File niederlassungen = new File(context.getPfad() + "niederlassungen.txt");
		File lager = new File(context.getPfad() + "lager.txt");
		File guthaben = new File(context.getPfad() + "guthaben.txt");
		File fuhrpark = new File(context.getPfad() + "fuhrpark.txt");
		
		ArrayList nl_liste = context.getNiederlassungen();
		
		FileWriter fw = null;

		
		try {
			// nur zum Schreiben oeffen, vorherige Daten gehen verloren
			fw = new FileWriter(niederlassungen);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i = 0; i < nl_liste.size(); i++) {
				
				Niederlassung nl = (Niederlassung) nl_liste.get(i);
				
				String eineZeile = nl.getOrt() + ";" + nl.getWarenartString() + ";" + nl.getArbeiter() + ";" + nl.getLohn();
				
				bw.write(eineZeile);
				bw.newLine();
				
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//-------------------------------
		
		try {
			// nur zum Schreiben oeffen, vorherige Daten gehen verloren
			fw = new FileWriter(lager);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Lager l = context.getLager();
			l.getOrt();
			
			List<Warenart> Warenliste = new ArrayList<>(l.getEingelagerteWaren());
			
			for(int j = 0; j < Warenliste.size(); j++) {				
			
				Warenart wa = Warenliste.get(j);
				String eineZeile = wa.toString() + ";" + l.getBestand(wa);
				
				bw.write(eineZeile);
				bw.newLine();
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			// nur zum Schreiben oeffen, vorherige Daten gehen verloren
			fw = new FileWriter(guthaben);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String eineZeile = String.valueOf(context.getGuthaben());
				
			bw.write(eineZeile);
			bw.newLine();
		
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			// nur zum Schreiben oeffen, vorherige Daten gehen verloren
			fw = new FileWriter(fuhrpark);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Fuhrpark fp1 = context.getFuhrpark();
			
			String eineZeile = fp1.getAnzahlFuhrwerke() + ";" + fp1.getPreisFuhrwerk();
				
			bw.write(eineZeile);
			bw.newLine();
		
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
