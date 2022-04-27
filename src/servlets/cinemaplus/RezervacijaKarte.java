package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Clanstvo;
import beans.cinemaplus.Film;
import beans.cinemaplus.Klub;
import beans.cinemaplus.Korisnik;
import beans.cinemaplus.Projekcija;
import beans.cinemaplus.Sala;
import dao.Clanstvo.ClanstvoDao;
import dao.FilmDao.FilmDao;
import dao.KlubDao.KlubDao;
import dao.ProjekcijaDao.ProjekcijaDao;
import dao.RezervacijaDao.RezervacijaDao;
import dao.SalaDao.SalaDao;
import service.validation.Validacija;

@WebServlet("/RezervacijaKarte")
public class RezervacijaKarte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Korisnik korisnik = (Korisnik)request.getSession().getAttribute("Korisnik");
		if(korisnik == null)
		{
			request.setAttribute("poruka", "Morate se prijaviti da biste rezervisali kartu! ");
			request.getRequestDispatcher("prijava.jsp").forward(request, response);
		}
		
		ArrayList<Integer> rezSedista = new ArrayList<Integer>();
		String idProjekcije = request.getParameter("IdProjekcije");
		ProjekcijaDao p = new ProjekcijaDao();
		FilmDao f = new FilmDao();
		SalaDao s = new SalaDao();
		
		try {
			int projekcijaId = Integer.parseInt(idProjekcije);
			Projekcija projekcija = p.vratiProjekcijuPoId(projekcijaId);
			Film film = f.vratiFilmPoId(projekcija.getIdFilma());
			Sala sala = s.vratiSaluPoId(projekcija.getIdSale());
			RezervacijaDao rDao = new RezervacijaDao();
			rezSedista = rDao.vratiRezervisanaSedista(projekcijaId);
			
			request.setAttribute("rezervisanaSedista", rezSedista);
			request.setAttribute("sala", sala);
			request.setAttribute("film", film);
			request.setAttribute("projekcija", projekcija);
			request.getRequestDispatcher("rezervacija.jsp").forward(request, response);
			
		}catch(Exception ex)
		{
			request.setAttribute("poruka", "Došlo je do greške prilikom konverzije! " + ex);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClanstvoDao c = new ClanstvoDao();
		KlubDao k = new KlubDao();
		
		String idP = request.getParameter("IdProjekcije");
		String cenaKarte = request.getParameter("cenaKarte");
//		String brKarata = request.getParameter("brojKarata");
		String[] brojeviSedista = request.getParameterValues("brojSedista");
		String korisnikId = request.getParameter("idKorisnika"); 
		
		String[] proveriUnos = new String[] {idP, cenaKarte, korisnikId};
		
		if(Validacija.validacijaUnosa(proveriUnos))
		{
			try {
				int idProjekcije = Integer.parseInt(idP);
//				int brojKarata = Integer.parseInt(brKarata);
				int idKor = Integer.parseInt(korisnikId);
				double cena = Double.parseDouble(cenaKarte);

				Clanstvo clanstvo = c.vratiClanstvoPoId(idKor);
				if(clanstvo != null)
				{
					Klub klub = k.vratiKlubPoId(clanstvo.getIdKluba());
					int popust = klub.getPopust();
					if(popust >= 0)
					{
						cena -= cena/popust;
					}
				}

				
				RezervacijaDao r = new RezervacijaDao();
				if(brojeviSedista == null)
				{
					request.setAttribute("poruka", "Rezervacija nije validna!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else if(brojeviSedista.length == 1)
				{
					int brojSedista = Integer.parseInt(brojeviSedista[0]);
					
					r.dodajRezervaciju(idProjekcije,cena, brojSedista, idKor);
				}
				else if(brojeviSedista.length >= 1 && brojeviSedista.length <= 6)
				{
					ArrayList<Integer> brs = new ArrayList<Integer>();

					for(String br: brojeviSedista)
					{
						brs.add(Integer.parseInt(br));
					}
					r.dodajRezervacije(idProjekcije, cena, brs, idKor);
				}
				else if(brojeviSedista.length > 6)
				{
					request.setAttribute("poruka", "Možete rezervisati maksimalno 6 karata!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
				request.setAttribute("uspeh", "Uspešno ste rezervisali karte!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}catch(Exception ex)
			{
				request.setAttribute("poruka", "Došlo je do greške prilikom konverzije! " + ex);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("poruka", "Došlo je do greške!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}
