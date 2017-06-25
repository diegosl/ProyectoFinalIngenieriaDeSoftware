import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEstadoLogueo 
{	
	Modelo modelo;
	ControladorLogueo controladorLogueo;
	
	private int estadoLogueo = 0;
	
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
		estadoLogueo = modelo.getEstadoLogueo();
		assertEquals(estadoLogueo,1);
	}
	
	@Test
	public void testB() 
	{	
		controladorLogueo.iniciarLogueo("diego");
		controladorLogueo.iniciarLogueo("diego");
		estadoLogueo = modelo.getEstadoLogueo();
		assertEquals(estadoLogueo,2);
	}
	
	@Test
	public void testC() 
	{	
		controladorLogueo.iniciarLogueo("diego");
		modelo.inicioJuego();
		estadoLogueo = modelo.getEstadoLogueo();
		assertEquals(estadoLogueo,4);
	}

}
