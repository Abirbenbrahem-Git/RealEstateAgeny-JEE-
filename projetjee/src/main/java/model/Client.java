package model;

public class Client {
	public Client(int numCli, String nomCli, String ville, String catégorie, double compte) {
		super();
		NumCli = numCli;
		NomCli = nomCli;
		Ville = ville;
		Catégorie = catégorie;
		Compte = compte;
	}
	public int NumCli;
	public String NomCli;
	public String Ville;
	public String Catégorie;
	public double Compte;
}
