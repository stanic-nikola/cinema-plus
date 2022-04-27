<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dodaj salu</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<form action="DodajSalu" method="post">
		<h1>Dodaj salu:</h1>
			<input type="hidden" name="IdBioskopa" value="${bioskop.getIdBioskopa()}"/>
			<input type="text" name="NazivBioskopa" value="${bioskop.getNazivBioskopa()}" disabled><br><br>
			<input type="text" name="NazivSale" placeholder="Naziv sale"><br><br>
			<textarea cols="50" name="Opis" rows="3" placeholder="Opis sale"></textarea><br><br>
			<input type="text" name="BrojMesta" placeholder="Broj mesta"><br><br>
			<input type="text" name="Tehnologija" placeholder="Tehnologija"><br><br>
			
			<input type="submit" value="Dodaj salu"/>
		</form>
	</body>
</html>