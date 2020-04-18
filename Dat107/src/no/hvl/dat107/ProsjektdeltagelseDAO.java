package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektdeltagelseDAO {

	private EntityManagerFactory emf;

	public ProsjektdeltagelseDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	}

	public Prosjektdeltagelse finnProsjektdeltagelse(int id) {

		EntityManager em = emf.createEntityManager();

		Prosjektdeltagelse prosjekt = null;
		try {
			prosjekt = em.find(Prosjektdeltagelse.class, id);
		} finally {
			em.close();
		}
		return prosjekt;
	}

	public void leggeTilNyProsjektdeltagelse(int ansatt_id, int prosjekt_id, String rolle) {

		AnsattDAO AnsattDAO = new AnsattDAO();
		ProsjektDAO ProsjektDAO = new ProsjektDAO();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Prosjektdeltagelse prosjektdeltagelse = new Prosjektdeltagelse(AnsattDAO.finnAnsattMedId(ansatt_id),
					ProsjektDAO.finnProsjektMedId(prosjekt_id), rolle, 0);

			em.persist(prosjektdeltagelse);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

	}

	public void leggeTilTimerMedProsjektdeltagelseId(int id, int timer) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Prosjektdeltagelse prosjektdeltagelse = finnProsjektdeltagelse(id);
			prosjektdeltagelse.setTimer(timer);

			em.merge(prosjektdeltagelse);

			tx.commit();

		} catch (Throwable e) {
			if (tx.isActive()) {
				tx.rollback();

			}

		} finally {
			em.close();
		}

	}
	
	
	

}// Slutt
