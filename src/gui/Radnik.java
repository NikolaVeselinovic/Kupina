package gui;

import java.io.Serializable;
import java.util.LinkedList;

public class Radnik implements Serializable{
	private String ime;
	LinkedList<Merenje> listaMerenja = new LinkedList<>();
	private double neto;
	private int ukupnoG;
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public double getNeto() {
		double brojG=0;
		double ukupno=0;
		for(int i=0;i<listaMerenja.size();i++){
			brojG+=listaMerenja.get(i).getBrojGajbi();
			ukupno+=listaMerenja.get(i).getBruto();
		}

		return ukupno-(brojG*0.5);
	}
	public int getUkupnoG() {
		int brojG=0;

		for(int i=0;i<listaMerenja.size();i++){
			brojG+=listaMerenja.get(i).getBrojGajbi();

		}

		return brojG;
	}

}
