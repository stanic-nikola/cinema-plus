package service.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IzvrsniTajmer implements ServletContextListener {

	private ScheduledExecutorService scheduler;
	
	public void contextInitialized(ServletContextEvent event)
	{
		try
		{
			scheduler = Executors.newSingleThreadScheduledExecutor();
			
			scheduler.scheduleAtFixedRate(new OtkaziRezervaciju(), 5, 30, TimeUnit.SECONDS);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	
	}
	
	public void contextDestroyed(ServletContextEvent event) {
	    scheduler.shutdownNow();
	 }
}
