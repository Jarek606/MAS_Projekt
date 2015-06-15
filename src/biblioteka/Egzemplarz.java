package biblioteka;

import enums.statusEgzemplarza;
import objectplus.ObjectPlusPlus;

public class Egzemplarz extends ObjectPlusPlus{
	
	private int nrEgzemplarza;
	private statusEgzemplarza status;
	
	
	public int getNrEgzemplarza() {
		return nrEgzemplarza;
	}
	public void setNrEgzemplarza(int nrEgzemplarza) {
		this.nrEgzemplarza = nrEgzemplarza;
	}
	public statusEgzemplarza getStatus() {
		return status;
	}
	public void setStatus(statusEgzemplarza status) {
		this.status = status;
	}
		
}
