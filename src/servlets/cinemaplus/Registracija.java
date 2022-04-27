package servlets.cinemaplus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Korisnik;
import dao.KorisnikDao.KorisnikDao;
import service.validation.Validacija;


@WebServlet("/Registracija")
public class Registracija extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		KorisnikDao k = new KorisnikDao();
		
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String nadimak = request.getParameter("nadimak");
		String brojMobilnog = request.getParameter("brojMobilnog");
		String email = request.getParameter("email");
		String lozinka = request.getParameter("lozinka");
		String[] unosZaProveru = new String[] {ime,prezime, nadimak, brojMobilnog, email, lozinka};
		
		if(Validacija.validacijaUnosa(unosZaProveru))
		{
			try 
			{
				KorisnikDao kDao = new KorisnikDao();

			if(kDao.proveriEmail(email)) 
			{
				request.setAttribute("poruka", "Korisnik sa email-om '" + email + "' veæ postoji!");
				request.getRequestDispatcher("registracija.jsp").forward(request, response);
			}
			else
			{
				try
				{		
					Korisnik noviKorisnik = new Korisnik(ime, prezime, nadimak, email, lozinka, brojMobilnog);
					k.dodajKorisnika(noviKorisnik);
					request.setAttribute("uspeh", "Uspešno ste se registrovali! Možete se prijaviti.");
					request.getRequestDispatcher("prijava.jsp").forward(request, response);	
				}
				catch(Exception ex){
					request.setAttribute("poruka", "Došlo je do greške!");
					request.getRequestDispatcher("registracija.jsp").forward(request, response);
				}
			}
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Došlo je do greške!");
				request.getRequestDispatcher("registracija.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("poruka", "Morate popuniti sva polja!");
			request.getRequestDispatcher("registracija.jsp").forward(request, response);
		}
		
	}
}
