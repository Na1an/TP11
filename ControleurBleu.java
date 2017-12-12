package TP11;

import javax.swing.event.ChangeEvent;

public class ControleurBleu extends Controleur{

	public ControleurBleu(Vue vue) {
		super(vue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		vue.modele.setPctBleu(vue.tabJSLider[2].getValue());
		vue.miseAJour();
	}

}
