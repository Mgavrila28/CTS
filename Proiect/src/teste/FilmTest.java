package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pachet.Film;
import pachet.Sala;

public class FilmTest {

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
		fileReader=new FileReader("filmTest.txt");
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

					String[] linie=s.split(",");
					System.out.println("Film fisier : "+s+ " ");				
					Sala sala = new Sala(Integer.parseInt(linie[0]), Integer.parseInt(linie[1]));
					Film film = new Film(sala,linie[2],Double.parseDouble(linie[3]),Double.parseDouble(linie[4]),linie[5]);
					assertNotNull(film);	
			}
		}catch (Exception e) {
			if(e.getMessage() == "Constructor null de initializare")
				assertTrue(true);
		}
	}
	
	@Test
	public void ConstructorPretNegativ(){
		try {
			String s = null;
			while((s=bufferedReader.readLine())!=null&&s.length()!=0){

					String[] linie=s.split(",");
					//System.out.println("Film fisier negativ: "+s+" ");
					Sala sala = new Sala(Integer.parseInt(linie[0]), Integer.parseInt(linie[1]));
					Film film = new Film(sala,linie[2],Double.parseDouble(linie[3]),Double.parseDouble(linie[4]),linie[5]);
					assertTrue(Integer.parseInt(linie[3])>0);	
			}
		}catch (Exception e) {
			
		}
	}
	
	@Test
	public void ConstructorDurataNegativa(){
		try {
			String s = null;
			while((s=bufferedReader.readLine())!=null&&s.length()!=0){

					String[] linie=s.split(",");
					//System.out.println(s+" neg ");
					Sala sala = new Sala(Integer.parseInt(linie[0]), Integer.parseInt(linie[1]));
					Film film = new Film(sala,linie[2],Double.parseDouble(linie[3]),Double.parseDouble(linie[4]),linie[5]);
					assertTrue(Integer.parseInt(linie[4])>0);	
			}
		}catch (Exception e) {
			
		}
	}
	
	@Test
	public void FilmSetterDenumireNull() throws Exception
	{
		Sala sala = new Sala(3,34);
		Film film = new Film(sala,"Cenusareasa",30,1.20,"2D");
		film.setDenumire(null);
		System.out.println("Film: Denumirea setata null : "+film.getDenumire());
		assertEquals("Cenusareasa", film.getDenumire());
	}
	
	@Test
	public void FilmSetPretZero() throws Exception {
		Sala sala = new Sala(3,34);
		Film film = new Film(sala,"Cenusareasa",30,1.20,"2D");
		film.setPret(0);
		System.out.println("Film: Pretul setat 0: "+film.getPret());
		assertEquals(30, film.getPret(),0.5);
	}
	
	@Test
	public void FilmSetPretNegativ() throws Exception {
		Sala sala = new Sala(3,34);
		Film film = new Film(sala,"Cenusareasa",30,1.20,"2D");
		film.setPret(-20);
		System.out.println("Film: Pretul setat negativ : "+film.getPret());
		assertEquals(30, film.getPret(),0.5);
	}
	
	@Test
	public void FilmSetDurataZero() throws Exception {
		Sala sala = new Sala(3,34);
		Film film = new Film(sala,"Cenusareasa",30,1.20,"2D");
		film.setDurata(0);
		System.out.println("Film: Durata setata 0 : "+film.getDurata());
		assertEquals(1.2, film.getDurata(),0.5);
	}
	
	@Test
	public void FilmSetDurataNegativ() throws Exception {
		Sala sala = new Sala(3,34);
		Film film = new Film(sala,"Cenusareasa",30,1.20,"2D");
		film.setDurata(0);
		System.out.println("Film: Durata setata negativa : "+film.getDurata());
		assertEquals(1.2, film.getDurata(),0.5);
	}
	
	@Test
	public void FilmSetTipNull() throws Exception {
		Sala sala = new Sala(3,34);
		Film film = new Film(sala,"Cenusareasa",30,1.20,"2D");
		film.setTip(null);
		System.out.println("Film: Tipul setat null: "+film.getTip());
		assertEquals("2D", film.getTip());
	}
	
	@Test
	public void FilmSetSala() throws Exception {
		Sala sala = new Sala(3,34);
		Film film = new Film(sala,"Cenusareasa",30,1.20,"2D");
		film.setSala(null);
		System.out.println("Film: Sala setata null: "+film.getSala());
		assertEquals(sala, film.getSala());
	}


}
