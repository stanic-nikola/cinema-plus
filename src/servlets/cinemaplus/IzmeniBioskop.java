package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Bioskop;
import dao.BioskopDao.BioskopDao;

@WebServlet("/IzmeniBioskop")
public class IzmeniBioskop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BioskopDao b = new BioskopDao();
		String id = request.getParameter("IdBioskopa");
		
		try 
		{
			int idBioskopa = Integer.parseInt(id);
			Bioskop bioskop = b.vratiBioskopPoId(idBioskopa);
			
			if(bioskop != null)
			{
				request.setAttribute("bioskop", bioskop);
				request.getRequestDispatcher("azurirajBioskop.jsp").forward(request, response);
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije." + ex);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BioskopDao b = new BioskopDao();
		String id = request.getParameter("Id");
		String naziv = request.getParameter("NazivBioskopa");
		String adresa = request.getParameter("Adresa");
		String slika = request.getParameter("Slika");
		String opis = request.getParameter("Opis");
		
		try {
			Bioskop azuriranBioskop = new Bioskop(Integer.parseInt(id), naziv, adresa, slika, opis);
			if(b.azurirajBioskop(azuriranBioskop) == 0)
			{
				request.setAttribute("poruka", "Greška");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("poruka", "Uspešno ste ažurirali bioskop.");
				request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije.");
			request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
		}
	}
}
