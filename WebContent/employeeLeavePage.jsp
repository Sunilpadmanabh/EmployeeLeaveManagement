 <%@page import="com.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LeavePage</title>
</head>
<body>
<center>
<style>
.shift{
margin-left:80%;
}
h2 {
color: #FF5733;
}
.color {
color: teal;
}
h3{
color:red}
</style>
<h1 class="color">LEAVE REQUEST FORM</h1>
<h4>
<a class="shift" href="http://localhost:8080/EmployeeLeaveManagement/">Logout</a>
</h4>
<%
Employee employee = (Employee)session.getAttribute("loginSession");
%>

<h3>
${messageSession }
<% session.removeAttribute("messageSession"); %>
</h3>
 

<table>
<tr><td><b>
Employee Id:<%= employee.getEmployeeId() %><br>
Employee Name:<%= employee.getName() %><br>
Employee EmailId:<%= employee.getEmailId() %><br>
Employee Department:<%= employee.getDept() %><br>

<form action="Leave?empid=${loginSession.getEmployeeId() }" method="post">
<p>
Date From:<input type="date" name="datefrom"/>
</p>
<p>
Date to:<input type="date" name="dateto"/>
</p>
   <p>
Leave Type:
    <select name="leavetype">
        <option>Planned</option>
        <option>Holiday</option>
        <option>Medical</option>
    </select>
    </p>
    <p>
Description:
 <textarea rows="4" cols="50" name="descp" ></textarea>
 </p>
 <p>
<input type="submit" value="register">
</p>
</form>

<form action="LeaveView?vempid=${loginSession.getEmployeeId() }" method="post">
<p> 
<input type="submit" value="View Details" />
</p>
</form>
</b>
</td>
</tr>
</table>
</center>
</body>
</html>