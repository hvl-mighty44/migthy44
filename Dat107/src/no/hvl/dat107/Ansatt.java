package no.hvl.dat107;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(schema = "ovelse3_jpa")
public class Ansatt {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ansatt_id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private java.time.LocalDate ansettelse;
	private String stilling;
	private BigDecimal lonn; //Endre format
	
	@ManyToOne
	@JoinColumn(name = "avdeling_id", referencedColumnName = "avdeling_id")
	private Avdeling avdeling;
	
	//private String prosjekter; //Liste?
	
	@OneToMany(mappedBy="ansatt", fetch = FetchType.EAGER)
    private List<Prosjektdeltagelse> deltagelser;

	
	public Ansatt() {}
	
	public Ansatt(String brukernavn, String fornavn, String etternavn, Avdeling avdeling) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		ansettelse = LocalDate.now();
		this.avdeling = avdeling;
	}
	
	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansettelse, String stillling, BigDecimal lonn, Avdeling avdeling) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelse = ansettelse;
		this.stilling = stillling;
		this.lonn = lonn;
		this.avdeling = avdeling;
		this.deltagelser = null;
	}

	@Override
	public String toString() {
		return "Ansatt [id=" + ansatt_id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", ansettelse=" + ansettelse + ", stillling=" + stilling + ", lonn=" + lonn + ", avdeling="
				+ avdeling + ", prosjekter=" + "" + "]\n";
	}
//
//	public void skrivUt(String innrykk) {
//        System.out.printf("%sAnsatt nr %d: %s %s", innrykk, ansatt_id, fornavn, etternavn);
//    }
	
	 public void skrivUtMedProsjekter() {
	       // System.out.println();
	       // skrivUt("");
	        deltagelser.forEach(p -> p.skrivUt(""));
		 
	    }
	
	public String ansattTabellUtskrift() {

        return "Ansatt ID : " + this.getId() + "\n" + "Navn : " + this.getFulltNavn() + "\n" + "Stilling : " + this.getStillling()
                + " " + "\n";

    }
	
	
	public String fullAnsattUtskrift() {
		
	
		
        return "Ansatt ID : " + this.getId() + "\n" +  "Fornavn : "
                + this.getFornavn() + "\n" + "Etternavn : " + this.getEtternavn() + "\n" + "Ansettelses Tidspunkt : "
                + this.getAnsettelse() + "\n" + "Stilling : " + this.getStillling() + "\n" + "Lønn : " + this.getLonn() + " Kr"
                + "\n" + "Avdeling : " + this.getAvdeling().getAvdeling_navn() + "\n" + "Prosjekter : " + deltagelser.toString() + "\n";

    }
	
	
	public Integer getId() {
		return ansatt_id;
	}

	public void setId(Integer id) {
		this.ansatt_id = id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public String getFulltNavn() {
		return this.fornavn + " " + this.etternavn;
	}

	public java.time.LocalDate getAnsettelse() {
		return ansettelse;
	}

	public void setAnsettelse(java.time.LocalDate ansettelse) {
		this.ansettelse = ansettelse;
	}

	public String getStillling() {
		return stilling;
	}

	public void setStillling(String stillling) {
		this.stilling = stillling;
	}

	public BigDecimal getLonn() {
		return lonn;
	}

	public void setLonn(BigDecimal lonn) {
		this.lonn = lonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	public List<Prosjektdeltagelse> getProsjekter() {
		return deltagelser;
	}

	public void setProsjekter(List<Prosjektdeltagelse> deltagelser) {
		this.deltagelser = deltagelser;
	}

	
	
	   public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
	        deltagelser.add(prosjektdeltagelse);
	    }

	    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
	        deltagelser.remove(prosjektdeltagelse);
	    }
	
	
}