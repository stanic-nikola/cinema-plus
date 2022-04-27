package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Korisnik;
import beans.cinemaplus.Rezervacija;
import dao.RezervacijaDao.RezervacijaDao;

@WebServlet("/RezervacijeKorisnika")
public class RezervacijeKorisnika extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RezervacijaDao r = new RezervacijaDao();
		Korisnik korisnik = (Korisnik)request.getSession().getAttribute("Korisnik");
		try {
			if(korisnik.getIme() != null)
			{
				ArrayList<Rezervacija> sveRezervacije = r.rezervacijePoIdKorisnika(korisnik.getIdKorisnika());
				
				request.setAttribute("rezervacije", sveRezervacije);
				request.getRequestDispatcher("rezervacijeKorisnika.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("poruka", "Greška, korisnik nije ulogovan!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
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
