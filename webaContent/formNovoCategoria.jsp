<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoCategoria" var="linkServletCategoria"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova categoria</title>
</head>
<body>
	<form action="${linkServletCategoria}" method="post">
	
		<label>Nome da categoria : </label>
		<input type="text" name="nome">
		<br><br>
		
		<label>Descricao da categoria : </label>
		<input type="text" name="descricao">
		<br><br>
		
		<input type="submit">
	
	</form>
</body>
</html>