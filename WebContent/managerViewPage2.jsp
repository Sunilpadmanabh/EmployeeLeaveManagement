<%@page import="com.model.EmployeeLeave"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style>
.color{
color:teal}
h3{
color:red}
</style>
<body>
<% EmployeeLeave empleave = (EmployeeLeave) session.getAttribute("leaveBySlNo"); %>

<center>
 
<table border="3px">
<tr>
<th>
slNo:
</th>
<th>
eId:
</th>
<th>
eName:
</th>
<th>
emailId:
</th>
<th>
dept:
</th>
<th>
dateFrom:
</th>
<th>
dateTo:
</th>
<th>
leaveType:
</th>
<th>
description:
</th>
<th>
status:
</th>
<th>
totalLeave:
</th>
<th>
consumedLeave:
</th>
<th>
askedLeave:
</th>
<th>
action:
</th>
</tr>


<tr>
<td>
${leaveBySlNo.slNo }
</td>
<td>
${leaveBySlNo.employeeId }
</td>
<td>
${leaveBySlNo.name }
</td>
<td>
${leaveBySlNo.emailId }
</td>
<td>
${leaveBySlNo.dept }
</td>
<td>
${leaveBySlNo.dateFrom }
</td>
<td>
${leaveBySlNo.dateto }
</td>
<td>
${leaveBySlNo.leaveType }
</td>
<td>
${leaveBySlNo.descp }
</td>
<!-- <td> -->
<%-- ${leaveBySlNo.status } --%>
<!-- </td> -->
<!-- <td> -->
<%-- ${leaveBySlNo.total } --%>
<!-- </td> -->
<!-- <td> -->
<%-- ${leaveBySlNo.consumed } --%>
<!-- </td> -->
<!-- <td> -->
<%-- ${leaveBySlNo.askedDays } --%>
<!-- </td> -->

<td>
<%-- <form method="post" action="AcceptLeave?sid=${leaveBySlNo.slNo}&eid=${leaveBySlNo.employeeId}&days=${leaveBySlNo.askedDays}&type=${leaveBySlNo.leaveType}"> --%>
<!-- <input type="submit" value="APPROVE"></input> -->

<input type="submit" value="Accept" <c:if test="${leaveBySlNo.status =='approved'}"><c:out value="disabled='disabled'"/></c:if>">

</form>
<form method="post" action="RejectLeave?sid=${leaveBySlNo.slNo}&eid=${leaveBySlNo.employeeId}">
<!-- <input type="submit" value="REJECT"></input> -->
<input type="submit" value="Reject" <c:if test="${leaveBySlNo.status =='approved'}"><c:out value="disabled='disabled'"/></c:if>">

</form>
</td>

</tr>

</table>

</center>

</body>
</html>