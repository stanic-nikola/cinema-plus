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
import dao.KorisnikDao.KorisnikDao;
import dao.RezervacijaDao.RezervacijaDao;

@WebServlet("/StatusRezervacije")
public class StatusRezervacije extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBioskopa = request.getParameter("IdBioskopa");
		String idRezervacije = request.getParameter("IdRezervacije");
		String otkazi = request.getParameter("Otkazi");
		KorisnikDao k = new KorisnikDao();

		try {
			int bioskopId = Integer.parseInt(idBioskopa);
			int rezervacijaId = Integer.parseInt(idRezervacije);
			Korisnik korisnik = k.vratiKorisnikaPoIdRezervacije(rezervacijaId);
			int idKor = korisnik.getIdKorisnika();
			int poeniKorisnika = korisnik.getBrojPoena();
			RezervacijaDao r = new RezervacijaDao();
			
			if(otkazi != null)
			{
				r.promeniStatusRezervacije(rezervacijaId, "Otkazana");
			}
			else
			{
				KorisnikDao kDao = new KorisnikDao();
				r.promeniStatusRezervacije(rezervacijaId, "Potvrðena");
				kDao.promeniPoeneKorisnika(idKor, poeniKorisnika + 100);
			}
			
			RezervacijaDao rDao = new RezervacijaDao();
			ArrayList<Rezervacija> sveRezervacije = rDao.rezervacijePoIdBioskopa(bioskopId);
			request.setAttribute("idBioskopa", bioskopId);
			request.setAttribute("rezervacije", sveRezervacije);
			request.getRequestDispatcher("prikazRezervacija.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Došlo je do greške prilikom konverzije.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
