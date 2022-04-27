<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Učlani se u klub</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<form action="UclaniSe" method="post">
		<div class="cont">
		<h1>Klub: ${klub.getNaziv()}</h1>
			<input type="hidden" name="IdKluba" value="${klub.getIdKluba()}"/>
			<input type="hidden" name="IdKorisnika" value="${sessionScope.Korisnik.getIdKorisnika()}"/>
			<div>
			  <label class="bojica" for="TipClanstva">Odaberi tip članstva:</label><br>
			  <label class="bojica" for="TipClanstva">Basic</label> <input type="radio" name="TipClanstva" value="Basic" checked> <br>
			  <label class="bojica" for="TipClanstva">Standard</label> <input type="radio" name="TipClanstva" value="Standard"> <br>
			  <label class="bojica" for="TipClanstva">Premium</label> <input type="radio" name="TipClanstva" value="Premium"><br>

			</div><br>
			<input type="number" name="Sediste" class="form-control" placeholder="Broj sedišta"><br><br>
			<input type="submit" class="btn btn-dark" value="Učlani se"/>
			</div>
		</form>
	</body>
</html>