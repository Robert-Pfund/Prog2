package modultest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

// TestCase mit JUnit -> Klassennamen mit Test ergaenzen
// Methode fuer jeden Testfall muss mit test... beginnen

public class CalculationTest {

	@Test
	public void testAddition() {
		// Vorbereiten des Stubs
		ResultRepository testRepository = new InMemoryResultRepository();
		
		// zu testendes Modul instanziieren
		Calculation calc = new Calculation(testRepository);
		
		// Test durchfuehren
		assertEquals( "Fehler bei Addition", 7, calc.addition(3, 4));
	}
	
	@Test
	public void testRepositoryAddition() {
		InMemoryResultRepository resultRepos = new InMemoryResultRepository();
		
		Calculation calc = new Calculation(resultRepos);
		
		int targetValue = 7;
		
		assertEquals("Fehler bei Addition", calc.addition(3, 4) , targetValue);
		assertTrue(resultRepos.getIntResults().contains(targetValue));
		
	}
	
}
