package ccc.y2014;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) {
		(new J1()).solve();
	}

	Scanner scanner = new Scanner(System.in);
	
	public void solve() {
		
		// Prompt the user
		System.out.print("Enter number of squares : ");

		// Read a number from the console
		int number = Integer.valueOf(scanner.nextLine());
		
		System.out.println("The number entered was " + number);

		double squareRoot = Math.sqrt(number);
		
		System.out.println("Square root " + squareRoot);
		
		// If you want the rounded value, you can round using
		// Math.round()
		System.out.println("Rounded value " + Math.round(squareRoot));
		
		// Casting as an int throws away the decimals
		// IT DOES NOT ROUND
		int maxSideLength = (int) squareRoot;
		
		System.out.println("Max Side length " + maxSideLength);
		
	}

}
