package dao.SalaDao;

import java.util.ArrayList;

import beans.cinemaplus.Sala;

public interface ISalaDao {
	ArrayList<Sala> vratiSalePoId(int idBioskopa);
	Sala vratiSaluPoId(int idSale);
	int dodajSalu(Sala novaSala);
	void obrisiSalu(int idSale);
	int azurirajSalu(Sala azuriranaSala);
	int vratiIdBioskopa(int idSale);
}
