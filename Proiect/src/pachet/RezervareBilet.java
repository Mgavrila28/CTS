package pachet;

import interfete.IPersoana;
import interfete.IPlata;

import java.util.ArrayList;


public class RezervareBilet {
	public Film film;
	public ArrayList<IPersoana> listaPersoane=new ArrayList<IPersoana>();
	public IPlata modalitateDePlata;
	
	public void realizareRezervare(Film f,IPersoana persoana, String string)
	{
		if(string.equals("Card")){
			modalitateDePlata =  new CuCard();
		modalitateDePlata.executaPlata();}
		else
			if(string.equals("Cash")){
				modalitateDePlata = new Cash();
				modalitateDePlata.executaPlata();}
		
		listaPersoane.add(persoana);
		
		f.pret-=f.pret*persoana.procentReducere();
	}
	

}
