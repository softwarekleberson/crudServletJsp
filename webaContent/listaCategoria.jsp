<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, br.com.fatec.web.categoria.servlet.Categoria" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Categorias</title>
</head>
<body>

	<c:if test="${not empty categoria }">
		Categoria : ${categoria} cadastrado com sucesso
	</c:if>
	
	<ul>
		<c:forEach items="${categoria}" var="categorias">
			<li> ${categorias.nome} <br>
				 ${categorias.descricao}
			</li>
			
			<a href="/webfatec/removeCategoria?id=${categorias.id}">remover</a>	
			<a href="/webfatec/mostraCategoria?id=${categorias.id}">alterar</a>	
			<br><br>
								
		</c:forEach>
	</ul>
	
</body>
</html>