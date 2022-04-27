package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Korisnik;
import beans.cinemaplus.Rezervacija;
import dao.KorisnikDao.KorisnikDao;
import dao.RezervacijaDao.RezervacijaDao;

@WebServlet("/IskoristiPopust")
public class IskoristiPopust extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IskoristiPopust() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRezervacije = request.getParameter("IdRezervacije");
		RezervacijaDao r = new RezervacijaDao();
		int brojPoena = (int)request.getSession().getAttribute("BrojPoena");
		Korisnik korisnik = (Korisnik)request.getSession().getAttribute("Korisnik");
		
		if(brojPoena >= 100)
		{
			try {
				int id = Integer.parseInt(idRezervacije);
				
				brojPoena -= 100;
				Rezervacija rezervacija = r.vratiRezervacijuPoId(id);
				double cenaKarte = rezervacija.getCenaKarte();
				if(cenaKarte > 0)
				{
					cenaKarte -= cenaKarte/10;
					r.umanjiCenuKarte(id, cenaKarte);
					KorisnikDao k = new KorisnikDao();
					k.promeniPoeneKorisnika(korisnik.getIdKorisnika(), brojPoena);
					
					
					request.getSession().removeAttribute("BrojPoena");
					request.getSession().setAttribute("BrojPoena", brojPoena);
					
					request.setAttribute("poruka", "Uspešno ste iskoristili popust!");
					request.getRequestDispatcher("RezervacijeKorisnika").forward(request, response);
				}
				else
				{
					request.setAttribute("poruka", "Cena karte nije validna!");
					request.getRequestDispatcher("RezervacijeKorisnika").forward(request, response);
				}

			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Greška prilikom konverzije!");
				request.getRequestDispatcher("RezervacijeKorisnika").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
