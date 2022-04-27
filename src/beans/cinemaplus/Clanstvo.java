package beans.cinemaplus;

public class Clanstvo {
	//Fields
	int idClanstva;
	int idKluba;
	int idKorisnika;
	String tipClanstva;
	int sediste;
	
	//Constructors
	public Clanstvo() {
	}
	public Clanstvo(int idKluba, int idKorisnika, String tipClanstva, int sediste)
	{
		this.idKluba = idKluba;
		this.idKorisnika = idKorisnika;
		this.tipClanstva = tipClanstva;
		this.sediste = sediste;
	}

	//Getters
	public int getIdClanstva() {
		return idClanstva;
	}
	public int getIdKluba() {
		return idKluba;
	}
	public int getIdKorisnika() {
		return idKorisnika;
	}
	public String getTipClanstva() {
		return tipClanstva;
	}
	public int getSediste() {
		return sediste;
	}
	
	//Setters
	public void setIdClanstva(int idClanstva) {
		this.idClanstva = idClanstva;
	}
	public void setIdKluba(int idKluba) {
		this.idKluba = idKluba;
	}
	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	public void setTipClanstva(String tipClanstva) {
		this.tipClanstva = tipClanstva;
	}
	public void setSediste(int sediste) {
		this.sediste = sediste;
	}
	

}
