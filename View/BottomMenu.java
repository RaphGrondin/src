package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BottomMenu extends JPanel implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	private AddItem pan1;
	private AddPackage pan2;
	private Button bout = new Button ("Créer Animal");
	
	public BottomMenu()
	{
		setPreferredSize(new Dimension(1200, 100));
		bout.setPreferredSize(new Dimension(400,200));
		pan1 =new AddItem();
		pan2 =new AddPackage();
	    setBackground(Color.black);
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.white));
		setLayout(new BorderLayout());		
		add(pan1, BorderLayout.WEST);
		add(pan2, BorderLayout.CENTER);
		add(bout,BorderLayout.EAST);
		bout.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		new CreateDrone(null,"Création d'un animal",true);			
		
	}
}
