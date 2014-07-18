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
	<input type="text" id="txtBuscar" />
	<input type="submit" value="Buscar" onclick="buscar()" />

	<table id="tblDatos">
		<tr>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>-</th>
		</tr>
		
		<c:forEach items="${categorias }" var="cat">
			<tr>
				<td>${cat.nombre }</td>
				<td>${cat.descripcion }</td>
				<td>
					<a href="#" onclick="evento(${cat.idCategoria})">Detalle Ajax</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<div id="divDetalle"></div>
	
	<script type="text/javascript">
		function evento(id)
		{
			var url = "" + id;

			$.get(url, function(res){
				var resultado="<ul>";
				resultado+="<li>"+res.idCategoria+"</li>";
				resultado+="<li>"+res.nombre+"</li>";
				resultado+="<li>"+res.icono+"</li>";
				resultado+="<li>"+res.descripcion+"</li></ul>";

				$("#divDetalle").html(resultado);
			});
		}

		function buscar()
		{
			var url = "buscar/" + $("#txtBuscar").val();

			$.get(url, function(res){
				var tabla = $("#tblDatos");
				
				$("#tblDatos tr").each(function(){
					$(this).remove();
				});

				for (var i = 0; i < res.length; i++) {
					var resultado = "<tr><td>" + res[i].nombre + "</td><td>" + res[i].descripcion + "</td><td><a href='#' onclick='evento(" + res[i].idCategoria + ")'>Detalle Ajax</a></td></tr>";

					tabla.append(resultado);
				}
			});
		}
	</script>
</body>
</html>