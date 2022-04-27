package dao.BioskopDao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.cinemaplus.Bioskop;
import jdbc.database.connection.DBConnect;

public class BioskopDao implements IBioskopDao {
	Connection con = DBConnect.getConnection();
		
	@Override
	public ArrayList<Bioskop> vratiSveBioskope() {
		String upitSvi = "SELECT * FROM Bioskop";
		
		ArrayList<Bioskop> sviBioskopi = new ArrayList<Bioskop>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upitSvi);
			while(rezultat.next())
			{
				Bioskop bioskop = new Bioskop();
				try
				{
					bioskop.setIdBioskopa(rezultat.getInt("IdBioskopa"));
					bioskop.setNazivBioskopa(rezultat.getString("NazivBioskopa"));
					bioskop.setAdresa(rezultat.getString("Adresa"));
					bioskop.setSlika(rezultat.getString("Slika"));
					bioskop.setOpis(rezultat.getString("Opis"));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sviBioskopi.add(bioskop);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return sviBioskopi;
	}

	@Override
	public Bioskop vratiBioskopPoId(int idBioskopa) {
		String vratiBioskop = "SELECT * FROM Bioskop WHERE IdBioskopa =" + idBioskopa;
		Bioskop bioskop = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiBioskop);
			while(rezultat.next())
			{
				bioskop = new Bioskop();
				try
				{
					bioskop.setIdBioskopa(rezultat.getInt("IdBioskopa"));
					bioskop.setNazivBioskopa(rezultat.getString("NazivBioskopa"));
					bioskop.setAdresa(rezultat.getString("Adresa"));
					bioskop.setSlika(rezultat.getString("Slika"));
					bioskop.setOpis(rezultat.getString("Opis"));
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
		return bioskop;
	}

	@Override
	public int dodajBioskop(Bioskop noviBioskop) {
		String upitDodaj = "INSERT INTO Bioskop(NazivBioskopa, Adresa, Slika, Opis, IdGrada)"
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitDodaj);
			ps.setString(1, noviBioskop.getNazivBioskopa());
			ps.setString(2, noviBioskop.getAdresa());
			ps.setString(3, noviBioskop.getSlika());
			ps.setString(4, noviBioskop.getOpis());
			ps.setInt(5, noviBioskop.getIdGrada());

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
	public void obrisiBioskop(int idBioskopa) {
		String upitObrisi = "DELETE FROM Bioskop WHERE IdBioskopa = " + idBioskopa;
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
	public int azurirajBioskop(Bioskop azuriranBioskop) {
		String azurirajBioskop = "UPDATE Bioskop SET NazivBioskopa=?, Adresa=?, Slika=?, "
				+ "Opis=? WHERE IdBioskopa=" + azuriranBioskop.getIdBioskopa();
		int result = 0;
		try(PreparedStatement ps = con.prepareStatement(azurirajBioskop))
		{
			ps.setString(1, azuriranBioskop.getNazivBioskopa());
			ps.setString(2, azuriranBioskop.getAdresa());
			ps.setString(3, azuriranBioskop.getSlika());
			ps.setString(4, azuriranBioskop.getOpis());
			
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
	public Bioskop vratiBioskopPoIdSale(int idSale) {
		String vratiBioskop = "SELECT * FROM Bioskop b JOIN Sala s WHERE s.IdSale=" + idSale;
		Bioskop bioskop = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiBioskop);
			while(rezultat.next())
			{
				bioskop = new Bioskop();
				try
				{
					bioskop.setIdBioskopa(rezultat.getInt("IdBioskopa"));
					bioskop.setNazivBioskopa(rezultat.getString("NazivBioskopa"));
					bioskop.setAdresa(rezultat.getString("Adresa"));
					bioskop.setSlika(rezultat.getString("Slika"));
					bioskop.setOpis(rezultat.getString("Opis"));
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
		return bioskop;
	}
}

