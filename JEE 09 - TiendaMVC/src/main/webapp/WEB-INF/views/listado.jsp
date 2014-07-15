<!-- Autor: Rub�n Alejandro Catal�n Romero
	 Fecha creaci�n: 15/07/2014
	 �ltima modificaci�n: 15/07/2014
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
		
		<c:forEach items="${productos }" var="prod">
			<tr>
				<td>${prod.nombre }</td>
				<td>${prod.precio }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>