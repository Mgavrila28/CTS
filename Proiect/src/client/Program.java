package client;

import interfete.IPersoana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import pachet.Film;
import pachet.PersoanaFactory;
import pachet.Pornirefilm;
import pachet.RezervareBilet;

public class Program {

	public static void main(String[] args) {
		Pornirefilm pornireFilm = new Pornirefilm();
		pornireFilm.executa("filme.txt");
		Film film = pornireFilm.filmCautat();
		RezervareBilet rezervare = new RezervareBilet();
		IPersoana persoana = null;
		String str;
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
		System.out.print("Introduceti tipul persoanei: ");
			try {
				str = br.readLine();
				PersoanaFactory factory = new PersoanaFactory();
				persoana = factory.getPersoana(str);	
				film.pret-=film.pret*persoana.procentReducere();
				System.out.println("Pretul biletului este : "+film.pret+" RON");
				System.out.println("S-a rezervat un bilet in sala cu numarul "+film.sala.nrSala);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("Introduceti modalitatea de plata : ");
			try {
				s= br.readLine();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			rezervare.realizareRezervare(film, persoana,s);

	}

}
