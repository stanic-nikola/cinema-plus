<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Izveštaj - ${izvestaj.getNaziv()}</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	    <link rel="stylesheet" href="css/bootstrap.css">
	    <link rel="stylesheet" href="css/custom.css">
	</head>
	<body>
	<jsp:include page="header.jsp"/>
		<h1 class="centerColorHeader">Naziv izveštaja - ${izvestaj.getNaziv()}</h1>
		<div class="conti">

		<table class="table table-dark tbBorder">
		<c:if test="${izvestaj.getNaziv() == 'Dnevni izveštaj'}">
		<tr>
			<th>Izveštaj za datum:</th><td>${izvestaj.getDatum()}</td>
		</tr>
		<tr>
			<th>Ukupan broj potvrđenih rezervacija:</th><td>${izvestaj.getUkupnoPotvrdjenihRezervacija()}</td>
		</tr>
		<tr>
			<th>Ukupan prihod sa popustom:</th><td>${izvestaj.getUkupanPrihod()}RSD</td>
		</tr>
		<tr>
			<th>Ukupan prihod bez popusta:</th><td>${izvestaj.getPrihodBezPopusta()}RSD</td>
		</tr>
		<tr>
			<th>Razlika prihoda:</th><td>${izvestaj.getRazlika()}RSD</td>
		</tr>
		</c:if>
		
		
		<c:if test="${izvestaj.getNaziv() == 'Godišnji izveštaj'}">
			<tr>
			<th>Izveštaj za datum:</th><td>${izvestaj.getDatum()}</td>
		</tr>
		<tr>
			<th>Ukupan broj potvrđenih rezervacija:</th><td>${izvestaj.getUkupnoPotvrdjenihRezervacija()}</td>
		</tr>
		<tr>
			<th>Ukupan prihod sa popustom:</th><td>${izvestaj.getUkupanPrihod()}RSD</td>
		</tr>
		<tr>
			<th>Ukupan prihod bez popusta:</th><td>${izvestaj.getPrihodBezPopusta()}RSD</td>
		</tr>
		<tr>
			<th>Razlika prihoda:</th><td>${izvestaj.getRazlika()}RSD</td>
		</tr>
		<h2></h2>
		
		</c:if>
		
		<c:if test="${izvestaj.getNaziv() == 'Mesečni izveštaj'}">
		<tr>
			<th>Izveštaj za datum:</th><td>${izvestaj.getDatum()}</td>
		</tr>
		<tr>
			<th>Ukupan broj potvrđenih rezervacija:</th><td>${izvestaj.getUkupnoPotvrdjenihRezervacija()}</td>
		</tr>
		<tr>
			<th>Ukupan prihod sa popustom:</th><td>${izvestaj.getUkupanPrihod()}RSD</td>
		</tr>
		<tr>
			<th>Ukupan prihod bez popusta:</th><td>${izvestaj.getPrihodBezPopusta()}RSD</td>
		</tr>
		<tr>
			<th>Razlika prihoda:</th><td>${izvestaj.getRazlika()}RSD</td>
		</tr>
		</c:if>
		</table>
		<br><br>
		<button class="btn btn-dark" onclick="window.print()">Odštampaj izveštaj</button>
		</div>
		<h1>${poruka}</h1>
	</body>
</html>