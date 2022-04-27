<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ažuriraj bioskop</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<form action="IzmeniBioskop" method="post">
		<h1>Izmena bioskopa:</h1>
			<input type="hidden" name="Id" value="${bioskop.getIdBioskopa()}"/>
			<input type="text" name="NazivBioskopa" value="<c:out value="${bioskop.getNazivBioskopa()}"/>"><br><br>
			<input type="text" name="Adresa" value="<c:out value="${bioskop.getAdresa()}"/>"><br><br>
			<textarea cols="50" name="Slika" rows="3"><c:out value="${bioskop.getSlika()}"/></textarea><br><br>
			<input type="text" name="Opis" value="<c:out value="${bioskop.getOpis()}"/>"><br><br>
			<input type="submit" value="Ažuriraj bioskop"/>
		</form>
	</body>
</html>