import static org.junit.Assert.*;

import org.junit.Test;

public class TestTiempo 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		int estadoJuego = 0;
		int estadoPuntuacion = 0;
		ControladorLogueo controladorLogueo = new ControladorLogueo(modelo);
		ControladorJuego controladorJuego = new ControladorJuego(modelo);
		
		controladorLogueo.iniciarLogueo("diego");
		controladorJuego.tiempoLimite();
		estadoJuego = modelo.getEstadoJuego();
		estadoPuntuacion = modelo.getEstadoPuntuacion();
		
		assertEquals(estadoJuego,2);
		assertEquals(estadoPuntuacion,2);
	}

}
