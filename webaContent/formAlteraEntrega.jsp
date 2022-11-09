<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraEntrega" var="linkServletEntrega"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

	<form action="${linkServletEntrega}" method="post">
		<label>Data da entrega : </label>
		<input type="text" name="data" value="<fmt:formatDate value="${entrega.data }" pattern="dd/MM/yyyy"/>"/>
		
		<input type="hidden" name="id" value="${entrega.id }">
		<input type="submit">
	</form>

</body>
</html>