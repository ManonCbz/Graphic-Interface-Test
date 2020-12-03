import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExerciceCalculatrice extends JFrame {
	
	JTextField nb1 = new JTextField(8);
	JTextField nb2 = new JTextField(8);
	JTextField result = new JTextField(10);
	JLabel labelEqual = new JLabel(" = ");
	JButton addition = new JButton("+");
	JButton soustraction = new JButton("-");
	JButton multiplication = new JButton("*");
	
	public ExerciceCalculatrice() {
		
 	    setBounds(10,40,500,140);
 	    
 	    JPanel panel1 = new JPanel();
 	    JPanel panel2 = new JPanel();
 	    JPanel panel3 = new JPanel();

 	    this.setLayout(new BorderLayout());

 	    panel1.add(nb1);
 	    panel1.add(addition);
 	    panel1.add(soustraction);
 	    panel1.add(multiplication);
 	    panel1.add(nb2);

 	    panel2.add(labelEqual);
 	    panel3.add(result);

 	    this.add(panel1, BorderLayout.NORTH);
 	    this.add(panel2);
 	    this.add(panel3, BorderLayout.SOUTH);

	 	addition.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int un = Integer.parseInt(nb1.getText());
				int deux = Integer.parseInt(nb2.getText());

				int total = un + deux;
				String test = null;

				result.setText(test.valueOf(total));
			}
	 	});
	 	
	 	soustraction.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int un = Integer.parseInt(nb1.getText());
				int deux = Integer.parseInt(nb2.getText());

				int total = un - deux;
				String test = null;

				result.setText(test.valueOf(total));
			}
		});
	 	
	 	multiplication.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int un = Integer.parseInt(nb1.getText());
				int deux = Integer.parseInt(nb2.getText());

				int total = un * deux;
				String test = null;

				result.setText(test.valueOf(total));
			}
		});
 	    
	}
	
    public static void main(String[] args) {
    	ExerciceCalculatrice f = new ExerciceCalculatrice();
		f.setVisible(true);
	}
}