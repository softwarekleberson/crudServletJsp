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
	
		<label>Quantidade Venda</label>
		<input type="number" name="qtd">
		
		<label>Desconto Venda</label>
		<input type="text" name="desconto">
		
		<label>Valor Total</label>
		<input type="text" name="valor">
		
		<label>Data Venda</label>
		<input type="text" name="data">
		
		
		<input type="submit">
		
		
	</form>

</body>
</html>