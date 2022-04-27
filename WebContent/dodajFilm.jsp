<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dodaj film</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		 <div>
        <div class="centerInput">
            <fieldset class="border-input">
            <div id="naslov">
                <h2>Dodaj novi film</h2>
            </div>            
            <form role="form" action="DodajFilm" method="post" name="forma">
                <div class="form-group">
                    <label for="NazivFilma">Naziv filma</label>
                    <input type="text" class="form-control" name="NazivFilma" id="NazivFilma" required>
                </div>
                <div class="form-group">
                    <label for="OpisFilma">Opis filma</label>
                    <input type="text" class="form-control" name="OpisFilma" id="OpisFilma" required>
                </div>
                <div class="form-group">
                  <label for="Slika">Link od slike filma:</label>
                  <textarea name="Slika" class="form-control" rows="3"></textarea>
                </div>
                <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="Zanr">Žanr</label>
                    <input type="text" class="form-control" name="Zanr" id="Zanr" placeholder="Akcija">
                </div>
                <div class="form-group col-md-6">
                    <label for="Trajanje">Trajanje</label>
                    <input type="text" class="form-control" name="Trajanje" id="Trajanje" placeholder="120 minuta">
                </div>
                </div>
                <div class="form-group">
                    <label for="Trejler">Link od trejlera:</label>
                    <textarea name="Trejler" class="form-control" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label for="Datum">Premijera:</label>
                    <input type="date" class="form-control" name="Datum"/>
                </div>
                <c:if test="${poruka != null}">
                	<div class="alert alert-danger" role="alert"><span id="poruka">${poruka}</span></div>
                </c:if>
                <div class="buttonspos">
                    <input type="submit" class="btn btn-dark buttonstyle" value="Dodaj novi film">
                    <input type="reset" class="btn btn-danger">
                </div>
              </form>
            </fieldset>
        </div>
    </div>
	</body>
</html>