<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Rezervacija karata - ${film.getNazivFilma()}</title>
		<link rel="stylesheet" href="css/tabla.css">
		<link rel="icon" type="image" href="imgs/favicon.ico">
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/custom.css">
		</head>
	<body>
		<jsp:include page="header.jsp"/>
	${poruka}
    <div class="containerRezervacija">
        <form action="RezervacijaKarte" method="post">
        <div class="borfield">
            <div class="row">
                <div class="page-header">
                    <h1>Rezervacija karte za film: <span class="imeFilma">${film.getNazivFilma()}</span></h1>
                </div>
            </div>
            <hr class="sep">
            <div class="row povecaj">
                <Label class="bojica">Datum projekcije:</Label>
                <p><span class="polja">${projekcija.getDatum()}</span></p>
            </div>
            <div class="row povecaj">
                <Label class="bojica">Vreme početka projekcije:</Label>
                <p><span class="polja">${projekcija.getVreme()}</span></p>
            </div>
            <div class="row povecaj">
                <Label class="bojica">Naziv sale:</Label>
                <p><span class="polja">${sala.getNazivSale()}</span></p>
            </div>
            <div class="row bojica povecaj">
                <Label class="crvena">Cena karte:</Label>
                <p><span class="polja bojica">${projekcija.getCenaKarte()} din</span></p>
            </div>
            <br>
            <div class="row bojica povecaj centriraj">
                <Label class="crvena">Odaberite mesta:</Label>
            </div>
            <div class="pom">
                <div class="row platno">
                    <div >
                        <h5 id="marg">PLATNO</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="duka">
                       	 <c:forEach var="mesto" begin="1" end="${sala.getBrojMesta()}">
                       	 			<c:choose> 
									  <c:when test = "${fn:contains(rezSedista, mesto)}">
									         <input id="cb" type="checkbox" name="brojSedista" value="${mesto} checked disabled">
									  </c:when>
									  <c:otherwise>
							          		<input id="cb" type="checkbox" name="brojSedista" value="${mesto}">
							         </c:otherwise>
									</c:choose>
                       	 </c:forEach>
                    </div>
                </div>
            </div>
            <div class="row move">
                <p class="coloorful">možete maksimalno rezervisati 6 karata*</p>
            </div>
        <input type="hidden" name="IdProjekcije" value="${projekcija.getIdProjekcije()}">
		<input type="hidden" name="cenaKarte" value="${projekcija.getCenaKarte()}">
		<input type="hidden" name="idKorisnika" value="${sessionScope.Korisnik.getIdKorisnika()}">
            <div class="form-group">
                <input type="submit" class="btn btn-dark dugmic" value="Potvrdi rezervaciju">
            </div>
        </div>
    </form>
    </div>
	</body>
</html>