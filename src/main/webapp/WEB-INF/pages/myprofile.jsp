<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post" >
<h1>Login Success Page</h1>
  <p>You are logged in with email ${emailId}.</p>
 
  <!-- Click here to view the session attributes -->
<input type="submit" id="btn-login" class="btn btn-success" value="Login"/>
</form>
</body>
</html>