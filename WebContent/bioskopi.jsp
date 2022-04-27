<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bioskopi" class="dao.BioskopDao.BioskopDao"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bioskopi</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>Bioskopi</h1>
		<ul>
		<c:forEach items="${bioskopi.vratiSveBioskope()}" var="bioskop">
			<li>${bioskop.getNazivBioskopa()}
				<ol>
					<li><b>Adresa:</b> ${bioskop.getAdresa()}</li>
					<li><b>Slika:</b> <img src="${bioskop.getSlika()}" width="50" height="50"/></li>
					<li><b>Opis:</b> ${bioskop.getOpis()}</li>
					<li><a href="IzmeniBioskop?IdBioskopa=${bioskop.getIdBioskopa()}">Izmeni</a> || <a href="ObrisiBioskop?IdBioskopa=${bioskop.getIdBioskopa()}">Obriši</a>
					 || <a href="PrikaziSale?IdBioskopa=${bioskop.getIdBioskopa()}">Prikaži sale</a>
					</li>
				</ol>
			</li>
			<br><br><br><br>
		</c:forEach>
		</ul>
		${poruka}
		<h3><a href="DodajBioskop">Dodaj novi bioskop</h3> 
	</body>
</html>