package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Rezervacija;
import dao.RezervacijaDao.RezervacijaDao;

@WebServlet("/PrikazRezervacija")
public class PrikazRezervacija extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RezervacijaDao r = new RezervacijaDao();
		String idBioskopa = request.getParameter("IdBioskopa");
		
		try 
		{
			int bioskopId = Integer.parseInt(idBioskopa);
			ArrayList<Rezervacija> sveRezervacije = r.rezervacijePoIdBioskopa(bioskopId);
			
			request.setAttribute("idBioskopa", bioskopId);
			request.setAttribute("rezervacije", sveRezervacije);
			request.getRequestDispatcher("prikazRezervacija.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
