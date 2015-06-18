package biblioteka;

import objectplus.ObjectPlusPlus;

public class Osoba extends ObjectPlusPlus{
	
	private String imie;
	private String nazwisko;
	private int pesel;
	private Klient klient = null;
	private Pracownik pracownik = null;
	
	public Osoba(String imie, String nazwisko, int pesel){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
	}
	
	public Osoba(String imie, String nazwisko, int pesel, int nrKlienta){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		Klient k = new Klient(nrKlienta);
		this.klient = k;
	}
	
	public Osoba(String imie, String nazwisko, int pesel, Pracownik pracownik){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.pracownik = pracownik;
	}
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getPesel() {
		return pesel;
	}
	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public Pracownik getPracownik() {
		return pracownik;
	}

	public void setPracownik(Pracownik pracownik) {
		this.pracownik = pracownik;
	}
	
	public String toString(){
		return this.imie + " " + this.nazwisko;
	}
	
}
