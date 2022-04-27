package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Korisnik;
import dao.KorisnikDao.KorisnikDao;

@WebServlet("/AzurirajKorisnika")
public class AzurirajKorisnika extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String ime = request.getParameter("imeKorisnika");
		String idKor = request.getParameter("idKorisnika");
		String prezime = request.getParameter("prezimeKorisnika");
		String nadimak = request.getParameter("nadimak");
		String email = request.getParameter("email");
		String lozinka = request.getParameter("lozinka");
		String brojMobilnog = request.getParameter("brojMobilnog");
		String rola = request.getParameter("rola");
		
		try {
			char rolaKorisnika = rola.charAt(0);
			int idKorisnika = Integer.parseInt(idKor);
			Korisnik azuriranKorisnik = new Korisnik(idKorisnika, ime, prezime, nadimak, email, lozinka, brojMobilnog, rolaKorisnika);
			KorisnikDao k = new KorisnikDao();
			
			k.azurirajKorisnika(azuriranKorisnik);
			request.setAttribute("uspeh", "Uspešno ste ažurirali korisnika: " + ime + " " + prezime);
			request.getRequestDispatcher("PrikazKorisnika").forward(request, response);
			
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Došlo je do greške prilikom konverzije! " + ex);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
