package pachet;

public class Sala {
	public int nrSala;
	public int nrLocuri;
	
	public int getNrSala() {
		return nrSala;
	}
	public void setNrSala(int _nrSala) {
		
		if(_nrSala>0)
			nrSala = _nrSala;	
		
	}
	
	public int getNrLocuri() {
		return nrLocuri;
	}
	public void setNrLocuri(int _nrLocuri) {
		if(_nrLocuri>0)
			nrLocuri = _nrLocuri;
		
	}
	public Sala(int _nrSala, int _nrLocuri) throws Exception {
		if(_nrSala==0)
			throw new Exception("NrSala este 0");
		if(_nrSala<=0)
			throw new Exception("NrSala este negativ ");
		if(_nrLocuri==0)
			throw new Exception("NrLocuri este  0");
		if(_nrLocuri<=0)
			throw new Exception("NrLocuri este negativ");
		nrSala =_nrSala;
		nrLocuri = _nrLocuri;
	}
	public Sala(){}
	@Override
	public String toString() {
		return "Sala cu nrSala=" + nrSala + 
				 ", are nrLocuri=" + nrLocuri + "";
	};
	
	
	
	

}
