package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjekcijaDao.ProjekcijaDao;

@WebServlet("/ObrisiProjekciju")
public class ObrisiProjekciju extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProjekcije = request.getParameter("IdProjekcije");
		
		try
		{
			int id = Integer.parseInt(idProjekcije);
			ProjekcijaDao p = new ProjekcijaDao();
			
			p.obrisiProjekciju(id);

			
			request.setAttribute("uspeh", "Uspešno obrisana projekcija!");
			request.getRequestDispatcher("filmovi.jsp").forward(request, response);
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
