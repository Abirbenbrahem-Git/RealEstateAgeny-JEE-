package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idres;

	@Temporal(TemporalType.DATE)
	private Date datearrive;

	@Temporal(TemporalType.DATE)
	private Date datedepart;

	//bi-directional many-to-one association to Clientimmo
	@ManyToOne
	@JoinColumn(name="idClient")
	private Clientimmo clientimmo;

	//bi-directional many-to-one association to Immobilier
	@ManyToOne
	@JoinColumn(name="idimmobilier")
	private Immobilier immobilier;

	public Reservation() {
	}

	public int getIdres() {
		return this.idres;
	}

	public void setIdres(int idres) {
		this.idres = idres;
	}

	public Date getDatearrive() {
		return this.datearrive;
	}

	public void setDatearrive(Date datearrive) {
		this.datearrive = datearrive;
	}

	public Date getDatedepart() {
		return this.datedepart;
	}

	public void setDatedepart(Date datedepart) {
		this.datedepart = datedepart;
	}

	public Clientimmo getClientimmo() {
		return this.clientimmo;
	}

	public void setClientimmo(Clientimmo clientimmo) {
		this.clientimmo = clientimmo;
	}

	public Immobilier getImmobilier() {
		return this.immobilier;
	}

	public void setImmobilier(Immobilier immobilier) {
		this.immobilier = immobilier;
	}

}