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
import service.validation.Validacija;

@WebServlet("/DodajProjekciju")
public class DodajProjekciju extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String[] sati = {"00","01","02","03","04","05","06","07","08","09","10","11","12",
			"13","14","15","16","17","18","19","20","21","22","23"};
	String[] minuti = {"00","15","30","45"};
	String idFilma = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("IdBioskopa");
		if(id == null)
		{	
			BioskopDao b = new BioskopDao();

			idFilma = request.getParameter("IdFilma");
			ArrayList<Bioskop> bioskopi = b.vratiSveBioskope();
			
			if(bioskopi != null)
			{
				request.setAttribute("bioskopi", bioskopi);
				request.getRequestDispatcher("dodajProjekciju.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("poruka", "Došlo je do greške!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else
		{
			try 
			{
				int idBioskopa = Integer.parseInt(id);
				int idFilm = Integer.parseInt(idFilma);
				SalaDao s = new SalaDao();
				ArrayList<Sala> sale = s.vratiSalePoId(idBioskopa);
				BioskopDao bDao = new BioskopDao();
				Bioskop bioskop = bDao.vratiBioskopPoId(idBioskopa);
				FilmDao fDao = new FilmDao();
				Film film = fDao.vratiFilmPoId(idFilm);
				
				request.setAttribute("minuti", minuti);
				request.setAttribute("sati", sati);
				request.setAttribute("film", film);
				request.setAttribute("NazivBioskopa", bioskop.getNazivBioskopa());
				request.setAttribute("sale", sale);
				request.getRequestDispatcher("dodajProjekciju.jsp").forward(request, response);
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Došlo je do greške prilikom konverzije!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idS = request.getParameter("sale");
		String idF = request.getParameter("IdFilma");
		String cenaK = request.getParameter("CenaKarte");
		String idK = request.getParameter("IdKorisnika");
		String datum = request.getParameter("Datum");
		String sat = request.getParameter("sati");
		String min = request.getParameter("minuti");
		String[] proveraUnosa = new String[] {idS, idF, cenaK, idK, datum, sat, min};
		
			
		if(Validacija.validacijaUnosa(proveraUnosa))
		{
			try
			{
				int salaId = Integer.parseInt(idS);
				int filmId = Integer.parseInt(idF);
				int korisnikId = Integer.parseInt(idK);
				double cenaKarte = Double.parseDouble(cenaK);
				
				String datumVreme = datum + " " + sat + ":" + min + ":00";
				
				Projekcija novaProjekcija = new Projekcija(salaId, filmId, datumVreme, cenaKarte, korisnikId);
				ProjekcijaDao p = new ProjekcijaDao();
				p.dodajProjekciju(novaProjekcija);	
				
				request.setAttribute("poruka", "Uspešno ste dodali projekciju!");
				request.getRequestDispatcher("PrikazFilma?IdFilma=" + idF).forward(request, response);
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Greška prilikom konverzije!" + ex);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("greska", "Niste uneli sve podatke, pokušajte ponovo!");
			request.getRequestDispatcher("PrikazFilma?IdFilma=" + idF).forward(request, response);
		}
	}
}
