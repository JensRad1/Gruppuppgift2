package edu.grupp1a.langdskidtavlingen.skidakare;

import java.util.Comparator;

public class ExternJamforare implements Comparator<SkidAkare> {
	
	@Override
	public int compare(SkidAkare o1, SkidAkare o2) {
		if(o1.getMellanTid() < o2.getMellanTid())
			return -1;
		else if(o1.getMellanTid() > o2.getMellanTid())
			return 1;
		else
			return 0;
	}	

}
