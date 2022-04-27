package service.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.RezervacijaDao.RezervacijaDao;

public class OtkaziRezervaciju implements Runnable {

	@Override
	public void run() {
		try 
		{
			
			RezervacijaDao r = new RezervacijaDao();
			SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

			Date timeNow = Calendar.getInstance().getTime();
			System.out.println(formatDate.format(timeNow));
			r.otkaziNepotvrdjeneRezervacije(formatDate.format(timeNow));
		} catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
