package duchy;

import enums.EEfektCoTure;
import enums.EEfektNatychmiastowy;
import enums.EKolor;
import gracze.Gracz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaKartDuchow {
	private List<Duch> listaKartDuchow;
	
	public ListaKartDuchow()
	{
		listaKartDuchow = new ArrayList<Duch>();
		listaKartDuchow.add(new Duch("Ghoul", EKolor.ZOLTY, 1, null, Arrays.asList(EEfektCoTure.NAWIEDZANIE)));
		listaKartDuchow.add(new Duch("Walking Corpse", EKolor.ZOLTY, 1, null, Arrays.asList(EEfektCoTure.KOSCI_TAO_NIE_MAJA_EFEKTU)));
		listaKartDuchow.add(new Duch("Coffin Breakers", EKolor.ZOLTY, 1, Arrays.asList(EEfektNatychmiastowy.NOWY_DUCH, EEfektNatychmiastowy.ZABLOKUJ_MOC_GRACZA), null));
	}
	
	public void wyciagnijKarte(List<Gracz> listaGraczy) {
		listaKartDuchow.get(0).wykonajEfektyNatychmiastowe();
		dodajKarteDoPlanszy();
		listaKartDuchow.remove(0);
	}
}
