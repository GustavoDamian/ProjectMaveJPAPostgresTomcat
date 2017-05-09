package com.myenterprise.practicalApp.core;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.myenterprise.practicalApp.api.Constante;
import com.myenterprise.practicalApp.api.Utilitario;
import com.myenterprise.practicalApp.entities.MfFlight;

/***
 * @author Gustavo Damian
 * @date  07/05/2017
 */
@ManagedBean(name = "approveAplicattionService")
@ViewScoped
public class ApproveAplicattionService implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<MfFlight> getFlightCustomer() {
		EntityManager em = Utilitario.getEntityManager();
		Query query = em.createQuery("SELECT e FROM MfFlight e ORDER BY e.flightDateRegistered ASC");
		return (List<MfFlight>) query.getResultList();
	}

	public void updateFlightCustomer(MfFlight mfFlight) {

		EntityManager em = Utilitario.getEntityManager();
		Query q = em.createQuery("SELECT e from MfFlight e WHERE e.flightId = :id").setParameter("id",
				mfFlight.getFlightId());

		MfFlight mFlightOld = new MfFlight((MfFlight) q.getSingleResult());
		em.getTransaction().begin();
		mFlightOld.setFlightStatus(Constante.RESERVED);
		em.merge(mFlightOld);
		em.getTransaction().commit();
		em.close();
	}

	public void inserFlightCustomer(MfFlight mfFlight) {
		EntityManager em = Utilitario.getEntityManager();
		em.getTransaction().begin();
		mfFlight.setFlightDateRegistered(Utilitario.getFechaActual());
		mfFlight.setFlightStatus(Constante.NEW);
		em.persist(mfFlight);
		em.getTransaction().commit();
		em.close();
	}

}
