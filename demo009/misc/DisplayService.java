package demo009.misc;

import demo009.ApplicationContext;
import demo009.model.Lager;
import demo009.model.Niederlassung;
import demo009.model.Warenart;

public class DisplayService {

	public static void anzeigenNiederlassungen(ApplicationContext context) {
		
		System.out.println("======= Niederlassungen");
		System.out.println("Ort 	Warenart 	Status Anforderung 	gesendete Fuhrwerke\tArbeiter");
		for(int i = 0; i < context.getNiederlassungen().size(); i++) {
			Niederlassung nl = context.getNiederlassungen().get(i);
			System.out.println(nl.getOrt() + "\t"+ nl.getWarenartString() + "\t\t" + (nl.wurdeAngefordert()?"angefordert":"nicht angefordert") + "\t\t\t" + context.getGeplanteFuhrwerke() + "\t" + nl.getArbeiter());
			
		}
		System.out.println("============================");
	}
	
	public static void anzeigenLager(ApplicationContext context) {
		
		System.out.println("======= Lagerbestand");
		Lager l = context.getLager();
		for(Warenart wa: l.getEingelagerteWaren()) {
			System.out.println(wa.toString() + l.getBestand(wa));
		}
		System.out.println("============================");
	}
	
	public static void anzeigenGuthaben(ApplicationContext context) {
		
		System.out.println("====== Finanzen");
		System.out.println("Guthaben (in Talern): " + context.getGuthaben());
		System.out.println("============================");
	}
	
}

