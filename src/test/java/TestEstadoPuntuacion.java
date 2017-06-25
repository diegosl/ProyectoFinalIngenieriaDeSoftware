import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEstadoPuntuacion 
{
	Modelo modelo;
	ControladorLogueo controladorLogueo;
	ControladorPuntuacion controladorPuntuacion;
	
	private int estadoPuntuacion = 0;
	
	@Before
	public void before()
	{
		modelo = new Modelo();
		controladorLogueo = new ControladorLogueo(modelo);
		controladorPuntuacion = new ControladorPuntuacion(modelo);
	}
	
	@Test
	public void testA() 
	{	
		controladorLogueo.iniciarLogueo("diego");
		controladorPuntuacion.iniciarPuntuacion();
		estadoPuntuacion = modelo.getEstadoPuntuacion();
		assertEquals(estadoPuntuacion,1);
	}
	
	@Test
	public void testB() 
	{	
		controladorLogueo.iniciarLogueo("diego");
		modelo.finTiempo();
		estadoPuntuacion = modelo.getEstadoPuntuacion();
		assertEquals(estadoPuntuacion,2);
	}
}
