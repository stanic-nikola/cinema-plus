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

@WebServlet("/DodajFilm")
public class DodajFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FilmDao f = new FilmDao();
		
		
		String naziv = request.getParameter("NazivFilma");
		String opis = request.getParameter("OpisFilma");
		String slika = request.getParameter("Slika");
		String zanr = request.getParameter("Zanr");
		String trajanje = request.getParameter("Trajanje");
		String trejler = request.getParameter("Trejler");
		String datum = request.getParameter("Datum");
		String[] proveraUnosa = new String[] {naziv, opis, slika, zanr, trajanje, trejler, datum};
		if(Validacija.validacijaUnosa(proveraUnosa))
		{
			try
			{
				
				java.sql.Date sqlDate = java.sql.Date.valueOf(datum);
				
				Film noviFilm = new Film(naziv, opis, slika, zanr, trajanje, trejler, sqlDate);
				
				f.dodajFilm(noviFilm);
				
				request.setAttribute("poruka", "Uspešno ste dodali novi film.");
				request.getRequestDispatcher("filmovi.jsp").forward(request, response);
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Greška prilikom konverzije!" + ex);
				request.getRequestDispatcher("filmovi.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("poruka", "Morate popuniti sva polja!");
			request.getRequestDispatcher("dodajFilm.jsp").forward(request, response);
		}

	}

}
