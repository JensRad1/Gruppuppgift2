package edu.grupp1a.langdskidtavlingen.anmalan;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import edu.grupp1a.langdskidtavlingen.skidakare.SkidAkare;

public class Anmalan {
	
	private Scanner input;
	
	private List<SkidAkare> startandeAkare;
	
	private long intervallTid;

	public Anmalan(Scanner input, List<SkidAkare> startandeAkare) {
		super();
		this.input = input;
		this.startandeAkare = startandeAkare;
		
		intervallTid = 0;
	}
	

	public void angeIntervallTid() {
		
		long svar = 0;
		
		do {
			
			System.out.println("Vilken intervalltid har tävlingen (millisekunder)?: ");
			
			svar = inputNummer();
			
			if(svar > 0) {
				intervallTid = svar;
				break;
			}
			else
				continue;
				
		
		} while(true);
		
	}
	
	private long inputNummer() {
		
		try {
			long val = 0;
			val = input.nextLong();
			return val;
			
		} catch (InputMismatchException e) {
			input.nextLine();
			System.out.println("Felaktig indata. Ange ett heltal.");
			return 0;
		}
		
	}
	
	public void anmalSkidAkare() {
		
		long tavlingsStartTid = System.currentTimeMillis() - intervallTid;
		
		Collections.shuffle(startandeAkare);
		
		int counter = 0;
		for(var element : startandeAkare) {
			element.setStartTid(tavlingsStartTid += intervallTid);
			
			element.setStartNummer(counter += 1);
		}
		
	}

	
	public void laggTillSkidAkare() {
		
		String svar = "";
		
		do {

			svar = inputAkare();
			
			if(!svar.equals("q"))
				laggTillStartandeAkare(svar);
			
		}while(!svar.equals("q"));		
	}
	
	private String inputAkare() {
		
		System.out.println("Lägg till namn på åkare (q för avbryt): ");
		
		return input.nextLine();
		
	}
	
	private void laggTillStartandeAkare(String namn) {
		
		startandeAkare.add(new SkidAkare(namn, 0, 0, 0, 0));		
	}
	
}
