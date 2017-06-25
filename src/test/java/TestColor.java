import static org.junit.Assert.*;

import org.junit.Test;

public class TestColor 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		int color=0;
		
		modelo.inicioLogueo("diego");
		modelo.secuenciaJuego("1",0);
		modelo.secuenciaJuego("2",1);
		modelo.secuenciaJuego("3",2);
		modelo.secuenciaJuego("4",3);
		modelo.secuenciaJuego("5",4);
		modelo.secuenciaJuego("6",5);
		modelo.secuenciaJuego("7",6);
		modelo.secuenciaJuego("8",7);
		modelo.secuenciaJuego("9",8);
		
		color = modelo.getColor();
		
		assertEquals(color,2);
		
		modelo.secuenciaJuego("9",0);
		modelo.secuenciaJuego("8",1);
		modelo.secuenciaJuego("7",2);
		modelo.secuenciaJuego("6",3);
		modelo.secuenciaJuego("5",4);
		modelo.secuenciaJuego("4",5);
		modelo.secuenciaJuego("3",6);
		modelo.secuenciaJuego("2",7);
		modelo.secuenciaJuego("1",8);
		modelo.inicioJuego();
		
		color = modelo.getColor();
		
		assertEquals(color,1);
	}

}
