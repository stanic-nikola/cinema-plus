package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Bioskop;
import beans.cinemaplus.Film;
import beans.cinemaplus.Projekcija;
import beans.cinemaplus.Sala;
import dao.BioskopDao.BioskopDao;
import dao.FilmDao.FilmDao;
import dao.ProjekcijaDao.ProjekcijaDao;
import dao.SalaDao.SalaDao;


@WebServlet("/IzmeniProjekciju")
public class IzmeniProjekciju extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String[] sati = {"00","01","02","03","04","05","06","07","08","09","10","11","12",
			"13","14","15","16","17","18","19","20","21","22","23"};
	String[] minuti = {"00","15","30","45"};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProjekcije = request.getParameter("IdProjekcije");
		ProjekcijaDao p = new ProjekcijaDao();
		
		try {
			int projekcijaId = Integer.parseInt(idProjekcije);
			
			Projekcija projekcija = p.vratiProjekcijuPoId(projekcijaId);
			BioskopDao b = new BioskopDao();
			Bioskop bioskop = b.vratiBioskopPoIdSale(projekcija.getIdSale());
			SalaDao s = new SalaDao();
			ArrayList<Sala> sale = s.vratiSalePoId(bioskop.getIdBioskopa());

			FilmDao fDao = new FilmDao();
			Film film = fDao.vratiFilmPoId(projekcija.getIdFilma());
			
			request.setAttribute("minuti", minuti);
			request.setAttribute("sati", sati);
			request.setAttribute("film", film);
			request.setAttribute("NazivBioskopa", bioskop.getNazivBioskopa());
			request.setAttribute("sale", sale);
			request.setAttribute("projekcija", projekcija);
			request.getRequestDispatcher("azurirajProjekciju.jsp").forward(request, response);
			
		}catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije." + ex);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idS = request.getParameter("sale");
		String idF = request.getParameter("IdFilma");
		String cenaK = request.getParameter("CenaKarte");
		String idK = request.getParameter("IdKorisnika");
		String datum = request.getParameter("Datum");
		String sat = request.getParameter("sati");
		String min = request.getParameter("minuti");
		String idProjekcije = request.getParameter("IdProjekcije");
		
		try
		{
			int idProj = Integer.parseInt(idProjekcije);
			int salaId = Integer.parseInt(idS);
			int filmId = Integer.parseInt(idF);
			int korisnikId = Integer.parseInt(idK);
			double cenaKarte = Double.parseDouble(cenaK);
			
			String datumVreme = datum + " " + sat + ":" + min + ":00";
			
			Projekcija azuriranaProjekcija = new Projekcija(idProj, salaId, filmId, datumVreme, cenaKarte, korisnikId);
			ProjekcijaDao p = new ProjekcijaDao();
			p.azurirajProjekciju(azuriranaProjekcija);
			
			request.setAttribute("poruka", "Uspešno ste ažurirali projekciju!");
			request.getRequestDispatcher("filmovi.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije!" + ex);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
