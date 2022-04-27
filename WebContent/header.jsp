<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bioskopi" class="dao.BioskopDao.BioskopDao"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    <link rel="shortcut icon" href=""/>
    <link rel="icon" type="image" href="imgs/favicon.ico">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
</head>

<body>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark header">
        <a class="navbar-brand" href="index.jsp">
            <img src="https://i.ibb.co/jG0f94v/27-Artstation-logo-logos-512.png" alt="Logo" width="30" height="30">
        </a>
        <a class="navbar-brand" id="d" href="index.jsp">CinemaPlus</a>
			<a></a>
        	<a href="filmovi.jsp">Filmovi</a>
			<a></a>
			
			<div class="nav-item dropdown" id="menu">
	            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	             Odaberi bioskop
	            </a>
	            <div class="dropdown-menu dropdown-menu" role="menu" aria-labelledby="dLabel">
	            
	            <c:forEach items="${bioskopi.vratiSveBioskope()}" var="bioskop">
	            	   <a class="dropdown-item" href="PrikazRepertoara?IdBioskopa=${bioskop.getIdBioskopa()}">${bioskop.getNazivBioskopa()}</a>
	            </c:forEach>
	            </div>
	          </div>
	         <c:if test="${sessionScope.Rola eq 'M'.charAt(0)}">
				 <a href="izvestaji.jsp">Izveštaji</a>
			</c:if>
	        <c:if test="${sessionScope.Rola eq 'K'.charAt(0)}">
	        	  <li id="menu"><a href="klubovi.jsp">Fan klub</a></li>
	        </c:if>

			

        	<!-- Sign in / header / Menu -->
			<c:if test="${sessionScope.Korisnik.getIme() eq null}">
			<div class="ml-auto">
				<img src="imgs/signinlogo.png" width="20" height="20" alt="Prijavi se logo"/>
				<a href="prijava.jsp" >Prijavi se</a>
			</div>
            </c:if>
            
            

            <c:if test="${sessionScope.Korisnik.getIme() != null}">
                 <div class="ml-auto"></div>
                 <c:if test="${sessionScope.Klub.getIdKluba() != null}">
			         <div class="nav-item">
						<a class="dropdown-item klub" href="PrikazClanstva"><img src="${sessionScope.Klub.getSlika()}" alt="club" width="70" height="20"></a>
					 </div>
				</c:if>
				<div class="nav-item dropdown" id="menu">
	            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	              ${sessionScope.Korisnik.getNadimak()}
	            </a>
	            <div class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="dLabel">
	            
	            <c:if test="${sessionScope.Rola eq 'A'.charAt(0)}">
				 <a class="dropdown-item" href="PrikazKorisnika">Korisnici</a>
				 <a class="dropdown-item" href="Bioskopi">Bioskopi</a>
			 	 <div class="dropdown-divider"></div>
				</c:if>
				<c:if test="${sessionScope.Rola eq 'M'.charAt(0)}">
		
				</c:if>
				<c:if test="${sessionScope.Rola eq 'K'.charAt(0)}">
					<a class="dropdown-item" href="RezervacijeKorisnika">Rezervacije</a>
				<c:if test="${sessionScope.Klub.getNaziv() == null}">
					${sessionScope.Klub.getNaziv()}
					 <a class="dropdown-item" href="klubovi.jsp">Učlani se u klub</a> 
				</c:if>
					
				</c:if>
	              <a class="dropdown-item" href="nalog.jsp">Nalog</a>
	              <c:if test="${sessionScope.Rola eq 'K'.charAt(0)}">
	              <div class="dropdown-divider"></div>
	              <a class="dropdown-item" href="#">Poeni ${sessionScope.BrojPoena} <img src="imgs/pointsicon.png" alt="points" width="30" height="25"></a>
	              </c:if>

	              <div class="dropdown-divider"></div>
	              <a class="dropdown-item" href="Odjava">Odjavi se</a>
	            </div>
	          </div>
            </c:if>

            <!-- //Menu -->
      </nav>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>
