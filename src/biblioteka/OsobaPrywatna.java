package biblioteka;

public class OsobaPrywatna extends Wydawca {
	
	private String imie;
	private String nazwisko;
	
	public OsobaPrywatna(String imie, String nazwisko){
		this.imie = imie;
		this.nazwisko = nazwisko;
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
	
	public String toString(){
		return "Osoba prywatna: " + getNazwisko() + " " + getImie();
	}

}
