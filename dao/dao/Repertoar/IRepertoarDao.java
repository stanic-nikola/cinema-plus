package dao.Repertoar;

import java.util.ArrayList;

import beans.cinemaplus.Repertoar;

public interface IRepertoarDao {
	ArrayList<Repertoar> vratiRepertoarPoDatumu(String datum, int idBioskop);
}
