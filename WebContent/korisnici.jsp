<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Prikaz korisnika</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>Korisnici</h1>
		<table class="table table-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Ime i prezime</th>
				<th scope="col">Nadimak</th>
				<th scope="col">Email</th>
				<th scope="col">Lozinka</th>
				<th scope="col">Rola</th>
				<th scope="col">Broj mobilnog</th>
				<th scope="col">Broj poena</th>
				<th scope="col">AKCIJE</th>
			</tr>
		<c:forEach items="${korisnici}" var="korisnik" varStatus="loop">
			<tr>
				<th scope="row">${loop.index + 1}</th>
				<td>${korisnik.getIme()} ${korisnik.getPrezime()}</td>
				<td>${korisnik.getNadimak()}</td>
				<td>${korisnik.getEmail()}</td>
				<td>${korisnik.getLozinka()}</td>
				<td>${korisnik.getRola()}</td>
				<td>${korisnik.getBrojMobilnog()}</td>
				<td>${korisnik.getBrojPoena()}</td>
				<td><a href="IzmeniKorisnika?IdKorisnika=${korisnik.getIdKorisnika()}">Ažuriraj korisnika</a> || 
				<a href="ObrisiKorisnika?IdKorisnika=${korisnik.getIdKorisnika()}">Obriši korisnika</a></td>
			</tr>
		</c:forEach>
		</table>
		<br>
		<h4><a class="bojica" href="dodajKorisnika.jsp">Dodaj korisnika</a></h4>
		<c:if test="${uspeh != null}">
		<div class="alert alert-success">${uspeh}</div>
		</c:if>
		<c:if test="${poruka != null}">
		<div class="alert alert-danger">${poruka}</div>
		</c:if>
	</body>
</html>