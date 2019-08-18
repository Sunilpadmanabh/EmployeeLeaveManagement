<%@page import="com.model.EmployeeLeave"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Leave</title>
</head>
<style>
h3{
color:red}
.color{
color:teal}

</style>
<body>
<center>
<h1 class="color">EDIT LEAVE REQUEST FORM</h1>
<h3>
${messageSession }
<% session.removeAttribute("messageSession"); %>
</h3>
 
<% EmployeeLeave empleave = (EmployeeLeave) session.getAttribute("editSession"); %>
<table>
<tr>
<td>
<b>
Id:<%= empleave.getEmployeeId() %><br>
Name:<%= empleave.getName() %><br>
Leave Type:<%= empleave.getLeaveType() %><br>
Previous Description:<%= empleave.getDescp() %><br>
<%-- Leave DateFrom:<%= empleave.getDateFrom() %><br> --%>
<%-- Leave DateTo:<%= empleave.getDateto() %><br> --%>
Status:<%= empleave.getStatus() %><br><br>
<form action="UpdateEmpLeave?slno=${editSession.getSlNo()}&empId=${editempId}" method="post">
<p>
Date From:<input type="date" value="${editSession.dateFrom }" name="datefrom"/>
</p>
<p>
Date to:<input type="date" value="${editSession.dateto }" name="dateto"/>
</p>
   <p>
Leave Type:
    <select name="leavetype" }">
        <option>Planned</option>
        <option>Holiday</option>
        <option>Medical</option>
    </select>
    </p>
    <p>
 
Description: <textarea rows="4" cols="50" value="${editSession.descp }"  name="descp"></textarea>
 </p>
 </td>
</tr>
</table>
 <p>
<input type="submit" value="Update">
</p>
</form>
</b>

<a href="employeeLeavePage.jsp">Go Back</a>
</center>
</body>
</html>