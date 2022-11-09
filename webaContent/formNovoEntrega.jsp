<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoEntrega" var="linkServletEntrega"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova categoria</title>
</head>
<body>

	<form action="${linkServletEntrega}" method="post">
		
		<label>Data da entrega : </label>
		<input type="text" name="data">
		
		<br><br>
		<input type="submit">
	
	</form>

</body>
</html>