package serijalizacijaDeserijalizacija;

import java.io.Serializable;

/*Serijalizacija objekta - smestanje objekata u fajl, cuvanje informacija o tipu objekta, tipu podataka koje sadrzi, nakon prestanka rada programa  
* Deserijalizacija - ponovno instanciranje objekta iz fajla 
* Klase koje omogucuju ovaj mehanizam su ObjectOutputStream i ObjectInputStream sa pripadajucim metodama metodama writeObject() i readObject()  
 */
// Neophodno implementirati interfejs Serializable u klasi cija instanca ce se serijalizovati i deserijalizovati


public class Knjiga implements Serializable{
	
	private String naslov;
	private String autor;
	private String ISBN;
	
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		if(naslov == null)
			throw new RuntimeException("Naslov ne sme biti null!");
		this.naslov = naslov;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		if(autor == null)
			throw new RuntimeException("Autor ne sme biti null!");
		this.autor = autor;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String isbn) {
		if(isbn == null)
			throw new RuntimeException("ISBN ne sme biti null!");
		ISBN = isbn;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Knjiga))
			throw new RuntimeException("Morate proslediti objekat klase Knjiga!");

		Knjiga knjiga = (Knjiga) (o);
		if (ISBN.equals(knjiga.getISBN()))
			return true;
		else
			return false;
	}
	
	public String toString() {
		return "Naslov: " + naslov + " Autor: " + autor + " ISBN: " + ISBN;
	}
	

}
