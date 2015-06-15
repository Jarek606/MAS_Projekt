package biblioteka;
import java.util.Date;


public class Wypozyczenie {
	
	private Date dataWypozyczenia;
	private Date planowanaDataZwrotu;
	private Date rzeczywistaDataZwrotu;
	private double oplataZaPrzetrzymanie;
	
	public Date getDataWypozyczenia() {
		return dataWypozyczenia;
	}
	public void setDataWypozyczenia(Date dataWypozyczenia) {
		this.dataWypozyczenia = dataWypozyczenia;
	}
	public Date getPlanowanaDataZwrotu() {
		return planowanaDataZwrotu;
	}
	public void setPlanowanaDataZwrotu(Date planowanaDataZwrotu) {
		this.planowanaDataZwrotu = planowanaDataZwrotu;
	}
	public Date getRzeczywistaDataZwrotu() {
		return rzeczywistaDataZwrotu;
	}
	public void setRzeczywistaDataZwrotu(Date rzeczywistaDataZwrotu) {
		this.rzeczywistaDataZwrotu = rzeczywistaDataZwrotu;
	}
	public double getOplataZaPrzetrzymanie() {
		return oplataZaPrzetrzymanie;
	}
	public void setOplataZaPrzetrzymanie(float oplataZaPrzetrzymanie) {
		this.oplataZaPrzetrzymanie = oplataZaPrzetrzymanie;
	}
	

}
