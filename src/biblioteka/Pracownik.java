package biblioteka;

import objectplus.ObjectPlusPlus;

public class Pracownik extends ObjectPlusPlus{
	private String adresZamieszkania;
	private int nrTel;
	private double pensja;
	
	
	public String getAdresZamieszkania() {
		return adresZamieszkania;
	}
	public void setAdresZamieszkania(String adresZamieszkania) {
		this.adresZamieszkania = adresZamieszkania;
	}
	public int getNrTel() {
		return nrTel;
	}
	public void setNrTel(int nrTel) {
		this.nrTel = nrTel;
	}
	public double getPensja() {
		return pensja;
	}
	public void setPensja(float pensja) {
		this.pensja = pensja;
	}
	

}
