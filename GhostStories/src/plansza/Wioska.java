package plansza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Kostka;

public class Wioska {
	private List<Wiesniak> listaWiesniakow;
	
	public Wioska() {
		 listaWiesniakow = new ArrayList<Wiesniak>(9);
		 listaWiesniakow.add(new ChataCzarownika());
		 listaWiesniakow.add(new Cmentarz());
		 listaWiesniakow.add(new Herbaciarnia());
		 listaWiesniakow.add(new KragModlitewny());
		 listaWiesniakow.add(new NocnyStraznik());
		 listaWiesniakow.add(new OltarzTaoistyczny());
		 listaWiesniakow.add(new PawilonNiebianskiegoWiatru());
		 listaWiesniakow.add(new SklepikZielarza());
		 listaWiesniakow.add(new SwiatyniaBuddyjska());
		 
		 Collections.shuffle(listaWiesniakow, Kostka.zwrocRandom());		 
	}
	
	public List<Wiesniak> zwrocListeWiesniakow() {
		return listaWiesniakow;
	}
	
	public Wiesniak zwrocWiesniaka(int nrWiesniaka) {
		return listaWiesniakow.get(nrWiesniaka);
	}
}
