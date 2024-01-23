package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientimmo database table.
 * 
 */
@Entity
@NamedQuery(name="Clientimmo.findAll", query="SELECT c FROM Clientimmo c")
public class Clientimmo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClient;

	private int CINClient;

	private String mailClient;

	private String mdpClient;

	private String nomClient;

	private String prenomClient;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="clientimmo", fetch=FetchType.EAGER)
	private List<Reservation> reservations;

	public Clientimmo() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getCINClient() {
		return this.CINClient;
	}

	public void setCINClient(int CINClient) {
		this.CINClient = CINClient;
	}

	public String getMailClient() {
		return this.mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	public String getMdpClient() {
		return this.mdpClient;
	}

	public void setMdpClient(String mdpClient) {
		this.mdpClient = mdpClient;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return this.prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setClientimmo(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setClientimmo(null);

		return reservation;
	}

}