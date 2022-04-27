package servlets.cinemaplus;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.cinemaplus.Clanstvo;
import beans.cinemaplus.Klub;

import dao.Clanstvo.ClanstvoDao;
import dao.KlubDao.KlubDao;
import service.validation.Validacija;


@WebServlet("/UclaniSe")
public class UclaniSe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		KlubDao k = new KlubDao();
		String id = request.getParameter("IdKluba");
		
		try
		{
			int idKluba = Integer.parseInt(id);
			Klub klub = k.vratiKlubPoId(idKluba);
			
			if(klub != null)
			{
				request.setAttribute("klub", klub);
				request.getRequestDispatcher("postaniClan.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("poruka", "Greška prilikom uèitavanja gradova.");
				request.getRequestDispatcher("klubovi.jsp").forward(request, response);
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Došlo je do greške prilikom konverzije!");
			request.getRequestDispatcher("klubovi.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ClanstvoDao c = new ClanstvoDao();
		KlubDao kDao = new KlubDao();
		
		String idKluba = request.getParameter("IdKluba");
		String idKorisnika = request.getParameter("IdKorisnika");
		String tipClanstva = request.getParameter("TipClanstva");
		String sediste = request.getParameter("Sediste");
		String[] provera = new String[] {idKluba, idKorisnika, tipClanstva, sediste};
		
		if(Validacija.validacijaUnosa(provera))
		{
			try
			{
				int klubId = Integer.parseInt(idKluba);
				int korisnikId = Integer.parseInt(idKorisnika);
				int brojSedista = Integer.parseInt(sediste);
				
				request.getSession().removeAttribute("Klub");
				Clanstvo noviClan = new Clanstvo(klubId, korisnikId, tipClanstva, brojSedista);
				c.dodajClana(noviClan);
				Klub klubSesija = kDao.vratiKlubPoId(klubId);
				
				request.getSession().setAttribute("Klub", klubSesija);
				
				request.setAttribute("uspeh", "Uspešno ste se uèlanili u klub!");
				request.getRequestDispatcher("klubovi.jsp").forward(request, response);
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Greška prilikom konverzije!");
				request.getRequestDispatcher("klubovi.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("poruka", "Niste uneli sve podatke!");
			request.getRequestDispatcher("klubovi.jsp").forward(request, response);
		}

	}

}
