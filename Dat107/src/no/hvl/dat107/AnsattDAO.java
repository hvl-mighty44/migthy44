package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {

	private EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	}

	public Ansatt finnAnsattMedId(int ansatt_id) {

		EntityManager em = emf.createEntityManager();

		Ansatt p = null;

		try {
			p = em.find(Ansatt.class, ansatt_id);

		} finally {
			em.close();
		}

		return p;
	}

	
	public Ansatt finnAnsattMedBrukernavn(String tekst) {
		
		EntityManager em = emf.createEntityManager();

		Ansatt p = null;

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t WHERE t.brukernavn LIKE :tekst", Ansatt.class);
			query.setParameter("tekst", tekst);
			p =  query.getSingleResult();

		} catch (NoResultException e) {
            // e.printStackTrace();
        } 
		finally {
			em.close();
		}

		return p;
		
	}
	
	
public void skrivUtAnsatte() {
		
		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t ", Ansatt.class);
			
			System.out.println(query.getResultList());

		} catch (NoResultException e) {
            // e.printStackTrace();
        } 
		finally {
			em.close();
		}

	}
	

public void oppdaterStilling(int id, String stilling) {
	
	EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    Ansatt k = null;
    
    try {
        tx.begin();
        
        k = finnAnsattMedId(id); //NB! Detached
        		
        if (k != null) {
        	
    
        	
        	
        	k.setStillling(stilling);
        	

            em.merge(k);
           
        	
        } else {
        	System.out.println("Fant ingen ansatt med id: " + id );
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


public void oppdaterStillingOgLonn(int id, String stilling, int lonn) {
	
	EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    Ansatt k = null;
    
    try {
        tx.begin();
        
        k = finnAnsattMedId(id); //NB! Detached
        		
        if (k != null) {
        	
        	
        	k.setStillling(stilling);
        	k.setLonn(lonn);
        	

            em.merge(k);
           
        	
        } else {
        	System.out.println("Fant ingen ansatt med id: " + id );
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



public void oppdaterLonn(int id, int lonn) {
	
	EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    Ansatt k = null;
    
    try {
        tx.begin();
        
        k = finnAnsattMedId(id); //NB! Detached
        		
        if (k != null) {
        	
        	
        	
        	
        	k.setLonn(lonn);
        	

            em.merge(k);
           
        	
        } else {
        	System.out.println("Fant ingen ansatt med id: " + id );
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


public void leggTilAnsatt(Ansatt a) {
	
	EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
        tx.begin();
        em.persist(a);
        tx.commit();
    } catch (Throwable e) {
        e.printStackTrace();
        tx.rollback();
    } finally {
        em.close();
    }
	
	
}

public void oppdaterAvdeling(int id, Avdeling avdeling) {
	
	EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    Ansatt k = null;
    AvdelingDAO AvdelingDAO = new AvdelingDAO();
    
    try {
        tx.begin();
        
        k = finnAnsattMedId(id); //NB! Detached
        
        
        
        
        if (k != null && !AvdelingDAO.erSjef(k)) {
        	
        	// Dette gjorde vi sist gang, altså antar at karakteren ikke finnes.
        	
        	
        	k.setAvdeling(avdeling);
        	

            em.merge(k);
           
        	
        } else if( k == null) {
        	System.out.println("Fant ingen ansatt med id: " + id );
        } else if( AvdelingDAO.erSjef(k)) {
        	System.out.println("En sjef kan ikke bytte avdeling");
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


	
}//Slutt klasse
