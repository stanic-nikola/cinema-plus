package dao.PrijavaDao;

import beans.cinemaplus.Korisnik;

public interface IPrijavaDao {
	Korisnik autentifikujKorisnika(String email, String password);
}	
