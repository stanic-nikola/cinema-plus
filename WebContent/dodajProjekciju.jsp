<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dodaj projekciju</title>
<link rel="icon" type="image" href="imgs/favicon.ico">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<c:choose>
		<c:when test="${sale eq null}">
			<h1 class="headnaslov">Odaberite bioskop:</h1>
			<table class="table table-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Naziv bioskopa</th>
				</tr>
				<c:forEach items="${bioskopi}" var="bioskop" varStatus="loop">

					<tr>
						<th scope="row">${loop.index + 1}</th>
						<td><a
							href="DodajProjekciju?IdBioskopa=${bioskop.getIdBioskopa()}">${bioskop.getNazivBioskopa()}</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>

		<c:when test="${sale != null}">
			<div>
				<div class="centerInput">
					<fieldset class="border-inputPro">
						<div id="naslov">
							<h2>Dodaj novu projekciju</h2>
						</div>
						<form role="form" action="DodajProjekciju" method="post"
							name="forma">
							<div class="form-group">
								<label for="NazivBioskopa">Naziv bioskopa</label> <input
									type="text" class="form-control" value="${NazivBioskopa}" name="NazivBioskopa"
									id="NazivFilma" disabled>
							</div>

							<div class="form-group">
								<label for="sale">Izaberite salu</label> <select
									class="form-control" name="sale">
									<c:forEach items="${sale}" var="sala">
										<option value="${sala.getIdSale()}">${sala.getNazivSale()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="NazivFilma">Naziv filma</label> <input type="text"
									class="form-control" value="${film.getNazivFilma()}" disabled>
							</div>
							<input type="hidden" name="IdFilma" value="${film.getIdFilma()}">
							<input type="hidden" name="IdKorisnika"
								value="${sessionScope.Korisnik.getIdKorisnika()}">

							<div class="form-group">
								<label for="CenaKarte">Cena karte</label> <input type="number"
									name="CenaKarte" class="form-control" placeholder="Unesite cenu karte">
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="NazivFilma">Datum projekcije:</label> <input
										type="date" name="Datum" class="form-control" />
								</div>
								<div class="form-group col-md-6">
									<label for="sati">Podesite vreme projekcije</label> 
									<select	name="sati" class="form-control">
										<c:forEach var="sat" items="${sati}">
											<option value="<c:out value="${sat}"/>"><c:out
													value="${sat}" /></option>
										</c:forEach>
									</select> 
									
									 <select name="minuti" class="form-control">
										<c:forEach var="minut" items="${minuti}">
											<option value="<c:out value="${minut}"/>"><c:out
													value="${minut}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<c:if test="${poruka != null}">
								<div class="alert alert-danger" role="alert">
									<span id="poruka">${poruka}</span>
								</div>
							</c:if>
							<div class="buttonspos">
								<input type="submit" class="btn btn-dark"
									value="Dodaj novu projekciju"> <input type="reset"
									class="btn btn-danger">
							</div>
						</form>
					</fieldset>
				</div>
			</div>
		</c:when>
	</c:choose>
</body>
</html>