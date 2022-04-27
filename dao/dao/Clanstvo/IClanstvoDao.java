package dao.Clanstvo;

import java.util.ArrayList;

import beans.cinemaplus.Clanstvo;


public interface IClanstvoDao {
	ArrayList<Clanstvo> vratiSveClanove();
	Clanstvo vratiClanstvoPoId(int idClana);
	int dodajClana(Clanstvo noviClan);
	void obrisiClana(int idClana);
	int azurirajClana(Clanstvo azuriranClan);
}
