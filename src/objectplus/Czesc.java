/**
 * Created on 2007-04-22
 * 
 */
package objectplus;

/**
 * @author MariuszAdmin
 *
 */
public class Czesc {
	public String nazwa;	// public - dla uproszczenia 
	private Calosc calosc;
	
	/**
	 * Prywatny konstruktor
	 * @param nazwa
	 */
	private Czesc(Calosc calosc, String nazwa) {
		this.nazwa = nazwa;
		this.calosc =calosc; 
	}
	
	/**
	 * Tworzy czesc oraz laczy ja z podana caloscia. 
	 * @param calosc
	 * @param nazwa
	 * @return
	 * @throws Exception gdy calosc nie istnieje (== null).
	 */
	public static Czesc utworzCzesc(Calosc calosc, String nazwa) throws Exception {
		if(calosc == null) {
			throw new Exception("Calosc nie istnieje!");
		}

		// Utwocz nowa czesc
		Czesc cz = new Czesc(calosc, nazwa);
		
		// Dodaj do calosci
		calosc.dodajCzesc(cz);
		
		return cz; 
	}
}
