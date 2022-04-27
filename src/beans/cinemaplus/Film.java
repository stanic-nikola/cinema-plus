package beans.cinemaplus;

import java.sql.Date;

public class Film {
	//Fields
	int idFilma;
	String nazivFilma;
	String opisFilma;
	String slika;
	String zanr;
	String trajanje;
	String trejler;
	Date datum;
	
	//Constructors
	public Film() {
	}
	public Film(String nazivFilma, String opisFilma, String slika, 
			String zanr, String trajanje, String trejler, Date datum)
	{
		this.nazivFilma = nazivFilma;
		this.opisFilma = opisFilma;
		this.slika = slika;
		this.zanr = zanr;
		this.trajanje = trajanje;
		this.trejler = trejler;
		this.datum = datum;

	}
	
	public Film(int IdFilma,String nazivFilma, String opisFilma, String slika, 
			String zanr, String trajanje, String trejler, Date datum)
	{
		this.idFilma = IdFilma;
		this.nazivFilma = nazivFilma;
		this.opisFilma = opisFilma;
		this.slika = slika;
		this.zanr = zanr;
		this.trajanje = trajanje;
		this.trejler = trejler;
		this.datum = datum;

	}

	//Getters
	public int getIdFilma() {
		return idFilma;
	}
	public String getNazivFilma() {
		return nazivFilma;
	}
	public String getOpisFilma() {
		return opisFilma;
	}
	public String getSlika() {
		return slika;
	}
	public String getZanr() {
		return zanr;
	}
	public String getTrajanje() {
		return trajanje;
	}
	public String getTrejler() {
		return trejler;
	}
	public Date getDatum() {
		return datum;
	}

	//Setters
	public void setIdFilma(int idFilma) {
		this.idFilma = idFilma;
	}
	public void setNazivFilma(String nazivFilma) {
		this.nazivFilma = nazivFilma;
	}
	public void setOpisFilma(String opisFilma) {
		this.opisFilma = opisFilma;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}
	public void setTrejler(String trejler) {
		this.trejler = trejler;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
}


