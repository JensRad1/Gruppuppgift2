package edu.grupp1a.langdskidtavlingen.skidbana;

import java.util.Collections;
import java.util.List;

import edu.grupp1a.langdskidtavlingen.skidakare.*;

public class SkidBana {
	
	private List<SkidAkare> startandeAkare, mellanTidsAkare, malgangsAkare;

	public SkidBana(List<SkidAkare> startandeAkare, List<SkidAkare> mellanTidsAkare, List<SkidAkare> malgangsAkare) {
		super();
		this.startandeAkare = startandeAkare;
		this.mellanTidsAkare = mellanTidsAkare;
		this.malgangsAkare = malgangsAkare;
	}
	
	public void laggTillMellantid(int startNummer) {
		
		SkidAkare akaren;
		
		int position = startNrTillElementPos(startandeAkare, startNummer);		
		
		if(position >= 0 && startandeAkare.get(position).getMellanTid() == 0)	{	
		
			akaren = startandeAkare.get(position);
			
			long mellanTiden = System.currentTimeMillis() - akaren.getStartTid();
			
			akaren.setMellanTid(mellanTiden);
			
			mellanTidsAkare.add(akaren);
			
			System.out.println("Har lagt till mellantid för: \"" + "#" + akaren.getStartNummer()
			+ " " + akaren.getNamn() +"\". ");
			
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
				
		ExternJamforare ext = new ExternJamforare();
				
		Collections.sort(mellanTidsAkare, ext);
		
		
		int position = startNrTillElementPos(mellanTidsAkare, startNummer);
		
		if (position >= 0) {
			
			SkidAkare akaren = mellanTidsAkare.get(position);
			
			if(malgangsAkare.indexOf(akaren) < 0) {
			
				System.out.println("Åkare \"" + akaren.getNamn() + "\" ligger på plats "
					+ (mellanTidsAkare.indexOf(akaren) + 1) + " och har mellantiden: "
					+ akaren.getMellanTid()/1000d + " s, samt totala åktiden: "
					+ (System.currentTimeMillis() - akaren.getStartTid()) / 1000d + " s");
			}
			else {
				
				System.out.println("Åkare \"" + akaren.getNamn() + "\" har gått i mål och hamnade på plats "
						+ (malgangsAkare.indexOf(akaren) + 1) + " och hade åktiden " + akaren.getMalgangsTid()/1000d + " s");
				
				
			}
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
				
				System.out.println("Har angett målgång för: \"" + "#" + akaren.getStartNummer()
				+ " " + akaren.getNamn() +"\". ");
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
		
		System.out.println("Startlista:");
		
		for(var element : startandeAkare)
			System.out.println("#" + element.getStartNummer() + " " +  element);		

	}
	
	public void visaResultatLista() {
		
		System.out.println("\nResultatlista:");
		
		for(int i=0; i<malgangsAkare.size(); i++) {
			
			System.out.println("Placering " + (i+1) + " " + " | #" + malgangsAkare.get(i).getStartNummer()
					+ " " +  malgangsAkare.get(i));
		}
		
		if(malgangsAkare.size() == 0)
			System.out.println("Inga åkare har gått i mål ännu.");
	}
	
	public void visaMellantiderLista() {
		
		System.out.println("\nMellantidslista:");
		
		for(int i=0; i<mellanTidsAkare.size(); i++) {
			
			System.out.println("Placering " + (i+1) + " " + " | #" + mellanTidsAkare.get(i).getStartNummer()
					+ " " +  mellanTidsAkare.get(i));				
		}
		
		if(mellanTidsAkare.size() == 0)
			System.out.println("Inga åkare har passerat mellantiden ännu.");
	}

}
