<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager View Page</title>
</head>
<body>
<style>
.color{
color:teal}
h3{
color:red}
</style>
<body>
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

<c:forEach items="${list}" var="data">
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
${data.total }
</td>
<td>
${data.consumed }
</td>
<td>
${data.askedDays }
</td>

<td>
<form method="post" action="AcceptLeave?sid=${data.slNo}&eid=${data.employeeId}&days=${data.askedDays}&type=${data.leaveType}">
<!-- <input type="submit" value="APPROVE"></input> -->

<input type="submit" value="Accept" <c:if test="${data.status =='approved'}"><c:out value="disabled='disabled'"/></c:if>">

</form>
<form method="post" action="RejectLeave?sid=${data.slNo}&eid=${data.employeeId}">
<!-- <input type="submit" value="REJECT"></input> -->
<input type="submit" value="Reject" <c:if test="${data.status =='approved'}"><c:out value="disabled='disabled'"/></c:if>">

</form>
</td>

</tr>
</c:forEach>

</table>

</center>
</body>
</html>