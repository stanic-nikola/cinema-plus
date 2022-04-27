package beans.cinemaplus;

import java.sql.Date;
import java.sql.Time;

public class Repertoar {
	int idProjekcije;
	int idSale;
	int idFilma;
	Date datumPrikazivanja;
	Time vremePrikazivanja;
	double cenaKarte;
	int brojMesta;
	String tehnologija;
	String nazivSale;
	String nazivFilma;
	String slikaFilma;
	String trajanjeFilma;
	String zanr;
	
	public Repertoar() {}
	
	public Repertoar(int idPro, int idSal, int idFil, Date date, double cenaKa, 
			String nazivFi, String nazivSal, String slika, int brojMesta, 
			String tehnologija, String trajanje, String zanr, Time vremePrik)
	{
		this.idProjekcije = idPro;
		this.idSale = idSal;
		this.idFilma = idFil;
		this.datumPrikazivanja = date;
		this.cenaKarte = cenaKa;
		this.nazivFilma = nazivFi;
		this.nazivSale = nazivSal;
		this.slikaFilma = slika;
		this.brojMesta = brojMesta;
		this.tehnologija = tehnologija;
		this.trajanjeFilma = trajanje;
		this.zanr = zanr;
		this.vremePrikazivanja = vremePrik;
	}
	
	public int getIdProjekcije() {
		return idProjekcije;
	}
	public int getIdSale() {
		return idSale;
	}
	public int getIdFilma() {
		return idFilma;
	}
	public Date getDatumPrikazivanja() {
		return datumPrikazivanja;
	}
	public double getCenaKarte() {
		return cenaKarte;
	}
	public String getNazivFilma() {
		return nazivFilma;
	}
	public String getNazivSale() {
		return nazivSale;
	}
	public int getBrojMesta() {
		return brojMesta;
	}
	public String getSlikaFilma() {
		return slikaFilma;
	}
	public String getTehnologija() {
		return tehnologija;
	}
	public String getTrajanjeFilma() {
		return trajanjeFilma;
	}
	public String getZanr() {
		return zanr;
	}
	public Time getVremePrikazivanja() {
		return vremePrikazivanja;
	}
	
	public void setIdProjekcije(int idProjekcije) {
		this.idProjekcije = idProjekcije;
	}
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	public void setIdFilma(int idFilma) {
		this.idFilma = idFilma;
	}
	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}
	public void setDatumPrikazivanja(Date datumPrikazivanja) {
		this.datumPrikazivanja = datumPrikazivanja;
	}
	public void setNazivFilma(String nazivFilma) {
		this.nazivFilma = nazivFilma;
	}
	public void setNazivSale(String nazivSale) {
		this.nazivSale = nazivSale;
	}
	public void setSlikaFilma(String slikaFilma) {
		this.slikaFilma = slikaFilma;
	}
	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}
	public void setTehnologija(String tehnologija) {
		this.tehnologija = tehnologija;
	}
	public void setTrajanjeFilma(String trajanjeFilma) {
		this.trajanjeFilma = trajanjeFilma;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	public void setVremePrikazivanja(Time vremePrikazivanja) {
		this.vremePrikazivanja = vremePrikazivanja;
	}
}
