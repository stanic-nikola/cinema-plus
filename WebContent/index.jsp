<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bioskopi" class="dao.BioskopDao.BioskopDao"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
    <link rel="icon" type="image" href="imgs/favicon.ico">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <link rel="icon" type="image" href="imgs/favicon.ico">
</head>
<body>
	<jsp:include page="header.jsp"/>
	   	<c:if test="${uspeh != null}">
		<div class="alert alert-success">${uspeh}</div>
		</c:if>
		<c:if test="${poruka != null}">
		<div class="alert alert-danger">${poruka}</div>
		</c:if>
    <div id="main">
    <c:forEach items="${bioskopi.vratiSveBioskope()}" var="bioskop">
        <div class="container"><h3 class="bioskopi">${bioskop.getNazivBioskopa()}</h3>
        <img class="bios" src="${bioskop.getSlika()}"><a id="repertoar" href="PrikazRepertoara?IdBioskopa=${bioskop.getIdBioskopa()}">Pogledaj repertoar</a></div>
    </c:forEach>
    </div>
</body>
</html>