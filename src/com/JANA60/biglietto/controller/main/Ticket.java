package com.JANA60.biglietto.controller.main;

import java.text.DecimalFormat;

public class Ticket 
{
/*
 * Creare una classe Biglietto con due attributi: chilometri ed età del passeggero.
	Utilizzare i modificatori dei livelli di accesso per proteggere il funzionamento interno della classe 
	ed esporre solo un’interfaccia fatta di metodi public, come abbiamo visto in classe e nelle slide.
	La classe deve esporre un metodo che calcola il prezzo del biglietto secondo la logica:
	- il prezzo del biglietto è definito in base ai km (0.21 € al km)
	- va applicato uno sconto del 20% per i minorenni
	- va applicato uno sconto del 40% per gli over 65

 */
	
	//attributi di oggetto
	
	private double pricePerKM = 0.21, youngDiscount = 0.2, oldDiscount= 0.4;
	
	private int ageT, km, young = 18, old = 65;

	DecimalFormat df = new DecimalFormat ("0.00€");
	
	//costruttore
	public Ticket(int ageT, int km)  //il costruttore si crea solo utilizzando l'età del passeggero e i km che deve percorrere
	{
		super();
		this.ageT = ageT;
		this.km = km;
	}

	//getter e setter (in questo codice sono totalmente inutili, ma sono belli)

	public int getAgeT() {
		return ageT;
	}

	public void setAgeT(int ageT) {
		this.ageT = ageT;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	//metodi di classe
	
	public double getTotalPrice()
	{
		double basePrice=0.0;
		basePrice = km * pricePerKM;
		
		if(ageT<young)
			return basePrice - (basePrice * youngDiscount); //ticket con sconto giovani
		else if(ageT>=old)
			return basePrice - (basePrice * oldDiscount); //ticket con sconto anziani
		else 
			return basePrice; //ticket senza sconti
	
	}
	
	public String getFormattedTotalPrice() //riporto il prezzo formattato alla seconda cifra decimale
	{
		return df.format(getTotalPrice());
	}
	
	public String toString()
	{
		String res="";
		
		if(ageT<young)
			res+= "Hai diritto allo sconto giovani.";
		if(ageT>=old)
			res+= "Hai diritto allo sconto anziani.";
		
		res+= "\nIl costo del tuo biglietto è pari a: " +getFormattedTotalPrice();
		
		return res;
	}
}
