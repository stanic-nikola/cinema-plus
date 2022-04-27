package dao.RezervacijaDao;

import java.util.ArrayList;
import java.util.List;

import beans.cinemaplus.Rezervacija;

public interface IRezervacijaDao {
	int dodajRezervacije(int idProjekcije,double cenaKarte, List<Integer> brojeviSedista, int IdKorisnika);
	int dodajRezervaciju(int idProjekcije, double cenaKarte, int brojSedista, int IdKorisnika);
	ArrayList<Rezervacija> rezervacijePoIdBioskopa(int idBioskopa);
	void promeniStatusRezervacije(int idRezervacije, String status);
	ArrayList<Rezervacija> rezervacijePoIdKorisnika(int idKorisnika);
	void umanjiCenuKarte(int idRezervacije, double umanjenaCena);
	Rezervacija vratiRezervacijuPoId(int idRezervacije);
	void otkaziNepotvrdjeneRezervacije(String datum);
	ArrayList<Integer>  vratiRezervisanaSedista(int idProjekcije);
}
