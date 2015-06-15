/**
 * Created on 2007-04-11
 * 
 */
package objectplus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

/**
 * @author MariuszAdmin
 *
 */
public class ObjectPlus implements Serializable {
	private static Hashtable ekstensje = new Hashtable();

	/**
	 * Konstruktor.
	 */
	public ObjectPlus() {
		Vector ekstensja = null;
		Class klasa = this.getClass();
		
		if(ekstensje.containsKey(klasa)) {
			// Ekstensja tej klasy istnieje w kolekcji ekstensji
			ekstensja = (Vector) ekstensje.get(klasa);
		}
		else {
			// Ekstensji tej klasy jeszcze nie ma -> dodaj j¹
			ekstensja = new Vector();
			ekstensje.put(klasa, ekstensja);
		}
		
		ekstensja.add(this);
	}
	
	/**
	 * Zapisuje wszystkie ekstensje do podanego strumienia (wersja z serializacja).
	 * Metoda klasowa.
	 * @throws IOException 
	 */
	public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
		stream.writeObject(ekstensje);
	}

	/**
	 * Odczytuje wszystkie ekstensje z podanego strumienia (wersja z serializacja).
	 * Metoda klasowa.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void odczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		ekstensje = (Hashtable) stream.readObject();
	}	
	
	/**
	 * Wyswietla ekstensje.
	 * Metoda klasowa.
	 * @throws Exception 
	 */
	public static void pokazEkstensje(Class klasa) throws Exception {
		Vector ekstensja = null;
		
		if(ekstensje.containsKey(klasa)) {
			// Ekstensja tej klasy istnieje w kolekcji ekstensji
			ekstensja = (Vector) ekstensje.get(klasa);
		}
		else {
			throw new Exception("Unknown class " + klasa);
		}
		
		System.out.println("Ekstensja klasy: " + klasa.getSimpleName());

		for(Object obiekt : ekstensja) {
			System.out.println(obiekt);
		}
	}
	
}
