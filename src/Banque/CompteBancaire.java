package Banque;
public abstract class CompteBancaire {

	private int numAgence;
	private int numCompte;
	private Client client;
	private double solde;
	
	public CompteBancaire(int numAgence, Client client, int numCompte, double soldeDepart) {
		this.numAgence = numAgence;
		this.numCompte = numCompte;
		this.client = client;
		this.solde = soldeDepart;
		
		client.getCompteBancaire().add(this);
	}
	
	public abstract void virement(CompteBancaire retrait, CompteBancaire depot, double somme);

	public abstract void deposer(double somme);
	
	public abstract void retirer(double somme);
	
	public abstract void consulteSolde();

	public double getSolde() {
		return solde;
	}
	
	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public Client getClient() {
		return client;
	}

	public int getNumAgence() {
		return numAgence;
	}
}