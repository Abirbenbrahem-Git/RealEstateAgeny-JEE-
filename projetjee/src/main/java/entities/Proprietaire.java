package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proprietaire database table.
 * 
 */
@Entity
@NamedQuery(name="Proprietaire.findAll", query="SELECT p FROM Proprietaire p")
public class Proprietaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProprietaire;

	private int cinp;

	private String mailP;

	private String mdpP;

	private String nomP;

	private String prenomP;

	//bi-directional many-to-one association to Immobilier
	@OneToMany(mappedBy="proprietaire", fetch=FetchType.EAGER)
	private List<Immobilier> immobiliers;

	public Proprietaire() {
	}

	public int getIdProprietaire() {
		return this.idProprietaire;
	}

	public void setIdProprietaire(int idProprietaire) {
		this.idProprietaire = idProprietaire;
	}

	public int getCinp() {
		return this.cinp;
	}

	public void setCinp(int cinp) {
		this.cinp = cinp;
	}

	public String getMailP() {
		return this.mailP;
	}

	public void setMailP(String mailP) {
		this.mailP = mailP;
	}

	public String getMdpP() {
		return this.mdpP;
	}

	public void setMdpP(String mdpP) {
		this.mdpP = mdpP;
	}

	public String getNomP() {
		return this.nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public String getPrenomP() {
		return this.prenomP;
	}

	public void setPrenomP(String prenomP) {
		this.prenomP = prenomP;
	}

	public List<Immobilier> getImmobiliers() {
		return this.immobiliers;
	}

	public void setImmobiliers(List<Immobilier> immobiliers) {
		this.immobiliers = immobiliers;
	}

	public Immobilier addImmobilier(Immobilier immobilier) {
		getImmobiliers().add(immobilier);
		immobilier.setProprietaire(this);

		return immobilier;
	}

	public Immobilier removeImmobilier(Immobilier immobilier) {
		getImmobiliers().remove(immobilier);
		immobilier.setProprietaire(null);

		return immobilier;
	}

}