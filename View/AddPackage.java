package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.GameManager;

public class AddPackage extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Button littlePackage = new Button("Little Package");
	private Button bigPackage = new Button("Big Package");
	private JLabel text = new JLabel("Add package");
	
	public AddPackage()
	{
		setBackground(Color.black);
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
		setPreferredSize(new Dimension(400, 200));
		Font police = new Font("Courier", Font.BOLD, 20);
		text.setFont(police);
		text.setForeground(Color.white);
		text.setHorizontalAlignment(JLabel.CENTER);
		setLayout(new BorderLayout());		
		add(text, BorderLayout.CENTER);
		add(littlePackage, BorderLayout.NORTH);
		add(bigPackage, BorderLayout.SOUTH);
		littlePackage.addActionListener(this);
		bigPackage.addActionListener(this);
	    
	}
	public void actionPerformed(ActionEvent arg0) {


		if(arg0.getSource() == littlePackage){
			if (GameManager.nbPackages() < 10) {
				GameManager.addLittlePackage();
			}

		} else {
			if (GameManager.nbPackages() < 10) {
				GameManager.addBigPackage();
			}
		}
		 
}
}
