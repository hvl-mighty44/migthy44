package no.hvl.dat107;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;



@Entity
@Table(schema = "ovelse3_jpa")
public class Prosjektdeltagelse {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektdeltagelse_id;
	private String rolle;
	private int timer;
	
	@ManyToOne
    @JoinColumn(name="ansatt_Id")
    private Ansatt ansatt;
    
    @ManyToOne
    @JoinColumn(name="prosjekt_Id")
    private Prosjekt prosjekt;
	
    
public Prosjektdeltagelse() {}
    
    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt,String rolle, int timer) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.rolle = rolle;
        this.timer = timer;
       
        
        ansatt.leggTilProsjektdeltagelse(this);
        prosjekt.leggTilProsjektdeltagelse(this);
    }
    
    @Override
    public String toString() {
    	
    	
    	return prosjektInfo();
    }

	
	public String prosjektInfo() {
		return "Prosjektnavn: " + prosjekt.getProsjekt_navn() + " Antall timer: " + timer;
	}
	
	public String deltagere() {
		return "Ansatt id: " + ansatt.getId() +", Navn: " + ansatt.getFulltNavn() + ", Rolle: " + this.getRolle() + ", Timer: " + this.getTimer() +  " ";
	}
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s, %d timer", innrykk, 
                prosjekt.getProsjekt_navn(), timer);
    }
		
    
  

	public int getProsjektdeltagelse_id() {
		return prosjektdeltagelse_id;
	}

	public void setProsjektdeltagelse_id(int prosjektdeltagelse_id) {
		this.prosjektdeltagelse_id = prosjektdeltagelse_id;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = this.timer + timer;
	}

	public Ansatt getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(Ansatt ansatt) {
		this.ansatt = ansatt;
	}

	public Prosjekt getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(Prosjekt prosjekt) {
		this.prosjekt = prosjekt;
	}
   

    
    
}
