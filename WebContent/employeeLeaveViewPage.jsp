<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeLeaveViewPage</title>
</head>
<style>
.color{
color:teal}

h3{
color:red}
</style>
<body>
<center>
<h2 class="color">Employee Leave Details</h2>

<h3>
 ${messageSession }
 <% session.removeAttribute("messageSession"); %>
 </h3>
 

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
edit:
</th>
<th>
delete:
</th>
</tr>

<c:forEach items="${list }" var="data">
<tr>
<td>
${data.slNo }
</td>
<td>
${data.employeeId }
</td>
<td>
${data.name }
</td>
<td>
${data.emailId }
</td>
<td>
${data.dept }
</td>
<td>
${data.dateFrom }
</td>
<td>
${data.dateto }
</td>
<td>
${data.leaveType }
</td>
<td>
${data.descp }
</td>
<td>
${data.status }
</td>

<td>
<form action="EditEmpLeave?eid=${data.slNo}&eeid=${data.employeeId}" method="post">
<input type="submit" value="Edit" <c:if test="${data.status =='approved' || data.status == 'rejected'}"><c:out value="disabled='disabled'"/></c:if>">

</form>
</td>
<td>
<form action="DeleteEmpLeave?did=${data.slNo}&deid=${data.employeeId}" method="post">
<input type="submit" value="Delete">
</form>
</td>

</tr>
</c:forEach>

</table>
<a href="employeeLeavePage.jsp">Go Back</a>

</center>
</body>
</html>