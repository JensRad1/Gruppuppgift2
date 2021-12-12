package edu.grupp1a.langdskidtavlingen.skidbana;

import edu.grupp1a.langdskidtavlingen.skidakare.SkidAkare;

public class SkidBana {
	
	private SkidAkare[] skidAkare;

	public SkidBana(SkidAkare[] skidAkare) {
		super();
		this.skidAkare = skidAkare;
	}
	
	//test
	public void addMellantid(int startnummer) {
		
		for(int i=0; i<skidAkare.length; i++) {
			
			if(skidAkare[i].getStartNummer() == startnummer) {
				
				skidAkare[i].setMellanTid(System.currentTimeMillis() - skidAkare[i].getStartTid());
				
				System.out.println("Lagt till åkare: " + skidAkare[i].getNamn() + " #" + skidAkare[i].getStartNummer());
				
				System.out.println(skidAkare[i]);
			}
		}
		
	}
	
	
	//Etc mera metoder
	

}
