import static org.junit.Assert.*;

import org.junit.Test;

public class TestDesaciertosUsuario 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		ControladorLogueo controladorLogueo = new ControladorLogueo(modelo);
		ControladorJuego controladorJuego = new ControladorJuego(modelo);
		int desaciertos=0;
		
		controladorLogueo.iniciarLogueo("diego");
		modelo.secuenciaJuego("7",0);
		modelo.secuenciaJuego("2",1);
		modelo.secuenciaJuego("8",3);
		modelo.secuenciaJuego("9",4);
		controladorJuego.iniciarJuego();
		
		desaciertos = ((Usuario) modelo.getListaUsuario().get(0)).getDesacierto();
		
		assertEquals(desaciertos,4);
	}

}
