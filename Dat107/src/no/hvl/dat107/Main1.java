package no.hvl.dat107;



public class Main1 {

    public static void main(String[] args) {
    	
    	AvdelingDAO AvdelingDAO = new AvdelingDAO();
    	AnsattDAO AnsattDAO = new AnsattDAO();
    	
    	
    	Avdeling avdeling = AvdelingDAO.finnAvdelingMedId(1);
    	
    	avdeling.skrivUtAnsattListe();
    	
    	
    	//AnsattDAO.oppdaterLonn(1, BigDecimal.valueOf(10,00));
    	
    	//AnsattDAO.oppdaterStilling(1, "Test");
    	
    	//AvdelingDAO.leggeTilNyAvdeling("bla", AnsattDAO.finnAnsattMedId(6));
    	
    	
    	//Ansatt ansatt = AnsattDAO.finnAnsattMedBrukernavn("nn");
    	
    	
    	//Avdeling avdeling = AvdelingDAO.finnAvdelingMedId(3);
    	
    	
    	//AnsattDAO.oppdaterAvdeling(6, avdeling);
    	
    	//System.out.println(AvdelingDAO.erSjef(ansatt));
    	
    	
    	// AvdelingDAO.oppdaterSjef(2, AnsattDAO.finnAnsattMedBrukernavn("na"));
    	
    	
    	
		/*
		 * Ansatt ansatt1 = AnsattDAO.finnAnsattMedId(1);
		 * 
		
		 * 
		 * 
		 * Avdeling avdeling = new Avdeling(); avdeling =
		 * AvdelingDAO.finnAvdelingMedId(2);
		 * 
		 * AnsattDAO.oppdaterAvdeling(1, avdeling);
		 * 
		 * 
		 * System.out.println(ansatt1);
		 */
    	
		/*
		 * Avdeling avdeling1 = AvdelingDAO.finnAvdelingMedId(1); Avdeling avdeling2 =
		 * AvdelingDAO.finnAvdelingMedId(2); Avdeling avdeling3 =
		 * AvdelingDAO.finnAvdelingMedId(3); Avdeling avdeling4 =
		 * AvdelingDAO.finnAvdelingMedId(3);
		 * 
		 * 
		 * Ansatt kontorsjef = AnsattDAO.finnAnsattMedId(6); Ansatt renholdsjef =
		 * AnsattDAO.finnAnsattMedId(7); Ansatt transportsjef =
		 * AnsattDAO.finnAnsattMedId(8); Ansatt lagersjef =
		 * AnsattDAO.finnAnsattMedId(9);
		 * 
		 * 
		 * 
		 * AvdelingDAO.oppdaterSjef(1, kontorsjef); AvdelingDAO.oppdaterSjef(2,
		 * renholdsjef); AvdelingDAO.oppdaterSjef(3, transportsjef);
		 * AvdelingDAO.oppdaterSjef(4, lagersjef);
		 */
    	
    	
    	//Ansatt ansatt3 = new Ansatt("nb","Nora","Bakk",LocalDate.now(),"Sjef", 2202200,avdeling1,"prosjekt1");
    	//Ansatt ansatt4 = new Ansatt("nb","Nora","Bakk",LocalDate.now(),"Sjef", 2202200,avdeling1,"prosjekt1");
    	//Ansatt ansatt5 = new Ansatt("nb","Nora","Bakk",LocalDate.now(),"Sjef", 2202200,avdeling1,"prosjekt1");
    	
    	//AnsattDAO.leggTilAnsatt(ansatt3);
    	
    	//System.out.println(ansatt3.getAvdeling());
    	
    	//AnsattDAO.oppdaterAvdeling(1, avdeling3);
    	
    	//Ansatt fredrik = AnsattDAO.finnAnsattMedId(1);
    	
    	//AvdelingDAO.oppdaterSjef(1, fredrik);
    	
    	
    	//AnsattDAO.skrivUtAnsatte();
    	//Avdeling p = AvdelingDAO.finnAvdelingMedId(1);
    	//System.out.println(p);
    	
    	
    }

   

}
