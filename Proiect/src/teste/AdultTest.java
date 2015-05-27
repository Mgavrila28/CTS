package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pachet.Adult;

public class AdultTest {

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
		reader = new FileReader("adult.txt");
		bufferReader = new BufferedReader(reader);
		
		
	}

	@After
	public void tearDown() throws Exception {
		bufferReader.close();	
		reader.close();
	}
	@Test
	public void AdultSetNumeNull() throws Exception {
		Adult adult = new Adult("Ioana","Pirvu","2670924565476","0734564564","ioana.pirvu@gmail.com");
		adult.setNume(null);
		System.out.println("Adult: Numele setat null: "+adult.getNume());
		assertEquals(adult.getNume(),"Ioana");
	}
	
	@Test
	public void AdultSetPrenumeNull() throws Exception {
		Adult adult = new Adult("Ioana","Pirvu","2670924565476","0734564564","ioana.pirvu@gmail.com");
		adult.setPrenume(null);
		System.out.println("Adult: Prenumele setat null: "+adult.getPrenume());
		assertEquals(adult.getPrenume(),"Pirvu");
	}
	
	@Test
	public void AdultSetNumarTelefonNull() throws Exception {
		Adult adult = new Adult("Ioana","Pirvu","2670924565476","0734564564","ioana.pirvu@gmail.com");
		adult.setNumar_telefon(null);
		System.out.println("Adult: Numarul de telefon setat null :"+adult.getNumar_telefon());
		assertEquals("0734564564", adult.getNumar_telefon());
	}
	
	@Test
	public void AdultSetEmailNull() throws Exception {
		Adult adult = new Adult("Ioana","Pirvu","2670924565476","0734564564","ioana.pirvu@gmail.com");
		adult.setEmail(null);
		System.out.println("Adult: Email-ul serat null : "+adult.getEmail());
		assertEquals("ioana.pirvu@gmail.com", adult.getEmail());
	}
	
	
	@Test
	public void ConstructorNull()
	{
		try {
			String string = null;
			while ((string=bufferReader.readLine())!=null&&string.length()!=0)
			{
				
				String[] linie = string.split(" ");
				System.out.println("Adult fisier : "+string + " ");
				Adult adult = new Adult(linie[0],linie[1],linie[2],linie[3],linie[4]);		
				assertNotNull(adult);
			}
			
		} catch (Exception e) {
			if(e.getMessage()=="Constructor null de initializare")
				assertTrue(true);
		}
	}
	
	@Test
	public void CnpNumericTest()
	{
		Adult a = new Adult();
		boolean test = a.CnpNumeric("2670924565476");
		assertTrue(test);
	}
	
	@Test
	public void CnpNenumericTest()
	{
		Adult a = new Adult();
		boolean test = a.CnpNumeric("2670924asa5476");
		assertFalse(test);
	}
	
	@Test
	public void NrTelefonNumericTest()
	{
		Adult a = new Adult();
		boolean test = a.NumarTelefonNumeric("0734564564");
		assertTrue(test);
	}
	
	@Test
	public void NrTelefonNenumericTest()
	{
		Adult a = new Adult();
		boolean test = a.NumarTelefonNumeric("07345ag564");
		assertFalse(test);
	}

	@Test
	public void NumeNenumeric()
	{
		Adult a =new Adult();
		boolean test = a.StringNenumeric("Ioana");
		assertTrue(test);
	}
	
	@Test
	public void NumeNumeric()
	{
		Adult a =new Adult();
		boolean test = a.StringNenumeric("Io232ana");
		assertFalse(test);
	}
	@Test
	public void EmailTestTrue()
	{
		Adult a = new Adult();
		boolean test = a.EmailValidate("ioana.pirvu@gmail.com");
		assertTrue(test);
	}

	@Test
	public void EmailTestFalse()
	{
		Adult a = new Adult();
		boolean test = a.EmailValidate("ioanapirvu@gmailcom");
		assertFalse(test);
	}
	

	
}
