<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoVenda" var="linkServletVenda"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletVenda}" method="post">
		<label>Quantidade vendida : </label>
		<input type="number" name="qtd">
		<br><br>
		
		<label>Desconto da venda : </label>
		<input type="text" name="desconto">
		<br><br>
		
		<label>Valor total : </label>
		<input type="text" name="valor">
		<br><br>
		
		<label>Data da venda : </label>
		<input type="text" name="data">
		<br><br>
		
		<input type="submit">
	</form>

</body>
</html>