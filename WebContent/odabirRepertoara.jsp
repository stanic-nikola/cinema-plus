<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Repertoar - ${bioskop.getNazivBioskopa() }</title>
<link rel="icon" type="image" href="imgs/favicon.ico">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<c:if test="${sessionScope.Rola eq 'A'.charAt(0)}">
		<div class="alert alert-light rezervacije">
			<a href="PrikazRezervacija?IdBioskopa=${bioskop.getIdBioskopa()}">Pogledaj
				rezervacije za bioskop: ${bioskop.getNazivBioskopa()}</a>
		</div>
	</c:if>
	<div id="repheading">
		<h1>Bioskop: ${bioskop.getNazivBioskopa()}</h1>
		<h2 class="obojimi">Repertoari su podeljeni po danima, odaberite dan:</h2>
	</div>


	<div id="mainRepertoar">
		<form action="PrikazRepertoara" method="post">
			<c:forEach items="${datumi}" var="datum" varStatus="loop">
				<input type="hidden" name="nazivBioskopa"
					value="${bioskop.getNazivBioskopa()}">
				<input type="hidden" name="idBioskopa"
					value="${bioskop.getIdBioskopa()}">
				<c:choose>
					<c:when test="${loop.index == 0}">
						<div class="containerRepertoar">
							<button class="rep btnDan" name="datum" type="submit"
								value="<fmt:formatDate value="${datum}" pattern="YYYY-MM-dd"/>">
								<fmt:formatDate value="${datum}" pattern="dd/MM E" />
							</button>
						</div>
					</c:when>

					<c:otherwise>
						<div class="containerRepertoar">
							<button class="rep btnDan" name="datum" type="submit"
								value="<fmt:formatDate value="${datum}" pattern="YYYY-MM-dd"/>">
								<fmt:formatDate value="${datum}" pattern="dd/MM E" />
							</button> 
						</div>
					</c:otherwise>
				</c:choose>

			</c:forEach>
			<div class="row datumRepertoar">
				<label id="datumRep" for="datum" class="obojimi">Repertoar za datum</label> <input
					type="date" name="datum" class="form-control date" /><br> <br>
				<input type="submit" value="Pogledaj repertoar"
					class="form-control btn btn-dark">
			</div>
		</form>
	</div>

	<br>
	<br> ${poruka}

</body>
</html>