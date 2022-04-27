package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SalaDao.SalaDao;

@WebServlet("/ObrisiSalu")
public class ObrisiSalu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalaDao s = new SalaDao();

		String idSale = request.getParameter("IdSale");
		
		try
		{
			int id = Integer.parseInt(idSale);
			SalaDao sDao = new SalaDao();
			int idBioskopa = sDao.vratiIdBioskopa(id);
		
			s.obrisiSalu(id);

			
			request.setAttribute("poruka", "Uspešno obrisana sala!");
			request.getRequestDispatcher("PrikaziSale?IdBioskopa=" + idBioskopa).forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
