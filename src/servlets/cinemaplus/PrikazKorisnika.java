package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Korisnik;
import dao.KorisnikDao.KorisnikDao;

@WebServlet("/PrikazKorisnika")
public class PrikazKorisnika extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		KorisnikDao k = new KorisnikDao();
		try {
			Korisnik korisnik = (Korisnik)request.getSession().getAttribute("Korisnik");
			ArrayList<Korisnik> korisnici = k.vratiKorisnikeBezAdmina(korisnik.getIdKorisnika());
			
			request.setAttribute("korisnici", korisnici);
			request.getRequestDispatcher("korisnici.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Došlo je do greške prilikom konverzije! " + ex);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
