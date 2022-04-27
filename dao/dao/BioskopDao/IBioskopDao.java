package dao.BioskopDao;

import java.util.ArrayList;

import beans.cinemaplus.Bioskop;

public interface IBioskopDao {
	ArrayList<Bioskop> vratiSveBioskope();
	Bioskop vratiBioskopPoId(int idBioskopa);
	int dodajBioskop(Bioskop noviBioskop);
	void obrisiBioskop(int idBioskopa);
	int azurirajBioskop(Bioskop azuriranBioskop);
	Bioskop vratiBioskopPoIdSale(int idSale);
}
