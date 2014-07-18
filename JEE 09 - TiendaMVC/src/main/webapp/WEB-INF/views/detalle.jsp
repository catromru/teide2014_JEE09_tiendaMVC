<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>${producto.nombre }</td>
			<td>${producto.descripcion }</td>
			<td>${producto.foto }</td>
			<td>${producto.existencias }</td>
			<td>${producto.precio }</td>
			<td>${producto.tiendaCategoria.nombre }</td>
		</tr>
	</table>
</body>
</html>