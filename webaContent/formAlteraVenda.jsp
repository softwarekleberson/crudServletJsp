<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraVenda" var="linkServletVenda"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletVenda}" method="post">
	
		<label>Quantidade vendida : </label>
		<input type="number" name="qtd" value="${venda.qtd }">
		
		<label>Desconto da venda : </label>
		<input type="text" name="desconto" value="${venda.desconto }">
		
		<label>Valor total : </label>
		<input type="text" name="valor" value="${venda.valorTotal }">
		
		<label>Data da venda : </label>
		<input type="text" name="data" value="<fmt:formatDate value="${venda.data }" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${venda.id }">
		 
		<input type="submit">
		
		
	</form>

</body>
</html>