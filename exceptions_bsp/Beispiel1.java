package exceptions_bsp;

public class Beispiel1 {

	public static void main(String[] args) {
		
		try {
			// do something
			
		} catch (Exception e) { // Exception e entspricht allgemeiner Exception
								// IOException e fuer Input-Output-Exception
			e.printStackTrace();
			return;
		}
		
		
	}
}
