package com.myenterprise.practicalApp.persistencia;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.myenterprise.practicalApp.entities.MfFlight;

/***
 * @author Gustavo Damian
 * @date 07/05/2017
 */
public class TestConexion {

	public static void main(String[] args) {
		System.out.println("Prueba");

		String persistenceUnitName = "practicalApp";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();

		java.util.Date utilDate = new java.util.Date(); // fecha actual
		long lnMilisegundos = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
		java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);

		em.getTransaction().begin();
		MfFlight mfFlight = new MfFlight();
		// mfFlight.setFlightId(3); //el id es generado por la secuancia de la db
		mfFlight.setFlightName("xxxxx");
		mfFlight.setFlightDestination("Miami");
		mfFlight.setFlightDatetravel(new Date());
		mfFlight.setFlightDateRegistered(sqlTimestamp);
		mfFlight.setFlightStatus("NEW");
		em.persist(mfFlight);
		em.getTransaction().commit();
		em.close();

		//TODO: Habilitar para realizar prueba de  actualizacion
		/*
		 * MfFlight mfFlight = new MfFlight(); mfFlight.setFlightId(3);
		 * mfFlight.setFlightName("XX");
		 * mfFlight.setFlightDestination("destinos");
		 * mfFlight.setFlightDatetravel(new Date());
		 * mfFlight.setFlightDateRegistered(sqlTimestamp);
		 * mfFlight.setFlightStatus("update");
		 * Query q =
		 * em.createQuery("SELECT e from MfFlight e WHERE e.flightId = :id").
		 * setParameter("id", mfFlight.getFlightId());
		 * MfFlight mFlightOld = new MfFlight((MfFlight) q.getSingleResult());
		 * em.getTransaction().begin();
		 * mFlightOld.setFlightStatus(mfFlight.getFlightStatus());
		 * em.merge(mFlightOld); em.getTransaction().commit(); em.close();
		 */

	}

}
