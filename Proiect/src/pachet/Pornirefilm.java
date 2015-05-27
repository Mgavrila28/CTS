package pachet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pornirefilm {
	
	IncarcareFilm incarcareFilm = new IncarcareFilm();
	
	public void executa(String numeFisier)
	{
		incarcareFilm.adaugaFilm(numeFisier);
	
	}
	public Film filmCautat()
	{
		
		String string;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
	      System.out.print("Introduceti numele filmului ");
			try {
				string = br.readLine();	
				System.out.println(incarcareFilm.cautaFilm(string).toString());
				return incarcareFilm.cautaFilm(string);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
	}
}
