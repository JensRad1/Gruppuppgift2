package edu.grupp1a.langdskidtavlingen.skidtavlingar;

import edu.grupp1a.langdskidtavlingen.anmalan.Masstart;
import edu.grupp1a.langdskidtavlingen.skidakare.SkidAkare;
import edu.grupp1a.langdskidtavlingen.skidbana.SkidBana;

public class SkidTavlingar {

	public static void main(String[] args) {
		
		SkidAkare skidAkareA = new SkidAkare("Johan Johansson", 0, 0, 0);
		SkidAkare skidAkareB = new SkidAkare("Oscar Johansson", 0, 0, 0);
		
		SkidAkare[] skidAkare = {skidAkareA, skidAkareB};
		
		long tavlingsStartTid = System.currentTimeMillis();
		
		Masstart masstart = new Masstart(tavlingsStartTid);
		
		masstart.anmalSkidakare(skidAkare);
		
		SkidBana aktuellTavling = new SkidBana(skidAkare);
		
		//...
		
				
		aktuellTavling.addMellantid(205);	//Test

		
		
	}
}
