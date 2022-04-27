<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gradovi" class="dao.GradDao.GradDao"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dodaj bioskop</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<form action="DodajBioskop" method="post">
		<h1>Dodaj bioskop:</h1>
			<select name="grad">
				<c:forEach items="${gradovi.vratiSveGradove()}" var="grad">
	          		 <option value="${grad.getIdGrada()}">${grad.getImeGrada()}</option>
	            </c:forEach>
			</select><br><br>
			<input type="text" name="NazivBioskopa" placeholder="Naziv bioskopa"><br><br>
			<input type="text" name="Adresa" placeholder="Adresa bioskopa"><br><br>
			<textarea cols="50" name="Slika" rows="3" placeholder="Link od logoa bioskopa"></textarea><br><br>
			<input type="text" name="Opis" placeholder="Opis bioskopa"><br><br>
			<input type="submit" value="Dodaj bioskop"/>
		</form>
	</body>
</html>