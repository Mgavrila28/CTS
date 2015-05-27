package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdultTest.class, ElevTest.class, EmailTestare.class,
		FilmTest.class, NumeTestNumeric.class, SalaTest.class,
		StudentTest.class, VerificareCnpTest.class,
		VerificareTelefonTest.class })
public class AllTests {

}
