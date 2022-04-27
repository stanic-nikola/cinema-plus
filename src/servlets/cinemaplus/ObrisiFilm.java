package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDao.FilmDao;


@WebServlet("/ObrisiFilm")
public class ObrisiFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDao f = new FilmDao();
		
		String idFilma = request.getParameter("IdFilma");
		
		try
		{
			int id = Integer.parseInt(idFilma);
			f.obrisiFilm(id);
			
			request.setAttribute("poruka", "Uspešno obrisan film!");
			request.getRequestDispatcher("filmovi.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije!");
			request.getRequestDispatcher("filmovi.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
