import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Une fenêtre est un objet de la classe JFrame

public class Mafenetre1 extends JFrame {
	
	JTextField jtextfield1 = new JTextField(10);//zone de texte de 10 caractères
	JButton jbuttonInc =new JButton("Incrémenter");//bouton
	JButton jbuttonDec =new JButton("Décrémenter");
	JTextField jtextfield2 = new JTextField(10);
	
	JTextField champTexte1 = new JTextField(10);
	JButton button1 =new JButton("Incrémenter");
	JButton button2 =new JButton("Décrémenter");
	JTextField champTexte2 = new JTextField(10);
	
     public Mafenetre1() {
 	    setTitle("Compteur"); 
 	    //initialisation du titre de la fenêtre
 	    setBounds(10,40,300,200);
 	    //le coin supérieur gauche de la fenêtre est placé au pixel de coordonnées 10, 40 et ses dimensions seront de 300 *200 pixels
 	    
 	    JPanel jpanel=new JPanel();//Un panel est un espace dans lequel on peut placer des composants graphiques
 	    
 	    jpanel.add(jtextfield1);//Mettre le bouton dans le panel
 	    jpanel.add(jbuttonInc);
 	    jpanel.add(jbuttonDec);
 	    jpanel.add(jtextfield2);//Mettre le bouton dans le panel
 	    
 	    jpanel.add(champTexte1);
 	    jpanel.add(button1);
 	    jpanel.add(button2);
 	    jpanel.add(champTexte2);

 	    this.add(jpanel);//ajouter le panel à la fenêtre
 	    
 	   // setDefaultCloseOperation(EXIT_ON_CLOSE);//quitter l'application quand on ferme la fenetre
     }
     
     public static void main(String[] args) {
		Mafenetre1 f= new Mafenetre1();
		f.setVisible(true);
	}
}
