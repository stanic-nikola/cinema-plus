package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Bioskop;
import beans.cinemaplus.Grad;
import dao.BioskopDao.BioskopDao;
import dao.GradDao.GradDao;

@WebServlet("/DodajBioskop")
public class DodajBioskop extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		GradDao d = new GradDao();
		
		ArrayList<Grad> gradovi = d.vratiSveGradove();
		
		if(gradovi != null)
		{
			request.setAttribute("gradovi", gradovi);
			request.getRequestDispatcher("dodajBioskop.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("poruka", "Greška prilikom uèitavanja gradova.");
			request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BioskopDao b = new BioskopDao();
		
		String idGrad = request.getParameter("grad");
		String naziv = request.getParameter("NazivBioskopa");
		String adresa = request.getParameter("Adresa");
		String slika = request.getParameter("Slika");
		String opis = request.getParameter("Opis");
		
		try
		{
			int id = Integer.parseInt(idGrad);
			
			Bioskop noviBioskop = new Bioskop(naziv, adresa, slika , opis, id);
			b.dodajBioskop(noviBioskop);
			
			request.setAttribute("poruka", "Uspešno ste dodali novi bioskop.");
			request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije!");
			request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
		}

	}

}
