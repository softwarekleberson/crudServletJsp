<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.fatec.web.cliente.servlet.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Cliente Cadastrado</title>
</head>
<body>

	<c:if test="${not empty cliente}">
		Cliente ${cliente} cadastrada com sucesso
	</c:if>
	
	<c:if test="${empty cliente }">
		Nenhum Cliente Criado
	</c:if>
					
</body>
</html>