<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraProduto" var="linkServletProduto"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Produto</title>
</head>
<body>


	<form action="${linkServletProduto}" method="post">
		
		<label>Nome do produto : </label>
		<input type="text" name="nome" value="${produto.nome}">
		
		<label>Descricao do produto : </label>
		<input type="text" name="descricao" value="${produto.descricao}">
		
		<label>Preco do produto : </label>
		<input type="text" name="preco" value="${produto.preco}">
		<input type="hidden" name="id" value="${produto.id }">
		
		<input type="submit">
		
	</form>

</body>
</html>