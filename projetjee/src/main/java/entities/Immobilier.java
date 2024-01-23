package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the immobilier database table.
 * 
 */
@Entity
@NamedQuery(name="Immobilier.findAll", query="SELECT i FROM Immobilier i")
public class Immobilier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idimmobilier;

	private String description;

	private int prix;

	private String type;

	//bi-directional many-to-one association to Proprietaire
	@ManyToOne
	@JoinColumn(name="idProprietaire")
	private Proprietaire proprietaire;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="immobilier", fetch=FetchType.EAGER)
	private List<Reservation> reservations;

	public Immobilier() {
	}

	public int getIdimmobilier() {
		return this.idimmobilier;
	}

	public void setIdimmobilier(int idimmobilier) {
		this.idimmobilier = idimmobilier;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Proprietaire getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setImmobilier(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setImmobilier(null);

		return reservation;
	}

}