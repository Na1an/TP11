package TP11;

import javax.swing.event.ChangeEvent;

public class ControleurRouge extends Controleur{

	public ControleurRouge(Vue vue) {
		super(vue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		vue.modele.setPctRouge(vue.tabJSLider[0].getValue());
		vue.miseAJour();
	
	}

}
