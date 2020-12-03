package Banque;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test extends JFrame {
	
	JTextField nom = new JTextField();
	JTextField prenom = new JTextField();
	JPasswordField password = new JPasswordField();
	JButton button = new JButton("Ok");

	public Test(ArrayList<Client> listeClient) {
		
		setBounds(10,40,300,280);
 	    
 	    JPanel panel = new JPanel();
 	    
 	    panel.setLayout(new GridLayout(5,1,25,20));

 	    panel.add(new JTextArea("Connexion"));
 	    panel.add(new JTextArea(""));
 	    panel.add(new JLabel("Nom : "));
 	    panel.add(nom);
 	    panel.add(new JLabel("Prénom : "));
 	    panel.add(prenom);
 	    panel.add(new JLabel("Mot de passe : "));
 	    panel.add(password);
 	    panel.add(new JTextArea(""));
 	    panel.add(button);

 	    this.add(panel);

 	    // Connexion
 	    
 	    button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				// Valeur des champs de textes
				
				String nomTxt = nom.getText();
				String prenomTxt = prenom.getText();
				String motDePasseTxt = password.getText();
				
				boolean error = true;
				
				for (Client c : listeClient) {
					
					// Si la connexion est ok
					
					if (c.getNom().equals(nomTxt) && c.getPrenom().equals(prenomTxt) && c.getMotDePasse().equals(motDePasseTxt)) {

						error = false;
						
						// Nouveau visuel pour le menu d'accueil
						
				 	    panel.setVisible(false);
				 	    
						setBounds(10,40,350,450);

						JPanel panel2 = new JPanel();
				 	    
				 	    panel2.setLayout(new GridLayout(8,3));

				 	    panel2.add(new JTextArea("Bonjour " + prenomTxt + ","));
				 	    panel2.add(new JTextArea(" "));				 	    
				 	    panel2.add(new JTextArea(" "));
				 	    panel2.add(new JTextArea("--------------------------------"));
				 	    panel2.add(new JTextArea("--------------------------------"));
				 	    panel2.add(new JTextArea("--------------------------------"));
				 	    
				 	    // Affiche les comptes courants de l'utilisateur
				 	    
				 	    JTextArea soldeCourant = new JTextArea("");
				 	    JTextArea soldeEpargne = new JTextArea("");
				 	    
			 	    	if (c.getCompteBancaire().size() > 0) {
			 	    		panel2.add(new JTextArea("Compte courant : "));
					 	    panel2.add(new JTextArea(" "));
					 	    panel2.add(new JTextArea(" "));
					 	    for (CompteBancaire cb : c.getCompteBancaire()) {
					 	    	if (cb instanceof CompteEpargne == false) {
					 	    		panel2.add(new JTextArea("Compte n°" + cb.getNumCompte() + " : "));
					 	    		soldeCourant.setText(cb.getSolde() + "€");
					 	    		panel2.add(soldeCourant);	
							 	    panel2.add(new JTextArea(" "));
					 	    	}
					 	    }
			 	    	}

			 	    	// Affiche les comptes épargnes de l'utilisateur
			 	    	
			 	    	if (c.getCompteEpargne().size() > 0) {
			 	    		panel2.add(new JTextArea("Compte épargne : "));
					 	    panel2.add(new JTextArea(" "));
					 	    panel2.add(new JTextArea(" "));
					 	    for (CompteBancaire cb : c.getCompteEpargne()) {
					 	    		panel2.add(new JTextArea("Compte n°" + cb.getNumCompte() + " : "));
					 	    		soldeEpargne.setText(cb.getSolde() + "€");
					 	    		panel2.add(soldeEpargne);		
							 	    panel2.add(new JTextArea(" "));
					 	    }
			 	    	}
			 	    	
			 	    	// Boutons
			 	    	
			 	    	JButton buttonAjouter = new JButton("Ajouter");
			 	    	JButton buttonRetirer = new JButton("Retirer");
			 	    	JButton buttonVirement = new JButton("Virement");
			 	    	
				 	    panel2.add(new JTextArea("--------------------------------"));
				 	    panel2.add(new JTextArea("--------------------------------"));
				 	    panel2.add(new JTextArea("--------------------------------"));
			 	    	panel2.add(buttonAjouter);
			 	    	panel2.add(buttonVirement);
			 	    	panel2.add(buttonRetirer);
			 	    	
				 	    add(panel2);		
				 	    
				 	    //  Ajouter de l'argent sur un compte
				 	    
				 	    buttonAjouter.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								
								// Nouveau visuel
								
								panel2.setVisible(false);
								
								setBounds(10,40,300,300);

								JPanel panel3 = new JPanel();
						 	    
						 	    panel3.setLayout(new GridLayout(5,2));
						 	    
								JTextField champSomme = new JTextField(10);
								JTextField champNumCompte = new JTextField(10);
								JTextArea messageStatut = new JTextArea("HGJ");
								JButton buttonOkAjouter = new JButton("Ok");
								JButton buttonRetour = new JButton("Retour");
								
								messageStatut.setSelectionColor(Color.green);
								
								panel3.add(new JLabel("Somme : "));
								panel3.add(champSomme);
								panel3.add(new JLabel("Compte à créditer (n°) : "));
								panel3.add(champNumCompte);
								panel3.add(messageStatut);
								panel3.add(new JTextArea(" "));
								panel3.add(buttonOkAjouter);
								panel3.add(buttonRetour);
								
								add(panel3);
								
								buttonOkAjouter.addActionListener(new ActionListener() {
									
									public void actionPerformed(ActionEvent e) {
										
										int somme = Integer.parseInt(champSomme.getText());
										int numCompte = Integer.parseInt(champNumCompte.getText());

										for (CompteBancaire compte : c.getCompteBancaire()) {
											if (compte.getNumCompte() == numCompte) {
												double newSolde = compte.getSolde() + somme;
												compte.setSolde(newSolde);
												soldeCourant.setText(Double.toString(newSolde));
												messageStatut.setText("Votre compte à bien été crédité !");
												System.out.println(compte.getSolde());
											}
										}
									}
								});	
								
								buttonRetour.addActionListener(new ActionListener() {
									
									public void actionPerformed(ActionEvent e) {
										setBounds(10,40,350,450);
										panel3.setVisible(false);
										panel2.setVisible(true);
									}
								});
							}
							
						});
				 	    
				 	    // Retirer de l'argent d'un compte
				 	    
				 	    buttonRetirer.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								
								// Nouveau visuel 
								
								panel2.setVisible(false);
								
								setBounds(10,40,300,300);

								JPanel panel3 = new JPanel();
						 	    
						 	    panel3.setLayout(new GridLayout(5,2));
						 	    
								JTextField champSomme = new JTextField(10);
								JTextField champNumCompte = new JTextField(10);
								JButton buttonOkAjouter = new JButton("Ok");
								JButton buttonRetour = new JButton("Retour");

								
								panel3.add(new JLabel("Somme : "));
								panel3.add(champSomme);
								panel3.add(new JLabel("Compte à débiter (n°) : "));
								panel3.add(champNumCompte);
								panel3.add(buttonOkAjouter);
								panel3.add(buttonRetour);
								
								add(panel3);
								
								buttonOkAjouter.addActionListener(new ActionListener() {
									
									public void actionPerformed(ActionEvent e) {
										
										int somme = Integer.parseInt(champSomme.getText());
										int numCompte = Integer.parseInt(champNumCompte.getText());

										for (CompteBancaire compte : c.getCompteBancaire()) {
											if (compte.getNumCompte() == numCompte) {
												double newSolde = compte.getSolde() - somme;
												soldeCourant.setText(Double.toString(newSolde));
												compte.setSolde(newSolde);
												System.out.println(compte.getSolde());
											}
										}
									}
								});	
								
								buttonRetour.addActionListener(new ActionListener() {
									
									public void actionPerformed(ActionEvent e) {
										setBounds(10,40,350,450);
										panel3.setVisible(false);
										panel2.setVisible(true);
										
									}
								});
							}
							
						});
				 	    
				 	    // Faire un virement
				 	    
				 	    buttonVirement.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent e) {
								
								// Nouveau visuel 
								
								panel2.setVisible(false);
								
								setBounds(10,40,300,300);

								JPanel panel3 = new JPanel();
						 	    
						 	    panel3.setLayout(new GridLayout(5,2));
						 	    
								JTextField champSomme = new JTextField(10);
								JTextField champNumCompte1 = new JTextField(10);
								JTextField champNumCompte2 = new JTextField(10);
								JButton buttonOkAjouter = new JButton("Ok");
								JButton buttonRetour = new JButton("Retour");
								
								panel3.add(new JLabel("Somme : "));
								panel3.add(champSomme);
								panel3.add(new JLabel("Compte à créditer (n°) : "));
								panel3.add(champNumCompte1);
								panel3.add(new JLabel("Compte à débiter (n°) : "));
								panel3.add(champNumCompte2);
								panel3.add(buttonOkAjouter);
								panel3.add(buttonRetour);
								
								add(panel3);
								
								buttonOkAjouter.addActionListener(new ActionListener() {
									
									public void actionPerformed(ActionEvent e) {
										
										int somme = Integer.parseInt(champSomme.getText());
										int numCompte1 = Integer.parseInt(champNumCompte1.getText());
										int numCompte2 = Integer.parseInt(champNumCompte2.getText());
										
										for (CompteBancaire compte1 : c.getCompteBancaire()) {
											if (compte1.getNumCompte() == numCompte1) {
												for (CompteBancaire compte2 : c.getCompteBancaire()) {
													if (compte2.getNumCompte() == numCompte2) {
														
														double newSoldeCompte1 = compte1.getSolde() + somme;
														compte1.setSolde(newSoldeCompte1);
														double newSoldeCompte2 = compte2.getSolde() - somme;
														compte2.setSolde(newSoldeCompte2);
														soldeEpargne.setText(Double.toString(newSoldeCompte1));
														soldeCourant.setText(Double.toString(newSoldeCompte2));
														System.out.println(compte1.getSolde());
														System.out.println(compte2.getSolde());
													}
												}
											}
										}
									}
								});	
								
								buttonRetour.addActionListener(new ActionListener() {
									
									public void actionPerformed(ActionEvent e) {
										setBounds(10,40,350,450);
										panel3.setVisible(false);
										panel2.setVisible(true);
										
									}
								});
							}
							
						});
				 	    
				 	    
						break;
					}
				}
				
				// Message d'erreur si la connexion est ko

				if (error == true) {
					nom.setText("erreur");
					prenom.setText("erreur");
				}
			}
	 	});
 	    
 	    
 	    
	}

	public static void main(String[] args) {
		
		ArrayList<Client> listeClient = new ArrayList<Client>();
		
		Client laurence = new Client("Laurence", "Denhez", "mdp");
		Client suzon = new Client("Suzon", "Honore", "mdp");
		
		listeClient.add(laurence);
		listeClient.add(suzon);
		
		CompteBancaire cc1 = new CompteCourant(1520, 6465, laurence, 2000);
		CompteBancaire ce1 = new CompteEpargne(1520, 6466, laurence, 0);
		
		CompteBancaire cc2 = new CompteCourant(1520, 5467, suzon, 1000);
		CompteBancaire ce2 = new CompteEpargne(1520, 5468, suzon, 50);
		
   	 	Test t = new Test(listeClient);
		t.setVisible(true);
	}
}