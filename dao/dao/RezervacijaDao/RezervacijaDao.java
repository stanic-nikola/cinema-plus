package dao.RezervacijaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.cinemaplus.Film;
import beans.cinemaplus.Korisnik;
import beans.cinemaplus.Projekcija;
import beans.cinemaplus.Rezervacija;
import beans.cinemaplus.Sala;
import dao.FilmDao.FilmDao;
import dao.KorisnikDao.KorisnikDao;
import dao.ProjekcijaDao.ProjekcijaDao;
import dao.SalaDao.SalaDao;
import jdbc.database.connection.DBConnect;

public class RezervacijaDao implements IRezervacijaDao{
	Connection con = DBConnect.getConnection();
	
	@Override
	public int dodajRezervacije(int idProjekcije, double cenaKarte, List<Integer> brojeviSedista, int IdKorisnika) {
		String upitDodaj = "INSERT INTO Rezervacija(IdProjekcije, BrojSedista, CenaKarte, DatumRezervacije, IdKorisnika, Status)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		 SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");  
		 Date date = new Date();  
		
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitDodaj);
			if(brojeviSedista.size() > 0)
			{
				for(int br: brojeviSedista) 
				{
					ps.setInt(1, idProjekcije);
					ps.setInt(2, br);
					ps.setDouble(3, cenaKarte);
					ps.setString(4, formatter.format(date).toString());
					ps.setInt(5, IdKorisnika);
					ps.setString(6, "Aktivna");
					result = ps.executeUpdate();
				}
			}
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
	public int dodajRezervaciju(int idProjekcije,double cenaKarte, int brojSedista, int IdKorisnika) {
		String upitDodaj = "INSERT INTO Rezervacija(IdProjekcije, BrojSedista, CenaKarte, DatumRezervacije, IdKorisnika, Status)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		 SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");  
		 Date date = new Date();  
		
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitDodaj);
			ps.setInt(1, idProjekcije);
			ps.setInt(2, brojSedista);
			ps.setDouble(3, cenaKarte);
			ps.setString(4, formatter.format(date).toString());
			ps.setInt(5, IdKorisnika);
			ps.setString(6, "Aktivna");
			
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
	public ArrayList<Rezervacija> rezervacijePoIdBioskopa(int idBioskopa) {
		String vratiRezervacije = "SELECT * FROM rezervacija r JOIN projekcija p "
				+ "ON p.IdProjekcije = r.IdProjekcije JOIN sala s ON s.IdSale = p.IdSale WHERE s.IdBioskopa =" + idBioskopa;
		
		ArrayList<Rezervacija> sveRezervacije = new ArrayList<Rezervacija>();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiRezervacije);
			while(rezultat.next())
			{
				Rezervacija rezervacija = new Rezervacija();
				KorisnikDao k = new KorisnikDao();
				FilmDao f = new FilmDao();
				SalaDao s = new SalaDao();
				ProjekcijaDao p = new ProjekcijaDao();
				
				try
				{
					rezervacija.setIdRezervacije(rezultat.getInt("r.IdRezervacije"));
					rezervacija.setIdProjekcije(rezultat.getInt("r.IdProjekcije"));
					rezervacija.setBrojSedista(rezultat.getInt("r.BrojSedista"));
					rezervacija.setDatumRezervacije(rezultat.getDate("r.DatumRezervacije"));
					rezervacija.setVremeRezervacije(rezultat.getTime("r.DatumRezervacije"));
					rezervacija.setIdKorisnika(rezultat.getInt("r.IdKorisnika"));
					rezervacija.setStatus(rezultat.getString("r.Status"));
					rezervacija.setCenaKarte(rezultat.getDouble("CenaKarte"));
					
					Korisnik korisnik = k.vratiKorisnikaPoId(rezervacija.getIdKorisnika());
					Projekcija projekcija = p.vratiProjekcijuPoId(rezervacija.getIdProjekcije());
					Sala sala = s.vratiSaluPoId(projekcija.getIdSale());
					Film film = f.vratiFilmPoId(projekcija.getIdFilma());
					
					rezervacija.setImeKorisnika(korisnik.getIme());
					rezervacija.setNazivSale(sala.getNazivSale());
					rezervacija.setNazivFilma(film.getNazivFilma());
					rezervacija.setDatumPrikazivanja(projekcija.getDatum());
					rezervacija.setVremePrikazivanja(projekcija.getVreme());

					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sveRezervacije.add(rezervacija);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return sveRezervacije;
	}

	@Override
	public void promeniStatusRezervacije(int idRezervacije, String status) {
		String azurirajStatus = "UPDATE Rezervacija SET Status=? WHERE IdRezervacije=" + idRezervacije;
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(azurirajStatus);
			ps.setString(1, status);
			
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
	public ArrayList<Rezervacija> rezervacijePoIdKorisnika(int idKorisnika) {
		String vratiRezervacije = "SELECT * FROM rezervacija r JOIN projekcija p "
				+ "ON p.IdProjekcije = r.IdProjekcije JOIN sala s ON s.IdSale = p.IdSale WHERE r.IdKorisnika =" + idKorisnika;
		
		ArrayList<Rezervacija> sveRezervacije = new ArrayList<Rezervacija>();
		Rezervacija rezervacija = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiRezervacije);
			while(rezultat.next())
			{
				rezervacija = new Rezervacija();
				KorisnikDao k = new KorisnikDao();
				FilmDao f = new FilmDao();
				SalaDao s = new SalaDao();
				ProjekcijaDao p = new ProjekcijaDao();
				
				try
				{
					rezervacija.setIdRezervacije(rezultat.getInt("r.IdRezervacije"));
					rezervacija.setIdProjekcije(rezultat.getInt("r.IdProjekcije"));
					rezervacija.setBrojSedista(rezultat.getInt("r.BrojSedista"));
					rezervacija.setDatumRezervacije(rezultat.getDate("r.DatumRezervacije"));
					rezervacija.setVremeRezervacije(rezultat.getTime("r.DatumRezervacije"));
					rezervacija.setIdKorisnika(rezultat.getInt("r.IdKorisnika"));
					rezervacija.setStatus(rezultat.getString("r.Status"));
					rezervacija.setCenaKarte(rezultat.getDouble("CenaKarte"));
					
					Korisnik korisnik = k.vratiKorisnikaPoId(rezervacija.getIdKorisnika());
					Projekcija projekcija = p.vratiProjekcijuPoId(rezervacija.getIdProjekcije());
					Sala sala = s.vratiSaluPoId(projekcija.getIdSale());
					Film film = f.vratiFilmPoId(projekcija.getIdFilma());
					
					rezervacija.setImeKorisnika(korisnik.getIme());
					rezervacija.setNazivSale(sala.getNazivSale());
					rezervacija.setNazivFilma(film.getNazivFilma());
					rezervacija.setDatumPrikazivanja(projekcija.getDatum());
					rezervacija.setVremePrikazivanja(projekcija.getVreme());
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sveRezervacije.add(rezervacija);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return sveRezervacije;
	}

	@Override
	public void umanjiCenuKarte(int idRezervacije, double umanjenaCena) {
		String umanjiCenu = "UPDATE Rezervacija SET CenaKarte=? WHERE IdRezervacije=" + idRezervacije;
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(umanjiCenu);
			ps.setDouble(1, umanjenaCena);
			
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
	public Rezervacija vratiRezervacijuPoId(int idRezervacije) {
		String upit = "SELECT * FROM Rezervacija WHERE IdRezervacije = " + idRezervacije;
		
		Rezervacija rezervacija = new Rezervacija();
		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upit);
			
			while(rezultat.next())
			{
				rezervacija.setIdRezervacije(rezultat.getInt("IdRezervacije"));
				rezervacija.setIdProjekcije(rezultat.getInt("IdProjekcije"));
				rezervacija.setBrojSedista(rezultat.getInt("BrojSedista"));
				rezervacija.setDatumRezervacije(rezultat.getDate("DatumRezervacije"));
				rezervacija.setVremeRezervacije(rezultat.getTime("DatumRezervacije"));
				rezervacija.setIdKorisnika(rezultat.getInt("IdKorisnika"));
				rezervacija.setStatus(rezultat.getString("Status"));
				rezervacija.setCenaKarte(rezultat.getDouble("CenaKarte"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rezervacija;
	}

	public void otkaziNepotvrdjeneRezervacije(String datum) {
		String otkazivanje = "UPDATE Rezervacija r JOIN Projekcija p ON r.IdProjekcije = p.IdProjekcije SET r.Status = 'Otkazana' "
				+ "WHERE r.Status = 'Aktivna' && DATE_SUB(p.DatumVreme, INTERVAL 30 MINUTE) <='" + datum + "'";
	
		try 
		{
			Statement stmt = con.createStatement();
			stmt.executeUpdate(otkazivanje);
			stmt.close();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Integer> vratiRezervisanaSedista(int idProjekcije) {
			String upit = "SELECT * FROM projekcija p JOIN rezervacija r ON p.IdProjekcije = r.IdProjekcije "
					+ "WHERE r.Status != 'Otkazana' && p.IdProjekcije =" + idProjekcije;
			int brojSedista = 0;
			ArrayList<Integer> svaSedista = new ArrayList<Integer>();
			try
			{
				Statement stmt = con.createStatement();
				ResultSet rezultat = stmt.executeQuery(upit);

				while(rezultat.next())
				{
					try
					{

						brojSedista = rezultat.getInt("BrojSedista");
						
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					svaSedista.add(brojSedista);
				}
				stmt.close();
				con.close();
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
			return svaSedista;
	}
}
