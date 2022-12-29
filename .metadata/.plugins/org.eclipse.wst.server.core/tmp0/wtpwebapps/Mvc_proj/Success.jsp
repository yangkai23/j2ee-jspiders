<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body bgcolor="green">
<h1 align="center">Registration successful</h1>
<%String name=(String)request.getAttribute("username"); 
String id=(String)request.getAttribute("empid");%>
<font color="black" size="10">UserName:</font> <%=name %><br>
<font color="black" size="10">Employee ID:</font><%=id %>
</body>
</html>