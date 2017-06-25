import static org.junit.Assert.*;

import org.junit.Test;

public class TestNombreUsuario 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		
		modelo.inicioLogueo("diego");
		modelo.inicioLogueo("diego");
		modelo.inicioLogueo("diego");
		modelo.inicioLogueo("diego");
		
		for(int i=0; i<modelo.getListaUsuario().size(); i++)
		{
			System.out.println(((Usuario) modelo.getListaUsuario().get(i)).getNombre());
		}
	
		assertEquals(modelo.getListaUsuario().size(),1);
	}

}
