package com.javacollections.question1;
import java.util.*;

public class HashMapSort {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(4, "A");
		map.put(1, "C");
		map.put(3, "D");
		
		// Need to convert it to TreeMap to make it sorted
		
		Map<Integer, String>sorted_map = new TreeMap<Integer, String>();
		
		sorted_map.putAll(map);
		
		for(Map.Entry<Integer, String> i: sorted_map.entrySet()) {
			System.out.println("[" + i.getKey() + " " + i.getValue() + "]");
		}
		

	}

}
