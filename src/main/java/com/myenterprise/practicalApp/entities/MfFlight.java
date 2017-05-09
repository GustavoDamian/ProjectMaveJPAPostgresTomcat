package com.myenterprise.practicalApp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

/**
 * The persistent class for the mf_customer_flight database table.
 * 
 */
@Entity
@Table(name = "mf_customer_flight")
@NamedQuery(name = "MfCustomerFlight.findAll", query = "SELECT m FROM MfFlight m")
public class MfFlight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "flight_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_flight_id")
	@SequenceGenerator(name = "seq_flight_id", sequenceName = "seq_flight_id", allocationSize = 1)
	@Basic(optional = false)
	private Integer flightId;

	@Column(name = "flight_date_registered")
	private Timestamp flightDateRegistered;

	@Temporal(TemporalType.DATE)
	@Column(name = "flight_datetravel")
	private Date flightDatetravel;

	@Column(name = "flight_destination")
	private String flightDestination;

	@Column(name = "flight_name")
	private String flightName;

	@Column(name = "flight_status")
	private String flightStatus;

	public MfFlight() {
	}

	public MfFlight(MfFlight mfFlight) {
		this.flightId = mfFlight.flightId;
		this.flightDateRegistered = mfFlight.flightDateRegistered;
		this.flightDatetravel = mfFlight.flightDatetravel;
		this.flightDestination = mfFlight.flightDestination;
		this.flightName = mfFlight.flightName;
		this.flightStatus = mfFlight.flightStatus;
	}

	public Integer getFlightId() {
		return this.flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public Timestamp getFlightDateRegistered() {
		return this.flightDateRegistered;
	}

	public void setFlightDateRegistered(Timestamp flightDateRegistered) {
		this.flightDateRegistered = flightDateRegistered;
	}

	public Date getFlightDatetravel() {
		return this.flightDatetravel;
	}

	public void setFlightDatetravel(Date flightDatetravel) {
		this.flightDatetravel = flightDatetravel;
	}

	public String getFlightDestination() {
		return this.flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public String getFlightName() {
		return this.flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightStatus() {
		return this.flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MfFlight other = (MfFlight) obj;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		return true;
	}

}