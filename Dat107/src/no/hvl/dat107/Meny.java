package no.hvl.dat107;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Meny {

	AvdelingDAO AvdelingDAO = new AvdelingDAO();
	AnsattDAO AnsattDAO = new AnsattDAO();

	Scanner leser = new Scanner(System.in);

	String skille = "------------------------------------------------";

	public void start() {
		int svar;
		int status = 0;
		while (status == 0) {
			System.out.println(skille);
			System.out.println("Trykk [1] for å søke etter ansatt");
			System.out.println("Trykk [2] for å skrive ut alle ansatte");
			System.out.println("Trykk [3] for å oppdatere en ansatt");
			System.out.println("Trykk [4] for å legge til en ansatt");
			System.out.println("Trykk [0] for å avslutte");
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
						
					} else if(id3 == 3) {
						System.out.println("Skriv inn id til den ansatte du vil endre stilling til");
						n = leser.nextInt();
						System.out.println("Skriv inn den nye stillingen");
						svar2 = leser.next() + leser.nextLine();
						System.out.println("Skriv inn den nye lønnen");
						lonn = leser.nextInt();
						
						AnsattDAO.oppdaterStillingOgLonn(n, svar2, BigDecimal.valueOf(lonn));
						System.out.println("Oppdatert");
						
					} 
				} else if(svar == 4) {
					
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
					System.out.println("Skriv inn prosjekt");
					String prosjekt = leser.next() + leser.nextLine();
					
					//Stilling,lønn,prosjekt
					
					Ansatt a = new Ansatt(brukernavn,fornavn,etternavn,LocalDate.now(),stilling, BigDecimal.valueOf(lonn), AvdelingDAO.finnAvdelingMedId(avdeling),prosjekt);
					
					AnsattDAO.leggTilAnsatt(a);
					
					System.out.println("Oppdatert");
					
					
				}
				 
		} 

		
		leser.close();
	}

}// slutt
