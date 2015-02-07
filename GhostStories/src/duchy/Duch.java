package duchy;

import java.util.List;

import gracze.PozycjaGracza;
import plansza.Wioska;
import utils.Kolor;
import utils.Stale;
//55 duchow
//10 inkarnacji Wu-Fenga
public class Duch {
	String nazwa;
	Kolor kolorDucha;
	int odpornosc;
	List<EfektNatychmiastowy> efektyNatychmiastowe;
	List<EfektCoTure> efektyCoTure;
	//Zdolnosc po przybyciu
	//Zdolnosc w ka¿dej turze
	//Nagroda
	//Obrazek
	private boolean czyNawiedza;
	private int stopienNawiedzenia; //0, 1, 2
	private boolean czyDreczy;
	
	public Duch(String nazwa, Kolor kolorDucha, int odpornosc, List<EfektNatychmiastowy> efektyNatychmiastowe, List<EfektCoTure> efektyCoTure) {
		this.nazwa = nazwa;
		this.kolorDucha = kolorDucha;
		this.odpornosc = odpornosc;
		this.efektyNatychmiastowe = efektyNatychmiastowe;
		this.efektyCoTure = efektyCoTure;
	}
	
	public boolean czyNawiedza() {
		return czyNawiedza;
	}
	
	public void Nawiedzaj(Wioska wioska, PozycjaGracza pozycjaGracza, int nrPola) {
		stopienNawiedzenia++;
		if (stopienNawiedzenia == 3) {
			stopienNawiedzenia = 0;
		}
		if (stopienNawiedzenia == 2) {
			//Odwróc Wieœniaka przed duchem
			int nrWiesniakaPrzedPolem = zwrocNrWiesniakaPrzedPolem(wioska, pozycjaGracza, nrPola);
			//Je¿eli jest nieodwrócony wieœniak przed polem
			if (nrWiesniakaPrzedPolem != -1)
				wioska.zwrocWiesniaka(nrWiesniakaPrzedPolem).odwrocWiesniaka();
		}
	}
	
	public int zwrocNrWiesniakaPrzedPolem(Wioska wioska, PozycjaGracza pozycjaGracza, int nrPola) {
		int nrWiesniakaPrzedPolem;
		if (pozycjaGracza == PozycjaGracza.GORA) {
			for (int i = 0; i < Stale.LICZBA_POL; i++) {
				nrWiesniakaPrzedPolem = nrPola + (i * 3);
				if(!wioska.zwrocListeWiesniakow().get(nrWiesniakaPrzedPolem).czyAktywny())
					return nrWiesniakaPrzedPolem;
			}
//			nrPola == 0 -> 0,3,6
//			nrPola == 1 -> 1,4,7
//			nrPola == 2 -> 2,5,8
		} else if (pozycjaGracza == PozycjaGracza.DOL) {
			for (int i = Stale.LICZBA_POL; i > 0; i--) {
				nrWiesniakaPrzedPolem = nrPola + (i * 3);
				if(!wioska.zwrocListeWiesniakow().get(nrWiesniakaPrzedPolem).czyAktywny())
					return nrWiesniakaPrzedPolem;
			}
//			nrPola == 0 -> 6,3,0
//			nrPola == 1 -> 7,4,1
//			nrPola == 2 -> 8,5,2
		} else if (pozycjaGracza == PozycjaGracza.LEWA) {
			for (int i = 0; i < Stale.LICZBA_POL; i++) {
				nrWiesniakaPrzedPolem = i + (nrPola * 3);
				if(!wioska.zwrocListeWiesniakow().get(nrWiesniakaPrzedPolem).czyAktywny())
					return nrWiesniakaPrzedPolem;
			}
//			nrPola == 0 -> 0,1,2
//			nrPola == 1 -> 3,4,5
//			nrPola == 2 -> 6,7,8
		} else if (pozycjaGracza == PozycjaGracza.PRAWA) {
			for (int i = Stale.LICZBA_POL; i > 0; i--) {
				nrWiesniakaPrzedPolem = i + (nrPola * 3);
				if(!wioska.zwrocListeWiesniakow().get(nrWiesniakaPrzedPolem).czyAktywny())
					return nrWiesniakaPrzedPolem;
			}
//			nrPola == 0 -> 2,1,0
//			nrPola == 1 -> 5,4,3
//			nrPola == 2 -> 8,7,6
		}
		//Wszystkie 3 pola odwrócone 
		return -1;
	}
	
	public boolean czyDreczy() {
		return czyDreczy;
	}
	
	public void Drecz() {
		
	}
	
	public void wykonajEfektyNatychmiastowe() {
		
	}
}
