package modultest;

import java.util.ArrayList;
import java.util.List;

public class InMemoryResultRepository implements ResultRepository{

	private List<Integer> resultArrayList = new ArrayList<Integer>();
	
	@Override
	public void save(Integer intResult) {	
	
		resultArrayList.add(intResult);
	}
	
	public List<Integer> getIntResults() {
		return resultArrayList;
	}
	
}
