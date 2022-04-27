package dao.GradDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.cinemaplus.Grad;
import jdbc.database.connection.DBConnect;

public class GradDao implements IGradDao {
	Connection con = DBConnect.getConnection();
	
	@Override
	public ArrayList<Grad> vratiSveGradove() {
		String upitSvi = "SELECT * FROM Grad";
		
		ArrayList<Grad> sviGradovi = new ArrayList<Grad>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upitSvi);
			while(rezultat.next())
			{
				Grad grad = new Grad();
				try
				{
					grad.setIdGrada(rezultat.getInt("IdGrada"));
					grad.setImeGrada(rezultat.getString("ImeGrada"));
					grad.setDrzava(rezultat.getString("Drzava"));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				sviGradovi.add(grad);
			}
			stmt.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return sviGradovi;
	}

}
