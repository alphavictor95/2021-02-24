package it.polito.tdp.PremierLeague.model;

public class Arco {
	int pID1;
	int pID2;
	Double eff1;
	Double eff2;
	Double peso;
	
	public Arco(int pID1, int pID2, Double eff1, Double eff2) {
		super();
		this.pID1 = pID1;
		this.pID2 = pID2;
		this.eff1 = eff1;
		this.eff2 = eff2;
		peso = Math.abs(eff1-eff2);
	}

	public int getpID1() {
		return pID1;
	}

	public void setpID1(int pID1) {
		this.pID1 = pID1;
	}

	public int getpID2() {
		return pID2;
	}

	public void setpID2(int pID2) {
		this.pID2 = pID2;
	}

	public Double getEff1() {
		return eff1;
	}

	public void setEff1(Double eff1) {
		this.eff1 = eff1;
	}

	public Double getEff2() {
		return eff2;
	}

	public void setEff2(Double eff2) {
		this.eff2 = eff2;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
	

}
