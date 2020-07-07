package com.javaIO.question1;
import java.io.File;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class LastFive {
	
	public static void main(String[] args) {
		File f = new File("Files/Test_In.txt");
		File f_out = new File("Files/Test_Out_q1.txt");
		LinkedList<String> all_lines = new LinkedList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				all_lines.add(line);
				
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(f_out))) {
				for(int i=all_lines.size()-5; i<all_lines.size(); i++) {
					System.out.println(all_lines.get(i));
					bw.write(all_lines.get(i));
					bw.newLine();
				}
			}	
		}
		catch(IOException e) {
			System.out.println(e);
		}

	}

}
