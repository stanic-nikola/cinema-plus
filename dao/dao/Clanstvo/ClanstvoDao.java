package dao.Clanstvo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.cinemaplus.Clanstvo;
import jdbc.database.connection.DBConnect;

public class ClanstvoDao implements IClanstvoDao{
	Connection con = DBConnect.getConnection();
	
	@Override
	public ArrayList<Clanstvo> vratiSveClanove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clanstvo vratiClanstvoPoId(int idClana) {
		String vratiClanstvo = "SELECT * FROM Clanstvo WHERE IdKorisnika =" + idClana;
		Clanstvo clanstvo = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiClanstvo);
			while(rezultat.next())
			{
				clanstvo = new Clanstvo();
				try
				{
					clanstvo.setIdClanstva(rezultat.getInt("IdClanstva"));
					clanstvo.setIdKluba(rezultat.getInt("IdKluba"));
					clanstvo.setIdKorisnika(rezultat.getInt("IdKorisnika"));
					clanstvo.setTipClanstva(rezultat.getString("TipClanstva"));
					clanstvo.setSediste(rezultat.getInt("Sediste"));
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
		return clanstvo;
	}

	@Override
	public int dodajClana(Clanstvo noviClan) {
		String upitDodaj = "INSERT INTO Clanstvo(IdKluba, IdKorisnika, TipClanstva, Sediste)"
				+ "VALUES (?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitDodaj);
			ps.setInt(1, noviClan.getIdKluba());
			ps.setInt(2, noviClan.getIdKorisnika());
			ps.setString(3, noviClan.getTipClanstva());
			ps.setInt(4, noviClan.getSediste());

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
	public void obrisiClana(int idClana) {
		String upitObrisi = "DELETE FROM Clanstvo WHERE IdKorisnika = " + idClana;
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
	public int azurirajClana(Clanstvo azuriranClan) {
		// TODO Auto-generated method stub
		return 0;
	}

}
