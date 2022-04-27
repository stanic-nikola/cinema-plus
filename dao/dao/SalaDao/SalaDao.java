package dao.SalaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.cinemaplus.Sala;
import jdbc.database.connection.DBConnect;

public class SalaDao implements ISalaDao {
	Connection con = DBConnect.getConnection();
	
	@Override
	public ArrayList<Sala> vratiSalePoId(int idBioskopa) {
		String upitSvi = "SELECT * FROM Sala WHERE IdBioskopa=" + idBioskopa;
		
		ArrayList<Sala> sveSale = new ArrayList<Sala>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upitSvi);
			while(rezultat.next())
			{
				Sala sala = new Sala();
				try
				{
					sala.setIdSale(rezultat.getInt("IdSale"));
					sala.setIdBioskopa(rezultat.getInt("IdBioskopa"));
					sala.setNazivSale(rezultat.getString("NazivSale"));
					sala.setOpis(rezultat.getString("Opis"));
					sala.setBrojMesta(rezultat.getInt("BrojMesta"));
					sala.setTehnologija(rezultat.getString("Tehnologija"));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sveSale.add(sala);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return sveSale;
	}

	@Override
	public Sala vratiSaluPoId(int idSale) {
		String vratiSalu = "SELECT * FROM Sala WHERE IdSale =" + idSale;
		Sala sala = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiSalu);
			while(rezultat.next())
			{
				sala = new Sala();
				try
				{
					sala.setIdSale(rezultat.getInt("IdSale"));
					sala.setIdBioskopa(rezultat.getInt("IdBioskopa"));
					sala.setNazivSale(rezultat.getString("NazivSale"));
					sala.setOpis(rezultat.getString("Opis"));
					sala.setBrojMesta(rezultat.getInt("BrojMesta"));
					sala.setTehnologija(rezultat.getString("Tehnologija"));

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
		return sala;
	}

	@Override
	public void obrisiSalu(int idSale) {
		String upitObrisi = "DELETE FROM Sala WHERE IdSale = " + idSale;
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
	public int azurirajSalu(Sala azuriranaSala) {
		String azurirajSalu = "UPDATE Sala SET NazivSale=?, Opis=?, BrojMesta=?, "
				+ "Tehnologija=? WHERE IdSale=" + azuriranaSala.getIdSale();
		int result = 0;
		try(PreparedStatement ps = con.prepareStatement(azurirajSalu))
		{
			ps.setString(1, azuriranaSala.getNazivSale());
			ps.setString(2, azuriranaSala.getOpis());
			ps.setInt(3, azuriranaSala.getBrojMesta());
			ps.setString(4, azuriranaSala.getTehnologija());
			
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
	public int dodajSalu(Sala novaSala) {
		String upitDodaj = "INSERT INTO Sala(NazivSale, Opis, BrojMesta, Tehnologija, IdBioskopa)"
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitDodaj);
			ps.setString(1, novaSala.getNazivSale());
			ps.setString(2, novaSala.getOpis());
			ps.setInt(3, novaSala.getBrojMesta());
			ps.setString(4, novaSala.getTehnologija());
			ps.setInt(5, novaSala.getIdBioskopa());

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
	public int vratiIdBioskopa(int idSale) {
		String vratiBioskop = "SELECT * FROM Sala WHERE IdSale=" + idSale;
		int idBioskopa = 0;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiBioskop);
			while(rezultat.next())
			{
				try
				{
					idBioskopa = rezultat.getInt("IdBioskopa");
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
		return idBioskopa;
	}
}
