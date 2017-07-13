package gui;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Merenje implements Serializable {
	private GregorianCalendar vreme;
	private int brojGajbi;
	private double bruto;
	public GregorianCalendar getVreme() {
		return vreme;
	}
	public void setVreme(GregorianCalendar vreme) {
		this.vreme = vreme;
	}
	public int getBrojGajbi() {
		return brojGajbi;
	}
	public void setBrojGajbi(int brojGajbi) {
		this.brojGajbi = brojGajbi;
	}
	public double getBruto() {
		return bruto;
	}
	public void setBruto(double bruto) {
		this.bruto = bruto;
	}
	
	public String toString() {
		int dan=vreme.get(GregorianCalendar.DAY_OF_MONTH);
		int mesec=vreme.get(GregorianCalendar.MONTH)+1;
		int godina=vreme.get(GregorianCalendar.YEAR);
		int sat=vreme.get(GregorianCalendar.HOUR_OF_DAY);
		int minut= vreme.get(GregorianCalendar.MINUTE);
		if(minut<10){return "---"+dan+"/"+mesec+"/"+godina+"  "+sat+":0"+minut+" ---    "+brojGajbi+"       |  "+bruto+" kg ---";}
		if(sat<10){return "---"+dan+"/"+mesec+"/"+godina+"  0"+sat+":"+minut+" ---    "+brojGajbi+"       |  "+bruto+" kg ---";}
		if(minut<10 && sat<10){return "---"+dan+"/"+mesec+"/"+godina+"  0"+sat+":0"+minut+" ---    "+brojGajbi+"       |  "+bruto+" kg ---";}
		return "---"+dan+"/"+mesec+"/"+godina+"  "+sat+":"+minut+" ---    "+brojGajbi+"       |  "+bruto+" kg ---";
	}
	
}
