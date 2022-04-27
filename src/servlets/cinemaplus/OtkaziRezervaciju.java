package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RezervacijaDao.RezervacijaDao;

@WebServlet("/OtkaziRezervaciju")
public class OtkaziRezervaciju extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRezervacije = request.getParameter("IdRezervacije");
		RezervacijaDao r = new RezervacijaDao();
		
		try {
			int id = Integer.parseInt(idRezervacije);
			
			r.promeniStatusRezervacije(id, "Otkazana");
			
			
			request.setAttribute("uspeh", "Uspešno ste otkazali rezervaciju!");
			request.getRequestDispatcher("RezervacijeKorisnika").forward(request, response);
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
