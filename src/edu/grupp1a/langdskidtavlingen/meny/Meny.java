package edu.grupp1a.langdskidtavlingen.meny;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.grupp1a.langdskidtavlingen.skidbana.SkidBana;

public class Meny {
	
	private Scanner input;
	
	private SkidBana aktuellTavling;
	
	
	public Meny(Scanner input, SkidBana aktuellTavling) {
		super();
		this.input = input;
		this.aktuellTavling = aktuellTavling;
	}
	
	
	public void tavlingsMeny() {
		
		int svar = 0;
		
		do {
			
			printMeny();
			
			svar = inputNummer();
			
			if(svar > 0 && svar < 5)
				menyVal(svar);
			else
				continue;
				
		
		} while(svar != 5);
		
	}
	
	private void menyVal(int val) {
		
		switch(val){
		
		case 1 -> laggTillMellantid(); 
		case 2 -> visaPlaceringOchTid();
		case 3 -> angeMalgangForAkare();
		case 4 -> visaStartOchResultatListor();
		default -> System.exit(0);		
		
		}		
	}




	private void printMeny() {
				
		String multiStr = """
				\nSKIDTÄVLING - INTERVALL
				
				(1) Lägg till åkares mellantid
				(2) Visa åkares aktuella placering samt åktid
				(3) Ange målgång för åkare
				(4) Visa start- och resultatlista
				(5) Avsluta
				Ange val: """;
		
		System.out.println(multiStr);
	}
	
	private int inputNummer() {
		
		try {
			int val = 0;
			val = input.nextInt();
			return val;
			
		} catch (InputMismatchException e) {
			input.nextLine();
			System.out.println("Felaktig indata. Ange ett heltal.");
			return 0;
		}
		
	}
	
	private void laggTillMellantid() {		
		
		System.out.println("\n-Lägg till Mellantid-");
		
		aktuellTavling.visaStartLista();
		
		System.out.println("\nAnge åkares startnummer: ");
		
		aktuellTavling.laggTillMellantid(inputNummer());
			
		
	}
	
	private void visaPlaceringOchTid() {
				
		System.out.println("\n-Visa åkares aktuella placering samt åktid-");
		
		aktuellTavling.visaStartLista();
		
		System.out.println("Ange åkares startnummer: ");
		
		aktuellTavling.visaAkaresPlaceringOchTid(inputNummer());		
		
	}
	
	private void angeMalgangForAkare() {
		
		System.out.println("\n-Ange målgång för åkare-");
		
		aktuellTavling.visaStartLista();
		
		System.out.println("Ange åkares startnummer: ");
		
		aktuellTavling.angeMalgang(inputNummer());
	}
	
	private void visaStartOchResultatListor() {
		
		System.out.println("\n-Start och resultatlistorna-\n");
		
		aktuellTavling.visaStartLista();
		
		aktuellTavling.visaMellantiderLista();
		
		aktuellTavling.visaResultatLista();		
		
	}

}
