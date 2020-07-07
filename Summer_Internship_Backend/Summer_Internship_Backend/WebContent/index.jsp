<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.higradius.Record" %>

<html>
<head>
<title>DB Response</title>
<style>
table, th, td {
  border: 2px solid black;
  border-collapse: collapse;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%! Record r[]; %>

	<%
	String s = request.getAttribute("jsonString").toString();
	r = new Gson().fromJson(s, Record[].class);
	%>

	<table class="table table-striped">
        <thead>
            <tr>
                <th> acct_doc_header_id </th>
                <th> company_id </th>
                <th> document_number </th>
                <th> document_number_norm </th>
                <th> business_code </th>
                <th> document_line_number </th>
                <th> doctype </th>
                <th> customer_number </th>
                <th> customer_number_norm </th>
                <th> fk_customer_map_id </th>
                <th> customer_name </th>
                <th> document_create_date </th>
                <th> document_create_date_norm </th>
                <th> invoice_id </th>
                <th> invoice_id_norm </th>
                <th> total_open_amount </th>
                <th> total_open_amount_norm </th>
                <th> cust_payment_terms </th>
                <th> clearing_date </th>
                <th> clearing_date_norm  </th>
                <th> invoice_amount_doc_currency </th>
                <th> document_id </th>
                <th> actual_payment_amount </th>
                <th> paid_amount </th>
                <th> days_past_due_date </th>
                <th> invoice_age </th>
                <th> disputed_amount </th>       
            </tr>
        </thead>
	
        <tbody>
	        <% for(int i=0; i<r.length; i++) {
	        	Record obj = r[i];	
	        %>
	        <tr>
	        <td> <%= r[i].getAcct_doc_header_id() %> </td>
	        <td> <%= r[i].getCompany_id() %> </td>
	        <td> <%= r[i].getDocument_number() %> </td>
	        <td> <%= r[i].getDocument_number_norm() %> </td>
	       	<td> <%= r[i].getBusiness_code() %> </td>
	       	<td> <%= r[i].getDocument_line_number() %> </td>
	       	<td> <%= r[i].getDoctype() %> </td>
	       	<td> <%= r[i].getCustomer_number() %> </td>
	       	<td> <%= r[i].getCustomer_number_norm() %> </td>
	       	<td> <%= r[i].getFk_customer_map_id() %> </td>
	       	<td> <%= r[i].getCustomer_name() %> </td>
	       	<td> <%= r[i].getDocument_create_date() %> </td>
	       	<td> <%= r[i].getDocument_create_date_norm() %> </td>
	       	<td> <%= r[i].getInvoice_id() %> </td>
	       	<td> <%= r[i].getInvoice_id_norm() %> </td>
	       	<td> <%= r[i].getTotal_open_amount() %> </td>
	       	<td> <%= r[i].getTotal_open_amount_norm() %> </td>
	       	<td> <%= r[i].getCust_payment_terms() %> </td>
	       	<td> <%= r[i].getClearing_date() %> </td>
	       	<td> <%= r[i].getClearing_date_norm() %> </td>
	       	<td> <%= r[i].getInvoice_amount_doc_currency() %> </td>
	       	<td> <%= r[i].getDocument_id() %> </td>
	       	<td> <%= r[i].getActual_payment_amount() %> </td>
	       	<td> <%= r[i].getPaid_amount() %> </td>
	       	<td> <%= r[i].getDays_past_due_date() %> </td>
	       	<td> <%= r[i].getInvoice_age() %> </td>
	       	<td> <%= r[i].getDisputed_amount() %> </td>
	        </tr>
	        
	        <% } %>
        
	</tbody>

    </table>

</body>
</html>
        <%-- 
     
        <c:forEach items="${jsonString}" var="pp">
        
                <tr>
                    <td><c:out value="${pp.acct_doc_header_id}" /></td>
                    <td><c:out value="${pp.company_id}" /></td>
                    <td><c:out value="${pp.document_number}" /></td>
                    <td><c:out value="${pp.document_number_norm}" /></td>
                    <td><c:out value="${pp.business_code}" /></td>
                    <td><c:out value="${pp.document_line_number}" /></td>
                    <td><c:out value="${pp.doctype}" /></td>
                    <td><c:out value="${pp.customer_number}" /></td>
                    <td><c:out value="${pp.customer_number_norm}" /></td>
                    <td><c:out value="${pp.fk_customer_map_id}" /></td>
                    <td><c:out value="${pp.customer_name}" /></td>
                    <td><c:out value="${pp.document_create_date}" /></td>
                    <td><c:out value="${pp.document_create_date_norm}" /></td>
                    <td><c:out value="${pp.invoice_id}" /></td>
                    <td><c:out value="${pp.invoice_id_norm}" /></td>
                    <td><c:out value="${pp.total_open_amount}" /></td>
                    <td><c:out value="${pp.total_open_amount_norm}" /></td>
                    <td><c:out value="${pp.cust_payment_terms}" /></td>
                    <td><c:out value="${pp.clearing_date}" /></td>
                    <td><c:out value="${pp.clearing_date_norm}" /></td>
                    <td><c:out value="${pp.isOpen}" /></td>
                    <td><c:out value="${pp.invoice_amount_doc_currency}" /></td>
                    <td><c:out value="${pp.document_id}" /></td>
                    <td><c:out value="${pp.actual_payment_amount}" /></td>
                    <td><c:out value="${pp.paid_amount}" /></td>
                    <td><c:out value="${pp.days_past_due_date}" /></td>
                    <td><c:out value="${pp.invoice_age}" /></td>
                    <td><c:out value="${pp.disputed_amount}" /></td>
        
                </tr>
        </c:forEach>
        --%>
