import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExerciceListe extends JFrame {

	List liste = new List();
	JTextField champTexte = new JTextField(10);
	JButton buttonAdd = new JButton("Ajouter");
	JButton buttonUpdate = new JButton("Modifier");
	JButton buttonDelete = new JButton("Supprimer");
	
	public ExerciceListe() {
		
 	    setBounds(10,40,700,200);
 	    
 	    JPanel panel = new JPanel();
 	     	    
 	    this.setLayout(new FlowLayout());
 	    
 	    panel.add(champTexte);
 	    panel.add(liste);
 	    panel.add(buttonAdd);
 	    panel.add(buttonUpdate);
 	    panel.add(buttonDelete);
 	     	    
 	    this.add(panel);
 	    
	 	buttonAdd.addActionListener(new ActionListener() {
	 	
			public void actionPerformed(ActionEvent e) {
				
				String value = champTexte.getText();
				liste.add(value);
				
			}
			
	 	});
	 	
	 	buttonDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String value = champTexte.getText();
				liste.remove(value);
			}
		});
	 	
	 	buttonUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String value = champTexte.getText();

			    for (int i = 0; i < liste.getItemCount(); i++) {
			        
			    	if(liste.getItem(i).equals(value)) {
			            liste.replaceItem("test", i);
			        }
			    }
			}
		});
 	    
	}
	
    public static void main(String[] args) {
    	ExerciceListe f = new ExerciceListe();
		f.setVisible(true);
	}
}