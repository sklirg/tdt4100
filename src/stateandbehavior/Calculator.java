package stateandbehavior;
import java.util.Scanner;

public class Calculator {
	double firstOperand;
	double secondOperand;
	char operator;

	void setFirstOperand(double x)
	{
		this.firstOperand = x;
	}
	
	void setSecondOperand(double y)
	{
		this.secondOperand = y;
	}
	
	void setOperator(char c)
	{
		this.operator = c;
	}
	double calculateResult()
	{
		switch(this.operator)
		{
		case '+' : return this.firstOperand + this.secondOperand;
		case '-' : return this.firstOperand - this.secondOperand;
		case '*' : return this.firstOperand * this.secondOperand;
		case '/' : return this.firstOperand / this.secondOperand;
		case '%' : return this.firstOperand % this.secondOperand;
		default : return -133.337; 
		// TODO Create failsafe default for error-handling.
		}
	}
	
	void calculateAndSetResult()
	{
		this.firstOperand = calculateResult();
	}
	
	public String toString() {
		return this.firstOperand + " " + this.operator + " " + this.secondOperand + " = " + calculateResult();
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println("Please enter first operand, operator and then second operand.");
		Scanner firstIn = new Scanner(System.in);
		Scanner operatorIn = new Scanner(System.in);
		Scanner secondIn = new Scanner(System.in);
		
		c.firstOperand = firstIn.nextDouble();
		c.operator = operatorIn.nextLine().toCharArray()[0];
		c.secondOperand = secondIn.nextDouble();
		
		firstIn.close();
		operatorIn.close();
		secondIn.close();
		System.out.println(c);
	}
}
