import static org.junit.Assert.*;

import org.junit.Test;

public class TestDesaciertosUsuario 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		int desaciertos=0;
		
		modelo.inicioLogueo("diego");
		modelo.secuenciaJuego("7",0);
		modelo.secuenciaJuego("2",1);
		modelo.secuenciaJuego("8",3);
		modelo.secuenciaJuego("9",4);
		modelo.inicioJuego();
		
		desaciertos = ((Usuario) modelo.getListaUsuario().get(0)).getDesacierto();
		
		assertEquals(desaciertos,4);
	}

}
