package beans.cinemaplus;

import java.sql.Date;
import java.sql.Time;

public class Projekcija {
	//Fields
	int idProjekcije;
	int idSale;
	int idFilma;
	String datumVreme;
	double cenaKarte;
	int idKorisnika;
	Date datum;
	Time vreme;
	String nazivBioskopa;
	String nazivSale;
	
	//Constructors
	public Projekcija()
	{
		
	}
	public Projekcija(int idSale, int idFilma, String datumVreme, double cenaKarte, int idKorisnika)
	{
		this.idSale = idSale;
		this.idFilma = idFilma;
		this.datumVreme = datumVreme;
		this.cenaKarte = cenaKarte;
		this.idKorisnika = idKorisnika;
	}
	public Projekcija(int idProjekcije,int idSale, int idFilma, String datumVreme, double cenaKarte, int idKorisnika)
	{
		this.idProjekcije = idProjekcije;
		this.idSale = idSale;
		this.idFilma = idFilma;
		this.datumVreme = datumVreme;
		this.cenaKarte = cenaKarte;
		this.idKorisnika = idKorisnika;
	}
	public Projekcija(int idSale, int idFilma, String datumVreme, double cenaKarte, Date datum, Time vreme)
	{
		this.idSale = idSale;
		this.idFilma = idFilma;
		this.datumVreme = datumVreme;
		this.cenaKarte = cenaKarte;
		this.datum = datum;
		this.vreme = vreme;
	}

	//Getters
	public int getIdProjekcije() {
		return idProjekcije;
	}
	public int getIdSale() {
		return idSale;
	}
	public int getIdFilma() {
		return idFilma;
	}
	public String getDatumVreme() {
		return datumVreme;
	}
	public double getCenaKarte() {
		return cenaKarte;
	}
	public int getIdKorisnika() {
		return idKorisnika;
	}
	public Date getDatum() {
		return datum;
	}
	public Time getVreme() {
		return vreme;
	}
	public String getNazivBioskopa() {
		return nazivBioskopa;
	}
	public String getNazivSale() {
		return nazivSale;
	}
	
	//Setters
	public void setIdProjekcije(int idProjekcije) {
		this.idProjekcije = idProjekcije;
	}
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	public void setIdFilma(int idFilma) {
		this.idFilma = idFilma;
	}
	public void setDatumVreme(String datumVreme) {
		this.datumVreme = datumVreme;
	}
	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}
	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public void setVreme(Time vreme) {
		this.vreme = vreme;
	}
	public void setNazivBioskopa(String nazivBioskopa) {
		this.nazivBioskopa = nazivBioskopa;
	}
	public void setNazivSale(String nazivSale) {
		this.nazivSale = nazivSale;
	}
}
