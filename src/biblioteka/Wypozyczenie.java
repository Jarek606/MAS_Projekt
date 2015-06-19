package biblioteka;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import objectplus.ObjectPlusPlus;


public class Wypozyczenie extends ObjectPlusPlus{
	
	private Date dataWypozyczenia = new Date();
	private Date planowanaDataZwrotu;
	private Date rzeczywistaDataZwrotu = null;
	private double oplataZaPrzetrzymanie = 0.0;
	
	public Wypozyczenie(){
		Calendar c = Calendar.getInstance(); 
		c.setTime(dataWypozyczenia); 
		c.add(Calendar.DATE, 14);
		planowanaDataZwrotu = c.getTime();
	}
	
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
