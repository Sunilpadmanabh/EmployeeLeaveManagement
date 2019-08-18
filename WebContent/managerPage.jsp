<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Page</title>
<style>
.shift{
margin-left:80%;
}
.color{
color:teal}

h3{
color:red}
</style>
<h4>
<a class="shift" href="http://localhost:8080/EmployeeLeaveManagement/">Logout</a>
</h4>
</head>
<body>
<center>
<h2 class="color">Welcome Manager</h2>

<table border="3px">
 <tr>
  <th>
 slNo:
 </th>
 <th>
 eid:
 </th>
 <th>
 ename:
 </th>
 <th>
 emailId:
 </th>
 <th>
 department:
 </th>
 <th>
 status:
 </th>
 <th>
 action:
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
 ${data.status }
 </td>
 <td>
 <form action="ManagerViewEmployee?eid=${data.employeeId}" method="post">
 <input type="submit" value="View">
<%-- <form action="ManagerViewEmployee?slno=${data.slNo}" method="post"> --%>
<!--  <input type="submit" value="View"> -->
 </form>
 </td>
 </tr>
 </c:forEach>
 
</table>
</center>
</body>
</html>