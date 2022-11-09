<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, br.com.fatec.web.Produto.servlet.Produto" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Produtos</title>
</head>
<body>
	
	<ul>
		<c:forEach items="${produto}" var="produtos">
			<li>
				${produtos.nome}
				${produtos.descricao}
				${produtos.preco}
			</li>
		</c:forEach>
	</ul>
		
</body>
</html>