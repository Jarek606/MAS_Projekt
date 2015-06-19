package biblioteka;

import enums.statusEgzemplarza;
import objectplus.ObjectPlusPlus;

public class Egzemplarz extends ObjectPlusPlus{
	
	private int nrEgzemplarza;
	private statusEgzemplarza status;
	private static int nr = 1;
	
	public Egzemplarz(){
		this.nrEgzemplarza = nr++;
		this.status = statusEgzemplarza.dostepny; 
	}
	
	public int getNrEgzemplarza() {
		return nrEgzemplarza;
	}
	public statusEgzemplarza getStatus() {
		return status;
	}
	public void setStatus(statusEgzemplarza status) {
		this.status = status;
	}
	
	public String toString(){
		return "egz: " + getNrEgzemplarza();
	}
		
}
