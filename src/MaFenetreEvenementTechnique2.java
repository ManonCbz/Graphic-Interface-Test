import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MaFenetreEvenementTechnique2 extends JFrame{
		
		JTextField jtextfield1 = new JTextField(10);//zone de texte de 10 caract�res
		JButton jbuttonInc =new JButton("Incr�menter");//bouton
		JButton jbuttonDec =new JButton("D�cr�menter");
		JTextField jtextfield2 = new JTextField(10);

		
		
	     public MaFenetreEvenementTechnique2() {
	 	    setTitle("Compteur") ; 
	 	    //initialisation du titre de la fen�tre
	 	    setBounds(10,40,300,200) ; 
	 	    //le coin sup�rieur gauche de la fen�tre est plac� au pixel de coordonn�es 10, 40 et ses dimensions seront de 300 *200 pixels
	 	    
	 	    JPanel jpanel=new JPanel();//Un panel est un espace dans lequel on peut placer des composants graphiques
	 	    
	 	    jpanel.add(jtextfield1);//Mettre le bouton dans le panel
	 	    jpanel.add(jbuttonInc);
	 	    jpanel.add(jbuttonDec);
	 	    jpanel.add(jtextfield2);//Mettre le bouton dans le panel

	 	    //le bouton est � l'�coute du listener
	 	    //new actionListner
	 	    //objet anonyme : objet dont la classe n'existe pas (objet d'une interface)
	 	    
	 	   jbuttonInc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int newVal=Integer.parseInt(jtextfield1.getText())+1;
				jtextfield2.setText(" "+newVal);
			}
			
		});
	 	   
	 	   jbuttonDec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int newVal=Integer.parseInt(jtextfield1.getText())-1;
				jtextfield2.setText(" "+newVal);
				
			}
		});

	 	   
	 	    
	 	    this.add(jpanel);//ajouter le panel � la fen�tre
	 	    
	 	    setDefaultCloseOperation(EXIT_ON_CLOSE);//quitter l'application quand on ferme la fenetre
	     }
	     
	     public static void main(String[] args) {
	    	 MaFenetreEvenementTechnique2 f= new MaFenetreEvenementTechnique2();
			f.setVisible(true);;
			
		}

	

	}



