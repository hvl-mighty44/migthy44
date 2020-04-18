package no.hvl.dat107;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


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
	 
	
	    
	    public void leggeTilNyttProsjekt(String prosjekt_navn, String beskrivelse) {
			
			
			
	    	
			EntityManager em = emf.createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    try {
		        tx.begin();
		        Prosjekt prosjekt = new Prosjekt(prosjekt_navn, beskrivelse);
		        em.persist(prosjekt);
		        tx.commit();
		    } catch (Throwable e) {
		        e.printStackTrace();
		        tx.rollback();
		    } finally {
		        em.close();
		    }
			
		}
	    

	    public void skrivUtProsjekt(int prosjekt_id) {
	    	
	    	
	    	System.out.println(finnProsjektMedId(prosjekt_id));
	    	
	    }
		
	
}
