<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ažuriraj film</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		
		 <div>
        <div class="centerInput">
            <fieldset class="border-input boja">
            <div id="naslov">
                <h2>Ažuriraj film</h2>
            </div>            
            <form role="form" action="IzmeniFilm" method="post" name="forma">
            	<input type="hidden" name="IdFilma" value="${film.getIdFilma()}"/>
                <div class="form-group">
                    <label for="NazivFilma">Naziv filma</label>
                    <input type="text" class="form-control" name="NazivFilma" id="NazivFilma" value="<c:out value="${film.getNazivFilma()}"/>" required>
                </div>
                <div class="form-group">
                    <label for="OpisFilma">Opis filma</label>
                    <input type="text" class="form-control" name="OpisFilma" id="OpisFilma" value="<c:out value="${film.getOpisFilma()}"/>" required>
                </div>
                <div class="form-group">
                  <label for="Slika">Link od slike filma:</label>
                  <textarea name="Slika" class="form-control" rows="3" ><c:out value="${film.getSlika()}"/></textarea>
                </div>
                <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="Zanr">Žanr</label>
                    <input type="text" class="form-control" name="Zanr" id="Zanr" value="<c:out value="${film.getZanr()}"/>">
                </div>
                <div class="form-group col-md-6">
                    <label for="Trajanje">Trajanje</label>
                    <input type="text" class="form-control" name="Trajanje" id="Trajanje" value="<c:out value="${film.getTrajanje()}"/>">
                </div>
                </div>
                <div class="form-group">
                    <label for="Trejler">Link od trejlera:</label>
                    <textarea name="Trejler" class="form-control" rows="3"><c:out value="${film.getTrejler()}"/></textarea>
                </div>
                <div class="form-group">
                    <label for="Datum">Premijera:</label>
                    <input type="date" class="form-control" name="Datum" value="<c:out value="${film.getDatum()}"/>"/>
                </div>
                <c:if test="${poruka != null}">
                	<div class="alert alert-danger" role="alert"><span id="poruka">${poruka}</span></div>
                </c:if>
                <div class="buttonspos">
                    <input type="submit" class="btn btn-dark buttonstyle" value="Ažuriraj film">
                    <input type="reset" class="btn btn-danger">
                </div>
              </form>
            </fieldset>
        </div>
    </div>
	</body>
</html>