package com.javabasics.question5;
import java.util.Scanner;
import java.lang.Math;

public class Series {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the number of queries:");
		int q = scan.nextInt();
		
		for(int i=0; i<q; i++) {
			int a, b, n, temp;
			System.out.println("Enter the required parameter values:");
			a = scan.nextInt();
			b = scan.nextInt();
			n = scan.nextInt();
			
			int prev = 0;
			System.out.println("SERIES:");
			for(int j=0; j<n; j++) {
				temp = (int)Math.pow(2, j);
				prev += temp*b;
				System.out.print(Integer.toString(a+prev) + ' ');
			}
			System.out.println();
			
		}
		
	}
}
