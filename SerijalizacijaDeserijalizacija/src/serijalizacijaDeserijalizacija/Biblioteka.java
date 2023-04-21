package serijalizacijaDeserijalizacija;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class Biblioteka {
	
	private List<Knjiga> knjige = new LinkedList<Knjiga>();
	
	public void ucitajKnjiguSaTastature() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			Knjiga k = new Knjiga();
			
			System.out.println("Unesite naslov knjige:");
			k.setNaslov(br.readLine());
			
			System.out.println("Unesite autora knjige:");
			k.setAutor(br.readLine());
			
			System.out.println("Unesite ISBN knjige:");
			k.setISBN(br.readLine());
			
			if(knjige.contains(k))
				throw new RuntimeException("Ta knjiga vec postoji u biblioteci!");
			
			knjige.add(k);
			
		}catch(Exception e) {
			System.out.println("Greska: " + e.getMessage());
		}
	}
	
	// upis u fajl serijalizacijom
	public void upisiUFajl() {
		
		try(FileOutputStream fos = new FileOutputStream("biblioteka.out");
			BufferedOutputStream br = new BufferedOutputStream(fos);
			ObjectOutputStream outs = new ObjectOutputStream(br)){
			
			for (int i = 0; i < knjige.size() ; i++) {
				outs.writeObject(knjige.get(i));
			}
			
		}catch(Exception e) {
			System.out.println("Desila se greska: " + e.getMessage());
		}
	}
	
	
	// citanje iz fajla deserijalizacijom
	public void ucitajIzFajla() {
		try(FileInputStream fis = new FileInputStream("biblioteka.out");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream oin = new ObjectInputStream(bis)){
				
			knjige.clear();
			System.out.println("Citanje iz fajla:");
			try {
				while(true) {
					Knjiga k = (Knjiga)oin.readObject();
					knjige.add(k);
				}
				
			}catch(EOFException e) {
				System.out.println("Kraj ucitavanja knjiga iz fajla.");
			}
				
			}catch(Exception e) {
				System.out.println("Desila se greska: " + e.getMessage());
			}
	}
	
	public void ispisi() {
		if(knjige.size() == 0) {
			System.out.println("Biblioteka nema knjiga.");
		}
		else {
			for (int i = 0; i < knjige.size(); i++) {
				System.out.println(knjige.get(i));
			}
		}
	}
	
}

	

