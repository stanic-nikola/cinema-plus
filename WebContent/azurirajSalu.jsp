<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
		<meta charset="UTF-8">
		<title>Ažuriraj salu</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<form action="IzmeniSalu" method="post">
		<h1>Izmena sale:</h1>
			<input type="hidden" name="Id" value="${sala.getIdSale()}"/>
			<input type="hidden" name="IdBioskopa" value="${sala.getIdBioskopa()}"/>
			<input type="text" name="NazivSale" value="<c:out value="${sala.getNazivSale()}"/>"><br><br>
			<input type="text" name="Opis" value="<c:out value="${sala.getOpis()}"/>"><br><br>
			<input type="number" name="BrojMesta" value="<c:out value="${sala.getBrojMesta()}"/>"><br><br>
			<input type="text" name="Tehnologija" value="<c:out value="${sala.getTehnologija()}"/>"><br><br>
			<input type="submit" value="Ažuriraj salu"/>
		</form>
</html>