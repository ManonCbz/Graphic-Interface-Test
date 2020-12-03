import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExercicePlacement extends JFrame {

	JTextField champTexte1 = new JTextField(10);
	JTextField champTexte2 = new JTextField(10);
	JTextField champTexte3 = new JTextField(10);
	JTextField champTexte4 = new JTextField(10);
	JTextField champTexte5 = new JTextField(10);
	JTextField champTexte6 = new JTextField(10);
	JButton button1 = new JButton("Ok");

	public ExercicePlacement() {

 	    setBounds(10,40,500,200);
 	    
 	    JPanel panel1 = new JPanel();
 	    JPanel panel2 = new JPanel();
 	    JPanel panel3 = new JPanel();
 	    
 	    this.setLayout(new BorderLayout());
 	    panel1.setLayout(new FlowLayout());
 	    
 	    panel1.add(champTexte1);
 	    panel1.add(champTexte2);
 	    panel1.add(champTexte3);
 	    
 	    panel2.add(button1);
 	    
 	    panel3.add(champTexte4);
 	    panel3.add(champTexte5);
 	    panel3.add(champTexte6);
 	    
 	    this.add(panel1, BorderLayout.NORTH);
 	    this.add(panel2, BorderLayout.CENTER);
 	    this.add(panel3, BorderLayout.SOUTH);
	}
	
    public static void main(String[] args) {
   	 	ExercicePlacement f = new ExercicePlacement();
		f.setVisible(true);
	}
}
