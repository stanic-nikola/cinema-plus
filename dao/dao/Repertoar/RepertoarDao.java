package dao.Repertoar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.cinemaplus.Repertoar;
import jdbc.database.connection.DBConnect;

public class RepertoarDao implements IRepertoarDao {
	Connection con = DBConnect.getConnection(); 
	
	@Override
	public ArrayList<Repertoar> vratiRepertoarPoDatumu(String datum, int idBioskopa) {
		String upit = "SELECT p.IdProjekcije, p.IdSale, p.IdFilma, p.DatumVreme, p.cenaKarte, s.BrojMesta, s.Tehnologija, "
				+ "s.NazivSale, f.NazivFilma, f.Slika, f.Trajanje, f.Zanr "
				+ "FROM projekcija p JOIN Sala s ON p.IdSale = s.IdSale "
				+ "JOIN film f ON p.IdFilma = f.IdFilma "
				+ "WHERE p.DatumVreme >  '" + datum + " 00:00:00' && p.DatumVreme < "
						+ "'" + datum + " 23:59:59' AND s.IdBioskopa =" + idBioskopa;
		
		ArrayList<Repertoar> repertoari = new ArrayList<Repertoar>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upit);
			
			while(rezultat.next())
			{
				Repertoar repertoar = new Repertoar();
				try {
					repertoar.setIdProjekcije(rezultat.getInt("IdProjekcije"));
					repertoar.setIdSale(rezultat.getInt("IdSale"));
					repertoar.setIdFilma(rezultat.getInt("IdFilma"));
					repertoar.setDatumPrikazivanja(rezultat.getDate("DatumVreme"));
					repertoar.setVremePrikazivanja(rezultat.getTime("DatumVreme"));
					repertoar.setCenaKarte(rezultat.getDouble("CenaKarte"));
					repertoar.setBrojMesta(rezultat.getInt("BrojMesta"));
					repertoar.setTehnologija(rezultat.getString("Tehnologija"));
					repertoar.setNazivSale(rezultat.getString("NazivSale"));
					repertoar.setNazivFilma(rezultat.getString("NazivFilma"));
					repertoar.setSlikaFilma(rezultat.getString("Slika"));
					repertoar.setTrajanjeFilma(rezultat.getString("Trajanje"));
					repertoar.setZanr(rezultat.getString("Zanr"));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				repertoari.add(repertoar);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return repertoari;
	}
}
