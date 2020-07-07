package com.javabasics.question4;
import java.util.Scanner;

public class InputCategorizer {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		int test_cases;
		System.out.println("Enter the number of test cases:");
		test_cases = scan.nextInt();
		
		for(int i=0; i<test_cases; i++) {
			String t;
			System.out.println("Enter the number:");
			t = scan.next();
			try {
				Byte.parseByte(t);
				
				// No exception indicates the number is at least a byte type.
				System.out.println(t + " can be fitted in:");
				System.out.println("byte");
				System.out.println("short");
				System.out.println("int");
				System.out.println("long");
			}
			catch (NumberFormatException eb) {
				try {
					Short.parseShort(t);
					
					// No exception indicates the number is at least a short type.
					System.out.println(t + " can be fitted in:");
					System.out.println("short");
					System.out.println("int");
					System.out.println("long");
				}
				catch(NumberFormatException es) {
					try {
						Integer.parseInt(t);
						
						// No exception indicates the number is at least a int type.
						System.out.println(t + " can be fitted in:");
						System.out.println("int");
						System.out.println("long");
					}
					catch(NumberFormatException ei) {
						try {
							Long.parseLong(t);
							
							// No exception indicates the number is at least a long type.
							System.out.println(t + " can be fitted in:");
							System.out.println("long");
						}
						catch(NumberFormatException el) {
							System.out.println(t + " can't be fitted anywhere.");
						}
					}
				}
			}
		}

	}

}
