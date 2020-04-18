package no.hvl.dat107;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Meny {

	AvdelingDAO AvdelingDAO = new AvdelingDAO();
	AnsattDAO AnsattDAO = new AnsattDAO();
	ProsjektDAO ProsjektDAO = new ProsjektDAO();
	ProsjektdeltagelseDAO ProsjektdeltagelseDAO = new ProsjektdeltagelseDAO();

	Scanner leser = new Scanner(System.in);

	String skille = "------------------------------------------------";

	public void start() {
		int svar;
		int status = 0;
		while (status == 0) {
			System.out.println(skille);
			System.out.println("Trykk [1]  for å søke etter ansatt");
			System.out.println("Trykk [2]  for å skrive ut alle ansatte");
			System.out.println("Trykk [3]  for å oppdatere en ansatt");
			System.out.println("Trykk [4]  for å bytte avdeling");
			System.out.println("Trykk [5]  for å legge til en ansatt");
			System.out.println("Trykk [6]  for å søke etter en avdeling");
			System.out.println("Trykk [7]  for å legge inn en ny avdeling");
			System.out.println("Trykk [8]  for å legge inn en ett nytt prosjekt");
			System.out.println("Trykk [9]  for å registrere prosjektdeltagelse");
			System.out.println("Trykk [10] for å føre timer for en ansatt på et prosjekt");
			System.out.println("Trykk [11] for å skrive ut et prosjekt");
			System.out.println("Trykk [0]  for å avslutte");
			System.out.println(skille);
			
		
	
			svar = leser.nextInt();

			
			if (svar == 1) {

				
				System.out.println(skille);
				System.out.println("Trykk [1] for å søke med ansatt ID");
				System.out.println("Trykk [2] for å søke med brukernavn");
				System.out.println(skille);
				
				int id = leser.nextInt();
				
				if(id == 1) {
					System.out.println(skille);
				  System.out.println("Skriv inn ansatt ID"); 
				  System.out.println(skille);
				  int id1 = leser.nextInt();
				  System.out.println(skille);
				  System.out.println(AnsattDAO.finnAnsattMedId(id1).fullAnsattUtskrift());
				} else if(id == 2) {
					System.out.println(skille);
					System.out.println("Skriv inn brukernavn");
					System.out.println(skille);
					String bruk = leser.next() + leser.nextLine();
					System.out.println(skille);
					System.out.println(AnsattDAO.finnAnsattMedBrukernavn(bruk).fullAnsattUtskrift());
					
					
				}
				
			} else if (svar == 0) { 
				status = 1; } else if(svar == 2) {
					AnsattDAO.skrivUtAnsatte();
				}else if(svar == 3) {
					System.out.println(skille);
					System.out.println("Trykk [1] for å oppdatere stilling");
					System.out.println("Trykk [2] for å oppdatere lønn");
					System.out.println("Trykk [3] for å oppdatere lønn og stilling");
					System.out.println(skille);
					
					int n = -1;
					int lonn = -1;
					String svar2 = null;
					int id3 = leser.nextInt();
					
					if(id3 == 1) {
						System.out.println("Skriv inn id til den ansatte du vil endre stilling til");
						n = leser.nextInt();
						System.out.println("Skriv inn den nye stillingen");
						svar2 = leser.next();
					
						AnsattDAO.oppdaterStilling(n, svar2);
						System.out.println("Oppdatert");
					} else if(id3 == 2) {
						
						System.out.println("Skriv inn id til den ansatte du vil endre stilling til");
						n = leser.nextInt();
						System.out.println("Skriv inn den nye lønnen");
						
						lonn = leser.nextInt();
					
						AnsattDAO.oppdaterLonn(n, BigDecimal.valueOf(lonn));
						System.out.println("Oppdatert");
						
					} else if(id3 == 4) {
						System.out.println("Skriv inn id til den ansatte du vil endre stilling til");
						n = leser.nextInt();
						System.out.println("Skriv inn den nye stillingen");
						svar2 = leser.next() + leser.nextLine();
						System.out.println("Skriv inn den nye lønnen");
						lonn = leser.nextInt();
						
						AnsattDAO.oppdaterStillingOgLonn(n, svar2, BigDecimal.valueOf(lonn));
						System.out.println("Oppdatert");
						
					} 
				} else if(svar == 5) {
					
					System.out.println("Skriv inn brukernavn");
					String brukernavn = leser.next() + leser.nextLine();
					System.out.println("Skriv inn fornavn");
					String fornavn = leser.next() + leser.nextLine();
					System.out.println("Skriv inn etternavn");
					String etternavn = leser.next() + leser.nextLine();
					System.out.println("Skriv inn avdeling id");
					int avdeling = leser.nextInt();
					System.out.println("Skriv inn stilling");
					String stilling = leser.next() + leser.nextLine();
					System.out.println("Skriv inn lønn");
					int lonn = leser.nextInt();
					System.out.println("Skriv inn prosjekt id");
					int prosjekt_id = leser.nextInt();
					System.out.println("Skriv inndin rolle");
					String rolle = leser.next() + leser.nextLine();
					
					// public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt,String rolle, int timer) 
					
					
					
					
					Ansatt a = new Ansatt(brukernavn,fornavn,etternavn,LocalDate.now(),stilling, BigDecimal.valueOf(lonn), AvdelingDAO.finnAvdelingMedId(avdeling));
					
					Prosjektdeltagelse Prosjektdeltagelse = new Prosjektdeltagelse(a,ProsjektDAO.finnProsjektMedId(prosjekt_id),rolle,0);
					
					
					AnsattDAO.leggTilAnsatt(a);
					
					System.out.println("Oppdatert");
					
					
				} else if(svar == 6) {
					
					System.out.println("Skriv inn avdelings ID");
					int avd = leser.nextInt();
					
					
					AvdelingDAO.finnAvdelingMedId(avd).skrivUtAnsattListe();
					
				}else if(svar == 4) {
					
					System.out.println("Skriv inn ansatt ID");
					int id4 = leser.nextInt();
					System.out.println("Skriv inn det nye avdelings nummeret");
					int avd4 = leser.nextInt();
					
					Ansatt ansatt = AnsattDAO.finnAnsattMedId(id4);
					
					AnsattDAO.oppdaterAvdeling(id4, AvdelingDAO.finnAvdelingMedId(avd4));
					
					if(!AvdelingDAO.erSjef(ansatt)){
					System.out.println("Oppdatert");
					}
					
				} else if(svar == 7) {
					
					System.out.println("Skriv inn det nye avdelings navnet");
					String avd7 = leser.next() + leser.nextLine();
					System.out.println("Skriv inn ID til den nye sjefen");
					int id7 = leser.nextInt();
					
					AvdelingDAO.leggeTilNyAvdeling(avd7, AnsattDAO.finnAnsattMedId(id7));
					System.out.println("Oppdatert");
					
				} else if(svar == 8) {
					
					System.out.println("Skriv inn prosjekt navn");
					String id8 = leser.next() + leser.nextLine();
					System.out.println("Skriv inn beskrivelse av prosjektet");
					String avd8 = leser.next() + leser.nextLine();
					
					ProsjektDAO.leggeTilNyttProsjekt(id8, avd8);
					System.out.println("Oppdatert");
					
				} else if(svar == 9) {
					
					
					
					System.out.println("Skriv inn ansatt id");
					int a_id9 = leser.nextInt();
					System.out.println("Skriv inn prosjekt id");
					int p_id9 = leser.nextInt();
					System.out.println("Skriv inn rolle i prosjektet");
					String rol = leser.next() + leser.nextLine();
					
					ProsjektdeltagelseDAO.leggeTilNyProsjektdeltagelse(a_id9, p_id9, rol);
					
					System.out.println("Oppdatert");
				} else if(svar == 10) {
					
					System.out.println("Skriv inn prosjektdeltagelse id");
					int id10 = leser.nextInt();
					System.out.println("Skriv inn antall timer");
					int timer10 = leser.nextInt();
					
					ProsjektdeltagelseDAO.leggeTilTimerMedProsjektdeltagelseId(id10, timer10);
					System.out.println("Oppdatert");
					
				} else if(svar == 11) {
					
					System.out.println("skriv inn prosjekt id");
					int id11 = leser.nextInt();
					
					ProsjektDAO.skrivUtProsjekt(id11);
					
				}
				 
		} 

		
		leser.close();
	}
	
	
	public void oppstart() {
		
		AvdelingDAO AvdelingDAO = new AvdelingDAO();
		AnsattDAO AnsattDAO = new AnsattDAO();
		
		
		AvdelingDAO.oppdaterSjef(1, AnsattDAO.finnAnsattMedId(3));
		AvdelingDAO.oppdaterSjef(2, AnsattDAO.finnAnsattMedId(1));
		AvdelingDAO.oppdaterSjef(3, AnsattDAO.finnAnsattMedId(5));
		AvdelingDAO.oppdaterSjef(4, AnsattDAO.finnAnsattMedId(10));
		
		
		
		
		
	}

}// slutt
