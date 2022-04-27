<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="filmovi" class="dao.FilmDao.FilmDao"/>
<!DOCTYPE html>
<html>
	<head>
		    <meta charset="UTF-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		    <title>Filmovi</title>
		    <link rel="icon" type="image" href="imgs/favicon.ico">
		    <link rel="stylesheet" href="css/bootstrap.css">
		    <link rel="stylesheet" href="css/custom.css">
		</head>
	<body>
		<jsp:include page="header.jsp"/>
		<c:if test="${poruka != null}">
			<h3 class="filmHead alert alert-success">${poruka}</h3>
		</c:if>
		<div id="mainFilmovi">
		<c:forEach items="${filmovi.vratiSveFilmove()}" var="film">
			<div class="containerFilmovi"><a href="PrikazFilma?IdFilma=${film.getIdFilma()}"><img class="film" 
			src="${film.getSlika()}"></a><h4 class="filmovi">${film.getNazivFilma()}</h4></div>
		</c:forEach>
				<c:if test="${sessionScope.Rola eq 'A'.charAt(0)}">
				<div class="containerFilmovi"><a href="dodajFilm.jsp">
				<img class="filmDodaj" src="https://i.ibb.co/JF0gDp4/analog-film-equipment.jpg"></a>
				<h4 class="filmoviDodaj"><a>Dodaj novi film</a></h4></div>
		</c:if>
		</div>
	</body>
</html>