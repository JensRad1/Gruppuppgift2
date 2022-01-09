package edu.grupp1a.langdskidtavlingen.skidakare;

public class SkidAkare extends Person implements Comparable<SkidAkare> {
	
	private long startTid;
	private long mellanTid;
	private long malgangsTid;
	
	private int startNummer;


	public SkidAkare(String namn, long startTid, long mellanTid, long malgangsTid, int startNummer) {
		super(namn);
		this.startTid = startTid;
		this.mellanTid = mellanTid;
		this.malgangsTid = malgangsTid;
		this.startNummer = startNummer;
	}
	

	public int getStartNummer() {
		return startNummer;
	}

	public void setStartNummer(int startNummer) {
		this.startNummer = startNummer;
	}

	public long getStartTid() {
		return startTid;
	}

	public void setStartTid(long startTid) {
		this.startTid = startTid;
	}

	public long getMellanTid() {
		return mellanTid;
	}

	public void setMellanTid(long mellanTid) {
		this.mellanTid = mellanTid;
	}

	public long getMalgangsTid() {
		return malgangsTid;
	}

	public void setMalgangsTid(long malgangsTid) {
		this.malgangsTid = malgangsTid;
	}

	
	@Override
	public String toString() {		
		return "#" + startNummer + " " + getNamn();
	}


	@Override
	public int compareTo(SkidAkare a) {
		if(malgangsTid < a.malgangsTid)
			return -1;
		else if(malgangsTid > a.malgangsTid)
			return 1;
		else
			return 0;
	}
	
}

