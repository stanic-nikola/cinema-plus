<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nalog</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
		</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>Nalog</h1>
		<h3>Ime i prezime: ${sessionScope.Korisnik.getIme()} ${sessionScope.Korisnik.getPrezime()}</h3>
		<h3>Nadimak: ${sessionScope.Korisnik.getNadimak()}</h3>
		<h3>Email: ${sessionScope.Korisnik.getEmail()}</h3>
		<h3>Lozinka: ${sessionScope.Korisnik.getLozinka()}</h3>
		<h3>Rola: ${sessionScope.Korisnik.getRola()}</h3>
		<h3>Broj mobilnog: ${sessionScope.Korisnik.getBrojMobilnog()}</h3>
		<h3>Broj poena: ${sessionScope.Korisnik.getBrojPoena()}</h3>
		${poruka}
	</body>
</html>