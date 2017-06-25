import static org.junit.Assert.*;

import org.junit.Test;

public class TestPuntuacionUsuario 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		ControladorLogueo controladorLogueo = new ControladorLogueo(modelo);
		ControladorJuego controladorJuego = new ControladorJuego(modelo);
		int puntuacion=0;
		
		controladorLogueo.iniciarLogueo("diego");
		modelo.secuenciaJuego("1",0);
		modelo.secuenciaJuego("2",1);
		modelo.secuenciaJuego("3",2);
		modelo.secuenciaJuego("4",3);
		modelo.secuenciaJuego("5",4);
		modelo.secuenciaJuego("6",5);
		modelo.secuenciaJuego("7",6);
		modelo.secuenciaJuego("8",7);
		modelo.secuenciaJuego("9",8);
		
		modelo.secuenciaJuego("9",0);
		modelo.secuenciaJuego("8",1);
		modelo.secuenciaJuego("7",2);
		modelo.secuenciaJuego("6",3);
		modelo.secuenciaJuego("5",4);
		modelo.secuenciaJuego("4",5);
		modelo.secuenciaJuego("3",6);
		modelo.secuenciaJuego("2",7);
		modelo.secuenciaJuego("1",8);
		controladorJuego.iniciarJuego();
		
		puntuacion = ((Usuario) modelo.getListaUsuario().get(0)).getPuntuacion();
		
		assertEquals(puntuacion,2);
	}

}
