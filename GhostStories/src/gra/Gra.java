package gra;

import duchy.ListaKartDuchow;
import plansza.Wioska;
import gracze.Gracz;
import gracze.ListaGraczy;
import utils.Kostka;

public class Gra {
	Kostka kostka;
	ListaGraczy listaGraczy;
	ListaKartDuchow listaKartDuchow;
	Wioska wioska;
	
	public Gra() {
		kostka = new Kostka();
		listaGraczy = new ListaGraczy();
		listaKartDuchow = new ListaKartDuchow();
		wioska = new Wioska();
		
		//kostka.rzucKoscia(2);
		mainLoop();
	}
	
	public void mainLoop() {
		Gracz aktualnyGracz;
		do {
			aktualnyGracz = listaGraczy.zwrocAktualnegoGracza();
//		faza Jin
//++		1a Duchy ze zdolnoscia Nawiedzanie
			aktualnyGracz.Nawiedzaj(wioska);
//		1b Duchy ze zdolnoscia Dr�czenie
			aktualnyGracz.Drecz();
//++		2 Czy plansza aktualnego gracza zape�niona
			if (aktualnyGracz.czyPlanszaPelna())
//				Zapelniona tak strata punktu Qi
				aktualnyGracz.stracPunktQi();//				
			else
//				Nie zape�niona przybycie ducha - nie przeprowadzane na neutralnej planszy
				listaKartDuchow.wyciagnijKarte(listaGraczy.zwrocListeGraczy());
//		faza Jang 
//		1 Ruch (opcjonalny)
			aktualnyGracz.czyWykonacRuch(); 
			aktualnyGracz.wykonajRuch();
//		2a Poproszenie wie�niaka o pomoc
//		2b Pr�ba egzorcyzmu
//		3 Umieszczenie Buddy(opcjonalne), wzi�cie znacznik�w Mocy
			listaGraczy.nastepnyGracz();
		} while(listaGraczy != null);
	}
}
