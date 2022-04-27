<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Rezervacije</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
<body>
	<jsp:include page="header.jsp"/>
	<h5>Preostali broj poena: ${sessionScope.BrojPoena}</h5>
	<br><br>
	<table class="table table-light">
		<tr>
			<th>Ime korisnika</th>
			<th>Naziv sale</th>
			<th>Naziv filma</th>
			<th>Broj sedišta</th>
			<th>Datum rezervacije</th>
			<th>Datum prikazivanja</th>
			<th>Vreme prikazivanja</th>
			<th>Cena karte</th>
			<th>Status</th>
			<th>Akcija</th>
		</tr>

	<c:forEach items="${rezervacije}" var="r">
		<tr>
			<td>${r.getImeKorisnika()}</td>
			<td>${r.getNazivSale()}</td>
			<td>${r.getNazivFilma()}</td>
			<td>${r.getBrojSedista()}</td>
			<td>${r.getDatumRezervacije()} / ${r.getVremeRezervacije()}</td>
			<td>${r.getDatumPrikazivanja()}</td>
			<td>${r.getVremePrikazivanja() }</td>
			<td>${r.getCenaKarte() }</td>
			<td>${r.getStatus()}</td>
			<c:if test="${r.getStatus() != \"Otkazana\" and sessionScope.BrojPoena > 0}"><td><a href="IskoristiPopust?IdRezervacije=${r.getIdRezervacije()}">Popust 10%</a> ||<a href="OtkaziRezervaciju?IdRezervacije=${r.getIdRezervacije()}">Otkaži rezervaciju</a></td></c:if>
		</tr>
	</c:forEach>	

	</table>
		<c:if test="${uspeh != null}">
		<div class="alert alert-success">${uspeh}</div>
		</c:if>
		<c:if test="${poruka != null}">
		<div class="alert alert-danger">${poruka}</div>
		</c:if>


	<br><br><br><br>
	
	
</body>
</html>