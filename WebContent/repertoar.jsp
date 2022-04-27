<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Repertoar - ${nazivBioskopa}</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/custom.css">
		</head>
	<body>
		<jsp:include page="header.jsp"/>
		<c:if test="${poruka != null}">
			<div class="alert alert-danger" role="alert">
				<span id="poruka">${poruka}</span>
			</div>
		</c:if>
		<div id="mainFilmovi">
		<c:forEach items="${repertoar}" var="p" varStatus="loopStatus">

			<div class="containerFilmovi">
				<h2 class="nasl">${nazivBioskopa}</h2>
				<h3 class="filmovi">Datum i vreme prikazivanja:  ${p.getDatumPrikazivanja()} ${p.getVremePrikazivanja()}</h3>
				<a href="PrikazFilma?IdFilma=${p.getIdFilma()}"><img class="film" src="${p.getSlikaFilma()}"></a>
				<h4 class="filmovi">Naziv sale: ${p.getNazivSale()}</h4>
				<h4 class="filmovi">Cena karte: ${p.getCenaKarte()}</h4>
				<h4 class="filmovi">Naziv filma: ${p.getNazivFilma()}</h4>
				<h4 class="filmovi">Tehnologija: ${p.getTehnologija()}</h4>
				<h4 class="filmovi">Trajanje filma: ${p.getTrajanjeFilma()}</h4>
				<h4 class="filmovi">Žanr: ${p.getZanr()}</h4>
				<c:if test="${sessionScope.Rola != 'A'.charAt(0) && sessionScope.Rola != 'M'.charAt(0)}">
				<h4><a class="bojica" href="RezervacijaKarte?IdProjekcije=${p.getIdProjekcije()}">Rezerviši karte</a></h4>
				</c:if>
		 	</div>
		</c:forEach>
		 </div>
		
		
		
	</body>
</html>