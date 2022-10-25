<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraCategoria" var="linkServletCategoria"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova categoria</title>
</head>
<body>
	<form action="${linkServletCategoria}" method="post">
	
		<label>Nome Categoria</label>
		<input type="text" name="nome" value="${categoria.nome }">
		
		<label>Descricao Categoria</label>
		<input type="text" name="descricao" value="${categoria.descricao }">
		
		<input type="hidden" name="id" value="${categoria.id }">
		
		<input type="submit">
	
	</form>
</body>
</html>