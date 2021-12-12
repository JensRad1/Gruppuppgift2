package edu.grupp1a.langdskidtavlingen.skidakare;


public class SkidAkare extends Person implements Comparable<SkidAkare>{
	
	private long startTid;
	
	private int startNummer;
	
	private long mellanTid;

	public SkidAkare(String namn, long startTid, int startNummer, long mellanTid) {
		super(namn);
		this.startTid = startTid;
		this.startNummer = startNummer;
		this.mellanTid = mellanTid;
	}

	public long getStartTid() {
		return startTid;
	}

	public void setStartTid(long starttid) {
		this.startTid = starttid;
	}

	public int getStartNummer() {
		return startNummer;
	}

	public void setStartNummer(int startNummer) {
		this.startNummer = startNummer;
	}

	public long getMellanTid() {
		return mellanTid;
	}

	public void setMellanTid(long mellantid) {
		this.mellanTid = mellantid;
	}

	@Override
	public String toString() {
		return "SkidAkare [starttid=" + startTid + ", startNummer=" + startNummer + ", mellantid=" + mellanTid
				+ ", getNamn()=" + getNamn() + "]";
	}
	
	
	public int compareTo(SkidAkare a) {
		
		if(mellanTid < a.mellanTid)
			return -1;
		else if(mellanTid > a.mellanTid)
			return 1;
		else
			return 0;
		
	}
	
	
	
	

}
