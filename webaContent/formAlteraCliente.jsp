<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraCliente" var="linkServletCliente"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Cliente</title>
</head>
<body>

	<form action="${linkServletCliente}" method="post">
		
		<label>Nome do cliente : </label>
		<input type="text" name="nome" value="${cliente.nome }">
		
		<label>Email do cliente : </label>
		<input type="email" name="email" value="${cliente.email }">
		
		<label>Telefone do cliente : </label>
		<input type="tel" name="telefone" value="${cliente.telefone }">
		
		<input type="hidden" name="id" value="${cliente.id }">
		<input type="submit">
				
	</form>

</body>
</html>