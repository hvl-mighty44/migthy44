package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



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

	
	/*
	 * @Override public String toString() { return
	 * "Prosjektdeltagelse [prosjektdeltagelse_id=" + prosjektdeltagelse_id +
	 * ", rolle=" + rolle + ", timer=" + timer + ", ansatt=" + ansatt +
	 * ", prosjekt=" + prosjekt + "]"; }
	 */
	 
    @Override public String toString() {
    	return "Prosjekt: " + prosjekt + " Rolle: ";
    }
   
    
}
