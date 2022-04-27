<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Rezervacije korisnika</title>
	<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
<body>
	<jsp:include page="header.jsp"/>
	<table class="table table-dark color">

		<tr>
			<th scope="col">#</th>
			<th scope="col">Ime korisnika</th>
			<th scope="col">Naziv sale</th>
			<th scope="col">Naziv filma</th>
			<th scope="col">Broj sedišta</th>
			<th scope="col">Datum rezervacije</th>
			<th scope="col">Datum prikazivanja</th>
			<th scope="col">Vreme prikazivanja</th>
			<th scope="col">Cena karte</th>
			<th scope="col">Status</th>
		</tr>
	<c:forEach items="${rezervacije}" var="r" varStatus="loop">
		<c:if test="${r.getStatus() == 'Aktivna'}">
		<tr>
			<th scope="row">${loop.index + 1}</th>
			<td>${r.getImeKorisnika()}</td>
			<td>${r.getNazivSale()}</td>
			<td>${r.getNazivFilma()}</td>
			<td>${r.getBrojSedista()}</td>
			<td>${r.getDatumRezervacije()} / ${r.getVremeRezervacije()}</td>
			<td>${r.getDatumPrikazivanja()}</td>
			<td>${r.getVremePrikazivanja() }</td>
			<td>${r.getCenaKarte() }</td>
			<td>${r.getStatus()}</td>
			<td ><a class="ahref" href="StatusRezervacije?IdBioskopa=${idBioskopa}&IdRezervacije=${r.getIdRezervacije()}">Potvrdi rezervaciju</a> || 
			<a class="ahref" href="StatusRezervacije?IdBioskopa=${idBioskopa}&IdRezervacije=${r.getIdRezervacije()}&Otkazi=1">Otkaži rezervaciju</a></td>
		</tr>
		</c:if>
	</c:forEach>		
	</table>
	<br><br>
	<table class="table table-light">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Ime korisnika</th>
			<th scope="col">Naziv sale</th>
			<th scope="col">Naziv filma</th>
			<th scope="col">Broj sedišta</th>
			<th scope="col">Datum rezervacije</th>
			<th scope="col">Datum prikazivanja</th>
			<th scope="col">Vreme prikazivanja</th>
			<th scope="col">Cena karte</th>
			<th scope="col">Status</th>
		</tr>
	<c:forEach items="${rezervacije}" var="r" varStatus="hoop">
		<c:if test="${r.getStatus() == 'Potvrđena'}">
		<tr>
			<th scope="row">${hoop.index + 1}</th>	
			<td>${r.getImeKorisnika()}</td>
			<td>${r.getNazivSale()}</td>
			<td>${r.getNazivFilma()}</td>
			<td>${r.getBrojSedista()}</td>
			<td>${r.getDatumRezervacije()} / ${r.getVremeRezervacije()}</td>
			<td>${r.getDatumPrikazivanja()}</td>
			<td>${r.getVremePrikazivanja() }</td>
			<td>${r.getCenaKarte() }</td>
			<td>${r.getStatus()}</td>
		</tr>
		</c:if>
	</c:forEach>		
	</table>
	<br><br>
	<table class="table table-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Ime korisnika</th>
			<th scope="col">Naziv sale</th>
			<th scope="col">Naziv filma</th>
			<th scope="col">Broj sedišta</th>
			<th scope="col">Datum rezervacije</th>
			<th scope="col">Datum prikazivanja</th>
			<th scope="col">Vreme prikazivanja</th>
			<th scope="col">Cena karte</th>
			<th scope="col">Status</th>
		</tr>
	<c:forEach items="${rezervacije}" var="r" varStatus="lap"> 
		<c:if test="${r.getStatus() == 'Otkazana'}">
		<tr>
			<th scope="row">${lap.index + 1}</th>	
			<td>${r.getImeKorisnika()}</td>
			<td>${r.getNazivSale()}</td>
			<td>${r.getNazivFilma()}</td>
			<td>${r.getBrojSedista()}</td>
			<td>${r.getDatumRezervacije()} / ${r.getVremeRezervacije()}</td>
			<td>${r.getDatumPrikazivanja()}</td>
			<td>${r.getVremePrikazivanja()}</td>
			<td>${r.getCenaKarte() }</td>
			<td>${r.getStatus()}</td>
		</tr>
		</c:if>
	</c:forEach>
	</table>
</body>
</html>