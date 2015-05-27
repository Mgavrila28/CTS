package pachet;

import interfete.IPersoana;

public class Student implements IPersoana{

	public String nume;
	public String prenume;
	public String cnp;
	public String numar_telefon;
	public String email;
	
	@Override
	public double procentReducere() {
		// TODO Auto-generated method stub
		return 0.5;
	}
	
	public String getNume() {
		return nume;
	}

	public void setNume(String _nume) {
		if(_nume!=null)
			nume = _nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String _prenume) {
		if(_prenume!=null)
			prenume = _prenume;
	}

	public String getNumar_telefon() {
		return numar_telefon;
	}

	public void setNumar_telefon(String _numar_telefon) {
		if(_numar_telefon!=null)
			numar_telefon = _numar_telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) {
		if(_email!=null)
			email = _email;
	}
	
	public String getCnp(){
		return cnp;
	}
	public boolean checkCNP(){

		int s=0;
		 String number="279146358279";
		for(int i=0;i<12;i++){
			s+=Integer.parseInt(""+number.charAt(i))*Integer.parseInt(""+cnp.charAt(i));			
		}
		int cifra=s%11;
		if(cifra==10)
			cifra=1;
		return cifra==Integer.parseInt(""+cnp.charAt(12));
	}

	public Student(String _nume, String _prenume, String _cnp, String _numar_telefon,
			String _email) throws Exception {
		if(_nume==null)
			throw new Exception("Numele este null ");
		if(_prenume==null)
			throw new Exception("Prenumele este null");
		if(_cnp==null)
			throw new Exception("Cnp-ul este null ");
		if(_numar_telefon==null)
			throw new Exception("Telefonul este null");
		if(_email==null)
			throw new Exception("Email-ul este null ");
		nume = _nume;
		prenume = _prenume;
		cnp = _cnp;
		numar_telefon = _numar_telefon;
		email = _email;
	}
	public Student(){}
	
	
	public boolean CnpNumeric(String cnpNumeric)
	{
		return cnpNumeric.matches("^[-+]?\\d+(\\.\\d+)?$");
	}
	
	public boolean NumarTelefonNumeric(String nrTelefonNumeric)
	{
		return nrTelefonNumeric.matches("\\d{3}\\d{7}");
	}
	public boolean StringNenumeric(String str)
	{
	  return str.matches("^[A-Za-z]+$");  
	}
	
	public boolean EmailValidate(String str)
	{
		return str.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}


}
