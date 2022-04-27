package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Sala;
import dao.SalaDao.SalaDao;

@WebServlet("/PrikaziSale")
public class PrikaziSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBioskopa = request.getParameter("IdBioskopa");
		
		try
		{
			int id = Integer.parseInt(idBioskopa);
			SalaDao s = new SalaDao();
			ArrayList<Sala> sale = s.vratiSalePoId(id);
			
			request.setAttribute("sale", sale);
			request.setAttribute("IdBioskopa", id);
			request.getRequestDispatcher("sale.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije.");
			request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
