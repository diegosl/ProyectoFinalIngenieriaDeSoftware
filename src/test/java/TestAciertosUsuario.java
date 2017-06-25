import static org.junit.Assert.*;

import org.junit.Test;

public class TestAciertosUsuario 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		int aciertos=0;
		
		modelo.inicioLogueo("diego");
		modelo.secuenciaJuego("1",0);
		modelo.secuenciaJuego("2",1);
		modelo.secuenciaJuego("3",3);
		modelo.secuenciaJuego("4",4);
		modelo.inicioJuego();
		
		aciertos = ((Usuario) modelo.getListaUsuario().get(0)).getAcierto();
		
		assertEquals(aciertos,4);
	}

}
