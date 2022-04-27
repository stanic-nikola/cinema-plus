package dao.KorisnikDao;

import java.util.ArrayList;

import beans.cinemaplus.Korisnik;

public interface IKorisnikDao {
	ArrayList<Korisnik> vratiSveKorisnike();
	Korisnik vratiKorisnikaPoId(int idKorisnika);
	int dodajKorisnika(Korisnik noviKorisnik);
	void obrisiKorisnika(int idKorisnika);
	int azurirajKorisnika(Korisnik azuriranKorisnik);
	ArrayList<Korisnik> vratiKorisnikeBezAdmina(int IdAdmina);
	void promeniPoeneKorisnika(int IdKorisnika, int brojPoena);
	Korisnik vratiKorisnikaPoIdRezervacije(int IdRezervacije);
	boolean proveriEmail(String email);
}
