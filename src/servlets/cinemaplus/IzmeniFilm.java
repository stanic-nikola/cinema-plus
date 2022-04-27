package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.cinemaplus.Film;

import dao.FilmDao.FilmDao;
import service.validation.Validacija;

@WebServlet("/IzmeniFilm")
public class IzmeniFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FilmDao f = new FilmDao();
		String id = request.getParameter("IdFilma");
		
		if(!id.isEmpty())
		{
			try 
			{
				int idFilma = Integer.parseInt(id);
				Film film = f.vratiFilmPoId(idFilma);
				
				if(film != null)
				{
					request.setAttribute("film", film);
					request.getRequestDispatcher("azurirajFilm.jsp").forward(request, response);
				}
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Greška prilikom konverzije." + ex);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("poruka", "Greška");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FilmDao f = new FilmDao();
		
		String id = request.getParameter("IdFilma");
		String naziv = request.getParameter("NazivFilma");
		String opis = request.getParameter("OpisFilma");
		String slika = request.getParameter("Slika");
		String zanr = request.getParameter("Zanr");
		String trajanje = request.getParameter("Trajanje");
		String trejler = request.getParameter("Trejler");
		String datum = request.getParameter("Datum");
		String[] proveraUnosa = new String[] {id, naziv, opis, slika, zanr, trajanje, trejler, datum};
		
		
		if(Validacija.validacijaUnosa(proveraUnosa))
		{
			try {
				java.sql.Date sqlDate = java.sql.Date.valueOf(datum);
				int idFilma = Integer.parseInt(id);
				Film azuriranFilm = new Film(idFilma, naziv, opis, slika, zanr, trajanje, trejler, sqlDate);
				
				if(f.azurirajFilm(azuriranFilm) == 0)
				{
					request.setAttribute("poruka", "Greška");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("uspeh", "Uspešno ste ažurirali film.");
					request.getRequestDispatcher("PrikazFilma?IdFilma=" + id).forward(request, response);
				}
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Greška prilikom konverzije.");
				request.getRequestDispatcher("filmovi.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("poruka", "Morate uneti sve podatke.");
			request.getRequestDispatcher("azurirajFilm.jsp").forward(request, response);
		}
	}
}
