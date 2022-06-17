package com.JANA60.biglietto.controller.main;

import java.util.Scanner;

public class TicketOffice {

	public static void main(String[] args) 
	{
		
		/*
		 * Aggiungere una classe Biglietteria, eseguibile con metodo main, 
		 * in cui si chiede all’utente di inserire 
		 * il numero di km e l’età del passeggero e stampa il prezzo del biglietto calcolato.
		 */
		
		Scanner keyboard = new Scanner(System.in);
		int age, km;
		String repeat;
		
		do
		{
			System.out.println("Benvenuto alla biglietteria del treno!");
			
			do
			{
				System.out.println("Prego, inserisca la sua età"); //chiedo l'età del passeggiero
				age = Integer.parseInt(keyboard.nextLine());
				
				if (age<1) //ma se l'età è minore di 1, do errore e chiedo di nuovo
					System.out.println("Devi essere almeno nato per poter viaggiare, prova di nuovo");
			}while (age<1);
			
			do
			{
				System.out.println("Prego, inserire il numero di chilometri che vuole percorrere");
				km = Integer.parseInt(keyboard.nextLine());
				
				if (km<1)
					System.out.println("Se vuoi fare meno di un chilometro, vattene a piedi");
			}while (km<1);
			
			Ticket t = new Ticket(age, km);
			
			System.out.println(t.toString());
			
			
			do
			{
				System.out.println("Vuoi comprare un altro biglietto?");
				
				repeat=keyboard.nextLine();
				
				if(!repeat.equalsIgnoreCase("si") && !repeat.equalsIgnoreCase("no"))
					System.out.println("Input errato, riprovare con si o no.");
				
			}while(!repeat.equalsIgnoreCase("si") && !repeat.equalsIgnoreCase("no"));
			
			
		}while(repeat.equalsIgnoreCase("si"));
		
		System.out.println("Grazie, arrivederci!");
		
		
		keyboard.close();
		
	}

}
