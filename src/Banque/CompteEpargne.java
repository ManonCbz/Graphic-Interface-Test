package Banque;
public class CompteEpargne extends CompteBancaire{

	public CompteEpargne(int numAgence, int numCompte, Client client, double solde) {
		
		super(numAgence, client, numCompte, solde);
		client.getCompteEpargne().add(this);

	}

	public void virement(CompteBancaire retrait, CompteBancaire depot, double somme) {
	}
	
	public void deposer(double somme) {
		
		double sommeEpargne = somme + (somme * 0.05);
		
		double newSolde = (super.getSolde() + sommeEpargne);
		super.setSolde(newSolde);
		
		System.out.println("Compte n°" + super.getNumCompte() + "\nNouveau solde : " + newSolde);
	}
	
	public void retirer(double somme) {
		double newSolde = (super.getSolde() - somme);
		super.setSolde(newSolde);
		
		System.out.println("Compte n°" + super.getNumCompte() + "\nNouveau solde : " + newSolde);
	}

	public void consulteSolde() {
		System.out.println( "-------------------------\n"
				 + super.getClient().getNom() + " " + super.getClient().getPrenom() + " :\n"
				 + "Compte épargne \n"
				 + "Numéro de compte : " + super.getNumCompte() + "\n"
				 + "Solde : " + super.getSolde() + " €");
	}
}
