package pachet;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;

public class IncarcareFilm {
	public ArrayList<Film> listaFilme= new ArrayList<Film>();
	
	public Film cautaFilm(String denumire)
	{	
			 for (Film film2 : listaFilme) 
		    	   if(film2.denumire.equals(denumire))
		    	   		return film2;		  	   	
			  
	       return null;
	      
	      
		}

	public IncarcareFilm(){}
	public void adaugaFilm(String numeFisier)
	{
		try{
			FileReader reader = new FileReader(numeFisier);
			BufferedReader buffReader = new BufferedReader(reader);
			String string;
			while((string = buffReader.readLine())!=null){
				String[] linie = string.split(",");
				Sala sala = new Sala(Integer.parseInt(linie[0]), Integer.parseInt(linie[1]));
				Film film = new Film(sala,linie[2],Double.parseDouble(linie[3]),Double.parseDouble(linie[4]),linie[5]);
				listaFilme.add(film);
				
			}
			reader.close();
			buffReader.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
