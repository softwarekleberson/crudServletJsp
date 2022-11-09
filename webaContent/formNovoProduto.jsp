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
		<label>Nome do produto : </label>
		<input type="text" name="nome">
		<br><br>
		
		<label>Descricao do produto : </label>
		<input type="text" name="descricao">
		<br><br>
		
		<label>Preco do produto : </label>
		<input type="text" name="preco">
		<br><br>
		
		<input type="submit">
	</form>

</body>
</html>