package pachet;

public class Film {
	public String denumire;
	public double pret;
	public double durata;
	public String tip;
	public Sala sala;
	
	public Film( Sala _sala,String _denumire, double _pret, double _durata,String _tip) throws Exception {
		if(_sala==null)
			throw new Exception("Sala este null ");
		if(_denumire==null)
			throw new Exception("Denumire este null");
		if(_pret==0)
			throw new Exception("Pretul este 0");
		if(_pret<=0)
			throw new Exception("Pretul este negativ");
		if(_durata==0)
			throw new Exception("Durata este 0");
		if(_durata<=0)
			throw new Exception("Durata este negativa");
		if(_tip==null)
			throw new Exception("Tipul este null ");
		
		sala = _sala;
		denumire = _denumire;
		pret = _pret;
		durata = _durata;
		tip = _tip;
		
	}
	
	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String _denumire) {
		if(_denumire!=null)
			denumire = _denumire;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double _pret) {
		if(_pret>0)
			pret = _pret;
	}

	public double getDurata() {
		return durata;
	}

	public void setDurata(double _durata) {
		if(_durata>0)
			durata = _durata;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String _tip) {
		if(_tip!=null)	
			tip = _tip;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala _sala) {
		if(_sala!=null)
			sala = _sala;
	}

	public Film(){}

	@Override
	public String toString() {
		return "Film cu denumirea=" + denumire + ", costa=" + pret + " RON "+", durata="
				+ durata +" ore " + ", tip=" + tip + ", " + sala + "";
	}

}
