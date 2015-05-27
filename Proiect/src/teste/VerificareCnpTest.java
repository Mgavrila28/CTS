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

public class VerificareCnpTest {
	
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
		reader = new FileReader("cnp.txt");
		bufferReader = new BufferedReader(reader);
	}

	@After
	public void tearDown() throws Exception {
		bufferReader.close();
		reader.close();
	}


	@Test
	public void TestareStringCnpFisier()
	{
		System.out.println(" Verificare cnp ");
		String linie = null;
		try {
			while((linie=bufferReader.readLine())!=null&&linie.length()!=0){
				boolean rez =! linie.split(" ")[0].equals("0");
				String str = linie.split(" ")[1];
				System.out.println("Test : "+str+ " rezultat "+rez);
				assertEquals("Erroare la "+rez+" cu "+str, rez,new Adult().CnpNumeric(str));
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
