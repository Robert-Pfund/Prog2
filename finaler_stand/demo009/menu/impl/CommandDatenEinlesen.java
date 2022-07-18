package demo009.menu.impl;

import  java.util.*;
import java.io.*;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.misc.Util;
import demo009.model.Fuhrpark;
import demo009.model.Lager;
import demo009.model.Niederlassung;
import demo009.model.Warenart;

public class CommandDatenEinlesen implements Command {

	@Override
	public String menuItemName() {

	return "Spielstand laden";
	}
 
	@Override
	public void execute(ApplicationContext context) {

	FileReader fr;

	// für Niederlassungen:
	
	int length = context.getNiederlassungen().size();
	for(int i = length-1 ; i >= 0; i--) {
		Niederlassung nl = context.getNiederlassungen().get(i);
		context.getNiederlassungen().remove(nl);
	}
	
	
	
	try {
	
		fr = new FileReader(context.getPfad() + "niederlassungen.txt");
		BufferedReader br = new BufferedReader(fr);

		String eineZeile = br.readLine();

		while(eineZeile!=null && !eineZeile.trim().equals("")) {
		StringTokenizer st = new StringTokenizer(eineZeile, ";");

		String name = st.nextToken();
		String warenart_string = st.nextToken(); // Speichern als String und nicht als Warenart
		int anzahlArbeiter = Integer.parseInt(st.nextToken().trim());
		int lohn = Integer.parseInt(st.nextToken().trim());
		
		Warenart warenart = Util.convertWarenartToWarenart(warenart_string);

		context.addNiederlassung(new Niederlassung(name, lohn, warenart, anzahlArbeiter));

		eineZeile = br.readLine();
		}
		br.close();
	} catch (IOException e){
		e.printStackTrace();
	}


	// für Lager

	context.setLager(new Lager("Augsburg", 1));

	try {
	
		fr = new FileReader(context.getPfad() + "lager.txt");
		BufferedReader br = new BufferedReader(fr);

		String eineZeile = br.readLine();

		while(eineZeile!=null && !eineZeile.trim().equals("")) {
			
			StringTokenizer st = new StringTokenizer(eineZeile, ";");

			String warenart_string = st.nextToken();
			int menge = Integer.parseInt(st.nextToken().trim());

			Warenart warenart = Util.convertWarenartToWarenart(warenart_string);
		
			context.getLager().einlagern(warenart, menge);

			eineZeile = br.readLine();
		}
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

	// für Guthaben
	
	try {
	
		fr = new FileReader(context.getPfad() + "guthaben.txt");
		BufferedReader br = new BufferedReader(fr);

		String eineZeile = br.readLine();

		while(eineZeile!=null && !eineZeile.trim().equals("")) {
		StringTokenizer st = new StringTokenizer(eineZeile, ";");

		int guthaben = Integer.parseInt(st.nextToken().trim());

		context.setGuthaben(guthaben);

		eineZeile = br.readLine();
		}
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

	// für Fuhrpark
	
	try {
	
		fr = new FileReader(context.getPfad() + "fuhrpark.txt");
		BufferedReader br = new BufferedReader(fr);

		String eineZeile = br.readLine();

		while(eineZeile!=null && !eineZeile.trim().equals("")) {
		StringTokenizer st = new StringTokenizer(eineZeile, ";");

		int anzahl = Integer.parseInt(st.nextToken().trim());
		int kosten = Integer.parseInt(st.nextToken().trim());

		context.setFuhrpark(new Fuhrpark(anzahl, kosten));
		
		eineZeile = br.readLine();
		}
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
}