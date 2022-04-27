<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Film - <c:out value="${film.getNazivFilma()}"></c:out></title>
<link rel="icon" type="image" href="imgs/favicon.ico">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">
		<c:if test="${sessionScope.Rola eq 'A'.charAt(0)}">
			<div class="filmHead">
				<h2>
					<a id="nasl" href="IzmeniFilm?IdFilma=${film.getIdFilma()}">Ažuriraj film</a>
					|| <a id="nasl" href="ObrisiFilm?IdFilma=${film.getIdFilma()}">Obriši
						film</a> || <a id="nasl" href="DodajProjekciju?IdFilma=${film.getIdFilma()}">Dodaj
						projekciju</a>
				</h2>
			</div>
		</c:if>

		<div class="row">
			<div class="col-sm prva">
				<div class="containerFilmovi">
					<img class="film" src="${film.getSlika()}">
				</div>
			</div>
			
			<div class="col-sm druga">
				<h4 class="naslovFilm">${film.getNazivFilma()}</h4>
				<br><br><br><br>
				<p class="zanr">Žanr: ${film.getZanr()}</p>
				<p class="zanr">Trajanje: ${film.getTrajanje()}</p>
				<br>
				<p class="zanr">Premijera: ${film.getDatum()}</p>
				<br>
				<h3 class="zanr">Opis:</h3>
				<p class="opis">${film.getOpisFilma()}</p>
			</div>
			
			<div class="col-sm treca">
				<p class="zanr">Pogledaj trejler</p>
				<iframe width="650" height="350"
					src="https://www.youtube.com/embed/${film.getTrejler()}" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
		</div>
		<c:if test="${sessionScope.Rola eq 'A'.charAt(0)}">
		<div class="row">
			<div class="col-sm prva"></div>
			<div class="col-sm druga"></div>
			<div class="col-sm treca">
				<table class="table table-dark tabela">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Bioskop</th>
						<th scope="col">Sala</th>
						<th scope="col">Datum</th>
						<th scope="col">Vreme</th>
						<th scope="col">Cena karte</th>
						<th scope="col">Ažuriraj</th>
						<th scope="col">Obriši</th>
					</tr>
					<c:forEach items="${projekcije}" var="p"  varStatus="loop">
						<tr>
							<th scope="row">${loop.index + 1}</th>
							<td>${p.getNazivBioskopa()}</td>
							<td>${p.getNazivSale()}</td>
							<td>${p.getDatum()}</td>
							<td>${p.getVreme()}</td>
							<td>${p.getCenaKarte()}</td>
							<td><a
								href="IzmeniProjekciju?IdProjekcije=${p.getIdProjekcije()}&IdSale=${p.getIdSale()}">Ažuriraj projekciju</a></td> 
							<td><a href="ObrisiProjekciju?IdProjekcije=${p.getIdProjekcije()}">Obriši projekciju</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</c:if>

	<div class="row">
		<div class="col-sm prva">
			<h4><a href="filmovi.jsp">Vrati se nazad na filmove</a></h4>
		</div>
	</div><br><br>
		<div class="row pomeraj">
			<c:if test="${poruka != null}">
			<h3 class="filmHead alert alert-success">${poruka}</h3>
		</c:if>
		<c:if test="${greska != null}">
		<h3 class="filmHead alert alert-danger">${greska}</h3>
		</c:if>
		<c:if test="${uspeh != null}">
		<h3 class="filmHead alert alert-success">${uspeh}</h3>
		</c:if>
	</div>
	
	</div>
</html>