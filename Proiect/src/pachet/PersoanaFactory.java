package pachet;

import interfete.IPersoana;

//factory design pattern
public class PersoanaFactory {

	public IPersoana getPersoana(String tip)
	{
		if(tip.equalsIgnoreCase("Student"))
			return new Student();
		else
			if(tip.equalsIgnoreCase("Elev"))
				return new Elev();
			else 
				if (tip.equalsIgnoreCase("Adult"))
					return new Adult();
				else
		return null;
	}
}
