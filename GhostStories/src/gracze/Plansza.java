package gracze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import duchy.Duch;
import plansza.Wioska;
import utils.Stale;

//Plansza gracza na której znajduj¹ siê duchy
public class Plansza {
	private Duch[] pola;
	private PozycjaGracza pozycja;
	
	public Plansza() {
		pola = new Duch[Stale.LICZBA_POL];
		Arrays.fill(pola, null);
	}
	
	public void ustawPole(Duch duch, int nrPola) {
		pola[nrPola] = duch;
	}
	
	public Duch zwrocPole(int nrPola) {
		return pola[nrPola];	
	}
	
	private boolean czyPoleZajetePrzezDucha(int nrPola) {
		if(pola[nrPola] == null)
			return false;
		else
			return true;
	}
	
	public boolean czyDuchNawiedza(int nrPola) {
		if (czyPoleZajetePrzezDucha(nrPola))
			return pola[nrPola].czyNawiedza();
		else
			return false;
	}
	
	public void Nawiedzaj(Wioska wioska, PozycjaGracza pozycjaGracza, int nrPola) {
		pola[nrPola].Nawiedzaj(wioska, pozycjaGracza, nrPola);
	}
	
	public boolean czyDuchDreczy(int nrPola) {
		if (czyPoleZajetePrzezDucha(nrPola))
			return pola[nrPola].czyDreczy();
		else
			return false;
	}
	
	public void Drecz(int nrPola) {
		pola[nrPola].Drecz();
	}
}
