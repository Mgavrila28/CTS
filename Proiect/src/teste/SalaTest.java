package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pachet.Sala;

public class SalaTest {

	static FileReader fileReader;
	static BufferedReader bufferedReader;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		fileReader=new FileReader("sali.txt");
		bufferedReader=new BufferedReader(fileReader);
	}

	@After
	public void tearDown() throws Exception {
		bufferedReader.close();
		fileReader.close();
	}

	@Test
	public void ConstructorNull() {
		try {
			String s = null;
			while((s=bufferedReader.readLine())!=null&&s.length()!=0){

					String[] linie=s.split(" ");
					System.out.println("Sala fisier: "+s+ " ");				
					Sala sala = new Sala(Integer.parseInt(linie[0]), Integer.parseInt(linie[1]));
					assertNotNull(sala);	
			}
		}catch (Exception e) {
			if(e.getMessage() == "Constructor null de initializare")
				assertTrue(true);
		}
	}
	
	@Test
	public void SalaSetNrLocuritestZero() throws Exception {
		Sala sala = new Sala(2,23);
		sala.setNrLocuri(0);
		System.out.println("Sala: Numar locuri setat 0: "+sala.getNrLocuri());
		assertEquals(23,sala.getNrLocuri());
	}

	@Test
	public void SalaSetNrLocuriNegativ() throws Exception {
		Sala sala = new Sala(2,23);
		sala.setNrLocuri(-20);
		System.out.println("Sala: Numar locuri setatat negativ: "+sala.getNrLocuri());
		assertEquals(23,sala.getNrLocuri());
	}
	
	
	@Test
	public void SalaSetNrSalaZero() throws Exception {
		Sala sala = new Sala(2,23);
		sala.setNrSala(0);
		System.out.println("Sala: Numar sala setat 0: "+sala.getNrSala());
		assertEquals(2,sala.getNrSala());
	}
	
	@Test
	public void SalaNrSalaNull() throws Exception
	{
		Sala sala = new Sala(2,23);
		sala.setNrSala(0);
		System.out.println("Sala: Numar sala setat null: "+sala.getNrSala());
		assertNotNull(sala.getNrSala());
		
	}
	@Test
	public void SalaNrSalaNegativ() throws Exception
	{
		Sala sala = new Sala(2,23);
		sala.setNrSala(-2);
		System.out.println("Sala: Numar sala setat negativ: "+sala.getNrSala());
		assertNotNull(sala.getNrSala());
		
	}

	

}
