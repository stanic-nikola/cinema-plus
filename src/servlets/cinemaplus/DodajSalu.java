package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Bioskop;
import beans.cinemaplus.Sala;
import dao.BioskopDao.BioskopDao;
import dao.SalaDao.SalaDao;

@WebServlet("/DodajSalu")
public class DodajSalu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BioskopDao b;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String idBioskopa = request.getParameter("IdBioskopa");
		
		try
		{
			int id = Integer.parseInt(idBioskopa);
			b = new BioskopDao();
			Bioskop bioskop = b.vratiBioskopPoId(id);
			
			if(bioskop != null)
			{
				request.setAttribute("bioskop", bioskop);
				request.getRequestDispatcher("dodajSalu.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("poruka", "Došlo je do greške");
				request.getRequestDispatcher("sale.jsp").forward(request, response);
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Došlo je do greške prilikom konverzije.");
			request.getRequestDispatcher("sale.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SalaDao s = new SalaDao();
		
		
		String idBioskopa = request.getParameter("IdBioskopa");
		String naziv = request.getParameter("NazivSale");		
		String opis = request.getParameter("Opis");
		String brojMesta = request.getParameter("BrojMesta");
		String tehnologija = request.getParameter("Tehnologija");

		
		try
		{
			int id = Integer.parseInt(idBioskopa);
			int brm = Integer.parseInt(brojMesta);
			
			Sala novaSala = new Sala(naziv, opis, brm, tehnologija, id);
			s.dodajSalu(novaSala);
			
			request.setAttribute("poruka", "Uspešno ste dodali novu salu.");
			request.getRequestDispatcher("PrikaziSale?IdBioskopa=" + id).forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije!");
			request.getRequestDispatcher("sale.jsp").forward(request, response);
		}
	}

}
