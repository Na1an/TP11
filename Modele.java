package TP11;

public class Modele {
	private int pctRouge;
	private int pctVert;
	private int pctBleu;
	
	public Modele(int r,int v,int b){
		this.pctRouge = r;
		this.pctVert = v;
		this.pctBleu = b;
	}
	
	
	public int getPctRouge() {
		return pctRouge;
	}
	public void setPctRouge(int pctRouge) {
		this.pctRouge = pctRouge;
	}
	public int getPctVert() {
		return pctVert;
	}
	public void setPctVert(int pctVert) {
		this.pctVert = pctVert;
	}
	public int getPctBleu() {
		return pctBleu;
	}
	public void setPctBleu(int pctBleu) {
		this.pctBleu = pctBleu;
	}
	
	

}
