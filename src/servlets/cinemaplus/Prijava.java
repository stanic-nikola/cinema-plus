package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.cinemaplus.Clanstvo;
import beans.cinemaplus.Klub;
import beans.cinemaplus.Korisnik;
import dao.Clanstvo.ClanstvoDao;
import dao.KlubDao.KlubDao;
import dao.PrijavaDao.PrijavaDao;
import service.validation.Validacija;

@WebServlet("/Prijava")
public class Prijava extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String lozinka = request.getParameter("lozinka");
		HttpSession sesija = request.getSession();
		String[] proveriPodatke = new String[] {email, lozinka};

		if(Validacija.validacijaUnosa(proveriPodatke))
		{
		    PrijavaDao prijavaDao = new PrijavaDao();
		    ClanstvoDao c = new ClanstvoDao();
		    KlubDao k = new KlubDao();
		    try
		    {
		    	Korisnik korisnik = prijavaDao.autentifikujKorisnika(email, lozinka);
		    	
		    	if(korisnik != null && korisnik.getIme() != null)
		    	{
		    	Klub klub = null;
		    	Clanstvo clanstvo = c.vratiClanstvoPoId(korisnik.getIdKorisnika());
		    	
		    	if(clanstvo != null)
		    	{
			    	klub = k.vratiKlubPoId(clanstvo.getIdKluba());
		    	}

		    	
		    	if(clanstvo != null && klub != null)
		    	{
		    		sesija.setAttribute("Klub", klub);
		    	}

		    		sesija.setAttribute("BrojPoena", korisnik.getBrojPoena());
		    		sesija.setAttribute("Korisnik", korisnik);
		    		sesija.setAttribute("Rola", korisnik.getRola());
		    		
		    		request.getRequestDispatcher("index.jsp").forward(request, response);
		    	}
		    	else
		    	{
		    		request.setAttribute("poruka", "Neispravan email ili lozinka.");
		    		request.getRequestDispatcher("prijava.jsp").forward(request, response);
		    	}
		    }
		    catch(Exception ex)
		    {
		    	ex.printStackTrace();
		    }
		}
		else
		{
    		request.setAttribute("poruka", "Morate popuniti sva polja!");
    		request.getRequestDispatcher("prijava.jsp").forward(request, response);
		}
	}
}
