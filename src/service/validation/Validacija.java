package service.validation;

public class Validacija {
	
	public static boolean validacijaUnosa(String[] unosi)
	{
		for(String unos:unosi)
		{
			if(unos.isBlank() || unos.isEmpty())
			{
				return false;
			}
		}
		return true;
	}
	
	public static String vratiImeMeseca(int mesec)
	{
		String[] meseci = 
				new String[] { "Januar", "Februar", "Mart", "April", "Maj", "Jun", "Jul", "Avgust", "Septembar", "Oktobar", "Novembar", "Decembar"};
		
		return meseci[mesec-1];
	}
}
