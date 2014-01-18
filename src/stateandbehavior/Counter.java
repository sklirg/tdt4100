package stateandbehavior;

public class Counter {
	
	int end;
	int counter = 1;
	
	public Counter(int end){
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "[Counter end=" + end + ", counter=" + counter + "]";
	}
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count() {
		if (counter < end) { counter++; }
		return counter == end;
	}
	

}
