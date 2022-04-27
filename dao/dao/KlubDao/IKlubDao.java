package dao.KlubDao;

import java.util.ArrayList;

import beans.cinemaplus.Klub;

public interface IKlubDao {
	ArrayList<Klub> vratiSveKlubove();
	Klub vratiKlubPoId(int idKluba);
	
}
