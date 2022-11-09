<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoCliente" var="linkServletCliente"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Cliente</title>
</head>
<body>

	<form action="${linkServletCliente}" method="post">
		
		<label>Nome do cliente : </label>
		<input type="text" name="nome">
		<br><br>
		
		<label>Email do cliente : </label>
		<input type="email" name="email">
		<br><br>
		
		<label>Telefone do cliente : </label>
		<input type="tel" name="telefone">
		<br><br>
		
		<input type="submit">
				
	</form>

</body>
</html>