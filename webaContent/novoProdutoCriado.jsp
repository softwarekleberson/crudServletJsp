<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.fatec.web.Produto.servlet.Produto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${not empty produto }">
		Produto : ${ produto} cadastrado com sucesso
	</c:if>
	
	<c:if test="${empty produto }">
		Nenhum Produto Cadastrado
	</c:if>
	
	
		
</body>
</html>