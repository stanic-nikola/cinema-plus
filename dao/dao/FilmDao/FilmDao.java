package dao.FilmDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.cinemaplus.Film;
import jdbc.database.connection.DBConnect;

public class FilmDao implements IFilmDao {
	Connection con = DBConnect.getConnection();
	
	@Override
	public ArrayList<Film> vratiSveFilmove() {
		String vratiKorisnike = "SELECT * FROM Film";

		ArrayList<Film> sviFilmovi = new ArrayList<Film>();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiKorisnike);
			while(rezultat.next())
			{
				Film film = new Film();
				try
				{
					film.setIdFilma(rezultat.getInt("IdFilma"));
					film.setNazivFilma(rezultat.getString("NazivFilma"));
					film.setOpisFilma(rezultat.getString("OpisFilma"));
					film.setSlika(rezultat.getString("Slika"));
					film.setZanr(rezultat.getString("Zanr"));
					film.setTrajanje(rezultat.getString("Trajanje"));
					film.setTrejler(rezultat.getString("Trejler"));
					film.setDatum(rezultat.getDate("PocetakPrikazivanja"));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sviFilmovi.add(film);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return sviFilmovi;
	}

	@Override
	public Film vratiFilmPoId(int idFilma) {
		String vratiFilm = "SELECT * FROM Film WHERE IdFilma =" + idFilma;
		Film film = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiFilm);
			while(rezultat.next())
			{
				film = new Film();
				try
				{
					film.setIdFilma(rezultat.getInt("IdFilma"));
					film.setNazivFilma(rezultat.getString("NazivFilma"));
					film.setOpisFilma(rezultat.getString("OpisFilma"));
					film.setSlika(rezultat.getString("Slika"));
					film.setZanr(rezultat.getString("Zanr"));
					film.setTrajanje(rezultat.getString("Trajanje"));
					film.setTrejler(rezultat.getString("Trejler"));
					film.setDatum(rezultat.getDate("PocetakPrikazivanja"));
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
		return film;
	}

	@Override
	public int dodajFilm(Film noviFilm) {
		String upitDodaj = "INSERT INTO Film(NazivFilma, OpisFilma, Slika, Zanr, Trajanje, Trejler, PocetakPrikazivanja) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitDodaj);
			ps.setString(1, noviFilm.getNazivFilma());
			ps.setString(2, noviFilm.getOpisFilma());
			ps.setString(3, noviFilm.getSlika());
			ps.setString(4, noviFilm.getZanr());
			ps.setString(5, noviFilm.getTrajanje());
			ps.setString(6, noviFilm.getTrejler());
			ps.setDate(7, noviFilm.getDatum());

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
	public void obrisiFilm(int idFilma) {
		String upitObrisi = "DELETE FROM Film WHERE IdFilma = " + idFilma;
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
	public int azurirajFilm(Film azuriranFilm) {
		String upitAzuriraj = "UPDATE Film SET NazivFilma=?, OpisFilma=?, Slika=?, "
				+ "Zanr=?, Trajanje=?, Trejler=?, PocetakPrikazivanja=? WHERE IdFilma=" + azuriranFilm.getIdFilma();
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitAzuriraj);
			ps.setString(1, azuriranFilm.getNazivFilma());
			ps.setString(2, azuriranFilm.getOpisFilma());
			ps.setString(3, azuriranFilm.getSlika());
			ps.setString(4, azuriranFilm.getZanr());
			ps.setString(5, azuriranFilm.getTrajanje());
			ps.setString(6, azuriranFilm.getTrejler());
			ps.setDate(7, azuriranFilm.getDatum());
			
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
}
