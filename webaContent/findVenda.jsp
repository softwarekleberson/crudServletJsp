<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/findVenda" var="linkServletEntrega"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Pesquise nome da Venda</h3>
	<form action="${linkServletEntrega}" method="post">
		
		<label>Quantidade vendida : </label>
		<input type="search" name="qtd">
		
		<br><br>
		<input type="submit">
	
	</form>

</body>
</html>