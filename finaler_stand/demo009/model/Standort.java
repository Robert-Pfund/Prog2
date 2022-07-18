package demo009.model;

public class Standort {

	/**
	 * Ort, in dem der Standort platziert wird. Die Funktionalität ist nicht vom Ortsnamen abhängig.
	 * Der Ort kann beliebig gewählt werden und dient lediglich der Illustration im Spiel. 
	 */
	private String ort;
	private int lohn;
	
	public Standort(String ort, int lohn) {
		this.ort=ort;
		this.lohn = lohn;
	}

	/**
	 * Jeder Standort steht in einem Ort. Die Methode gibt den Ort des Standortes zurück.
	 * @return Ort, in dem der Standort steht.
	 */
	public String getOrt() {
		return this.ort;
	}
	
	public int getLohn() {
		
		return this.lohn;
	}
	
	public void setLohn(int lohn_value) {
		
		this.lohn = lohn_value;
	}

}
