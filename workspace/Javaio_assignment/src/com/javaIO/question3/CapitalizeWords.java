package com.javaIO.question3;
import java.io.File;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class CapitalizeWords {
	
	public static String capitalize_words(String s) {
		String upper_case_line = ""; 
		Scanner lineScan = new Scanner(s); 
		while(lineScan.hasNext()) {
			String word = lineScan.next(); 
			upper_case_line += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " "; 
		}
		return upper_case_line;
	}

	public static void main(String[] args) {
		LinkedList<String> all_lines = new LinkedList<String>();
		
		File f = new File("Files/Test_In.txt");
		File f_out = new File("Files/Test_Out_q3.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				all_lines.add(line);
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(f_out))) {
				for(int i=0; i<all_lines.size(); i++) {
					System.out.println(all_lines.get(i));
					bw.write(capitalize_words(all_lines.get(i)));
					bw.newLine();
				}
			}	
		}
		catch(IOException e) {
			System.out.println(e);
		}

	}

}
