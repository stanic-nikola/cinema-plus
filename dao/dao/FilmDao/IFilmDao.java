package dao.FilmDao;

import java.util.ArrayList;

import beans.cinemaplus.Film;

public interface IFilmDao {
	ArrayList<Film> vratiSveFilmove();
	Film vratiFilmPoId(int idFilma);
	int dodajFilm(Film noviFilm);
	void obrisiFilm(int idFilma);
	int azurirajFilm(Film azuriranFilm);
}
