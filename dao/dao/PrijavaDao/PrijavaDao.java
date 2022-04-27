package dao.PrijavaDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.cinemaplus.Korisnik;
import jdbc.database.connection.DBConnect;

public class PrijavaDao implements IPrijavaDao {
	Connection con = DBConnect.getConnection();
	@Override
	public Korisnik autentifikujKorisnika(String email, String password) {
		Statement stmt = null;

		String upit = "SELECT * FROM Korisnik WHERE Email = '" +email + 
				"' && Lozinka = '" + password +"'";
		try
		{
			Korisnik korisnik = new Korisnik();
			stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upit);

			while(rezultat.next())
			{
				korisnik.setIdKorisnika(rezultat.getInt("IdKorisnika"));
				korisnik.setIme(rezultat.getString("Ime"));
				korisnik.setPrezime(rezultat.getString("Prezime"));
				korisnik.setNadimak(rezultat.getString("Nadimak"));
				korisnik.setEmail(rezultat.getString("Email"));
				korisnik.setLozinka(rezultat.getString("Lozinka"));
				korisnik.setRola(rezultat.getString("Rola").charAt(0));
				korisnik.setBrojMobilnog(rezultat.getString("BrojMobilnog"));
				korisnik.setBrojPoena(rezultat.getInt("BrojPoena"));
			}
			stmt.close();
			con.close();
			return korisnik;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
}
