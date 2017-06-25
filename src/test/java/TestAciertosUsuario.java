import static org.junit.Assert.*;

import org.junit.Test;

public class TestAciertosUsuario 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		ControladorLogueo controladorLogueo = new ControladorLogueo(modelo);
		ControladorJuego controladorJuego = new ControladorJuego(modelo);
		int aciertos=0;
		
		controladorLogueo.iniciarLogueo("diego");
		modelo.secuenciaJuego("1",0);
		modelo.secuenciaJuego("2",1);
		modelo.secuenciaJuego("3",3);
		modelo.secuenciaJuego("4",4);
		controladorJuego.iniciarJuego();
		
		aciertos = ((Usuario) modelo.getListaUsuario().get(0)).getAcierto();
		
		assertEquals(aciertos,4);
	}

}
