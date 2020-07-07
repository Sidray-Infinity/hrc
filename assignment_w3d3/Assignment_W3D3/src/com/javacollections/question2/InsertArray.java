package com.javacollections.question2;
import java.util.*;

public class InsertArray {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>();
		
		for(int i=0; i<5; i++)
			al.add(i);
		
		System.out.println("Before:");
		for(int i=0; i<al.size(); i++)
			System.out.print(Integer.toString(al.get(i)) + " ");
		System.out.println();
		
		int index, element;
		System.out.println("Enter the index and the element to be inserted:");
		index = scan.nextInt();
		element = scan.nextInt();
		
		// Inserting the element at the given index
		al.add(index, element);
		
		System.out.println("After:");
		for(int i=0; i<al.size(); i++)
			System.out.print(Integer.toString(al.get(i)) + " ");
		System.out.println();
		
	}
	
}
