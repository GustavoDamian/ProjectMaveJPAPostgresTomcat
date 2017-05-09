package com.myenterprise.practicalApp.api;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/***
 * @author Gustavo Damian
 * @date 07/05/2017
 */
public final class Utilitario {
	private static Utilitario instancia;

	private Utilitario() {
	}

	/**
	 * @return el instancia
	 */
	public static Utilitario getInstancia() {
		if (instancia == null) {
			instancia = new Utilitario();
		}
		return instancia;
	}

	@SuppressWarnings("unused")
	public static Timestamp getFechaActual() {
		java.util.Date utilDate = new java.util.Date();
		long lnMilisegundos = utilDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
		java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
		return sqlTimestamp;
	}

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constante.PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		return em;
	}

}
