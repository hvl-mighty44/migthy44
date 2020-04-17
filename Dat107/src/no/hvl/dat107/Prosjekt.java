package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(schema = "ovelse3_jpa")
public class Prosjekt {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjekt_id;
	private String prosjekt_navn;
	private String beskrivelse;
	
	
	@OneToMany(mappedBy="prosjekt", fetch = FetchType.EAGER)
    private List<Prosjektdeltagelse> deltagelser;
	
	 public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
	        deltagelser.add(prosjektdeltagelse);
	    }

	    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
	        deltagelser.remove(prosjektdeltagelse);
	    }
	    

	    
	    
	    public Prosjekt() {};
	    
		public Prosjekt(String prosjekt_navn, String beskrivelse, List<Prosjektdeltagelse> deltagelser) {
			super();
			this.prosjekt_navn = prosjekt_navn;
			this.beskrivelse = beskrivelse;
			this.deltagelser = deltagelser;
		}

		public String getProsjekt_navn() {
			return prosjekt_navn;
		}

		public void setProsjekt_navn(String prosjekt_navn) {
			this.prosjekt_navn = prosjekt_navn;
		}

		public String getBeskrivelse() {
			return beskrivelse;
		}

		public void setBeskrivelse(String beskrivelse) {
			this.beskrivelse = beskrivelse;
		}

		public List<Prosjektdeltagelse> getDeltagelser() {
			return deltagelser;
		}

		public void setDeltagelser(List<Prosjektdeltagelse> deltagelser) {
			this.deltagelser = deltagelser;
		}

		@Override
		public String toString() {
			return "Prosjekt [prosjekt_id=" + prosjekt_id + ", prosjekt_navn=" + prosjekt_navn + ", beskrivelse="
					+ beskrivelse + ", deltagelser=" + deltagelser + "]";
		}
	
		
		
	
}//Slutt klasse
