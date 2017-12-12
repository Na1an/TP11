package TP11;

public class Platte {
	Vue vue;
	//Controleur controleur;
	//Modele modele; // 这个modele 完全没用
	
	public Platte() {
		this.vue = new Vue();
		this.vue.setTitle("TP11 Interface Graphiques");
		//this.modele = vue.modele; //这里也没用
		//this.controleur = new Controleur(vue);
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				Platte platte = new Platte();
			}
		});
	}
	

}
