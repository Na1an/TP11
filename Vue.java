package TP11;

import java.awt.*;

import javax.jws.WebParam.Mode;
import javax.swing.*;


public class Vue extends JFrame{
	
	JLabel textJLabel;
	Container contentPane;
	JPanel panneauChoix;
	JPanel panneauColor;
	JSlider[] tabJSLider;
	String[] Coleur = {"rouge","Vert","Bleu"};
	Modele modele;
	Modele modelePre;
	
	ControleurRouge controleurRouge;
	ControleurVert controleurVert;
	ControleurBleu controleurBleu;
	Controleur controleur[] = new Controleur[3];
	
	JPanel panneauBoutons;
	JButton SetCouleurPref;
	JButton GetCouleurPref;
	JButton Complementaire;
	
	
	public Vue(){
		contentPane = getContentPane();                //大容器，放各类小组件的
		contentPane.setLayout(new GridLayout(1,2));    //把大容器划分区域，这里就是一行两列
		
		panneauChoix = new JPanel();                   //左侧画板，调整红绿蓝三色比例
		panneauColor = new JPanel();                   //右侧画板，显示调色结果
		panneauChoix.setBackground(new Color(0,0,1f)); //设定背景颜色 三个取值范围都是0~~1 十六进制
		panneauColor.setBackground(new Color(0,1f,0)); 
		
		contentPane.add(panneauChoix);                 //这里把两个画板添加到大容器里，最精彩的是--
		contentPane.add(panneauColor);                 //它会按照默认顺序由左向右添加 也就是先添加panneauChoix
		                                               //再添加panneauColor
		panneauChoix.setLayout(new GridLayout(4,1));   //三行一列，设置三个布局组件，也就是左边三个滑条
		tabJSLider = new JSlider[3];                   //滑动条数组，里面仨，也是按顺序放置
		modele = new Modele(50, 50, 50);                //独立类，放置三色数据
		modelePre = null;
		
		controleurRouge = new ControleurRouge(this);
		controleurVert = new ControleurVert(this);
		controleurBleu = new ControleurBleu(this);
		
		controleur[0] = controleurRouge;             //独立类，主要是接入接口监听动态，然后更新数据，使左右两个画板同步
		controleur[1] = controleurVert;
		controleur[2] = controleurBleu;
		
		for(int i=0;i<3;i++){
			tabJSLider[i] = new JSlider(0,100);        //设置滑条的长度，这里0到100
			//还可以 JSlider slider = new JSlider(JSlider.HORIZONTAL,0,50,20); 0，50 指的是滑条长度，平行时平行放置，而20是初始位置
			tabJSLider[i].setPaintTicks(true);         //此方法问你是否在滑条上加入刻度？  这里选是，只有选true下边两个大小刻度才有用
			tabJSLider[i].setMajorTickSpacing(25);     //大刻度25
			tabJSLider[i].setMinorTickSpacing(5);      //小刻度5
			//tabJSLider[i].setLabelTable(tabJSLider[i].createStandardLabels(20));
			tabJSLider[i].setPaintLabels(true);        //设置是否数字标记，若设为true，则JSlider刻度上就会有数值出现。
			tabJSLider[i].setPaintTrack(true);         //方法表示是否出现滑动杆的横杆。默认值为true,像进度条那个东西，你要不要，默认为true
			tabJSLider[i].setBorder(BorderFactory.createTitledBorder(Coleur[i]));
			                                           //这里是设置标题边框，Coleur[i]是标题内容
			//tabJSLider[i].setVisible(true);            //可见，这里的可见是滑条可见
			tabJSLider[i].addChangeListener(controleur[i]); //添加了时间监听器，这里controleur类接入了ChangListener接口，所以才能做变量
			panneauChoix.add(tabJSLider[i]);           //最后，不能忘了把滑条添加到画板panneauChoix里，这也是按顺序放的
		}
		
		
		panneauBoutons = new JPanel();
		panneauBoutons.setLayout(new GridLayout(1, 3));
		
		SetCouleurPref = new JButton("SetCouleurPref");
		GetCouleurPref = new JButton("GetCouleurPref");
		Complementaire = new JButton("Complementaire");
		
		SetCouleurPref.addActionListener(new ActionSetCouleurPref(this));
		GetCouleurPref.addActionListener(new ActionGetCouleurPref(this));
		Complementaire.addActionListener(new ActionComplementaire(this));
		
		panneauBoutons.add(SetCouleurPref);
		panneauBoutons.add(GetCouleurPref);
		panneauBoutons.add(Complementaire);
		
		panneauChoix.add(panneauBoutons);
		
		//setSize(800,400); //这里可以随意设定窗口大小
		pack();             //这里可以依据你放置的组件设定窗口的大小 使之正好能容纳你放置的所有组件
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);   //可见，这里是整个Vue类可见,为什么可以这么玩儿？因为Vue接入了JFrame接口，setVisible是JFrame的方法
	}
	
	public void miseAJour() { //在stateListener里，不断的调用这个方法
		
		panneauColor.setBackground(new Color( (int)(255*modele.getPctRouge()/100),
				                              (int)(255*modele.getPctVert()/100),
				                              (int)(255*modele.getPctBleu()/100)
				                             ));
		                      //这里就是重新设置一下背景，没什么好说的。刷新。
	}
	
	public void appuieBoutonSetCouleurPref() {
		modelePre = new Modele(modele.getPctRouge(), modele.getPctVert(), modele.getPctBleu());
	}
	
	public void appuieBoutonGetCouleurPref() {
		if(modelePre != null) {
			tabJSLider[0].setValue(modelePre.getPctRouge());
			tabJSLider[1].setValue(modelePre.getPctVert());
			tabJSLider[2].setValue(modelePre.getPctBleu());
		}
		
	}
	
	public void appuieBoutonComplementaire() {
		
		modele.setPctRouge(100-modele.getPctRouge());
		modele.setPctVert(100-modele.getPctVert());
		modele.setPctBleu(100-modele.getPctBleu());
		
		tabJSLider[0].setValue(modele.getPctRouge());
		tabJSLider[1].setValue(modele.getPctVert());
		tabJSLider[2].setValue(modele.getPctBleu());
	}

	public static void main(String[] args){
		Vue vue = new Vue();
		boolean a = true;
		
		while(a) {
			vue.miseAJour();
		}
			
	}
}


