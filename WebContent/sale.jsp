<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projekcione sale</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
		</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>Sale</h1>
		<ul>
		<c:forEach items="${sale}" var="sala">
			<li>${sala.getNazivSale()}
				<ol>
					<li><b>Opis:</b> ${sala.getOpis()}</li>
					<li><b>Broj mesta:</b> ${sala.getBrojMesta()}</li>
					<li><b>Tehnologija:</b> ${sala.getTehnologija()}</li>
					<li><a href="IzmeniSalu?IdSale=${sala.getIdSale()}&IdBioskopa=${sala.getIdBioskopa()}">Izmeni</a> || <a href="ObrisiSalu?IdSale=${sala.getIdSale()}">Obriši</a></li>
				</ol>
			</li>
			<br><br><br><br>
		</c:forEach>
		</ul>
		${poruka}
		<h3><a href="DodajSalu?IdBioskopa=${IdBioskopa}">Dodaj novu salu</a></h3> <br><br>
		<a href="bioskopi.jsp"><em>Nazad na bioskope</em></a>
	</body>
</html>