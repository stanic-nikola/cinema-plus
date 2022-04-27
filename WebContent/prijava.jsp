<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prijava</title>
    <link rel="icon" type="image" href="imgs/favicon.ico">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/validacijaLozinke.js"></script>
    <script src="js/validacijaNaloga.js"></script>
</head>
<body>
  	<jsp:include page="header.jsp"/>
    <div>
        <div class="center">
            <fieldset class="border-fd prijavafd">
            <div id="naslov">
                <h2 >Prijava</h2>
            </div>            
            <form role="form" action="Prijava" method="post" name="forma" onsubmit="return proveri()">
                <div class="form-group">
                  <label for="email">Email</label>
                  <input type="text" class="form-control" name="email" id="email" autofocus placeholder="petarpetrovic@gmail.com" required>
                </div>
                <div class="form-group">
                    <label for="lozinka">Lozinka</label>
                    <input type="password" class="form-control" name="lozinka" id="lozinka" placeholder="*******" required onfocus="skloni()">
                </div>
                <c:if test="${uspeh != null}">
                	<div class="alert alert-success" id="skloni" role="alert"><span id="poruka">${uspeh}</span></div>
                </c:if>
                <c:if test="${poruka != null}">
                	<div class="alert alert-danger" role="alert"><span id="poruka">${poruka}</span></div>
                </c:if>
                <span id="ispis"></span>
                <div class="buttonspos">
                    <input type="submit" class="btn btn-dark lbtn buttonstyle" value="Prijavi se">
                    <a href="registracija.jsp" class="btn btn-dark loginbtn buttonstyle">Registruj se</a>
                </div>
              </form>
            </fieldset>
        </div>
    </div>
</body>
</html>