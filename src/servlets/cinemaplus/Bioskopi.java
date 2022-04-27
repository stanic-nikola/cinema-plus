package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Bioskop;
import dao.BioskopDao.BioskopDao;

@WebServlet("/Bioskopi")
public class Bioskopi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BioskopDao b = new BioskopDao();
		ArrayList<Bioskop> bioskopi = b.vratiSveBioskope();
		if(bioskopi != null && bioskopi.size() > 0)
		{
			request.setAttribute("bioskopi", bioskopi);
			request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("poruka", "Došlo je do greške");
			request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
