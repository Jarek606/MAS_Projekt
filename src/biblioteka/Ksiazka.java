package biblioteka;

import objectplus.ObjectPlusPlus;

public class Ksiazka extends ObjectPlusPlus {
	
	private String tytul;
	private String autor;
	private int ISBN;
	private static double oplataZaPrzetrzymanie = 0.5;
	
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public static double getOplataZaPrzetrzymanie() {
		return oplataZaPrzetrzymanie;
	}
	public static void setOplataZaPrzetrzymanie(double oplataZaPrzetrzymanie) {
		Ksiazka.oplataZaPrzetrzymanie = oplataZaPrzetrzymanie;
	}
	
	
}
