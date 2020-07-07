package com.javabasics.question1;
import java.util.Scanner;

class Adder extends Arithmetic{
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Adder a = new Adder();
        int x, y;

        System.out.println("Enter the two numbers to be added:");
        x = scan.nextInt();
        y = scan.nextInt();

        System.out.println("Their sum is: " + a.add(x, y));
	}
}
