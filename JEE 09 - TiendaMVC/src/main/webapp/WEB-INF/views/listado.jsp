<!-- Autor: Rubén Alejandro Catalán Romero
	 Fecha creación: 15/07/2014
	 Última modificación: 15/07/2014
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
</head>
<body>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
			<th>-</th>
			<th>-</th>
		</tr>
		
		<c:forEach items="${productos }" var="prod">
			<tr>
				<td>${prod.nombre }</td>
				<td>${prod.precio }</td>
				<td>
					<a href="detalle.html?id=${prod.idProducto }">Ver detalle</a>
				</td>
				<td>
					<a href="#" id="idObligatorio" onclick="evento(${prod.idProducto})">Detalle Ajax</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div id="divDetalle"></div>
	
	<script type="text/javascript">
		function evento(id)
		{
			var url = "producto/" + id;

			$.get(url, function(res){
				var resultado="<ul>";
				resultado+="<li>"+res.nombre+"</li>";
				resultado+="<li>"+res.descripcion+"</li>";
				resultado+="<li>"+res.foto+"</li>";
				resultado+="<li>"+res.existencias+"</li>";
				resultado+="<li>"+res.precio+"</li>";
				resultado+="<li>"+res.tiendaCategoria.nombre+"</li></ul>";

				$("#divDetalle").html(resultado);
			});
		}
	</script>
</body>
</html>