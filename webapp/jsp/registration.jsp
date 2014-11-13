<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="main_div">
<h1>Enter your personal information</h1>
<form action="/RegistrationServlet" method="post">
	<div><label>email:</label> <input type="text" name="email">	</div>
	<div><label>password:</label> <input type="password" name="password">	</div>
	<button type="submit"> registration </button>
</form>
</div>
</body>
</html>