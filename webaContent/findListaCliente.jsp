<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, br.com.fatec.web.cliente.servlet.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<ul>
		<c:forEach items="${cliente}" var="clientes">
			<li> 
				 ${clientes.nome}
				 ${clientes.email}
				 ${clientes.telefone} 
			</li>
		
			<br><br>
								
		</c:forEach>
	</ul>

</body>
</html>