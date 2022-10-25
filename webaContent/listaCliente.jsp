<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, br.com.fatec.web.cliente.servlet.Cliente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Cliente</title>
</head>
<body>

		<c:if test="${not empty cliente}">
		Cliente ${cliente} cadastrada com sucesso
		</c:if>
	
		<ul>
			<c:forEach items="${cliente}" var="clientes">
				<li>${clientes.nome} ${clientes.email} ${clientes.telefone}</li>
				
				<a href="/webfatec/removeCliente?id=${clientes.id }">remover</a>
				<a href="/webfatec/mostraCliente?id=${clientes.id}">edita</a>	
					
			</c:forEach>
		</ul>
		
</body>
</html>