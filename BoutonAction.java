package TP11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BoutonAction implements ActionListener{
	protected Vue vue;
	
	public BoutonAction(Vue vue) {
		this.vue = vue;
	}

	@Override
	public abstract void actionPerformed(ActionEvent e);

}
