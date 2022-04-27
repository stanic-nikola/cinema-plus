<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <title>Registracija</title>
        <link rel="icon" type="image" href="imgs/favicon.ico">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">
        <script src="js/validacijaLozinke.js"></script>
        <script src="js/validacijaNaloga.js"></script>
    </head>
    <body>
 		<jsp:include page="header.jsp"/>
        <div class="center">
            <fieldset class="border-fd">
            <div id="naslov">
                <h2 >Registracija</h2>
            </div>            
            <form role="form" action="Registracija" method="post" name="forma" onsubmit="return proveri()" >
                <div class="form-row">
                  <div class="form-group col-md-6">
                    <label for="ime">Ime</label>
                    <input type="text" class="form-control" name="ime" id="ime" autofocus placeholder="Petar" required>
                  </div>
                  <div class="form-group col-md-6">
                    <label for="prezime">Prezime</label>
                    <input type="text" class="form-control" name="prezime" id="prezime" placeholder="Petrović" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="nadimak">Nadimak</label>
                  <input type="text" class="form-control" name="nadimak" id="nadimak" placeholder="Pera98" required>
                </div>
                <div class="form-group">
                  <label for="email">Email</label>
                  <input type="text" class="form-control" name="email" id="email" placeholder="petarpetrovic@gmail.com" required>
                </div>
                <div class="form-group">
                  <label for="brojMobilnog">Broj mobilnog</label>
                  <input type="text" class="form-control" name="brojMobilnog" id="brojMobilnog" placeholder="+381xxxxxxxxx" maxlength="13" pattern="+[0-9]{12}" required onfocusout="validiraj()">
                </div>
                <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="lozinka">Lozinka</label>
                    <input type="password" class="form-control" name="lozinka" id="lozinka" placeholder="*******" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="lozinka">Ponovi lozinku</label>
                    <input type="password" class="form-control" name="ponoviLozinku" id="ponoviLozniku" placeholder="*******" required>
                </div>
                </div>
                <c:if test="${poruka != null }">
                <div class="alert alert-danger" role="alert"><span id="poruka">${poruka}</span></div>
                </c:if>
                <div id="ispis"></div>
                <div class="buttonspos">
                    <input type="submit" class="btn btn-dark regbtn buttonstyle" value="Registruj se">
                    <a href="prijava.jsp" class="btn btn-dark nbtn buttonstyle">Prijavi se</a>
                </div>
              </form>
            </fieldset>
        </div>
    </body>
</html>