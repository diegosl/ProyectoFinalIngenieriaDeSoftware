import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAciertosUsuario.class, TestColor.class, TestDesaciertosUsuario.class, TestEstadoJuego.class,
		TestEstadoLogueo.class, TestEstadoPuntuacion.class, TestNombreUsuario.class, TestNumeros.class,
		TestPuntuacionUsuario.class, TestTiempo.class })
public class AllTests {

}
