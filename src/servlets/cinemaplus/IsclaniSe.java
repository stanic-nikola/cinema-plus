package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Clanstvo.ClanstvoDao;


@WebServlet("/IsclaniSe")
public class IsclaniSe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idClana = request.getParameter("Id");
		
		ClanstvoDao c = new ClanstvoDao();
		try
		{
			int clanId = Integer.parseInt(idClana);
			
			request.getSession().removeAttribute("Klub");
			c.obrisiClana(clanId);
			request.getSession().setAttribute("Klub", null);
			
			request.setAttribute("poruka", "Uspe�no ste se i��lanili!");
			request.getRequestDispatcher("klubovi.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Do�lo je do gre�ke prilikom konverzije!");
			request.getRequestDispatcher("klubovi.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
