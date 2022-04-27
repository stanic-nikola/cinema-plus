package beans.cinemaplus;

public class Klub {
	//Fields
	int idKluba;
	String naziv;
	String opis;
	String slika;
	int popust;
	
	//Constructors
	public Klub() {
	}
	public Klub(String naziv, String opis, String slika, int popust)
	{
		this.naziv = naziv;
		this.opis = opis;
		this.slika = slika;
		this.popust = popust;
	}

	//Getters
	public int getIdKluba() {
		return idKluba;
	}
	public String getNaziv() {
		return naziv;
	}
	public String getOpis() {
		return opis;
	}
	public String getSlika() {
		return slika;
	}
	public int getPopust() {
		return popust;
	}
	
	//Setters
	public void setIdKluba(int idKluba) {
		this.idKluba = idKluba;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	public void setPopust(int popust) {
		this.popust = popust;
	}
}
