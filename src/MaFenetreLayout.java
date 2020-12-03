import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MaFenetreLayout extends JFrame {
	
	JTextField jtextfield1 = new JTextField(10);//zone de texte de 10 caractères
	JButton jbuttonInc =new JButton("Incrémenter");//bouton
	JButton jbuttonDec =new JButton("Décrémenter");
	JTextField jtextfield2 = new JTextField(10);

     public MaFenetreLayout() {
 	    setTitle("Compteur") ; 
 	    //initialisation du titre de la fenêtre
 	    setBounds(10,40,300,200) ; 
 	    //le coin supérieur gauche de la fenêtre est placé au pixel de coordonnées 10, 40 et ses dimensions seront de 300 *200 pixels
 	    
 	    JPanel jpanel=new JPanel();//Un panel est un espace dans lequel on peut placer des composants graphiques
 	    
 	    this.setLayout(new BorderLayout());

 	    jpanel.setLayout(new BorderLayout());

	    jpanel.add(jtextfield1, BorderLayout.NORTH);//Mettre le bouton dans le panel
	    jpanel.add(jbuttonInc,  BorderLayout.WEST);
	    jpanel.add(jbuttonDec, BorderLayout.EAST);
	    jpanel.add(jtextfield2, BorderLayout.SOUTH);//Mettre le bouton dans le panel
 	    
 	    this.add(jpanel);//ajouter le panel à la fenêtre
 	    
 	    setDefaultCloseOperation(EXIT_ON_CLOSE);//quitter l'application quand on ferme la fenetre
     }
     
     public static void main(String[] args) {
    	 MaFenetreLayout f= new MaFenetreLayout();
		f.setVisible(true);
	}

}