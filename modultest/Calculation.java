package modultest;

public class Calculation {

	private ResultRepository repository;
	
	public Calculation(ResultRepository repository) {
		this.repository = repository;
	}
	
	public int addition(int a, int b) {
		int result = a + b;
		repository.save(result);
		return result;
	}
	
	public int multiplication(int a, int b) {
		int result = a * b;
		repository.save(result);
		return result;
	}
	
}
