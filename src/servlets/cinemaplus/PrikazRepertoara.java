package servlets.cinemaplus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Bioskop;
import beans.cinemaplus.Repertoar;
import dao.BioskopDao.BioskopDao;
import dao.Repertoar.RepertoarDao;

@WebServlet("/PrikazRepertoara")
public class PrikazRepertoara extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("IdBioskopa");
		
		if(!id.isBlank() && !id.isEmpty())
		{
			try {
				ArrayList<Date> datumi = new ArrayList<Date>();
				
				int idBioskopa = Integer.parseInt(id);
				
				BioskopDao b = new BioskopDao();
				Bioskop bioskop = b.vratiBioskopPoId(idBioskopa);
				//SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-dd");
				
				Calendar cal = Calendar.getInstance();
				Date timeNow = Calendar.getInstance().getTime();
				cal.setTime(timeNow);
				
				for(int i = 1; i<=7; i++)
				{
					datumi.add(timeNow);
					cal.add(Calendar.DATE, 1);
					timeNow = cal.getTime();
				}
				
				request.setAttribute("datumi", datumi);
				request.setAttribute("bioskop", bioskop);
				request.getRequestDispatcher("odabirRepertoara.jsp").forward(request, response);
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Došlo je do greške prilikom konverzije!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("poruka", "Došlo je do greške prilikom uèitavanja repertoara!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String datum = request.getParameter("datum");
		String idBioskop = request.getParameter("idBioskopa");
		String nazivB = request.getParameter("nazivBioskopa");
		
		RepertoarDao r = new RepertoarDao();
		
		try {
			int bioskopId = Integer.parseInt(idBioskop);
			ArrayList<Repertoar> repertoar = r.vratiRepertoarPoDatumu(datum, bioskopId);
			
			if(repertoar.size() > 0)
			{
				request.setAttribute("nazivBioskopa", nazivB);
				request.setAttribute("repertoar", repertoar);
				request.getRequestDispatcher("repertoar.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("nazivBioskopa", nazivB);
				request.setAttribute("poruka", "Nema projekcija za izabrani datum.");
				request.getRequestDispatcher("repertoar.jsp").forward(request, response);
			}

		}catch(Exception ex)
		{
			request.setAttribute("poruka", "Došlo je do greške prilikom konverzije! " + ex);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
