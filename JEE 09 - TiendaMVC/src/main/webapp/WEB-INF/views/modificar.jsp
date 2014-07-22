<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" commandName="producto">
		<form:hidden path="idProducto"/>
	
		Nombre: <form:input path="nombre" /> <br/>
		Descripcion: <form:input path="descripcion" /> <br/>
		Foto: <form:input path="foto" /> <br/>
		Existencias: <form:input path="existencias" /> <br/>
		Precio: <form:input path="precio" /> <br/>
		<form:select path="idCategoria"> <br/>
			<form:options items="${categorias }" />
		</form:select> <br/>
		<form:select path="idsTags" multiple="true"> <br/>
			<form:options items="${tags }" />
		</form:select> <br/> <br/>
		
		<input type="submit" value="Guardar" />
	</form:form>
</body>
</html>