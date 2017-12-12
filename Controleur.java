package TP11;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public abstract class Controleur implements ChangeListener{
	protected Vue vue;

	public Controleur(Vue vue) {
		this.vue = vue;
	}
	
	public abstract void stateChanged(ChangeEvent e);//这里我们把这个Controleur 发展成了继承类，这样我们可以分别监听三个滑块，达到分别记录讯息（滑块位置）而互不干扰的目的
	                                                 //之前一个很干扰我们的问题就是 每当我们滑动一个滑块，所有的滑块的位置讯息同时刷新，这样就影响Complementaire 的功能
	
	/*
	public void stateChanged(ChangeEvent e) {  //这里事件监听很有意思，相当于这里的输入量是一个事件
		vue.miseAJour();                       //比如这里就是状态的改变，我动了滑块，
	}     
	*/                                     //这个动作会被包装成一个变量，输入到这个方法里，从而开始起作用

}
