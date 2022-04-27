package dao.KlubDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.cinemaplus.Klub;
import jdbc.database.connection.DBConnect;

public class KlubDao implements IKlubDao {
	Connection con = DBConnect.getConnection();

	@Override
	public ArrayList<Klub> vratiSveKlubove() {
		String upitSvi = "SELECT * FROM Klub";
		
		ArrayList<Klub> sviKlubovi = new ArrayList<Klub>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upitSvi);
			while(rezultat.next())
			{
				Klub klub = new Klub();
				try
				{
					klub.setIdKluba(rezultat.getInt("IdKluba"));
					klub.setNaziv(rezultat.getString("Naziv"));
					klub.setOpis(rezultat.getString("Opis"));
					klub.setSlika(rezultat.getString("Slika"));
					klub.setPopust(rezultat.getInt("Popust"));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sviKlubovi.add(klub);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return sviKlubovi;
	}

	@Override
	public Klub vratiKlubPoId(int idKluba) {
		String vratiKlub = "SELECT * FROM Klub WHERE IdKluba =" + idKluba;
		Klub klub = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiKlub);
			while(rezultat.next())
			{
				klub = new Klub();
				try
				{
					klub.setIdKluba(rezultat.getInt("IdKluba"));
					klub.setNaziv(rezultat.getString("Naziv"));
					klub.setOpis(rezultat.getString("Opis"));
					klub.setSlika(rezultat.getString("Slika"));
					klub.setPopust(rezultat.getInt("Popust"));
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
		return klub;
	}			
}
