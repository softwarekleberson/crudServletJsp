<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.List, br.com.fatec.web.Entrega.servlet.Entrega" %>
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
	
	<ul>
		<c:forEach items="${entrega}" var="entregas">
			<li> <fmt:formatDate value="${entregas.data }" pattern="dd/MM/yyyy"/></li>
			<a href="/webfatec/removeEntrega?id=${entregas.id }">remover</a>
			<a href="/webfatec/mostraEntrega?id=${entregas.id}">edita</a>	
				
		</c:forEach>
	</ul>

</body>
</html>