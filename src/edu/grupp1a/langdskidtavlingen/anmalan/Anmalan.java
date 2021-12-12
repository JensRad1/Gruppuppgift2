package edu.grupp1a.langdskidtavlingen.anmalan;

import edu.grupp1a.langdskidtavlingen.skidakare.SkidAkare;

abstract class Anmalan {
	
	private long startTid;

	public Anmalan(long startTid) {
		super();
		this.startTid = startTid;
	}

	public long getStartTid() {
		return startTid;
	}
	
	abstract void anmalSkidakare(SkidAkare[] skidakare);

}
