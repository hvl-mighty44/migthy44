package no.hvl.dat107;

import java.util.Iterator;
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
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdeling_id;
	private String avdeling_navn;
	private String sjef;

	@OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
	private List<Ansatt> ansatte;

	public Avdeling() {
	}

	public Avdeling(String avdeling_navn) {

		this.avdeling_navn = avdeling_navn;
		sjef = null;

	}

	public void skrivUtAnsattListe() {

		Iterator<Ansatt> iterator = ansatte.iterator();
		System.out.println("Avdeling : " + avdeling_navn);
		System.out.println("Sjef : " + sjef + "\n");
		while (iterator.hasNext()) {
		System.out.println(iterator.next().ansattTabellUtskrift());

		}

	}

	public int getAvdeling_id() {
		return avdeling_id;
	}

	public String getAvdeling_navn() {
		return avdeling_navn;
	}

	public void setAvdeling_navn(String avdeling_navn) {
		this.avdeling_navn = avdeling_navn;
	}

	public String getSjef() {
		return sjef;
	}

	public void setSjef(String sjef) {
		this.sjef = sjef;
	}

	@Override
	public String toString() {
		return "Avdeling [avdeling_id=" + avdeling_id + ", avdeling_navn=" + avdeling_navn + ", sjef=" + sjef + "]";
	}

}
