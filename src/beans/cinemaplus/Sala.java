package beans.cinemaplus;

public class Sala {
	//Fields
	int idSale;
	int idBioskopa;
	String nazivSale;
	String opis;
	int brojMesta;
	String tehnologija;
	
	//Constructors
	public Sala() {
	}
	public Sala(int idSale, String nazivSale, String opis, int brojMesta, String tehnologija)
	{
		this.idSale = idSale;
		this.nazivSale = nazivSale;
		this.opis = opis;
		this.brojMesta = brojMesta;
		this.tehnologija = tehnologija;
	}
	public Sala(String nazivSale, String opis, int brojMesta, String tehnologija, int IdBioskopa)
	{
		this.nazivSale = nazivSale;
		this.opis = opis;
		this.brojMesta = brojMesta;
		this.tehnologija = tehnologija;
		this.idBioskopa = IdBioskopa;
	}
	
	//Getters
	public int getIdSale() {
		return idSale;
	}
	public int getIdBioskopa() {
		return idBioskopa;
	}
	public String getNazivSale() {
		return nazivSale;
	}
	public String getOpis() {
		return opis;
	}
	public int getBrojMesta() {
		return brojMesta;
	}
	public String getTehnologija() {
		return tehnologija;
	}
	
	//Setters
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	public void setIdBioskopa(int idBioskopa) {
		this.idBioskopa = idBioskopa;
	}
	public void setNazivSale(String nazviSale) {
		this.nazivSale = nazviSale;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}
	public void setTehnologija(String tehnologija) {
		this.tehnologija = tehnologija;
	}
}
