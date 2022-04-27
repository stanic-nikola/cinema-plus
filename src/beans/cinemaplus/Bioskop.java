package beans.cinemaplus;

public class Bioskop {
	//Fields
	int idBioskopa;
	int idGrada;
	String nazivBioskopa;
	String adresa;
	String slika;
	String opis;
	
	//Constructors
	public Bioskop() {
	}
	public Bioskop(int idBioskopa, String nazivBioskopa, String adresa, String slika, String opis)
	{
		this.idBioskopa = idBioskopa;
		this.nazivBioskopa = nazivBioskopa;
		this.adresa = adresa;
		this.slika = slika;
		this.opis = opis;
	}
	public Bioskop(String nazivBioskopa, String adresa, String slika, String opis, int idGrada)
	{
		this.nazivBioskopa = nazivBioskopa;
		this.adresa = adresa;
		this.slika = slika;
		this.opis = opis;
		this.idGrada = idGrada;
	}
	
	//Getters
	public int getIdBioskopa() {
		return idBioskopa;
	}
	public int getIdGrada() {
		return idGrada;
	}
	public String getNazivBioskopa() {
		return nazivBioskopa;
	}
	public String getAdresa() {
		return adresa;
	}
	public String getSlika() {
		return slika;
	}
	public String getOpis() {
		return opis;
	}

	//Setters
	public void setNazivBioskopa(String nazivBioskopa) {
		this.nazivBioskopa = nazivBioskopa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public void setIdBioskopa(int idBioskopa) {
		this.idBioskopa = idBioskopa;
	}
}
