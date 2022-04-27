package beans.cinemaplus;

public class Grad {
	//Fields
	int idGrada;
	String imeGrada;
	String drzava;
	
	//Constructors
	public Grad() {

	}
	public Grad(String imeGrada, String drzava)
	{
		this.imeGrada = imeGrada;
		this.drzava = drzava;
	}
	
	//Getters
	public int getIdGrada() {
		return idGrada;
	}
	public String getImeGrada() {
		return imeGrada;
	}
	public String getDrzava() {
		return drzava;
	}
	
	//Setters
	public void setIdGrada(int idGrada) {
		this.idGrada = idGrada;
	}
	public void setImeGrada(String imeGrada) {
		this.imeGrada = imeGrada;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
}
