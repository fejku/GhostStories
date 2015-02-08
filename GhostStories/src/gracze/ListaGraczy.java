package gracze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.EPozycjaGracza;
import utils.Kostka;

public class ListaGraczy {
	private int aktualnyGracz;
	private List<Gracz> listaGraczy;
	
	public ListaGraczy() {
		aktualnyGracz = 0;
		listaGraczy = new ArrayList<Gracz>(4);
		listaGraczy.add(new GraczCzerwony());
		listaGraczy.add(new GraczZielony());
		listaGraczy.add(new GraczNiebieski());
		listaGraczy.add(new GraczZolty());
		
		Collections.shuffle(listaGraczy, Kostka.zwrocRandom());
		
		ustawPozycjeGraczy();
	}
	
	private void ustawPozycjeGraczy() {
		listaGraczy.get(0).ustawPozycjeGracza(EPozycjaGracza.GORA);
		listaGraczy.get(1).ustawPozycjeGracza(EPozycjaGracza.PRAWA);
		listaGraczy.get(2).ustawPozycjeGracza(EPozycjaGracza.DOL);
		listaGraczy.get(3).ustawPozycjeGracza(EPozycjaGracza.LEWA);
	}
	
	public Gracz zwrocAktualnegoGracza() {
		return listaGraczy.get(aktualnyGracz);
	}
	
	public int zwrocNrAktualnegoGracza() {
		return aktualnyGracz;
	}
	
	public void nastepnyGracz() {
		aktualnyGracz++;
		if (aktualnyGracz == listaGraczy.size())
			aktualnyGracz = 0;
	}
	
	public List<Gracz> zwrocListeGraczy() {
		return listaGraczy;
	}
}
