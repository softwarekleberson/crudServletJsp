<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.fatec.web.Entrega.servlet.Entrega" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
	<c:if test="${not empty entrega }">
		Entrega Criada		
	</c:if>
	
	<c:if test="${empty entrega}">
		Nenhuma entrega cadastrado
	</c:if>
	
</body>
</html>