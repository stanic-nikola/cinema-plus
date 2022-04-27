package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BioskopDao.BioskopDao;


@WebServlet("/ObrisiBioskop")
public class ObrisiBioskop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BioskopDao b;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		b = new BioskopDao();
		
		String idBioskopa = request.getParameter("IdBioskopa");
		
		try
		{
			int id = Integer.parseInt(idBioskopa);
			b.obrisiBioskop(id);
			
			request.setAttribute("poruka", "Uspešno obrisan bioskop!");
			request.getRequestDispatcher("bioskopi.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
