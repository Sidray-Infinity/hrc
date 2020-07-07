package com.higradius;
import java.sql.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class UploadData {
	
	public static void main(String[] args) {
		Connection dbCon = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:mysql://127.0.0.1/project";
		String userName = "root";
		String password = "root";
		String csv_path = "Files/Data.csv";
		
		
		try {
			
			// Establishing connection to DB
			System.out.println("Connecting to DB..");
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection(url, userName, password);
			dbCon.setAutoCommit(false);
			System.out.println("Connected.");

			
			BufferedReader br = new BufferedReader(new FileReader(csv_path));
			String line_text = null;
			
			int count = 0;
			br.readLine();	// Skip the column row
			
			int row_count = 0;
			
			Queue<Record> record_buffer = new LinkedList<Record>();
		
			
			while((line_text = br.readLine()) != null) {
				System.out.println("Row Number: " + Integer.toString(row_count));
				row_count += 1;
				
				String data[] = line_text.split(",");
				for(int i=0; i<data.length; i++) { 			// Storing null at places where empty string is present
					if (data[i].length() == 0)
						data[i] = null;
				}
				
				Record r = new Record();
			
				
				r.read_data(data);		// Adding the data to the record object (except pk_id and disputed_amount)
				record_buffer.add(r);	// Adding the object to the queue
				
				if(row_count % 5000 == 0) {  //Test
					// Write these 20 rows to the DB before proceeding
					
					System.out.println("----------------------------------");
					System.out.println("Updating DB");
					System.out.println("----------------------------------");
					
					while(!record_buffer.isEmpty()) {
						Record t = record_buffer.poll();
						String insert_query = "INSERT INTO customer_invoice(acct_doc_header_id," +
											  "company_id,document_number,document_number_norm,business_code,create_year," +
											  "document_line_number,doctype,customer_number,customer_number_norm,fk_customer_map_id," +
											  "customer_name,division,document_create_date,document_create_date_norm,posting_date," +
											  "posting_date_norm,posting_id,due_date,due_date_norm,order_date,order_date_norm,invoice_id," +
											  "invoice_id_norm,baseline_create_date,invoice_date_norm,total_open_amount,total_open_amount_norm," +
											  "cust_payment_terms,business_area,ship_date,ship_to,clearing_date,clearing_date_norm,reason_code," +
											  "isOpen,discount_due_date_norm,debit_credit_indicator,payment_method,document_creation_date,invoice_amount_doc_currency," +
											  "document_id,actual_open_amount,paid_amount,days_past_due_date,invoice_age) VALUES" +
											  "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
						
						PreparedStatement p = dbCon.prepareStatement(insert_query);					  
						p = t.insert_values(p); 	// Inserting the parameter values from the record object
						
						p.executeUpdate();			// Updating the DB (which is not working)
						dbCon.commit();
					}
				}
			}
			dbCon.close();
		}
		catch (IOException ex) {
            System.err.println(ex);
        }
		catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                dbCon.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
