<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, br.com.fatec.web.categoria.servlet.Categoria" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categoria Criada</title>
</head>
<body>

	<c:if test="${not empty categoria }">
		Categoria : ${categoria} cadastrado com sucesso
	</c:if>

	<c:if test="${empty categoria }">
		Nenhuma Categoria Criada
	</c:if>
	
		
</body>
</html>