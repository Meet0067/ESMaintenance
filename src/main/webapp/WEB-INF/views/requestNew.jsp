<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.dao.*,com.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


	<title></title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="resources/requests/image/png" href="resources/requests/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/requests/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/requests/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<%
		AdminDao ad = (AdminDao)request.getAttribute("adminDao");
		List<NewUserBean> nb = ad.getNewUser();

%>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Date</th>
								<th class="column2">Request ID</th>
								<th class="column3">Name</th>
								<th class="column4">Flat No</th>
								<th class="column5">Email</th>
								<th class="column6">Mobile</th>
								<th class="column7">Approve</th>
								
								<th class="column8">Reject</th>
								<th class="column9">Comment</th>
							</tr>
						</thead>
						<tbody>
				
						
						<%
						for(NewUserBean nub :nb)
						{
							String id =nub.getUserid().toString();
						%>
								<tr>
									<td class="column1">2017-09-29 01:22</td>
									<td class="column2"><%= nub.getUserid() %></td>
									<td class="column3"><%= nub.getFname()+" "+nub.getMname()+" "+nub.getLname() %></td>
									<td class="column4"><%=nub.getFlate_no() %></td>
									<td class="column5"><%= nub.getEmail() %></td>
									<td class="column6"><%= nub.getPhone_no() %></td>
									<td class="column7"><%out.print("<a href='approve/" + id +" '>"); %><input type="button" value="Approve" /></a></td>
									<td class="column7"><%out.print("<a href='reject/" + id +" '>"); %><input type="button" value="Reject" /></a></td>							
							
								</tr>
								
							<%} %>
								
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	

<!--===============================================================================================-->	
	<script src="resources/requests/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/requests/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/requests/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/requests/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/requests/js/main.js"></script>

</body>
</html>