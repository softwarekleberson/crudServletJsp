<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/findCliente" var="linkServletEntrega"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Pesquise nome do cliente</h3>
	<form action="${linkServletEntrega}" method="post">
		
		<label>Nome Cliente : </label>
		<input type="search" name="nome">
		
		<br><br>
		<input type="submit">
	
	</form>
	
</body>
</html>