package TP11;

import java.awt.event.ActionEvent;

public class ActionGetCouleurPref extends BoutonAction{

	public ActionGetCouleurPref(Vue vue) {
		super(vue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.vue.appuieBoutonGetCouleurPref();
		this.vue.miseAJour();
	}

}
