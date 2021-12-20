package edu.grupp1a.langdskidtavlingen.skidtavlingar;

import java.util.LinkedList;
import java.util.Scanner;

import edu.grupp1a.langdskidtavlingen.anmalan.Anmalan;
import edu.grupp1a.langdskidtavlingen.meny.Meny;
import edu.grupp1a.langdskidtavlingen.skidakare.SkidAkare;
import edu.grupp1a.langdskidtavlingen.skidbana.SkidBana;

public class SkidTavlingar {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		var startandeAkare = new LinkedList<SkidAkare>();		
		var mellanTidsAkare = new LinkedList<SkidAkare>();		
		var malgangsAkare = new LinkedList<SkidAkare>();
		
		
		Anmalan anmal = new Anmalan(input, startandeAkare);		
		
		anmal.laggTillSkidAkare();
		
		anmal.angeIntervallTid();
		
		anmal.anmalSkidAkare();
		
		
		Meny meny = new Meny(input, new SkidBana(startandeAkare, mellanTidsAkare, malgangsAkare));
		
		meny.tavlingsMeny();
		
		
		input.close();
		

	}

}
