package TP11;

import java.awt.event.ActionEvent;

public class ActionComplementaire extends BoutonAction{

	public ActionComplementaire(Vue vue) {
		super(vue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.vue.appuieBoutonComplementaire();
		this.vue.miseAJour();
		
	}

}
