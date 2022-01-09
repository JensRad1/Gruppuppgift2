package edu.grupp1a.langdskidtavlingen.skidbana;

import java.util.Collections;
import java.util.List;

import edu.grupp1a.langdskidtavlingen.skidakare.*;

public class SkidBana {
	
	private List<SkidAkare> startandeAkare, mellanTidsAkare, malgangsAkare;
	
	private ExternJamforare ext;

	public SkidBana(List<SkidAkare> startandeAkare, List<SkidAkare> mellanTidsAkare, List<SkidAkare> malgangsAkare) {
		super();
		this.startandeAkare = startandeAkare;
		this.mellanTidsAkare = mellanTidsAkare;
		this.malgangsAkare = malgangsAkare;
		
		ext = new ExternJamforare();
	}
	
	public void laggTillMellantid(int startNummer) {
		
		SkidAkare akaren;
		
		int position = startNrTillElementPos(startandeAkare, startNummer);		
		
		//finns angiven åkare i startfältet? har åkaren redan en mellantid?
		if(position >= 0 && startandeAkare.get(position).getMellanTid() == 0)	{	
		
			akaren = startandeAkare.get(position);
			
			//kan bara lägga till mellantid om åkaren har startat
			if(akaren.getStartTid() - System.currentTimeMillis() < 0) {
			
				long mellanTiden = System.currentTimeMillis() - akaren.getStartTid();
				
				akaren.setMellanTid(mellanTiden);
				
				mellanTidsAkare.add(akaren);
				
				System.out.println("Har lagt till mellantiden: " + mellanTiden/1000d +" s, för: \"" + akaren +"\". ");
			
			}
			else
				System.out.println("Angiven åkare har inte startat ännu");
			
		}
		else
			System.out.println("Angivet startnummer har redan en mellantid eller är felaktigt");
		
	}
	
	private int startNrTillElementPos(List<SkidAkare> listan, int startNummer) {		
		
		//-1 retur om inte hittar angivet startnummer i listan	
		
		int position = 0;
		
		for(var element : listan) {
			
			if(element.getStartNummer() == startNummer) {
				return position;			
			}
			else
				position +=1;
			
		}
		
		position = -1;
		return position;		
	}
	
	public void visaAkaresPlaceringOchTid(int startNummer) {
				
		Collections.sort(mellanTidsAkare, ext);		
		
		int position = startNrTillElementPos(mellanTidsAkare, startNummer);
		
		if (position >= 0) {
			
			SkidAkare akaren = mellanTidsAkare.get(position);			
			
			System.out.println("Åkare \"" + akaren + "\" har mellantid: "
					+ akaren.getMellanTid()/1000d + " s, samt har mellantidsplacering på plats "
					+ (mellanTidsAkare.indexOf(akaren) + 1) + ".");
			
		}
		else
			System.out.println("Angiven åkare har inte fått en mellantid ännu");	
	}
	
	public void angeMalgang(int startNummer) {		
		
		//testar: 1. finns angivet startnummer i listan? 2. har åkaren redan ett värde på variabeln? 
		
		SkidAkare akaren;
		
		int position = startNrTillElementPos(startandeAkare, startNummer);		
		
		if(position >= 0) {
			
			akaren = startandeAkare.get(position);
			
			if (akaren.getMalgangsTid() == 0 && akaren.getMellanTid() != 0) {
			
				akaren.setMalgangsTid(System.currentTimeMillis() - akaren.getStartTid());
				
				malgangsAkare.add(akaren);
				
				System.out.println("Har angett målgång för: \"" + akaren + "\".");
				
			}
			else {
				System.out.println("Angiven åkare har redan gått i mål eller saknar en mellantid");
			}			
		}
		else {
			System.out.println("Angiven åkare finns inte som tävlande");
		}
		
	}
	
	public void visaStartLista() {
		
		double intervallTid = (startandeAkare.get(1).getStartTid() - startandeAkare.get(0).getStartTid())/1000d;		
		
		System.out.println("\nStartlista:");
		
		String akareStr = "";
		
		for(int i=0; i<startandeAkare.size();i++) {
			
			if(startandeAkare.get(i).getMellanTid() != 0)
				akareStr += "    \t| Mellantid: " + (startandeAkare.get(i).getMellanTid()/1000d) + " s";
			
			if(startandeAkare.get(i).getMalgangsTid() != 0)
				akareStr += "\t| Målgångstid: " + (startandeAkare.get(i).getMalgangsTid()/1000d + " s");
			
			
			System.out.println("+" + intervallTid*i + " s\t| " + startandeAkare.get(i) + akareStr);
			
			akareStr = "";			
		}

	}
	
	public void visaResultatLista() {
		
		Collections.sort(malgangsAkare);
		
		System.out.println("\nResultatlista:");
		
		for(int i=0; i<malgangsAkare.size(); i++) {
			
			System.out.println("Placering " + (i+1) + "  | " + malgangsAkare.get(i) + "\t| Slutgiltig åktid: " 
					+ malgangsAkare.get(i).getMalgangsTid()/1000d + " s");
			
		}
		
		if(malgangsAkare.size() == 0)
			System.out.println("Inga åkare har gått i mål ännu.");
	}
	
	public void visaMellantiderLista() {
		
		Collections.sort(mellanTidsAkare, ext);	
		
		System.out.println("\nMellantidslista:");
		
		for(int i=0; i<mellanTidsAkare.size(); i++) {
			
			System.out.println("Placering " + (i+1) + "  | " + mellanTidsAkare.get(i) + "\t| Mellantid: " 
					+ mellanTidsAkare.get(i).getMellanTid()/1000d + " s");
		}
		
		if(mellanTidsAkare.size() == 0)
			System.out.println("Inga åkare har passerat mellantidspunkten ännu.");
	}
	
	
	public double visaAktuellTavlingsTid() {
		
		return (System.currentTimeMillis() - startandeAkare.get(0).getStartTid())/1000d;
	}

}
