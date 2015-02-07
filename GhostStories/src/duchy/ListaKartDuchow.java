package duchy;

import gracze.Gracz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Kolor;

public class ListaKartDuchow {
	private List<Duch> listaKartDuchow;
	
	public ListaKartDuchow()
	{
		listaKartDuchow = new ArrayList<Duch>();
		listaKartDuchow.add(new Duch("Ghoul", Kolor.ZOLTY, 1, null, Arrays.asList(EfektCoTure.NAWIEDZANIE)));
		listaKartDuchow.add(new Duch("Walking Corpse", Kolor.ZOLTY, 1, null, Arrays.asList(EfektCoTure.KOSCI_TAO_NIE_MAJA_EFEKTU)));
		listaKartDuchow.add(new Duch("Coffin Breakers", Kolor.ZOLTY, 1, Arrays.asList(EfektNatychmiastowy.NOWY_DUCH, EfektNatychmiastowy.ZABLOKUJ_MOC_GRACZA), null));
	}
	
	public void wyciagnijKarte(List<Gracz> listaGraczy) {
		listaKartDuchow.get(0).wykonajEfektyNatychmiastowe();
		dodajKarteDoPlanszy();
		listaKartDuchow.remove(0);
	}
}
