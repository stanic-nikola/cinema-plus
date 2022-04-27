package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Clanstvo;
import beans.cinemaplus.Klub;
import beans.cinemaplus.Korisnik;
import dao.Clanstvo.ClanstvoDao;
import dao.KlubDao.KlubDao;

@WebServlet("/PrikazClanstva")
public class PrikazClanstva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Korisnik korisnik = (Korisnik)request.getSession().getAttribute("Korisnik");
		
		try
		{
			ClanstvoDao c = new ClanstvoDao();
			KlubDao k = new KlubDao();
			
			Clanstvo clanstvo = c.vratiClanstvoPoId(korisnik.getIdKorisnika());
			Klub klub = k.vratiKlubPoId(clanstvo.getIdKluba());
					
			request.setAttribute("klub", klub);
			request.setAttribute("clanstvo", clanstvo);
			request.getRequestDispatcher("clanstvo.jsp").forward(request, response);
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
