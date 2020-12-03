import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ExerciceConnexion extends JFrame implements ActionListener {
	
	JLabel labelLogin = new JLabel("Pseudo : ");
	JTextField login = new JTextField();
	JLabel labelPassword = new JLabel("Mot de passe : ");
	JPasswordField password = new JPasswordField();
	JButton button = new JButton("Ok");
	
	public ExerciceConnexion() {
		
 	    setBounds(10,40,300,200);
 	    
 	    JPanel panel = new JPanel();
 	    
 	    panel.setLayout(new GridLayout(5, 1));
 	    
 	    panel.add(labelLogin);
 	    panel.add(login);
 	    panel.add(labelPassword);
 	    panel.add(password);
 	    panel.add(button);
 	    
 	    button.addActionListener(this);
 	    
 	    this.add(panel);
	}
	
    public static void main(String[] args) {
   	 	ExerciceConnexion f = new ExerciceConnexion();
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {

			String pseudo = login.getText();
			String motDePasse = password.getText();
			
			login.setText("Bienvenue " + pseudo);
			System.out.println("Pseudo : " + pseudo + "\nMot de passe : " + motDePasse);
		}
	}
}