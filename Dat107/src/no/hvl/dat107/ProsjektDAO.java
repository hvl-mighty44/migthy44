package no.hvl.dat107;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ProsjektDAO {

	
	   private EntityManagerFactory emf;

	    public ProsjektDAO() {
	        emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	    }

	    public Prosjekt finnProsjektMedId(int id) {

	        EntityManager em = emf.createEntityManager();

	        Prosjekt prosjekt = null;
	        try {
	            prosjekt = em.find(Prosjekt.class, id);
	        } finally {
	            em.close();
	        }
	        return prosjekt;
	    }
	
	
}
