package beans.cinemaplus;

import java.sql.Time;
import java.util.Date;

public class Rezervacija {
	//Fields
	int idRezervacije;
	int idKorisnika;
	int idProjekcije;
	int brojSedista;
	Date datumRezervacije;
	Time vremeRezervacije;
	String status;
	
	String imeKorisnika;
	String nazivSale;
	String nazivFilma;
	Date datumPrikazivanja;
	Time vremePrikazivanja;
	double cenaKarte;	
	
	//Constructors
	public Rezervacija() {
	}
	public Rezervacija(int idRezervacije, int idKorisnika, int idProjekcije, int brojSedista, Date datumRezervacije)
	{
		this.idRezervacije = idRezervacije;
		this.idKorisnika = idKorisnika;
		this.idProjekcije = idProjekcije;
		this.brojSedista = brojSedista;
		this.datumRezervacije = datumRezervacije;
		this.status = "Aktivna";
	}

	//Getters
	public int getIdRezervacije() {
		return idRezervacije;
	}
	public int getIdKorisnika() {
		return idKorisnika;
	}
	public int getIdProjekcije() {
		return idProjekcije;
	}
	public int getBrojSedista() {
		return brojSedista;
	}
	public Date getDatumRezervacije() {
		return datumRezervacije;
	}
	public String getStatus() {
		return status;
	}
	public Time getVremeRezervacije() {
		return vremeRezervacije;
	}
	public double getCenaKarte() {
		return cenaKarte;
	}
	public Date getDatumPrikazivanja() {
		return datumPrikazivanja;
	}
	public String getImeKorisnika() {
		return imeKorisnika;
	}
	public String getNazivFilma() {
		return nazivFilma;
	}
	public String getNazivSale() {
		return nazivSale;
	}
	public Time getVremePrikazivanja() {
		return vremePrikazivanja;
	}

	
	//Setters
	public void setIdRezervacije(int idRezervacije) {
		this.idRezervacije = idRezervacije;
	}
	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	public void setIdProjekcije(int idProjekcije) {
		this.idProjekcije = idProjekcije;
	}
	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}
	public void setDatumRezervacije(Date datumRezervacije) {
		this.datumRezervacije = datumRezervacije;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setVremeRezervacije(Time vremeRezervacije) {
		this.vremeRezervacije = vremeRezervacije;
	}
	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}
	public void setDatumPrikazivanja(Date datumPrikazivanja) {
		this.datumPrikazivanja = datumPrikazivanja;
	}
	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}
	public void setNazivFilma(String nazivFilma) {
		this.nazivFilma = nazivFilma;
	}
	public void setNazivSale(String nazivSale) {
		this.nazivSale = nazivSale;
	}
	public void setVremePrikazivanja(Time vremePrikazivanja) {
		this.vremePrikazivanja = vremePrikazivanja;
	}
}
