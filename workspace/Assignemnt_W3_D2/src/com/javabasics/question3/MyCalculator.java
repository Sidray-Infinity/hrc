package com.javabasics.question3;
import java.util.Scanner;

public class MyCalculator {
	
	static Scanner scan = new Scanner(System.in);
	
	public long power(int n, int p) {
		long result = n;
		
		if (n < 0 || p < 0) {
			throw new NegativeNumberException();
		}
		
		else if (n == 0 || p == 0) {
			throw new ZeroNumberException();
		}
		else {
			for(int i=1; i<p; i++) {
				result *= n;
			}
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		
		int n, p;
		System.out.println("Enter the two numbers:");
		n = scan.nextInt();
		p = scan.nextInt();
		
		MyCalculator calc = new MyCalculator();
		try {
			System.out.println(calc.power(n, p));
		}
		catch(NegativeNumberException ne) {
			System.out.println(ne);
		}
		catch(ZeroNumberException ze) {
			System.out.println(ze);
		}
	}

}
