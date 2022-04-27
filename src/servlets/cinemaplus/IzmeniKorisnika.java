package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Korisnik;
import dao.KorisnikDao.KorisnikDao;

@WebServlet("/IzmeniKorisnika")
public class IzmeniKorisnika extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		KorisnikDao k = new KorisnikDao();
		String id = request.getParameter("IdKorisnika");
		try 
		{
			int idKorisnika = Integer.parseInt(id);
			Korisnik korisnik = k.vratiKorisnikaPoId(idKorisnika);
			
			if(korisnik != null)
			{
				request.setAttribute("korisnik", korisnik);
				request.getRequestDispatcher("azurirajKorisnika.jsp").forward(request, response);
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije." + ex);
			request.getRequestDispatcher("korisnici.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
