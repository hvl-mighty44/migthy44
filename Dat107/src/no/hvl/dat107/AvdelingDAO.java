package no.hvl.dat107;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingDAO {

	private EntityManagerFactory emf;

	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	}

	public Avdeling finnAvdelingMedId(int avdeling_id) {

		EntityManager em = emf.createEntityManager();

		Avdeling p = null;

		try {
			p = em.find(Avdeling.class, avdeling_id);

		} finally {
			em.close();
		}

		return p;
	}

	public void oppdaterSjef(int avdeling_id, Ansatt sjef) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		String navn = "";
		Avdeling avdeling = null;

		try {
			tx.begin();

			navn = sjef.getFornavn() + " " + sjef.getEtternavn();
			avdeling = finnAvdelingMedId(avdeling_id);

			if (navn != "") {

				// Dette gjorde vi sist gang, altså antar at karakteren ikke finnes.

				avdeling.setSjef(navn);

				em.merge(avdeling);

			} else {
				System.out.println("Klarte ikke å oppdatere sjef");
			}

			tx.commit();

		} catch (Throwable e) {
			if (tx.isActive()) {
				tx.rollback();

			}

		} finally {
			em.close();
		}

	}

	public boolean erSjef(Ansatt ansatt) {

		boolean svar = false;

		String tekst = ansatt.getFulltNavn();

		EntityManager em = emf.createEntityManager();

		Avdeling resultat = new Avdeling();

		try {
			TypedQuery<Avdeling> query = em.createQuery("SELECT t FROM Avdeling t WHERE t.sjef LIKE :tekst",
					Avdeling.class);
			query.setParameter("tekst", tekst);
			resultat = query.getSingleResult();

			if (resultat != null) {
				svar = true;
			}

		} catch (NoResultException e) {
			// e.printStackTrace();

		} finally {
			em.close();
		}

		return svar;

	}
	
	public void leggeTilNyAvdeling(String avdelingsnavn, Ansatt sjef) {
		
		
		
	
		EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        Avdeling avdeling = new Avdeling(avdelingsnavn);
	        avdeling.setSjef(sjef.getFulltNavn());
	        sjef.setAvdeling(avdeling);
	        em.persist(avdeling);
	        em.merge(sjef);
	        tx.commit();
	    } catch (Throwable e) {
	        e.printStackTrace();
	        tx.rollback();
	    } finally {
	        em.close();
	    }
		
	}

}
