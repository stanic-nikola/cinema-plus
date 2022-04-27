<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="klubovi" class="dao.KlubDao.KlubDao"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Klubovi</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/custom.css">
		</head>
	<body>
		<jsp:include page="header.jsp"/>
		<c:if test="${uspeh != null}">
		<div class="alert alert-success">${uspeh}</div>
		</c:if>
		<c:if test="${poruka != null}">
		<div class="alert alert-danger">${poruka}</div>
		</c:if>
    <h1 class="centerColorHeader">Klubovi</h1>
    <div id="mainKlubovi">
    <c:forEach items="${klubovi.vratiSveKlubove()}" var="klub">

                    <div class="containerKlubovi"><img class="klubb" src="${klub.getSlika()}"><h4 class="klubovi">Naziv kluba: ${klub.getNaziv()}</h4>
                    <label class="bojica">Opis:</label>
                    <h4>${klub.getOpis()}</h4>
                    <c:choose>
                     <c:when test = "${klub.getIdKluba() eq sessionScope.Klub.getIdKluba()}">
                        <h5><a href="IsclaniSe?Id=${sessionScope.Korisnik.getIdKorisnika()}">Iščlani se</a></h5>
                     </c:when>      
                     <c:when test = "${sessionScope.Klub.getIdKluba() == null}">
                        <h5><a href="UclaniSe?IdKluba=${klub.getIdKluba()}">Učlani se</a></h5>
                     </c:when>
                </c:choose>
                </div>
    </c:forEach>
    </div>
</body>
</html>