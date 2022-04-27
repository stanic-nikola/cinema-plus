package servlets.cinemaplus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.cinemaplus.Izvestaj;
import dao.IzvestajDao.IzvestajDao;

@WebServlet("/PrikazIzvestaja")
public class PrikazIzvestaja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tip = request.getParameter("Tip");
		
		if(!tip.isBlank() && !tip.isEmpty())
		{
			try
			{
				if(tip.equals("Dnevni"))
				{
					request.setAttribute("dnevni", "dnevni");
					request.getRequestDispatcher("izvestaji.jsp").forward(request, response);
				}
				else if(tip.equals("Mesecni"))
				{
 					String[] meseci = new String[] { "Januar", "Februar", "Mart", "April", "Maj", "Jun", "Jul", "Avgust", "Septembar", "Oktobar", "Novembar", "Decembar"};

					request.setAttribute("meseci", meseci);
					request.getRequestDispatcher("izvestaji.jsp").forward(request, response);
				}
				else if(tip.equals("Godisnji"))
				{
					String[] godine = new String[] { "2018","2019", "2020"};
					
					request.setAttribute("godine", godine);
					request.getRequestDispatcher("izvestaji.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("poruka", "Ne postoji takva vrsta izveštaja!");
					request.getRequestDispatcher("izvestaji.jsp").forward(request, response);
				}
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Došlo je do greške!");
				request.getRequestDispatcher("izvestaji.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String datum = request.getParameter("datum");
		String mesec = request.getParameter("mesec");
		String godina = request.getParameter("godina");
		
		
		if(datum !=null || mesec != null || godina != null)
		{
			IzvestajDao i = new IzvestajDao();
			Izvestaj izvestaj = null;
			try
			{
				if(datum != null)
				{
					izvestaj = i.vratiIzvestajDnevni(datum);

					request.setAttribute("izvestaj", izvestaj);
					request.getRequestDispatcher("izvestaj.jsp").forward(request, response);
				}
				else if(mesec != null)
				{
					izvestaj = i.vratiIzvestajMesecni(mesec);
					
					request.setAttribute("izvestaj", izvestaj);
					request.getRequestDispatcher("izvestaj.jsp").forward(request, response);
				}
				else if(godina != null)
				{
					izvestaj = i.vratiIzvestajGodisnji(godina);
					
					request.setAttribute("izvestaj", izvestaj);
					request.getRequestDispatcher("izvestaj.jsp").forward(request, response);
				}
			}
			catch(Exception ex)
			{
				request.setAttribute("poruka", "Došlo je do greške!");
				request.getRequestDispatcher("izvestaji.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("poruka", "Došlo je do greške!");
			request.getRequestDispatcher("izvestaji.jsp").forward(request, response);
		}
	}

}
