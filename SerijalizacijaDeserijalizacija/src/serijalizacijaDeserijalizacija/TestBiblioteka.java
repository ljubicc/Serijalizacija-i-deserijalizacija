package serijalizacijaDeserijalizacija;

public class TestBiblioteka {

	public static void main(String[] args) {
		
		Biblioteka b = new Biblioteka();
		b.ucitajKnjiguSaTastature();
		b.ucitajKnjiguSaTastature();
		b.ucitajKnjiguSaTastature();
		System.out.println();
		b.upisiUFajl();
		b.ispisi();
		System.out.println();
		b.ucitajIzFajla();
		b.ispisi();
		
		

	}

}
