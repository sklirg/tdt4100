package encapsulation;
import java.util.Scanner;

public class Calculator {
    // [1] Private vars
	private double firstOperand;
	private double secondOperand;
	private char operator;

    // [1] Public methods to change vars
	public void setFirstOperand(double x)
	{
		this.firstOperand = x;
	}
	
	public void setSecondOperand(double y)
	{
		this.secondOperand = y;
	}
	
	public void setOperator(char c)
	{
		this.operator = c;
	}
	public double calculateResult()
	{
		switch(this.operator)
		{
		case '+' : return this.firstOperand + this.secondOperand;
		case '-' : return this.firstOperand - this.secondOperand;
		case '*' : return this.firstOperand * this.secondOperand;
		case '/' : if (secondOperand != 0) { return this.firstOperand / this.secondOperand; } else { return -133.337; } // [2]
		case '%' : return this.firstOperand % this.secondOperand;
		default : return -133.337;
		}
	}
	
	public void calculateAndSetResult()
	{
		this.firstOperand = calculateResult();
	}
	
	public String toString() {
		return this.firstOperand + " " + this.operator + " " + this.secondOperand + " = " + calculateResult();
	}
	/*
	 *
	 * [2] Dersom man skal dele, passe på at secondOperand != 0.
	 *
	 */
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
