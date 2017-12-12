package TP11;

import javax.swing.event.ChangeEvent;

public class ControleurVert extends Controleur{

	public ControleurVert(Vue vue) {
		super(vue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		vue.modele.setPctVert(vue.tabJSLider[1].getValue());
		vue.miseAJour();
	}

}
