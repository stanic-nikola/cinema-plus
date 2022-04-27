package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Film;
import beans.cinemaplus.Projekcija;
import dao.FilmDao.FilmDao;
import dao.ProjekcijaDao.ProjekcijaDao;

@WebServlet("/PrikazFilma")
public class PrikazFilma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FilmDao f = new FilmDao();
		
		String idFilma = request.getParameter("IdFilma");
		
		try 
		{
			int id = Integer.parseInt(idFilma);
			Film film  = f.vratiFilmPoId(id);
			ProjekcijaDao p = new ProjekcijaDao();
			ArrayList<Projekcija> sveProjekcije = p.vratiProjekcijePoIdFilma(id);
			
			if(film != null)
			{
				request.setAttribute("projekcije", sveProjekcije);
				request.setAttribute("film", film);
				request.getRequestDispatcher("film.jsp").forward(request, response);
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije." + ex);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
