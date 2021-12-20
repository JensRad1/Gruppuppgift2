package edu.grupp1a.langdskidtavlingen.skidakare;

abstract class Person {
	
	private String namn;

	public Person(String namn) {
		super();
		this.namn = namn;
	}

	public String getNamn() {
		return namn;
	}

}
