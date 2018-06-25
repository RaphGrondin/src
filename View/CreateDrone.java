package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import Model.GameManager;

public class CreateDrone extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField nomT;
	private JLabel nomL;
	private ButtonGroup bgR = new ButtonGroup();
	private ButtonGroup bgP = new ButtonGroup();
	JButton creer;
	JButton annuler;
	private JRadioButton petit, grand;

	public CreateDrone(JFrame parent, String title, boolean modal){

		super(parent, title, modal);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponent();
		setVisible(true);

	}
	private void initComponent()
	{
		Font font = new Font("Courier", Font.BOLD, 15);
		JPanel pan =new JPanel();
		pan.setSize(this.getWidth(),this.getHeight());
		pan.setBackground(Color.black);
		//Nom
		JPanel panNom = new JPanel();
		panNom.setBackground(Color.black);
		panNom.setPreferredSize(new Dimension(250,100));
		nomT = new JTextField("Bip-bip");
		nomT.setFont(font);
		nomT.setPreferredSize(new Dimension(100, 25));
		TitledBorder nom;
		nom = BorderFactory.createTitledBorder("Nom de l'animal");
		nom.setTitleFont(font);
		nom.setTitleColor(Color.white);
		panNom.setBorder(nom);
		nomL = new JLabel("Saisir un nom :");
		nomL.setFont(font);
		nomL.setForeground(Color.white);
		petit=new JRadioButton("Petit drone");
		petit.setFont(font);
		petit.setBackground(Color.black);
		petit.setForeground(Color.white);
		grand=new JRadioButton("Grand drone");
		grand.setFont(font);
		grand.setBackground(Color.black);
		grand.setForeground(Color.white);
		panNom.add(nomL);
		panNom.add(nomT);
		panNom.add(petit);
		panNom.add(grand);

		/*//Regime
		JPanel panReg = new JPanel();
		panReg.setBackground(Color.black);
		panReg.setPreferredSize(new Dimension(300,100));
		TitledBorder regime;
		regime = BorderFactory.createTitledBorder("Regime alimentaire");
		regime.setTitleFont(font);
		regime.setTitleColor(Color.white);
		panReg.setBorder(regime);
		carn=new JRadioButton("Carnivore");
		carn.setFont(font);
		carn.setBackground(Color.black);
		carn.setForeground(Color.white);
		herb=new JRadioButton("Herbivore");
		herb.setFont(font);
		herb.setBackground(Color.black);
		herb.setForeground(Color.white);
		herb.setSelected(true);
		bgR.add(carn);
		bgR.add(herb);
		panReg.add(carn);
		panReg.add(herb);*/


		//D?placement
	    /*JPanel panDep=new JPanel();
	    panDep.setBackground(Color.black);
		panDep.setPreferredSize(new Dimension(300,100));
		TitledBorder deplacement;
		deplacement = BorderFactory.createTitledBorder("D?placement de l'animal");
		deplacement.setTitleFont(font);
		deplacement.setTitleColor(Color.white);
		panDep.setBorder(deplacement);
		terre=new JCheckBox("Terrestre");
		terre.setBackground(Color.black);
		terre.setForeground(Color.white);
		terre.setSelected(true);
		eau=new JCheckBox("Aquatique");
		eau.setBackground(Color.black);
		eau.setForeground(Color.white);
		air=new JCheckBox("A?rien");
		air.setBackground(Color.black);
		air.setForeground(Color.white);
		air.setSelected(true);
		nbPattesLabel=new JLabel("nombre de pattes");
		nbPattesLabel.setFont(font);
		nbPattesLabel.setForeground(Color.white);
		nbPattes=new SpinnerNumberModel(2, 0, 4, 1);
		JSpinner pattes = new JSpinner(nbPattes);
		panDep.add(terre);
		panDep.add(eau);
		panDep.add(air);
		panDep.add(nbPattesLabel);
		panDep.add(pattes);*/


		//P?riode d'activit?
		/*JPanel panPer = new JPanel();
		panPer.setBackground(Color.black);
		panPer.setPreferredSize(new Dimension(250,100));
		TitledBorder periode;
		periode = BorderFactory.createTitledBorder("P?riode d'activit?");
		periode.setTitleFont(font);
		periode.setTitleColor(Color.white);
		panPer.setBorder(periode);
		diurne=new JRadioButton("Duirne");
		diurne.setFont(font);
		diurne.setBackground(Color.black);
		diurne.setForeground(Color.white);
		diurne.setSelected(true);
		noct=new JRadioButton("Nocturne");
		noct.setFont(font);
		noct.setBackground(Color.black);
		noct.setForeground(Color.white);
		bgP.add(diurne);
		bgP.add(noct);
		panPer.add(diurne);
		panPer.add(noct);*/

		//Caract?ristiques
		/*JPanel panCar = new JPanel();
		panCar.setBackground(Color.black);
		panCar.setPreferredSize(new Dimension(250,100));
		TitledBorder carac;
		carac = BorderFactory.createTitledBorder("Caract?ristiques");
		carac.setTitleFont(font);
		carac.setTitleColor(Color.white);
		panCar.setBorder(carac);
		poids = new SpinnerNumberModel(10,10,100,1);
		JSpinner spiP = new JSpinner(poids);
		poidsL = new JLabel("Poids");
		poidsL.setFont(font);
		poidsL.setForeground(Color.white);
	    panCar.add(poidsL);
	    panCar.add(spiP);
	    taille = new SpinnerNumberModel(10,10,30,1);
		JSpinner spinT = new JSpinner(taille);
		tailleL = new JLabel("Taille");
		tailleL.setFont(font);
		tailleL.setForeground(Color.white);
	    panCar.add(tailleL);
	    panCar.add(spinT);
	    vitMax = new SpinnerNumberModel(10,2,10,1);
		JSpinner spinV = new JSpinner(vitMax);
		vitMaxL = new JLabel("Vitesse Max");
		vitMaxL.setFont(font);
		vitMaxL.setForeground(Color.white);
	    panCar.add(vitMaxL);
	    panCar.add(spinV);*/

		//Couleur
		/*JPanel panCou = new JPanel();
		panCou.setBackground(Color.black);
		panCou.setPreferredSize(new Dimension(250,100));
		TitledBorder couleur;
		couleur = BorderFactory.createTitledBorder("Couleur");
		couleur.setTitleFont(font);
		couleur.setTitleColor(Color.white);
		panCou.setBorder(couleur);
		rouge = new SpinnerNumberModel(0,0,255,1);
		JSpinner spiR = new JSpinner(rouge);
		rougeL = new JLabel("Rouge");
		rougeL.setFont(font);
		rougeL.setForeground(Color.white);
	    panCou.add(rougeL);
	    panCou.add(spiR);
	    vert = new SpinnerNumberModel(0,0,255,1);
		JSpinner spinVer= new JSpinner(vert);
		vertL = new JLabel("Vert");
		vertL.setFont(font);
		vertL.setForeground(Color.white);
	    panCou.add(vertL);
	    panCou.add(spinVer);
	    bleu = new SpinnerNumberModel(255,0,255,1);
		JSpinner spinB = new JSpinner(bleu);
		bleuL = new JLabel("Bleu");
		bleuL.setFont(font);
		bleuL.setForeground(Color.white);
	    panCou.add(bleuL);
	    panCou.add(spinB);*/


		JPanel boutons = new JPanel();
		boutons.setBackground(Color.black);
		boutons.setSize(100,100);
		creer= new JButton("Cr?er");
		annuler= new JButton("Annuler");
		creer.addActionListener(this);
		annuler.addActionListener(this);
		boutons.add(creer);
		boutons.add(annuler);






		pan.add(panNom);
		/*pan.add(panReg);
		pan.add(panDep);
		pan.add(panPer);
		pan.add(panCar);
		pan.add(panCou);*/
		pan.add(boutons);



		add(pan);


	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getSource() == annuler)
		{
			this.setVisible(false);
		}else
		{
			/*int r = (int) rouge.getValue();
			int v = (int) vert.getValue();
			int b = (int) bleu.getValue();
			int p = (int) poids.getValue();
			int t = (int) taille.getValue();
			int vM = (int) vitMax.getValue();
			int nbP = (int) nbPattes.getValue();*/
			String nom = nomT.getText();
			/*boolean carnivore = carn.isSelected();
			boolean periode = diurne.isSelected();
			boolean terrestre = terre.isSelected();
			boolean aquatique = eau.isSelected();
			boolean aerien = air.isSelected();*/
			if(petit.isSelected()) GameManager.createDrone(nom,10);
			else if(grand.isSelected()) GameManager.createDrone(nom, 0);
			this.setVisible(false);
		}

	}
}  
