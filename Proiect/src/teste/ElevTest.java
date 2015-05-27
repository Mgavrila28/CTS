package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pachet.Elev;

public class ElevTest {

	static FileReader reader;
	static BufferedReader bufferReader;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		reader = new FileReader("elev.txt");
		bufferReader = new BufferedReader(reader);
	}

	@After
	public void tearDown() throws Exception {
		reader.close();
		bufferReader.close();
	}

	@Test
	public void ElevSetNumeNull() throws Exception {
		Elev elev = new Elev("Gavrila","Monica","2897924565476","0734565345","monica.gavrila@gmail.com");
		elev.setNume(null);
		System.out.println("Elev: Numele setatat null : "+elev.getNume());
		assertEquals(elev.getNume(),"Gavrila");
	}
	
	@Test
	public void ElevSetPrenumeNull() throws Exception {
		Elev elev = new Elev("Gavrila","Monica","2897924565476","0734565345","monica.gavrila@gmail.com");
		elev.setPrenume(null);
		System.out.println("Elev: Prenumele setatat null: "+elev.getPrenume());
		assertEquals(elev.getPrenume(),"Monica");
	}
	
	@Test
	public void ElevSetNumarTelefonNull() throws Exception {
		Elev elev = new Elev("Gavrila","Monica","2897924565476","0734565345","monica.gavrila@gmail.com");
		elev.setNumar_telefon(null);
		System.out.println("Elev: Numarul de telefon setata null: "+elev.getNumar_telefon());
		assertEquals("0734565345", elev.getNumar_telefon());
	}
	
	@Test
	public void ElevSetEmailNull() throws Exception {
		Elev elev=new Elev("Gavrila","Monica","2897924565476","0734565345","monica.gavrila@gmail.com");
		elev.setEmail(null);
		System.out.println("Elev: Email-ul setat null: "+elev.getEmail());
		assertEquals("monica.gavrila@gmail.com", elev.getEmail());
	}
	
	@Test
	public void ConstructorNull()
	{
		try {
			String string = null;
			while ((string=bufferReader.readLine())!=null&&string.length()!=0)
			{
				
				String[] linie = string.split(" ");
				System.out.println("Elev fisier : "+string + " ");
				Elev elev = new Elev(linie[0],linie[1],linie[2],linie[3],linie[4]);
				
				assertNotNull(elev);
			}
			
		} catch (Exception e) {
			if(e.getMessage()=="Constructor null de initializare")
				assertTrue(true);
		}
	}
	
	@Test
	public void CnpNumericTest()
	{
		Elev e = new Elev();
		boolean test = e.CnpNumeric("2897924565476");
		assertTrue(test);
	}
	
	@Test
	public void CnpNenumericTest()
	{
		Elev e = new Elev();
		boolean test = e.CnpNumeric("26709dht445476");
		assertFalse(test);
	}
	
	@Test
	public void NrTelefonNumericTest()
	{
		Elev e = new Elev();
		boolean test = e.NumarTelefonNumeric("0734565345");
		assertTrue(test);
	}
	
	@Test
	public void NrTelefonNenumericTest()
	{
		Elev e = new Elev();
		boolean test = e.NumarTelefonNumeric("073456ad45");
		assertFalse(test);
	}
	
	@Test
	public void NumeNenumeric()
	{
		Elev e = new Elev();
		boolean test = e.StringNenumeric("Gavrila");
		assertTrue(test);
	}
	
	@Test
	public void NumeNumeric()
	{
		Elev e = new Elev();
		boolean test = e.StringNenumeric("Ga34rila");
		assertFalse(test);
	}

	@Test
	public void EmailTestTrue()
	{
		Elev e = new Elev();
		boolean test = e.EmailValidate("monica.gavrila@gmail.com");
		assertTrue(test);
	}

	@Test
	public void EmailTestFalse()
	{
		Elev e = new Elev();
		boolean test = e.EmailValidate("monica.gavrila@gmailcom");
		assertFalse(test);
	}

}
