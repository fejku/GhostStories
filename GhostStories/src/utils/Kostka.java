package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enums.EKlatwa;
import enums.EKolor;

public class Kostka {
	private static Random random;
	private List<EKolor> wyrzuconeKolory;
	private EKlatwa wyrzuconaKlatwa;
	private List<EKolor> koscKolorow;
	private List<EKlatwa> koscKlatw;
	
	public Kostka() {
		random = new Random();
		wyrzuconeKolory = new ArrayList<EKolor>(4);
		
		inicjujKoscKolorow();
		inicjujKoscKlatw();
	}
	
	private void inicjujKoscKolorow() {
		koscKolorow = new ArrayList<EKolor>(6);
		koscKolorow.add(EKolor.BIALY);
		koscKolorow.add(EKolor.CZARNY);
		koscKolorow.add(EKolor.CZERWONY);
		koscKolorow.add(EKolor.ZIELONY);
		koscKolorow.add(EKolor.NIEBIESKI);
		koscKolorow.add(EKolor.ZOLTY);
	}
	
	private void inicjujKoscKlatw() {
		koscKlatw = new ArrayList<EKlatwa>();
		koscKlatw.add(EKlatwa.PUSTA);
		koscKlatw.add(EKlatwa.PUSTA);
		koscKlatw.add(EKlatwa.NAWIEDZA_WIESNIAKA);
		koscKlatw.add(EKlatwa.NASTEPNY_DUCH);
		koscKlatw.add(EKlatwa.STRATA_TAO);
		koscKlatw.add(EKlatwa.STRATA_QI);
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
	
	public List<EKolor> wezWynikRzutuKolor() {
		return wyrzuconeKolory;
	}
	
	public EKlatwa wezWynikRzutuKlatwa() {
		return wyrzuconaKlatwa;
	}
	
	private int wylosujK6() {
		return random.nextInt(6);
	}
	
	public static Random zwrocRandom() {
		return random;
	}
}
