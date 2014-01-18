package stateandbehavior;

public class CounterProgram {
	stateandbehavior.Counter counter;
	
	void init() {
		this.counter = new stateandbehavior.Counter(3);
	}
	
	void run() {

		System.out.println(counter);
		System.out.println(counter.getCounter());
		System.out.println(counter);
		System.out.println(counter.count());
		System.out.println(counter);
		
	}
	
	public static void main(String[] args) {
		CounterProgram program = new CounterProgram();
		program.init();
		program.run();
	}
	
}
