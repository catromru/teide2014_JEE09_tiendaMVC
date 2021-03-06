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
	
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
</head>
<body>
	<a href="altaProducto.html">Nuevo producto</a> <br/> <br/>

	<input type="text" id="txtBuscar" />
	<input type="submit" value="Buscar" onclick="buscar()" />

	<table id="tblDatos">
		<!-- <tr>
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
					<a href="#" onclick="evento(${prod.idProducto})">Detalle Ajax</a>
				</td>
				<td>
					<a href="#" onclick="borrar(${prod.idProducto})">Borrar</a>
				</td>
			</tr>
		</c:forEach> -->
	</table>
	
	<div id="divDetalle"></div>
	
	<script type="text/javascript">
		(function(){
			buscar();
		})();

	
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

		function buscar()
		{
			var texto = $("#txtBuscar").val();
			if( texto == "" )
			{
				texto = "BusquedaVacia";
			}
			
			var url = "producto/buscar/" + texto;

			$.get(url, function(res){
				var tabla = $("#tblDatos");
				
				$("#tblDatos tr").each(function(){
					$(this).remove();
				});

				for (var i = 0; i < res.length; i++) {
					var resultado = "<tr><td>" + res[i].nombre + "</td><td>" + res[i].precio + "</td><td><a href='detalle.html?id="+ res[i].idProducto + "'>Ver detalle</a></td><td><a href='#' onclick='evento(" + res[i].idProducto + ")'>Detalle Ajax</a></td><td><a href='#' onclick='borrar(" + res[i].idProducto + ")'>Borrar</a></td><td><a href='modificarProducto.html/"+ res[i].idProducto + "'>Modificar</a></td></tr></tr>";

					tabla.append(resultado);
				}
			});
		}

		function borrar(id)
		{
			var datoEmple = {idProducto:id};
			var datoPasar = JSON.stringify(datoEmple);

			$.ajax(
					"producto", {data: datoPasar,
								method: "DELETE",
								contentType: "application/json",
								success: function(res){
											alert(res);
											buscar();
										},
								error: function(res){
											alert(JSON.stringify(res));
										}
								}
			);
		}
	</script>
</body>
</html>