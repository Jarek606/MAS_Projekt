import java.util.Date;


public class Rezerwacja {

	private Date dataRezerwacji;
	private statusRezerwacji status;
	private int okresRezerwacji = 3; //wyra¿ony w dniach
	
	public Date getDataRezerwacji() {
		return dataRezerwacji;
	}
	public void setDataRezerwacji(Date dataRezerwacji) {
		this.dataRezerwacji = dataRezerwacji;
	}
	public statusRezerwacji getStatus() {
		return status;
	}
	public void setStatus(statusRezerwacji status) {
		this.status = status;
	}
	public int getOkresRezerwacji() {
		return okresRezerwacji;
	}
	public void setOkresRezerwacji(int okresRezerwacji) {
		this.okresRezerwacji = okresRezerwacji;
	}
	
	
}
