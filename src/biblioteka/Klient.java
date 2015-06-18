package biblioteka;

import objectplus.ObjectPlusPlus;

public class Klient extends ObjectPlusPlus{
	private int nrKlienta;
	
	public Klient (int nrKlienta){
		this.nrKlienta = nrKlienta;
	}
	
	public int getNrKlienta() {
		return nrKlienta;
	}

	public void setNrKlienta(int nrKlienta) {
		this.nrKlienta = nrKlienta;
	} 
	
	
}
