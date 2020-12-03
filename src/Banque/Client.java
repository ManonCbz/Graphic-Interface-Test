package Banque;
import java.util.ArrayList;

public class Client {
	
	private String nom;
	private String prenom;
	private String motDePasse;
	private ArrayList<CompteBancaire> compteBancaire = new ArrayList<CompteBancaire>();
	private ArrayList<CompteEpargne> compteEpargne = new ArrayList<CompteEpargne>();
	
	public Client(String prenom, String nom, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public ArrayList<CompteBancaire> getCompteBancaire() {
		return compteBancaire;
	}
	
	public void setCompteBancaire(ArrayList<CompteBancaire> compteBancaire) {
		this.compteBancaire = compteBancaire;
	}
	
	public ArrayList<CompteEpargne> getCompteEpargne() {
		return compteEpargne;
	}
	
	public void setCompteEpargne(ArrayList<CompteEpargne> compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
}
