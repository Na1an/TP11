package TP11;

import java.awt.event.ActionEvent;

public class ActionSetCouleurPref extends BoutonAction{

	public ActionSetCouleurPref(Vue vue) {
		super(vue);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.vue.appuieBoutonSetCouleurPref();
		this.vue.miseAJour();
		
	}

}
