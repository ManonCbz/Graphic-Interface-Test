package listePersonne;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame {

	public Menu() {

		setBounds(10,40,800,400);
		
		JPanel fenetre = new JPanel();
		fenetre.setBackground(new Color(244, 245, 146));
		
		// Panel 1 - Formulaire
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout (4, 2));
		panel.setBackground(new Color(244, 245, 146));

		JTextField nomChamp = new JTextField(10);
		JTextField prenomChamp = new JTextField(10);
		JTextField ageChamp = new JTextField(10);
		JTextField villeChamp = new JTextField(10);
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
		
		fenetre.add(panel);
		
		JPanel panelButton = new JPanel();
		
		panelButton.setLayout(new GridLayout (3, 1));
		
		panelButton.add(ajouterButton);
		panelButton.add(modifierButton);
		panelButton.add(supprimerButton);

		fenetre.add(panelButton);
		
		
		// Panel 2 - Rechercher

 	    JPanel panel2 = new JPanel();
 	    panel2.setBackground(new Color(197, 197, 197));
		panel2.setLayout(new GridLayout (3, 1));

 	    JTextField rechercheChamp = new JTextField(10);
 	    JButton okRechercheButton = new JButton("Ok");

 	    panel2.add(new JLabel("Rechercher par nom : "));
 	    panel2.add(rechercheChamp);
 	    panel2.add(okRechercheButton);
 	    
		fenetre.add(panel2);

		
 	    // Tableau
		
	    DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);

	    model.addColumn("Nom");
	    model.addColumn("Prénom");
	    model.addColumn("Age");
	    model.addColumn("Ville");
                                  
	    model.insertRow(model.getRowCount(), new Object[] { "Denhez", "Laurence", "30", "Avesnelles"});
	    model.insertRow(model.getRowCount(), new Object[] { "Crombez", "Manon", "26", "Laon"});
	    model.insertRow(model.getRowCount(), new Object[] { "Honoré", "Suzon", "30", "Avesnelles"});

	    fenetre.add(new JScrollPane(table));
	    fenetre.setVisible(true);
 	    
	    
		// Affichage Panel
		
 	    this.add(fenetre);
 	    
 	    
 	    // Action Listener
 	    // Ajouter
 	    
 	   ajouterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String nom = nomChamp.getText();
				String prenom = prenomChamp.getText();
				String age = ageChamp.getText();
				String ville = villeChamp.getText();
				
				if ((!nom.isEmpty() && !nom.equals("!")) && (!prenom.isEmpty() && !prenom.equals("!")) && 
						(!age.isEmpty() && !age.equals("!")) && (!ville.isEmpty() && !ville.equals("!"))) {
					
					model.insertRow(model.getRowCount(), new Object[] {nom, prenom, age, ville});	
					
					nomChamp.setText("");
					prenomChamp.setText("");
					ageChamp.setText("");
					villeChamp.setText("");
				}
				
				if (nom.isEmpty()) nomChamp.setText("!");
				if (prenom.isEmpty()) prenomChamp.setText("!");
				if (age.isEmpty()) ageChamp.setText("!");
				if (ville.isEmpty()) villeChamp.setText("!");

			}
 	    });
 	   
	    // Modifier
 	   
 	   modifierButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String nom = nomChamp.getText();
				String prenom = prenomChamp.getText();
				String age = ageChamp.getText();
				String ville = villeChamp.getText();
												
				int ligneSelectionnee = table.getSelectedRow();
								
				if (!nom.isEmpty()) {
					model.setValueAt(nom, ligneSelectionnee, 0);
					nomChamp.setText("");
				}
				if (!prenom.isEmpty()) {
					model.setValueAt(prenom, ligneSelectionnee, 1);		
					prenomChamp.setText("");
				}
				if (!age.isEmpty()) {
					model.setValueAt(age, ligneSelectionnee, 2);		
					ageChamp.setText("");
				}
				if (!ville.isEmpty()) {
					model.setValueAt(ville, ligneSelectionnee, 3);				
					villeChamp.setText("");
				}
			}
 	    });
 	   
	    // Supprimer
 	   
 	   supprimerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				int ligneSelectionnee = table.getSelectedRow();
				model.removeRow(ligneSelectionnee);
				
				nomChamp.setText("");
				prenomChamp.setText("");
				ageChamp.setText("");
				villeChamp.setText("");
			}
 	    });
 	   
	    // Rechercher

 	   okRechercheButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				boolean isInList = false;
				
				String nom = rechercheChamp.getText();

				for (int i = 0; i < model.getRowCount(); i++) {

					if (model.getValueAt(i, 0).equals(nom)) {
						table.setRowSelectionInterval(i, i);
						isInList = true;
						rechercheChamp.setText("");
						
						nomChamp.setText(nom);
						prenomChamp.setText(model.getValueAt(i, 1).toString());
						ageChamp.setText(model.getValueAt(i, 2).toString());
						villeChamp.setText(model.getValueAt(i, 3).toString());
						
					}
				}
				
				if (isInList == false) {
					rechercheChamp.setText("Inconnu");
				}
			}
	    });
 	   
 	   // Click sur le tableau
 	   
 	   table.addMouseListener(new MouseListener() {
		
		public void mouseClicked(MouseEvent e) {

			if (e.getClickCount() == 1) {
				
				int rowNumb = table.getSelectionModel().getMaxSelectionIndex();
				 
				if (rowNumb != -1){
					String nom = table.getValueAt(rowNumb, 0).toString();
					String prenom = table.getValueAt(rowNumb, 1).toString();
					String age = table.getValueAt(rowNumb, 2).toString();
					String ville = table.getValueAt(rowNumb, 3).toString();
					
					nomChamp.setText(nom);
					prenomChamp.setText(prenom);
					ageChamp.setText(age);
					villeChamp.setText(ville);
				}
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
 	   
	}
	
	public static void main(String[] args) {

		Menu t = new Menu();
		t.setVisible(true);
		
	}

}
