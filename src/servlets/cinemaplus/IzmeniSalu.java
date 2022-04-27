package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.cinemaplus.Sala;
import dao.SalaDao.SalaDao;


@WebServlet("/IzmeniSalu")
public class IzmeniSalu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		SalaDao s;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		s = new SalaDao();
		
		String id = request.getParameter("IdSale");
		
		try 
		{
			int idSale = Integer.parseInt(id);
			Sala sala = s.vratiSaluPoId(idSale);
			
			if(sala != null)
			{
				request.setAttribute("sala", sala);
				request.getRequestDispatcher("azurirajSalu.jsp").forward(request, response);
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
		s = new SalaDao();
		
		String id = request.getParameter("Id");
		String idBioskopa = request.getParameter("IdBioskopa");
		String naziv = request.getParameter("NazivSale");
		String opis = request.getParameter("Opis");
		String brojMesta = request.getParameter("BrojMesta");
		String tehnologija = request.getParameter("Tehnologija");
		
		try {
			Sala azuriranaSala = new Sala(Integer.parseInt(id), naziv, opis, Integer.parseInt(brojMesta), tehnologija);
			if(s.azurirajSalu(azuriranaSala) == 0)
			{
				request.setAttribute("poruka", "Greška");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("poruka", "Uspešno ste ažurirali salu.");
				request.getRequestDispatcher("PrikaziSale?IdBioskopa=" + idBioskopa).forward(request, response);
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("poruka", "Greška prilikom konverzije.");
			request.getRequestDispatcher("sale.jsp").forward(request, response);
		}
	}

}
