package edu.grupp1a.langdskidtavlingen.anmalan;

import edu.grupp1a.langdskidtavlingen.skidakare.SkidAkare;

public class Masstart extends Anmalan {

	public Masstart(long startTid) {
		super(startTid);
	}

	@Override	
	public void anmalSkidakare(SkidAkare[] skidakare) {
		
		for(int i=0; i<skidakare.length; i++) {
			
			if(skidakare[i] != null) {
				
				skidakare[i].setStartNummer((i + 205));		//startnummer borjar på #205 exempelvis
				skidakare[i].setStartTid(getStartTid());
				
			}				
		}			
	}
	
	

}
