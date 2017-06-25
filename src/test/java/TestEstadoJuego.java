import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEstadoJuego 
{
	Modelo modelo;
	ControladorLogueo controladorLogueo;
	ControladorJuego controladorJuego;
	
	private int estadoJuego = 0;
	
	@Before
	public void before()
	{
		modelo = new Modelo();
		controladorLogueo = new ControladorLogueo(modelo);
	}
	
	@Test
	public void testA() 
	{	
		controladorLogueo.iniciarLogueo("diego");
		estadoJuego = modelo.getEstadoJuego();
		assertEquals(estadoJuego,1);
	}
	
	@Test
	public void testB() 
	{	
		controladorLogueo.iniciarLogueo("diego");
		modelo.inicioJuego();
		estadoJuego = modelo.getEstadoJuego();
		assertEquals(estadoJuego,2);
	}
	
}
