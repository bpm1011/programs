//Author: Brandon M
//Simple Calculator to compute basic computations



import java.util.Scanner;
import java.lang.Math;

public class Calculator {

	public static void main(final String[] args) {

		System.out.println("===================================");
		System.out.println("||                               ||");
		System.out.println("||                               ||");
		System.out.println("||           Calculator          ||");
		System.out.println("||                               ||");
		System.out.println("||                               ||");
		System.out.println("===================================\n");

		char operator='\0';

		final Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter first number:\n");
		while (!keyboard.hasNextInt()) {
			System.out.println("Invalid Input, please enter integer:");
			keyboard.next();
		}

		final int firstNumber = keyboard.nextInt();
		keyboard.nextLine();

		System.out.println("Enter second number:\n");
		while (!keyboard.hasNextInt()) {
			System.out.println("Invalid Input, please enter integer:");
			keyboard.next();
		}

		final int secondNumber = keyboard.nextInt();
		keyboard.nextLine();

		System.out.println("\n");
		System.out.println("Operators Alowed:");
		System.out.println(" '+' for addition");
		System.out.println(" '-' for subtraction");
		System.out.println(" '*' for multiplication");
		System.out.println(" '/' for division");
		System.out.println(" '^' for exponent ");
		System.out.println(" '%' for remainder\n");

			System.out.println("\n");
			System.out.println("Enter Operator for computation:\n");
			operator = keyboard.next().charAt(0);
		

			switch (operator) {
				case '+':
					final int sumAnswer = firstNumber + secondNumber;
					System.out.println("\n");
					System.out.println("The answer is: " + sumAnswer + "\n");
					break;
	
				case '-':
					final int subAnswer = firstNumber - secondNumber;
					System.out.println("\n");
					System.out.println("The answer is: " + subAnswer + "\n");
					break;
	
				case '*':
					final int multAnswer = firstNumber * secondNumber;
					System.out.println("\n");
					System.out.println("The answer is: " + multAnswer + "\n");
					break;
	
				case '/':
					final double divAnswer = firstNumber / secondNumber;
					System.out.println("\n");
					System.out.println("The answer is: " + divAnswer + "\n");
						break;
	
				case '^':
					final double expAnswer = Math.pow(firstNumber, secondNumber);
					System.out.println("\n");
					System.out.println("The answer is: " + expAnswer + "\n");
						break;
	
				case '%':
					final int modAnswer = firstNumber % secondNumber;
					System.out.println("\n");
					System.out.println("The answer is: " + modAnswer + "\n");
						break;		
	
				default:
					System.out.println("\n");
					System.out.println("Invalid Operator \n");
						return;	
			}	
	}	
}