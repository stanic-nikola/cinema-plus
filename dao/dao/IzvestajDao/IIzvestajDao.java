package dao.IzvestajDao;

import beans.cinemaplus.Izvestaj;

public interface IIzvestajDao {
	Izvestaj vratiIzvestajDnevni(String datum);
	Izvestaj vratiIzvestajMesecni(String mesec);
	Izvestaj vratiIzvestajGodisnji(String godina);
}
