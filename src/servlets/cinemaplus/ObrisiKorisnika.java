package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KorisnikDao.KorisnikDao;

@WebServlet("/ObrisiKorisnika")
public class ObrisiKorisnika extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idKorisnika = request.getParameter("IdKorisnika");
		
		try
		{
			int id = Integer.parseInt(idKorisnika);
			KorisnikDao k = new KorisnikDao();
			
			k.obrisiKorisnika(id);

			
			request.setAttribute("uspeh", "Uspešno obrisan korisnik!");
			request.getRequestDispatcher("PrikazKorisnika").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
