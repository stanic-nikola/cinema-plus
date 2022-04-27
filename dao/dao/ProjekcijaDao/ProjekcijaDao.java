package dao.ProjekcijaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.cinemaplus.Bioskop;
import beans.cinemaplus.Projekcija;
import beans.cinemaplus.Sala;
import dao.BioskopDao.BioskopDao;
import dao.SalaDao.SalaDao;
import jdbc.database.connection.DBConnect;

public class ProjekcijaDao implements IProjekcijaDao {
	Connection con = DBConnect.getConnection();
	@Override
	public ArrayList<Projekcija> vratiSveProjekcije() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projekcija vratiProjekcijuPoId(int idProjekcije) {
		String vratiProjekciju = "SELECT * FROM Projekcija WHERE IdProjekcije =" + idProjekcije;
		Projekcija projekcija = null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiProjekciju);
			while(rezultat.next())
			{
				projekcija = new Projekcija();
				try
				{
					projekcija.setIdProjekcije(rezultat.getInt("IdProjekcije"));
					projekcija.setIdSale(rezultat.getInt("IdSale"));
					projekcija.setIdFilma(rezultat.getInt("IdFilma"));
					projekcija.setDatum(rezultat.getDate("DatumVreme"));
					projekcija.setVreme(rezultat.getTime("DatumVreme"));
					projekcija.setCenaKarte(rezultat.getDouble("CenaKarte"));
					projekcija.setIdKorisnika(rezultat.getInt("IdKorisnika"));
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
		return projekcija;
	}

	@Override
	public int dodajProjekciju(Projekcija novaProjekcija) {
		String upitDodaj = "INSERT INTO Projekcija(IdSale, IdFilma, DatumVreme, CenaKarte, IdKorisnika) "
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		try
		{
			ps = con.prepareStatement(upitDodaj);
			ps.setInt(1, novaProjekcija.getIdSale());
			ps.setInt(2, novaProjekcija.getIdFilma());
			ps.setString(3, novaProjekcija.getDatumVreme());
			ps.setDouble(4, novaProjekcija.getCenaKarte());
			ps.setInt(5, novaProjekcija.getIdKorisnika());


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
	public void obrisiProjekciju(int idProjekcije) {
		String upitObrisi = "DELETE FROM Projekcija WHERE IdProjekcije = " + idProjekcije;
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
	public int azurirajProjekciju(Projekcija azuriranaProjekcija) {
		String azurirajSalu = "UPDATE Projekcija SET IdSale=?, DatumVreme=?, CenaKarte=?, "
				+ "IdKorisnika=? WHERE IdProjekcije=" + azuriranaProjekcija.getIdProjekcije();
		int result = 0;
		try(PreparedStatement ps = con.prepareStatement(azurirajSalu))
		{
			ps.setInt(1, azuriranaProjekcija.getIdSale());
			ps.setString(2, azuriranaProjekcija.getDatumVreme());
			ps.setDouble(3, azuriranaProjekcija.getCenaKarte());
			ps.setInt(4, azuriranaProjekcija.getIdKorisnika());
			
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
	public ArrayList<Projekcija> vratiProjekcijePoIdFilma(int idFilma) {
		String vratiProjekcije = "SELECT * FROM Projekcija WHERE IdFilma=" + idFilma;

		ArrayList<Projekcija> sveProjekcije = new ArrayList<Projekcija>();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(vratiProjekcije);
			while(rezultat.next())
			{
				Projekcija projekcija = new Projekcija();
				try
				{
					projekcija.setIdProjekcije(rezultat.getInt("IdProjekcije"));
					projekcija.setIdFilma(rezultat.getInt("IdFilma"));
					projekcija.setIdSale(rezultat.getInt("IdSale"));
					projekcija.setDatum(rezultat.getDate("DatumVreme"));
					projekcija.setVreme(rezultat.getTime("DatumVreme"));
					projekcija.setCenaKarte(rezultat.getDouble("CenaKarte"));
					
					SalaDao s = new SalaDao();
					BioskopDao b = new BioskopDao();
					Sala sala = s.vratiSaluPoId(projekcija.getIdSale());
					Bioskop bioskop = b.vratiBioskopPoId(sala.getIdBioskopa());
					projekcija.setNazivSale(sala.getNazivSale());
					projekcija.setNazivBioskopa(bioskop.getNazivBioskopa());
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sveProjekcije.add(projekcija);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return sveProjekcije;
	}

}
