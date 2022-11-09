<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.fatec.web.Venda.servlet.Venda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Venda Criada</title>
</head>
<body>

	<c:if test="${not empty venda }">
		Venda : ${venda} cadastrado com sucesso
	</c:if>

	<c:if test="${empty venda }">
		Nenhuma Venda Cadastrada
	</c:if>

	
</body>
</html>