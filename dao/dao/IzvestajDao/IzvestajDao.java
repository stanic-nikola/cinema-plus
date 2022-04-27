package dao.IzvestajDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.cinemaplus.Izvestaj;
import jdbc.database.connection.DBConnect;
import service.validation.Validacija;

public class IzvestajDao implements IIzvestajDao {
	Connection con = DBConnect.getConnection();
	
	@Override
	public Izvestaj vratiIzvestajDnevni(String datum) {
		String upit = "SELECT COUNT(r.IdRezervacije) as 'BrojRezervacija', SUM(r.CenaKarte) as 'PrihodPopust', SUM(p.CenaKarte) as 'MoguciPrihod' FROM projekcija p JOIN rezervacija r ON p.IdProjekcije = r.IdProjekcije WHERE r.Status='Potvrðena'" + 
				 "&& p.DatumVreme > '" + datum + " 00:00:00' && p.DatumVreme < '"+ datum + " 23:59:59'" ;
		
		Izvestaj izvestaj = new Izvestaj();

		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upit);
			while(rezultat.next())
			{
				izvestaj.setDatum(datum);
				izvestaj.setNaziv("Dnevni izveštaj");
				izvestaj.setUkupnoPotvrdjenihRezervacija(rezultat.getString(1));
				izvestaj.setUkupanPrihod(rezultat.getString(2));
				izvestaj.setPrihodBezPopusta(rezultat.getString(3));

				Double bezPopusta = Double.parseDouble(izvestaj.getPrihodBezPopusta());
				Double saPopustom = Double.parseDouble(izvestaj.getUkupanPrihod());
				izvestaj.setRazlika(bezPopusta - saPopustom);
			}
			stmt.close();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return izvestaj;
	}

	@Override
	public Izvestaj vratiIzvestajMesecni(String mesec) {
		String upit = "SELECT COUNT(r.IdRezervacije) as 'BrojRezervacija', SUM(r.CenaKarte) as 'PrihodPopust', SUM(p.CenaKarte) as 'MoguciPrihod' FROM projekcija p JOIN rezervacija r ON p.IdProjekcije ="+ 
				"r.IdProjekcije WHERE r.Status='Potvrðena' && YEAR(p.DatumVreme)= 2020 && MONTH(p.DatumVreme)=" + Integer.parseInt(mesec); 
		
		Izvestaj izvestaj = new Izvestaj();

		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upit);
			while(rezultat.next())
			{
				izvestaj.setDatum(Validacija.vratiImeMeseca(Integer.parseInt(mesec)));
				izvestaj.setNaziv("Meseèni izveštaj");
				izvestaj.setUkupnoPotvrdjenihRezervacija(rezultat.getString(1));
				izvestaj.setUkupanPrihod(rezultat.getString(2));
				izvestaj.setPrihodBezPopusta(rezultat.getString(3));
				izvestaj.setRazlika(Double.parseDouble(izvestaj.getPrihodBezPopusta()) - Double.parseDouble(izvestaj.getUkupanPrihod()));
			}
			stmt.close();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return izvestaj;
	}

	@Override
	public Izvestaj vratiIzvestajGodisnji(String godina) {
		String upit = "SELECT COUNT(r.IdRezervacije) as 'BrojRezervacija', SUM(r.CenaKarte) as 'PrihodPopust', SUM(p.CenaKarte) as 'MoguciPrihod' FROM projekcija p JOIN rezervacija r ON p.IdProjekcije ="+ 
				"r.IdProjekcije WHERE r.Status='Potvrðena' && YEAR(p.DatumVreme)=" + Integer.parseInt(godina); 
		
		Izvestaj izvestaj = new Izvestaj();

		try {
			Statement stmt = con.createStatement();
			ResultSet rezultat = stmt.executeQuery(upit);
			while(rezultat.next())
			{
				izvestaj.setDatum(godina);
				izvestaj.setNaziv("Godišnji izveštaj");
				izvestaj.setUkupnoPotvrdjenihRezervacija(rezultat.getString(1));
				izvestaj.setUkupanPrihod(rezultat.getString(2));
				izvestaj.setPrihodBezPopusta(rezultat.getString(3));
				izvestaj.setRazlika(Double.parseDouble(izvestaj.getPrihodBezPopusta()) - Double.parseDouble(izvestaj.getUkupanPrihod()));
			}
			stmt.close();
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return izvestaj;
	}
}
