package biblioteka;

import java.util.Collection;
import java.util.HashMap;

import enums.statusEgzemplarza;
import objectplus.ObjectPlus;
import objectplus.ObjectPlusPlus;

public class Ksiazka extends ObjectPlusPlus {
	
	private String tytul;
	private String autor;
	private int ISBN;
	private static double oplataZaPrzetrzymanie = 0.5;
	
	public Ksiazka(String tytul, String autor, int ISBN){
		this.tytul = tytul;
		this.autor = autor;
		this.ISBN = ISBN;
	}
	
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
	
	public Egzemplarz dajDostepnyEgzemplarz(){
		ObjectPlusPlus[] powiazaniaObiektu = null;
		try {
			powiazaniaObiektu = this.dajPowiazania("egzemplarz");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Object o: powiazaniaObiektu){
			if (((biblioteka.Egzemplarz) o).getStatus() == statusEgzemplarza.dostepny){
				return ((biblioteka.Egzemplarz) o);
			}
		}
		try {
			throw new Exception("Brak egzemplarza: " + this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String toString() {
		return getTytul();
	}
	
}
