<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Izveštaji</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	    <link rel="stylesheet" href="css/bootstrap.css">
	    <link rel="stylesheet" href="css/custom.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
	    <div class="row">
	        <div class="col-md">
	            <h2><a class="whiteColor" href="PrikazIzvestaja?Tip=Dnevni">Dnevni izveštaj</a></h2>
	        </div>
	        <div class="col-md">
	            <h2><a class="whiteColor" href="PrikazIzvestaja?Tip=Mesecni">Mesečni izveštaj</a></h2>
	        </div>
	        <div class="col-md">
	            <h2><a class="whiteColor" href="PrikazIzvestaja?Tip=Godisnji">Godišnji izveštaj</a></h2>
	        </div>
	    </div>
		<br><br><br>
		<c:choose>
         <c:when test = "${dnevni != null}">
         <div class="centriraj">
         <h4>Odaberite datum za prikaz izveštaja:</h4>
			<form action="PrikazIzvestaja" method="post">
				<input class="form-control" type="date" name="datum"/><br>
				<input type="submit" class="btn btn-dark" value="Prikaži izveštaj">
			
			</form>
			</div>
         </c:when>
         
         <c:when test = "${meseci != null}">
			<form action="PrikazIzvestaja" method="post">
				<div class="centriraj">
				<h4>Odaberite mesec za prikaz izveštaja:</h4>
				<input class="form-control" type="text" name="godina" value="2020" disabled/> <br><br>
				 <select class="form-control" name="mesec">
					<c:forEach var="mesec" items="${meseci}" varStatus="loop">
						<option value="<c:out value="${loop.index + 1}"/>"><c:out value="${mesec}"/></option>
					</c:forEach>
				</select><br>
				<input type="submit" class="btn btn-dark" value="Prikaži izveštaj">
				</div>
			</form>
         </c:when>
         
         <c:when test = "${godine != null}">
				<form action="PrikazIzvestaja" method="post">
				 <div class="centriraj">
				 <h4>Odaberite godinu za prikaz izveštaja:</h4> 
				 <select class="form-control" name="godina">
					<c:forEach var="godina" items="${godine}">
						<option value="<c:out value="${godina}"/>"><c:out value="${godina}"/></option>
					</c:forEach>
				</select><br>
				<input type="submit" class="btn btn-dark" value="Prikaži izveštaj">
				</div>
				</form>
         </c:when>
      </c:choose>
			${poruka }
	</body>
</html>