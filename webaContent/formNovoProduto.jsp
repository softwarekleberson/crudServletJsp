<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoProduto" var="linkServletProduto"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Produto</title>
</head>
<body>

	<form action="${linkServletProduto}" method="post">
		
		<label>Nome Produto</label>
		<input type="text" name="nome">
		
		<label>Descricao Produto</label>
		<input type="text" name="descricao">
		
		<label>Preco Produto</label>
		<input type="text" name="preco">
		
		<input type="submit">
		
	</form>

</body>
</html>