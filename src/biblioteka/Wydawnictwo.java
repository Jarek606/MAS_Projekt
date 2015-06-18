package biblioteka;

import objectplus.ObjectPlusPlus;

public class Wydawnictwo extends Wydawca {
	private String nazwa;
	private String adres;
	
	public Wydawnictwo(String nazwa, String adres){
		this.nazwa = nazwa;
		this.adres = adres;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	
	public String toString(){
		return getNazwa();
	}
	
}
