package teste;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pachet.Student;

public class StudentTest {

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
		reader = new FileReader("student.txt");
		bufferReader = new BufferedReader(reader);
	}

	@After
	public void tearDown() throws Exception {
		reader.close();
		bufferReader.close();
	}

	@Test
	public void StudentSetNumeNull() throws Exception {
		Student student=new Student("Tudorie","Mihai","2920923465476","0734524345","tudorie.mihai@gmail.com");
		student.setNume(null);
		System.out.println("Student: Nume setat null: "+student.getNume());
		assertEquals(student.getNume(),"Tudorie");
	}
	
	@Test
	public void StudentSetPrenumeNull() throws Exception {
		Student student = new Student("Tudorie","Mihai","2920923465476","0734524345","tudorie.mihai@gmail.com");
		student.setPrenume(null);
		System.out.println("Student: Prenume setat null: "+student.getPrenume());
		assertEquals(student.getPrenume(),"Mihai");
	}
	
	@Test
	public void StudentSetNumarTelefonNull() throws Exception {
		Student student = new Student("Tudorie","Mihai","2920923465476","0734524345","tudorie.mihai@gmail.com");
		student.setNumar_telefon(null);
		System.out.println("Student: Numar telefon setat null: "+student.getNumar_telefon());
		assertEquals("0734524345", student.getNumar_telefon());
	}
	
	@Test
	public void StudentSetEmailNull() throws Exception {
		Student student=new Student("Tudorie","Mihai","2920923465476","0734524345","tudorie.mihai@gmail.com");
		student.setEmail(null);
		System.out.println("Student: Email-ul setat null: "+student.getEmail());
		assertEquals("tudorie.mihai@gmail.com", student.getEmail());
	}
	
	@Test
	public void ConstructorNull()
	{
		try {
			String string = null;
			while ((string=bufferReader.readLine())!=null&&string.length()!=0)
			{
				
				String[] linie = string.split(" ");
				System.out.println("Student fisier : "+string + " ");
				Student student = new Student(linie[0],linie[1],linie[2],linie[3],linie[4]);
				
				assertNotNull(student);
			}
			
		} catch (Exception e) {
			if(e.getMessage()=="Constructor null de initializare")
				assertTrue(true);
		}
	}
	
	@Test
	public void CnpNumericTest()
	{
		Student s=new Student();
		boolean test = s.CnpNumeric("292092355476");
		assertTrue(test);
	}
	
	@Test
	public void CnpNenumericTest()
	{
		Student s=new Student();
		boolean test = s.CnpNumeric("2670934e445476");
		assertFalse(test);
	}
	
	@Test
	public void NrTelefonNumericTest()
	{
		Student s = new Student();
		boolean test = s.NumarTelefonNumeric("0734524345");
		assertTrue(test);
	}
	
	@Test
	public void NrTelefonNenumericTest()
	{
		Student s = new Student();
		boolean test = s.NumarTelefonNumeric("07345df345");
		assertFalse(test);
	}

	@Test
	public void NumeNenumeric()
	{
		Student s = new Student();
		boolean test = s.StringNenumeric("Tudorie");
		assertTrue(test);
	}
	
	@Test
	public void NumeNumeric()
	{
		Student s = new Student();
		boolean test = s.StringNenumeric("Tudo34e");
		assertFalse(test);
	}


	@Test
	public void EmailTestTrue()
	{
		Student s = new Student();
		boolean test = s.EmailValidate("tudorie.mihai@gmail.com");
		assertTrue(test);
	}

	@Test
	public void EmailTestFalse()
	{
		Student s = new Student();
		boolean test = s.EmailValidate("tudorie.mihaigmail.com");
		assertFalse(test);
	}

}
