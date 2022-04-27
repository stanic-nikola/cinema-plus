package beans.cinemaplus;

public class Korisnik {
	//Fields
	int idKorisnika;
	String ime;
	String prezime;
	String nadimak;
	String email;
	String lozinka;
	char rola;
	String brojMobilnog;
	int brojPoena;
	
	//Constructors
	public Korisnik() {
	}
	public Korisnik(String ime, String prezime, 
			String nadimak, String email, String lozinka, String brojMobilnog)
	{
		this.ime = ime;
		this.prezime = prezime;
		this.nadimak = nadimak;
		this.email = email;
		this.lozinka = lozinka;
		this.rola = 'K';
		this.brojMobilnog = brojMobilnog;
		this.brojPoena = 0;
	}
	public Korisnik(String ime, String prezime, 
			String nadimak, String email, String lozinka,String brojMobilnog, char rola)
	{
		this.ime = ime;
		this.prezime = prezime;
		this.nadimak = nadimak;
		this.email = email;
		this.lozinka = lozinka;
		this.rola = 'K';
		this.brojMobilnog = brojMobilnog;
		this.rola = rola;
	}
	public Korisnik(int id,String ime, String prezime, 
			String nadimak, String email, String lozinka,String brojMobilnog, char rola)
	{
		this.idKorisnika = id;
		this.ime = ime;
		this.prezime = prezime;
		this.nadimak = nadimak;
		this.email = email;
		this.lozinka = lozinka;
		this.rola = 'K';
		this.brojMobilnog = brojMobilnog;
		this.rola = rola;
	}
	
	//Getters
	public int getIdKorisnika() {
		return idKorisnika;
	}
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public String getNadimak() {
		return nadimak;
	}
	public String getEmail() {
		return email;
	}
	public String getLozinka() {
		return lozinka;
	}
	public char getRola() {
		return rola;
	}
	public String getBrojMobilnog() {
		return brojMobilnog;
	}
	public int getBrojPoena() {
		return brojPoena;
	}
	
	//Setters
	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public void setNadimak(String nadimak) {
		this.nadimak = nadimak;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public void setRola(char rola) {
		this.rola = rola;
	}
	public void setBrojMobilnog(String brojMobilnog) {
		this.brojMobilnog = brojMobilnog;
	}
	public void setBrojPoena(int brojPoena) {
		this.brojPoena = brojPoena;
	}
	
}
