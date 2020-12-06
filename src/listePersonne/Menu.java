package listePersonne;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Menu extends JFrame {

	public Menu() {

		setBounds(10,40,800,400);

		// Panel 1 - Formulaire

		JPanel panel = new JPanel();

		panel.setBackground(new Color(244, 245, 146));

		JTextField nomChamp = new JTextField();
		JTextField prenomChamp = new JTextField();
		JTextField ageChamp = new JTextField();
		JTextField villeChamp = new JTextField();
		JButton ajouterButton = new JButton("Ajouter");
		JButton modifierButton = new JButton("Modifier");
		JButton supprimerButton = new JButton("Supprimer");

		panel.add(new JLabel("Nom : "));
		panel.add(nomChamp);
		panel.add(new JLabel("Prénom : "));
		panel.add(prenomChamp);
		panel.add(new JLabel("Age :"));
		panel.add(ageChamp);
		panel.add(new JLabel("Ville :"));
		panel.add(villeChamp);

		panel.add(ajouterButton);
		panel.add(modifierButton);
		panel.add(supprimerButton);

		// Panel 2 - Rechercher

 	    JPanel panel2 = new JPanel();
 	    panel2.setBackground(new Color(197, 197, 197));

 	    JTextField rechercheChamp = new JTextField(10);
 	    JButton okRechercheButton = new JButton();

 	    panel2.add(new JLabel("Rechercher par nom : "));
 	    panel2.add(rechercheChamp);
 	    panel2.add(okRechercheButton);

 	    // Tableau

 	    String data[][]={ 
 	    		{"Crombez","Manon","26", "Semousies"},    
                {"Honoré","Suzon","25", "Avesnelles"},    
                {"Denhez","Laurence", "45", "Lille"}
                };  
 	    
		String column[]={"Nom","Prenom","Age", "Ville"};

		JTable tableau = new JTable(data,column);    
		tableau.setBounds(30,40,200,300);
		
		JScrollPane sp = new JScrollPane(tableau);    
		this.setVisible(true); 
		panel.add(sp);
		panel.add(panel2);
 	    
		// Affichage Panel
		
 	    this.add(panel);
 	    
 	    // Action Listener
 	    
 	   ajouterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String nom = nomChamp.getText();
				String prenom = prenomChamp.getText();
				String age = ageChamp.getText();
				String ville = villeChamp.getText();
				
				String [][]newTab;
				
				for (int i = 0; i < data.length; i++) {
					for (int j = 0; j < data.length; j++) {
						
					}
				}
			}
 	    });
 	   
 	   modifierButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String nom = nomChamp.getText();
				String prenom = prenomChamp.getText();
				String age = ageChamp.getText();
				String ville = villeChamp.getText();
			}
 	    });
 	   
 	   supprimerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String nom = nomChamp.getText();
				String prenom = prenomChamp.getText();
				String age = ageChamp.getText();
				String ville = villeChamp.getText();
			}
 	    });
	}
	
	public static void main(String[] args) {

		Menu t = new Menu();
		t.setVisible(true);
		
	}

}
