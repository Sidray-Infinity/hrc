package com.javaIO.question2;
import java.io.*;
import java.io.FileWriter;  

public class RemoveSpaces {
	public static void main(String[] args)
	{
		Reader rdr=null;
		BufferedReader bdr = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			rdr=new FileReader("Files/Test_In.txt");
			BufferedReader br = new BufferedReader(rdr);
			String line;
			try {
				while ((line = br.readLine()) != null) {
					sb.append(line + System.lineSeparator());
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String s = sb.toString();
	      s = s.trim();
	      String a[] = s.split(" ");
	      StringBuffer r = new StringBuffer();
	      for(int i=0; i<a.length; i++) {
	        r.append(a[i]);
	        
	        
	      }
	      String str = r.toString();
	     
		
	      try {
	    	FileWriter wtr = new FileWriter("Files/Test_Out_q2.txt");
			wtr.write(str);
			System.out.println(str);
			wtr.close();
		} catch (IOException e) {
		
			
		}
	      System.out.println("Success");
}
}
