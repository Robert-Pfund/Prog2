package modultest;

public class TestMain {

	public static void main(String[] args) {
		
		// Vorbereiten der Stubs
		InMemoryResultRepository testRepositoryInMemory = new InMemoryResultRepository();
		
		// zu testendes Modul instanziieren
		Calculation calc = new Calculation(testRepositoryInMemory);
		
		// Test durchfuehren
		int addResult = calc.addition(3, 4);
		
		//Sollwert festlegen
		int addResultTarget = 7;
		
		//------------------------------------
		
		//Bewertungsmoeglichkeit 1		
		if(addResult != addResultTarget) {
			System.out.println("Fehler bei calc.addition. Soll =" + addResultTarget 
					+ ", tatsaechlicher Wert = " + addResult);
		}
		else {
			System.out.println("calc.addition okay");
		}
		
		//------------------------------------
		
		//Bewertungsmoeglichkeit 2
		if(!testRepositoryInMemory.getIntResults().contains((Integer)addResultTarget)) {
			System.out.println("Fehler in Repository. Ergebnis " + addResultTarget
					+ " nicht in Repository enthalten");
		}
		else {
			System.out.println("Repository ok");
		}
		
		//
		System.out.println("------------------------------------");

		CalculationTest testadd = new CalculationTest();
		testadd.testAddition();
		testadd.testRepositoryAddition();
	}	
}
