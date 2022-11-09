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

	<ul>
		<c:forEach items="${venda}" var="vendas">
			<li>
				Quantidade : ${vendas.qtd}
				Desconto : ${vendas.desconto}
				Valor Total : ${vendas.valorTotal}
			</li>
		</c:forEach>
	
	</ul>
	
</body>
</html>