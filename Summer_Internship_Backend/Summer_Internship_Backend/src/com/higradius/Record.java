package com.higradius;
import java.io.IOException;
import java.text.ParseException;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Record {
	private int acct_doc_header_id;
	private int company_id;
	private int document_number;
	private int document_number_norm;
	private String business_code;
	private String create_year;
	private int document_line_number;
	private String doctype;
	private int customer_number;
	private int customer_number_norm;
	private int fk_customer_map_id;
	private String customer_name;
	private String division;
	private java.sql.Date document_create_date;
	private java.sql.Date document_create_date_norm;
	private java.sql.Date posting_date;
	private java.sql.Date posting_date_norm;
	private String posting_id;
	private java.sql.Date due_date;
	private java.sql.Date due_date_norm;
	private java.sql.Date order_date;
	private java.sql.Date order_date_norm;
	private int invoice_id;
	private int invoice_id_norm;
	private java.sql.Date baseline_create_date;
	private java.sql.Date invoice_date_norm;
	private float total_open_amount;
	private float total_open_amount_norm;
	private int cust_payment_terms;
	private String business_area;
	private java.sql.Date ship_date;
	private String ship_to;
	private java.sql.Date clearing_date;
	private java.sql.Date clearing_date_norm;
	private String reason_code;
	private int isOpen;
	private java.sql.Date discount_due_date_norm;
	private String debit_credit_indicator;
	private String payment_method;
	private java.sql.Date document_creation_date;
	private float invoice_amount_doc_currency;
	private int document_id;
	private float actual_payment_amount;
	private float paid_amount;
	private int days_past_due_date;
	private int invoice_age;
	private float disputed_amount;
	
	public Record() {
		
	}
	
	
	void set_values(ResultSet rs) {
		
		try {
			this.setAcct_doc_header_id(rs.getInt("acct_doc_header_id"));
			this.setActual_payment_amount(rs.getFloat("actual_open_amount"));
			this.setBaseline_create_date(rs.getDate("baseline_create_date"));
			this.setBusiness_area(rs.getString("business_area"));
			this.setBusiness_code(rs.getString("business_code"));
			this.setClearing_date(rs.getDate("clearing_date"));
			this.setClearing_date_norm(rs.getDate("clearing_date_norm"));
			this.setCompany_id(rs.getInt("company_id"));
			this.setCreate_year(rs.getString("create_year"));
			this.setCust_payment_terms(rs.getInt("cust_payment_terms"));
			this.setCustomer_name(rs.getString("customer_name"));
			this.setCustomer_number_norm(rs.getInt("customer_number_norm"));
			this.setDays_past_due_date(rs.getInt("days_past_due_date"));
			this.setDebit_credit_indicator(rs.getString("debit_credit_indicator"));
			this.setDiscount_due_date_norm(rs.getDate("discount_due_date_norm"));
			this.setDisputed_amount(rs.getFloat("disputed_amount"));
			this.setDivision(rs.getString("division"));
			this.setDoctype(rs.getString("doctype"));
			this.setDocument_create_date(rs.getDate("document_create_date"));
			this.setDocument_create_date_norm(rs.getDate("document_create_date_norm"));
			this.setDocument_creation_date(rs.getDate("document_creation_date"));
			this.setDocument_id(rs.getInt("document_id"));
			this.setDocument_line_number(rs.getInt("document_line_number"));
			this.setDocument_number(rs.getInt("document_number"));
			this.setDocument_number_norm(rs.getInt("document_number_norm"));
			this.setDue_date(rs.getDate("due_date"));
			this.setDue_date_norm(rs.getDate("due_date_norm"));
			this.setFk_customer_map_id(rs.getInt("fk_customer_map_id"));
			this.setInvoice_age(rs.getInt("invoice_age"));
			this.setInvoice_amount_doc_currency(rs.getFloat("invoice_amount_doc_currency"));
			this.setInvoice_id(rs.getInt("invoice_id"));
			this.setInvoice_id_norm(rs.getInt("invoice_id_norm"));
			this.setIsOpen(rs.getInt("isOpen"));
			this.setOrder_date(rs.getDate("order_date"));
			this.setOrder_date_norm(rs.getDate("order_date_norm"));
			this.setPaid_amount(rs.getFloat("paid_amount"));
			this.setPayment_method(rs.getString("payment_method"));
			this.setPosting_date(rs.getDate("posting_date"));
			this.setPosting_date_norm(rs.getDate("posting_date_norm"));
			this.setPosting_id(rs.getString("posting_id"));
			this.setReason_code(rs.getString("reason_code"));
			this.setShip_date(rs.getDate("ship_date"));
			this.setShip_to(rs.getString("ship_to"));
			this.setTotal_open_amount(rs.getFloat("total_open_amount"));
			this.setTotal_open_amount_norm(rs.getFloat("total_open_amount_norm"));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	void read_data(String data[]) {
		
		SimpleDateFormat a1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat a2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat b1 = new SimpleDateFormat("dd/MM/yyyy");

		java.util.Date d;
		
		try {
			if(data[0] != null)
				this.setAcct_doc_header_id(Integer.parseInt(data[0]));
			else
				this.setAcct_doc_header_id(0);
			
			if(data[1] != null)
				this.setCompany_id(Integer.parseInt(data[1]));
			else
				this.setCompany_id(0);
			
			if(data[2] != null)
				this.setDocument_number(Integer.parseInt(data[2]));
			else
				this.setDocument_number(0);
			
			if(data[3] != null)
				this.setDocument_number_norm(Integer.parseInt(data[3]));
			else
				this.setDocument_number_norm(0);
			
			if(data[4] != null)
				this.setBusiness_code(data[4]);
			else
				this.setBusiness_code(null);
			
			if(data[5] != null)
				this.setCreate_year(data[5]);
			else
				this.setCreate_year(null);
			
			if(data[6] != null )
				this.setDocument_line_number(Integer.parseInt(data[6]));
			else
				this.setDocument_line_number(0);
			
			if(data[7] != null)
				this.setDoctype(data[7]);
			else
				this.setDoctype(null);
			
			if(data[8] != null) {
				try {
					this.setCustomer_number(Integer.parseInt(data[8]));
				}
				catch(NumberFormatException e) {
					System.out.println("EXCEPTION: Only string having integer numbers are allowed!");
					this.setCustomer_number(0);
				}	
			}
			else
				this.setCustomer_number(0);
			
			if(data[9] != null)
				this.setCustomer_number_norm(Integer.parseInt(data[9]));
			else	
				this.setCustomer_number_norm(0);
			
			if(data[10] != null)
				this.setFk_customer_map_id(Integer.parseInt(data[10]));
			else	
				this.setFk_customer_map_id(0);
			
			if(data[11] != null)
				this.setCustomer_name(data[11]);
			else
				this.setCustomer_name(null);
			
			if(data[12] != null)
				this.setDivision(data[12]);
			else
				this.setDivision(null);
			
			if(data[13] != null) {
				d = a1.parse(data[13]);
				this.setDocument_create_date(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setDocument_create_date(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[14] != null) {
				d = a1.parse(data[14]);
				this.setDocument_create_date_norm(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setDocument_create_date_norm(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[15] != null) {
				d = a1.parse(data[15]);
				this.setPosting_date(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setPosting_date(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[16] != null) {
				d = a1.parse(data[16]);
				this.setPosting_date_norm(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setPosting_date_norm(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[17] != null)
				this.setPosting_id(data[17]);
			else
				this.setPosting_id(null);
			
			if(data[18] != null) {
				d = a1.parse(data[18]);
				this.setDue_date(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setDue_date(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[19] != null) {
				d = a1.parse(data[19]);
				this.setDue_date_norm(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setDue_date_norm(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[20] != null) {
				d = a1.parse(data[20]);
				this.setOrder_date(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setOrder_date(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[21] != null) {
				d = a1.parse(data[21]);
				this.setOrder_date_norm(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setOrder_date_norm(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[22] != null)
				this.setInvoice_id(Integer.parseInt(data[22]));
			else
				this.setInvoice_id(0);
			
			if(data[23] != null)
				this.setInvoice_id_norm(Integer.parseInt(data[23]));
			else
				this.setInvoice_id_norm(0);
			
			if(data[24] != null) {
				d = a1.parse(data[24]);
				this.setBaseline_create_date(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setBaseline_create_date(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[25] != null) {
				d = a1.parse(data[25]);
				this.setInvoice_date_norm(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setInvoice_date_norm(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[26] != null)
				this.setTotal_open_amount(Float.parseFloat(data[26]));
			else
				this.setTotal_open_amount((float)0.0);
			
			if(data[27] != null)
				this.setTotal_open_amount_norm(Float.parseFloat(data[27]));
			else
				this.setTotal_open_amount_norm((float)0.0);
			
			if(data[28] != null)
				this.setCust_payment_terms(Integer.parseInt(data[28]));
			else
				this.setCust_payment_terms(0);
			
			if(data[29] != null)
				this.setBusiness_area(data[29]);
			else
				this.setBusiness_area(null);
			
			if(data[30] != null) {
				try {
					d = b1.parse(data[30]);
					this.setShip_date(java.sql.Date.valueOf(a2.format(d)));
				}
				catch(java.text.ParseException e) {
					d = a1.parse(data[30]);
					this.setShip_date(java.sql.Date.valueOf(a2.format(d)));
				}
				
			}
			else 
				this.setShip_date(java.sql.Date.valueOf("1111-1-1"));
				
			if(data[31] != null)
				this.setShip_to(data[31]);
			else
				this.setShip_to(null);
			
			if(data[32] != null) {
				d = a1.parse(data[32]);
				this.setClearing_date(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setClearing_date(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[33] != null) {
				d = a1.parse(data[33]);
				this.setClearing_date_norm(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setClearing_date_norm(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[34] != null)
				this.setReason_code(data[34]);
			else
				this.setReason_code(null);
			
			if(data[35] != null)
				this.setIsOpen(Integer.parseInt(data[35]));
			else
				this.setIsOpen(0);
			
			if(data[36] != null) {
				d = a1.parse(data[36]);
				this.setDiscount_due_date_norm(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setDiscount_due_date_norm(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[37] != null)
				this.setDebit_credit_indicator(data[37]);
			else
				this.setDebit_credit_indicator(null);
			
			if(data[38] != null)
				this.setPayment_method(data[38]);
			else
				this.setPayment_method(null);
			
			if(data[39] != null) {
				d = a1.parse(data[39]);
				this.setDocument_creation_date(java.sql.Date.valueOf(a2.format(d)));
			}
			else
				this.setDocument_creation_date(java.sql.Date.valueOf("1111-1-1"));
			
			if(data[40] != null)
				this.setInvoice_amount_doc_currency(Float.parseFloat(data[40]));
			else
				this.setInvoice_amount_doc_currency((float)0.0);
			
			if(data[41] != null)
				this.setDocument_id(Integer.parseInt(data[41]));
			else
				this.setDocument_id(0);
			
			if(data[42] != null)
				this.setActual_payment_amount(Float.parseFloat(data[42]));
			else
				this.setActual_payment_amount((float)0.0);
			
			if(data[43] != null)
				this.setPaid_amount(Float.parseFloat(data[43]));
			else
				this.setPaid_amount((float)0.0);
			
			if(data[44] != null)
				this.setDays_past_due_date(Integer.parseInt(data[44]));
			else
				this.setDays_past_due_date(0);
			
			if(data[45] != null)
				this.setInvoice_age(Integer.parseInt(data[45]));
			else
				this.setInvoice_age(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	PreparedStatement insert_values(PreparedStatement pstmt) {
		
		try {
			if(this.getAcct_doc_header_id() != 0)
				pstmt.setInt(1, this.getAcct_doc_header_id());
			else
				pstmt.setNull(1, Types.INTEGER);
			
			if(this.getCompany_id() != 0)
				pstmt.setInt(2, this.getCompany_id());
			else
				pstmt.setNull(2, Types.INTEGER);
			
			if(this.getDocument_number() != 0)
				pstmt.setInt(3, this.getDocument_number());
			else
				pstmt.setNull(3, Types.INTEGER);
			
			if(this.getDocument_number_norm() != 0)
				pstmt.setInt(4, this.getDocument_number_norm());
			else
				pstmt.setNull(4, Types.INTEGER);
	
			pstmt.setString(5, this.getBusiness_code());
			
			pstmt.setString(6,  this.getCreate_year());
			
			if(this.getDocument_line_number() != 0)
				pstmt.setInt(7, this.getDocument_line_number());
			else
				pstmt.setNull(7, Types.INTEGER);
			
			pstmt.setString(8,  this.getDoctype());
			
			if(this.getCustomer_number() != 0)
				pstmt.setInt(9, this.getCustomer_number());
			else
				pstmt.setNull(9, Types.INTEGER);
			
			if(this.getCustomer_number_norm() != 0)
				pstmt.setInt(10, this.getCustomer_number_norm());
			else
				pstmt.setNull(10, Types.INTEGER);
			
			if(this.getFk_customer_map_id() != 0)
				pstmt.setInt(11,  this.getFk_customer_map_id());
			else
				pstmt.setNull(11, Types.INTEGER);
			
			pstmt.setString(12, this.getCustomer_name());
			
			pstmt.setString(13,  this.getDivision());
			
			if(!this.getDocument_create_date().toString().equals("1111-01-01"))
				pstmt.setDate(14, this.getDocument_create_date());
			else
				pstmt.setNull(14, Types.DATE);
			
			if(!this.getDocument_create_date_norm().toString().equals("1111-01-01"))
				pstmt.setDate(15, this.getDocument_create_date_norm());
			else
				pstmt.setNull(15, Types.DATE);
			
			if(!this.getPosting_date().toString().equals("1111-01-01"))
				pstmt.setDate(16, this.getPosting_date());
			else
				pstmt.setNull(16, Types.DATE);
			
			if(!this.getPosting_date_norm().toString().equals("1111-01-01")) {
				pstmt.setDate(17, this.getPosting_date_norm());
			}
			else
				pstmt.setNull(17, Types.DATE);
			
			pstmt.setString(18, this.getPosting_id());
			
			if(!this.getDue_date().toString().equals("1111-01-01"))
				pstmt.setDate(19, this.getDue_date());
			else
				pstmt.setNull(19, Types.DATE);
			
			if(!this.getDue_date_norm().toString().equals("1111-01-01"))
				pstmt.setDate(20, this.getDue_date_norm());
			else
				pstmt.setNull(20, Types.DATE);
			
			if(!this.getOrder_date().toString().equals("1111-01-01"))
				pstmt.setDate(21, this.getOrder_date());
			else
				pstmt.setNull(21, Types.DATE);
			
			if(!this.getOrder_date_norm().toString().equals("1111-01-01"))
				pstmt.setDate(22, this.getOrder_date_norm());
			else
				pstmt.setNull(22, Types.DATE);
			
			if(this.getInvoice_id() != 0)
				pstmt.setInt(23, this.getInvoice_id());
			else
				pstmt.setNull(23, Types.INTEGER);
			
			if(this.getInvoice_id_norm() != 0)
				pstmt.setInt(24, this.getInvoice_id_norm());
			else
				pstmt.setNull(24, Types.INTEGER);
			
			if(!this.getBaseline_create_date().toString().equals("1111-01-01"))
				pstmt.setDate(25, this.getBaseline_create_date());
			else
				pstmt.setNull(25, Types.DATE);
			
			if(!this.getInvoice_date_norm().toString().equals("1111-01-01"))
				pstmt.setDate(26, this.getInvoice_date_norm());
			else
				pstmt.setNull(26, Types.DATE);
			
			if(this.getTotal_open_amount() != (float)0.0)
				pstmt.setFloat(27, this.getTotal_open_amount());
			else
				pstmt.setNull(27, Types.FLOAT);
			
			if(this.getTotal_open_amount_norm() != (float)0.0)
				pstmt.setFloat(28, this.getTotal_open_amount_norm());
			else
				pstmt.setNull(28, Types.FLOAT);
			
			if(this.getCust_payment_terms() != 0)
				pstmt.setInt(29, this.getCust_payment_terms());
			else
				pstmt.setNull(29, Types.INTEGER);
			
			pstmt.setString(30, this.getBusiness_area());
			
			if(!this.getShip_date().toString().equals("1111-01-01"))
				pstmt.setDate(31, this.getShip_date());
			else
				pstmt.setNull(31, Types.DATE);
			
			pstmt.setString(32, this.getShip_to());
			if(!this.getClearing_date().toString().equals("1111-01-01"))
				pstmt.setDate(33, this.getClearing_date());
			else
				pstmt.setNull(33, Types.DATE);
			
			if(!this.getClearing_date_norm().toString().equals("1111-01-01"))
				pstmt.setDate(34, this.getClearing_date_norm());
			else
				pstmt.setNull(34, Types.DATE);
			
			pstmt.setString(35, this.getReason_code());
			if(this.getIsOpen() != 0)
				pstmt.setInt(36, this.getIsOpen());
			else
				pstmt.setNull(36, Types.INTEGER);
			
			if(!this.getDiscount_due_date_norm().toString().equals("1111-01-01"))
				pstmt.setDate(37, this.getDiscount_due_date_norm());
			else
				pstmt.setNull(37, Types.DATE);
			
			pstmt.setString(38, this.getDebit_credit_indicator());
			
			pstmt.setString(39, this.getPayment_method());
			
			if(!this.getDocument_creation_date().toString().equals("1111-01-01"))
				pstmt.setDate(40, this.getDocument_creation_date());
			else
				pstmt.setNull(40, Types.DATE);
			
			if(this.getInvoice_amount_doc_currency() != (float)0.0)
				pstmt.setFloat(41, this.getInvoice_amount_doc_currency());
			else
				pstmt.setNull(41, Types.FLOAT);
			
			if(this.getDocument_id() != 0)
				pstmt.setInt(42, this.getDocument_id());
			else
				pstmt.setNull(42, Types.INTEGER);
			
			if(this.getActual_payment_amount() != (float)0.0)
				pstmt.setFloat(43, this.getActual_payment_amount());
			else
				pstmt.setNull(43, Types.FLOAT);
			
			if(this.getPaid_amount() != (float)0.0)
				pstmt.setFloat(44, this.getPaid_amount());
			else
				pstmt.setNull(44, Types.FLOAT);
			
			if(this.getDays_past_due_date() != 0)
				pstmt.setInt(45, this.getDays_past_due_date());
			else
				pstmt.setNull(45, Types.INTEGER);
			
			if(this.getInvoice_age() != 0)
				pstmt.setInt(46, this.getInvoice_age());
			else
				pstmt.setNull(46, Types.INTEGER);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		

		return pstmt;
	}

	public int getAcct_doc_header_id() {
		return acct_doc_header_id;
	}

	public void setAcct_doc_header_id(int acct_doc_header_id) {
		this.acct_doc_header_id = acct_doc_header_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getDocument_number() {
		return document_number;
	}
	
	public void setDocument_number(int document_number) {
		this.document_number = document_number;
	}
	
	public int getDocument_number_norm() {
		return document_number_norm;
	}
	
	public void setDocument_number_norm(int document_number_norm) {
		this.document_number_norm = document_number_norm;
	}

	public String getBusiness_code() {
		return business_code;
	}

	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}

	public String getCreate_year() {
		return create_year;
	}

	public void setCreate_year(String create_year) {
		this.create_year = create_year;
	}

	public int getDocument_line_number() {
		return document_line_number;
	}

	public void setDocument_line_number(int document_line_number) {
		this.document_line_number = document_line_number;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public int getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}

	public int getCustomer_number_norm() {
		return customer_number_norm;
	}

	public void setCustomer_number_norm(int customer_number_norm) {
		this.customer_number_norm = customer_number_norm;
	}

	public int getFk_customer_map_id() {
		return fk_customer_map_id;
	}

	public void setFk_customer_map_id(int fk_customer_map_id) {
		this.fk_customer_map_id = fk_customer_map_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public java.sql.Date getDocument_create_date() {
		return document_create_date;
	}

	public void setDocument_create_date(java.sql.Date document_create_date) {
		this.document_create_date = document_create_date;
	}

	public java.sql.Date getDocument_create_date_norm() {
		return document_create_date_norm;
	}

	public void setDocument_create_date_norm(java.sql.Date document_create_date_norm) {
		this.document_create_date_norm = document_create_date_norm;
	}

	public java.sql.Date getPosting_date() {
		return posting_date;
	}

	public void setPosting_date(java.sql.Date posting_date) {
		this.posting_date = posting_date;
	}

	public java.sql.Date getPosting_date_norm() {
		return posting_date_norm;
	}

	public void setPosting_date_norm(java.sql.Date posting_date_norm) {
		this.posting_date_norm = posting_date_norm;
	}

	public String getPosting_id() {
		return posting_id;
	}

	public void setPosting_id(String posting_id) {
		this.posting_id = posting_id;
	}

	public java.sql.Date getDue_date() {
		return due_date;
	}

	public void setDue_date(java.sql.Date due_date) {
		this.due_date = due_date;
	}

	public java.sql.Date getDue_date_norm() {
		return due_date_norm;
	}

	public void setDue_date_norm(java.sql.Date due_date_norm) {
		this.due_date_norm = due_date_norm;
	}

	public java.sql.Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(java.sql.Date order_date) {
		this.order_date = order_date;
	}

	public java.sql.Date getOrder_date_norm() {
		return order_date_norm;
	}

	public void setOrder_date_norm(java.sql.Date order_date_norm) {
		this.order_date_norm = order_date_norm;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public int getInvoice_id_norm() {
		return invoice_id_norm;
	}

	public void setInvoice_id_norm(int invoice_id_norm) {
		this.invoice_id_norm = invoice_id_norm;
	}

	public java.sql.Date getBaseline_create_date() {
		return baseline_create_date;
	}

	public void setBaseline_create_date(java.sql.Date baseline_create_date) {
		this.baseline_create_date = baseline_create_date;
	}

	public java.sql.Date getInvoice_date_norm() {
		return invoice_date_norm;
	}

	public void setInvoice_date_norm(java.sql.Date invoice_date_norm) {
		this.invoice_date_norm = invoice_date_norm;
	}

	public float getTotal_open_amount() {
		return total_open_amount;
	}

	public void setTotal_open_amount(float total_open_amount) {
		this.total_open_amount = total_open_amount;
	}

	public float getTotal_open_amount_norm() {
		return total_open_amount_norm;
	}

	public void setTotal_open_amount_norm(float total_open_amount_norm) {
		this.total_open_amount_norm = total_open_amount_norm;
	}

	public int getCust_payment_terms() {
		return cust_payment_terms;
	}

	public void setCust_payment_terms(int cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}

	public String getBusiness_area() {
		return business_area;
	}

	public void setBusiness_area(String business_area) {
		this.business_area = business_area;
	}

	public java.sql.Date getShip_date() {
		return ship_date;
	}

	public void setShip_date(java.sql.Date ship_date) {
		this.ship_date = ship_date;
	}

	public String getShip_to() {
		return ship_to;
	}

	public void setShip_to(String ship_to) {
		this.ship_to = ship_to;
	}

	public java.sql.Date getClearing_date() {
		return clearing_date;
	}

	public void setClearing_date(java.sql.Date clearing_date) {
		this.clearing_date = clearing_date;
	}

	public java.sql.Date getClearing_date_norm() {
		return clearing_date_norm;
	}

	public void setClearing_date_norm(java.sql.Date clearing_date_norm) {
		this.clearing_date_norm = clearing_date_norm;
	}

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public int getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}

	public java.sql.Date getDiscount_due_date_norm() {
		return discount_due_date_norm;
	}

	public void setDiscount_due_date_norm(java.sql.Date discount_due_date_norm) {
		this.discount_due_date_norm = discount_due_date_norm;
	}

	public String getDebit_credit_indicator() {
		return debit_credit_indicator;
	}

	public void setDebit_credit_indicator(String debit_credit_indicator) {
		this.debit_credit_indicator = debit_credit_indicator;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public java.sql.Date getDocument_creation_date() {
		return document_creation_date;
	}

	public void setDocument_creation_date(java.sql.Date document_creation_date) {
		this.document_creation_date = document_creation_date;
	}

	public float getInvoice_amount_doc_currency() {
		return invoice_amount_doc_currency;
	}

	public void setInvoice_amount_doc_currency(float invoice_amount_doc_currency) {
		this.invoice_amount_doc_currency = invoice_amount_doc_currency;
	}

	public int getDocument_id() {
		return document_id;
	}

	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}

	public float getActual_payment_amount() {
		return actual_payment_amount;
	}

	public void setActual_payment_amount(float actual_payment_amount) {
		this.actual_payment_amount = actual_payment_amount;
	}

	public float getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(float paid_amount) {
		this.paid_amount = paid_amount;
	}

	public int getDays_past_due_date() {
		return days_past_due_date;
	}

	public void setDays_past_due_date(int days_past_due_date) {
		this.days_past_due_date = days_past_due_date;
	}

	public int getInvoice_age() {
		return invoice_age;
	}

	public void setInvoice_age(int invoice_age) {
		this.invoice_age = invoice_age;
	}

	public float getDisputed_amount() {
		return disputed_amount;
	}

	public void setDisputed_amount(float disputed_amount) {
		this.disputed_amount = disputed_amount;
	}
}
