package com.javaIO.question4;
import java.io.File;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class ReadFromCSV {

	public static void main(String[] args) {
		File f = new File("Files/sample.csv");
		File f_out = new File("Files/Test_Out_q4_test.txt");
		try  {
			BufferedReader br = new BufferedReader(new FileReader(f));
			BufferedWriter bw = new BufferedWriter(new FileWriter(f_out));
			
			String line;
			br.readLine(); // Skipping the column row
			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
				System.out.println(data[0]);
				for (String s: data)
					bw.write(s);
				bw.newLine();
				System.out.println(line);
		
			}
					
		}

		catch(IOException e) {
			System.out.println(e);
		}

	}

}