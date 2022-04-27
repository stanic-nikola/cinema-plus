package dao.KorisnikDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import beans.cinemaplus.Korisnik;
import jdbc.database.connection.DBConnect;

public class KorisnikDao implements IKorisnikDao {
	Connection con = DBConnect.getConnection();

	@Override
	public ArrayList<Korisnik> vratiSveKorisnike() {
		String vratiKorisnike = "SELECT * FROM Korisnik";

		ArrayList<Korisnik> sviKorisnici = new ArrayList<Korisnik>();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiKorisnike);
			while(rezultat.next())
			{
				Korisnik korisnik = new Korisnik();
				try
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
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sviKorisnici.add(korisnik);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return sviKorisnici;
	}

	@Override
	public Korisnik vratiKorisnikaPoId(int idKorisnika) {
		String vratiKorisnika = "SELECT * FROM Korisnik WHERE IdKorisnika =" + idKorisnika;
		Korisnik korisnik = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiKorisnika);
			while(rezultat.next())
			{
				korisnik = new Korisnik();
				try
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
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return korisnik;
	}

	@Override
	public int dodajKorisnika(Korisnik noviKorisnik) {
		String upitDodaj = "INSERT INTO Korisnik(Ime, Prezime, Nadimak, Email, Lozinka, Rola, BrojMobilnog) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitDodaj);
			ps.setString(1, noviKorisnik.getIme());
			ps.setString(2, noviKorisnik.getPrezime());
			ps.setString(3, noviKorisnik.getNadimak());
			ps.setString(4, noviKorisnik.getEmail());
			ps.setString(5, noviKorisnik.getLozinka());
			ps.setString(6, Character.toString(noviKorisnik.getRola()));
			ps.setString(7, noviKorisnik.getBrojMobilnog());

			result = ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void obrisiKorisnika(int idKorisnika) {
		String upitObrisi = "DELETE FROM Korisnik WHERE IdKorisnika = " + idKorisnika;
		try
		{
			Statement stmt = con.createStatement();
			stmt.executeUpdate(upitObrisi);
			stmt.close();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public int azurirajKorisnika(Korisnik azuriranKorisnik) {
		String azurirajKorisnika = "UPDATE Korisnik SET Ime=?, Prezime=?, Nadimak=?, "
				+ "Email=?, Lozinka=?, Rola=?, BrojMobilnog=? WHERE IdKorisnika='"+ azuriranKorisnik.getIdKorisnika() + "'";
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(azurirajKorisnika);
			ps.setString(1, azuriranKorisnik.getIme());
			ps.setString(2, azuriranKorisnik.getPrezime());
			ps.setString(3, azuriranKorisnik.getNadimak());
			ps.setString(4, azuriranKorisnik.getEmail());
			ps.setString(5, azuriranKorisnik.getLozinka());
			ps.setString(6, Character.toString(azuriranKorisnik.getRola()));
			ps.setString(7, azuriranKorisnik.getBrojMobilnog());
			
			result = ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		
		return result;
	}

	@Override
	public ArrayList<Korisnik> vratiKorisnikeBezAdmina(int IdAdmina) {
		String vratiKorisnike = "SELECT * FROM Korisnik WHERE IdKorisnika !=" + IdAdmina;

		ArrayList<Korisnik> sviKorisnici = new ArrayList<Korisnik>();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiKorisnike);
			while(rezultat.next())
			{
				Korisnik korisnik = new Korisnik();
				try
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
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sviKorisnici.add(korisnik);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return sviKorisnici;
	}

	@Override
	public void promeniPoeneKorisnika(int IdKorisnika, int brojPoena) {
		String dodajPoene = "UPDATE Korisnik SET BrojPoena=? WHERE IdKorisnika=" + IdKorisnika;
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(dodajPoene);
			ps.setInt(1, brojPoena);
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	}

	@Override
	public Korisnik vratiKorisnikaPoIdRezervacije(int IdRezervacije) {
		String vratiKorisnika = "SELECT * FROM Korisnik k JOIN Rezervacija r ON k.IdKorisnika = r.IdKorisnika "
				+ "WHERE r.IdRezervacije = " + IdRezervacije;
		Korisnik korisnik = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiKorisnika);
			while(rezultat.next())
			{
				korisnik = new Korisnik();
				try
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
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return korisnik;
	}

	@Override
	public boolean proveriEmail(String email) {
		String vratiKorisnika = "SELECT * FROM Korisnik WHERE Email ='" + email + "'";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiKorisnika);
			if(rezultat.next() == false)
			{
				return false;
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return true;
	}
	
}
