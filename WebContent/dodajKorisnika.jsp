<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Dodavanje korisnika</title>
		<link rel="icon" type="image" href="imgs/favicon.ico">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="userBorder">
		<h2 class="blackCol">Dodaj korisnika</h2>
		<form action="DodajKorisnika" method="post">
			<div class="form-group">
				<label for="imeKorisnika">Ime korisnika:</label>
				<input type="text" name="imeKorisnika" class="form-control">
			</div>
			<div class="form-group">
				<label for="prezimeKorisnika">Prezime korisnika:</label>
				<input type="text" name="prezimeKorisnika" class="form-control">
			</div>
			<div class="form-group">
				<label for="nadimak">Nadimak:</label>
				<input type="text" name="nadimak" class="form-control">
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="email" name="email" class="form-control">
			</div>
			<div class="form-group">
				<label for="lozinka">Lozinka:</label>
				<input type="password" name="lozinka" class="form-control">
			</div>
			<div class="form-group">
				<label for="BrojMobilnog">Broj mobilnog:</label>
				<input type="text"  placeholder="+381xxxxxxxxx" maxlength="13" pattern="+[0-9]{12}" required name="brojMobilnog" class="form-control">
			</div>
			  <div class="form-group">
		    <label for="rola">Odaberite rolu korisnika:</label>
			    <select class="form-control" name="rola" id="rola">
			      <option value="A">Admin</option>
			      <option value="M">Menadžer</option>
			      <option value="K">Korisnik</option>
			    </select>
		  </div>
		  <input type="submit" class="btn btn-dark" value="Dodaj korisnika">
		</form>
		</div>
	</body>
</html>