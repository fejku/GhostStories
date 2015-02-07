package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kostka {
	private static Random random;
	private List<Kolor> wyrzuconeKolory;
	private Klatwa wyrzuconaKlatwa;
	private List<Kolor> koscKolorow;
	private List<Klatwa> koscKlatw;
	
	public Kostka() {
		random = new Random();
		wyrzuconeKolory = new ArrayList<Kolor>(4);
		
		inicjujKoscKolorow();
		inicjujKoscKlatw();
	}
	
	private void inicjujKoscKolorow() {
		koscKolorow = new ArrayList<Kolor>(6);
		koscKolorow.add(Kolor.BIALY);
		koscKolorow.add(Kolor.CZARNY);
		koscKolorow.add(Kolor.CZERWONY);
		koscKolorow.add(Kolor.ZIELONY);
		koscKolorow.add(Kolor.NIEBIESKI);
		koscKolorow.add(Kolor.ZOLTY);
	}
	
	private void inicjujKoscKlatw() {
		koscKlatw = new ArrayList<Klatwa>();
		koscKlatw.add(Klatwa.PUSTA);
		koscKlatw.add(Klatwa.PUSTA);
		koscKlatw.add(Klatwa.NAWIEDZA_WIESNIAKA);
		koscKlatw.add(Klatwa.NASTEPNY_DUCH);
		koscKlatw.add(Klatwa.STRATA_TAO);
		koscKlatw.add(Klatwa.STRATA_QI);
	}
	
	public void rzucKoscmiKolorow(int iloscKosci) {
		wyrzuconeKolory.clear();
		//TODO Sytuacje gdy 4 kosci lub zabrana kosc/kosci
		//TODO Sytuacja gdy gracz zachowuje kosci
		for (int i = 0; i < iloscKosci; i++) {
			//wyrzuconeKolory.add(Kolor.values()[random.nextInt(Kolor.values().length)]);
			wyrzuconeKolory.add(koscKolorow.get(wylosujK6()));
		}
	}
	
	public void rzucKosciaKlatwy() {
		wyrzuconaKlatwa = koscKlatw.get(wylosujK6());
	}
	
	public List<Kolor> wezWynikRzutuKolor() {
		return wyrzuconeKolory;
	}
	
	public Klatwa wezWynikRzutuKlatwa() {
		return wyrzuconaKlatwa;
	}
	
	private int wylosujK6() {
		return random.nextInt(6);
	}
	
	public static Random zwrocRandom() {
		return random;
	}
}
