package beans.cinemaplus;

public class Izvestaj {
	//fields
	String datum;
	String naziv;
	String ukupnoPotvrdjenihRezervacija;
	String ukupanPrihod;
	String prihodBezPopusta;
	double razlika;
	
	//constructors
	public Izvestaj() {
	}
	
	//getters
	public String getDatum() {
		return datum;
	}
	public String getNaziv() {
		return naziv;
	}
	public String getPrihodBezPopusta() {
		return prihodBezPopusta;
	}
	public String getUkupanPrihod() {
		return ukupanPrihod;
	}
	public String getUkupnoPotvrdjenihRezervacija() {
		return ukupnoPotvrdjenihRezervacija;
	}
	public double getRazlika() {
		return razlika;
	}
	
	//setters
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public void setPrihodBezPopusta(String prihodBezPopusta) {
		this.prihodBezPopusta = prihodBezPopusta;
	}
	public void setUkupanPrihod(String ukupanPrihod) {
		this.ukupanPrihod = ukupanPrihod;
	}
	public void setUkupnoPotvrdjenihRezervacija(String ukupnoPotvrdjenihRezervacija) {
		this.ukupnoPotvrdjenihRezervacija = ukupnoPotvrdjenihRezervacija;
	}
	public void setRazlika(double razlika) {
		this.razlika = razlika;
	}
	
}
