<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,br.com.fatec.web.Venda.servlet.Venda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Venda</title>
</head>
<body>

	<c:if test="${not empty venda }">
		Venda : ${venda} cadastrado com sucesso
	</c:if>

	<ul>
		<c:forEach items="${venda}" var="vendas">
			<li>Data : <fmt:formatDate value="${vendas.data }" pattern="dd/MM/yyyy"/></li>
			<a href="/webfatec/removeVenda?id=${vendas.id }">remover</a>
			<a href="/webfatec/mostraVenda?id=${vendas.id }">altera</a>
		
		</c:forEach>
	
	</ul>
	
</body>
</html>