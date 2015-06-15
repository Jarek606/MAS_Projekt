/**
 * Created on 2007-04-22
 * 
 */
package objectplus;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Vector;

/**
 * @author Mariusz
 *
 */
public class Calosc {
	private Vector<Czesc> czesci = new Vector<Czesc>();
	
	private static HashSet<Czesc> wszystkieCzesci = new HashSet<Czesc>(); 
	
	private String nazwa;
	
	public Calosc(String nazwa) {
		this.nazwa = nazwa;
	}
	
	/**
	 * Dodaje podana czesc do calosci.
	 * @param czesc
	 * @throws Exception 
	 */
	public void dodajCzesc(Czesc czesc) throws Exception {
		if(!czesci.contains(czesc)) {
			// Sprawdz czy ta czesc nie zostala dodana do jakiejs calosci
			if(wszystkieCzesci.contains(czesc)) {
				throw new Exception("Ta czesc jest juz powiazana z caloscia!");
			}
			
			czesci.add(czesc);
			
			// Zapamietaj na liscie wszystkich czesci (przeciwdziala wspoldzielniu czesci)
			wszystkieCzesci.add(czesc);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String info = "Calosc: " + nazwa + "\n";
		for(Czesc cz : czesci) {
			info += "   " + cz.nazwa + "\n";
		}
		
		return info;
	}
}
