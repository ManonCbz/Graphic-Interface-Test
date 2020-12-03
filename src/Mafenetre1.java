import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Une fen�tre est un objet de la classe JFrame

public class Mafenetre1 extends JFrame {
	
	JTextField jtextfield1 = new JTextField(10);//zone de texte de 10 caract�res
	JButton jbuttonInc =new JButton("Incr�menter");//bouton
	JButton jbuttonDec =new JButton("D�cr�menter");
	JTextField jtextfield2 = new JTextField(10);
	
	JTextField champTexte1 = new JTextField(10);
	JButton button1 =new JButton("Incr�menter");
	JButton button2 =new JButton("D�cr�menter");
	JTextField champTexte2 = new JTextField(10);
	
     public Mafenetre1() {
 	    setTitle("Compteur"); 
 	    //initialisation du titre de la fen�tre
 	    setBounds(10,40,300,200);
 	    //le coin sup�rieur gauche de la fen�tre est plac� au pixel de coordonn�es 10, 40 et ses dimensions seront de 300 *200 pixels
 	    
 	    JPanel jpanel=new JPanel();//Un panel est un espace dans lequel on peut placer des composants graphiques
 	    
 	    jpanel.add(jtextfield1);//Mettre le bouton dans le panel
 	    jpanel.add(jbuttonInc);
 	    jpanel.add(jbuttonDec);
 	    jpanel.add(jtextfield2);//Mettre le bouton dans le panel
 	    
 	    jpanel.add(champTexte1);
 	    jpanel.add(button1);
 	    jpanel.add(button2);
 	    jpanel.add(champTexte2);

 	    this.add(jpanel);//ajouter le panel � la fen�tre
 	    
 	   // setDefaultCloseOperation(EXIT_ON_CLOSE);//quitter l'application quand on ferme la fenetre
     }
     
     public static void main(String[] args) {
		Mafenetre1 f= new Mafenetre1();
		f.setVisible(true);
	}
}
