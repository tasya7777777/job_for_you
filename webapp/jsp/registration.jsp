<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<link href="res/css/main.css" rel="stylesheet" media="screen">
<link href="res/css/bootstrap.css" rel="stylesheet" media="screen">
<script src="res/js/main.js"></script>

<div class="main-div">
<h1>Enter your personal information</h1>
<form action="RegistrationServlet" method="post">
	<div><label>email:</label> <input type="text" name="email">	</div>
	<div><label>password:</label> <input type="password" name="password">	</div>
	<div><label>repeat password:</label> <input type="password" name="password">	</div>
	<button type="submit" class="btn btn-primary btn-lg"> registration </button>
</form>
</div>
