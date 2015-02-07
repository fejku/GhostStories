package plansza;

public abstract class Wiesniak {
	private boolean aktywny;
	
	public Wiesniak() {
		aktywny = true;
	}
	
	public boolean czyAktywny() {
		return aktywny;
	}
	
	public void odwrocWiesniaka() {
		aktywny = !aktywny;
	}
}
