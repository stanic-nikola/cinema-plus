<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
		<meta charset="UTF-8">
		<title>Klub - <c:out value="${klub.getNaziv()}"></c:out></title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>Naziv kluba: ${klub.getNaziv()}</h1>
		<h5>Opis filma: </h5>
		<p>${klub.getOpis()}</p>
		<h5>Slika:</h5>
		<p><img src="${klub.getSlika()}" width="720" height="300"></p>
		<h5>Tip članstva:</h5>
		<p>${clanstvo.getTipClanstva()}</p>
		<h5>Popust</h5>
		<p>${klub.getPopust()}%</p><br><br>
		<h5>Broj Vašeg sedišta</h5>
		<p>${clanstvo.getSediste()}</p><br><br>
		<a href="klubovi.jsp">Promeni klub</a>
</html>