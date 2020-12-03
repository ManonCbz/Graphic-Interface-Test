package Banque;
public class CompteCourant extends CompteBancaire{

	public CompteCourant(int numAgence, int numCompte, Client client, double solde) {
		super(numAgence, client, numCompte, solde);
	}

	public void virement(CompteBancaire retrait, CompteBancaire depot, double somme) {
		
		retrait.retirer(somme);
		depot.deposer(somme);
		
	}

	public void deposer(double somme) {
		double newSolde = (super.getSolde() + somme);
		super.setSolde(newSolde);
		
		System.out.println("Compte n°" + super.getNumCompte() + "\nNouveau solde : " + newSolde);
	}
	
	public void retirer(double somme) {
		double newSolde = (super.getSolde() - somme);
		super.setSolde(newSolde);
		
		System.out.println("Compte n°" + super.getNumCompte() + "\nNouveau solde : " + newSolde);	
	}
 
	public void consulteSolde() {
		System.out.println("-------------------------\n"
				 + super.getClient().getNom() + " " + super.getClient().getPrenom() + " :\n"
				 + "Compte courant \n"
				 + "Numéro de compte : " + super.getNumCompte() + "\n"
				 + "Solde : " + super.getSolde() + " €");
	};
}
