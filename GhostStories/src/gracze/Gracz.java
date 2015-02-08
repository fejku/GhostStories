package gracze;

import enums.EPozycjaGracza;
import plansza.Wioska;
import utils.Stale;

public abstract class Gracz {
	private int punktyQi;
	private int aktualnePole;
	private int nastepnePole;
	private Plansza plansza;
	private EPozycjaGracza pozycjaGracza;
	
	public Gracz() {
		punktyQi = 2;
		aktualnePole = 5;
		plansza = new Plansza();
	}
	
	public void Nawiedzaj(Wioska wioska) {
		for (int nrPola = 0; nrPola < Stale.LICZBA_POL; nrPola++) {
			if (plansza.czyDuchNawiedza(nrPola)) {
				plansza.Nawiedzaj(wioska, pozycjaGracza, nrPola);
			}
		}
	}
	
	public void Drecz() {
		for (int nrPola = 0; nrPola < Stale.LICZBA_POL; nrPola++) {
			if (plansza.czyDuchDreczy(nrPola)) {
				plansza.Drecz(nrPola);
			}
		}
	}
	
	public boolean czyPlanszaPelna() {
		for (int nrPola = 0; nrPola < Stale.LICZBA_POL; nrPola++) {
			if(plansza.zwrocPole(nrPola) == null)
				return false;
		}
		return true;
	}
	
	public void stracPunktQi() {
		punktyQi--;
		if (punktyQi == 0) {
			//Gracz staje siê neutralny
		}
	}
	
	public int czyWykonacRuch() {
//		Zapytaj gracza czy chce wykonaæ ruch
		nastepnePole = 5;
		return nastepnePole;
	}
	
	public void wykonajRuch() {
		aktualnePole = nastepnePole;
	}
	
	public void ustawPozycjeGracza(EPozycjaGracza pozycjaGracza) {
		this.pozycjaGracza = pozycjaGracza;
	}
}
