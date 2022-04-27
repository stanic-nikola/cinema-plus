package dao.ProjekcijaDao;

import java.util.ArrayList;

import beans.cinemaplus.Projekcija;

public interface IProjekcijaDao {
	ArrayList<Projekcija> vratiSveProjekcije();
	Projekcija vratiProjekcijuPoId(int idProjekcije);
	int dodajProjekciju(Projekcija novaProjekcija);
	void obrisiProjekciju(int idProjekcije);
	int azurirajProjekciju(Projekcija azuriranaProjekcija);
	ArrayList<Projekcija> vratiProjekcijePoIdFilma(int idFilma);
}
