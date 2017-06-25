import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumeros 
{
	@Test
	public void test() 
	{
		Modelo modelo = new Modelo();
		int sumatoria = 0;
		
		modelo.setRandom();
		vector(modelo);
		modelo.setRandom();
		vector(modelo);
		modelo.setRandom();
		vector(modelo);
		
		for(int i=0; i< modelo.getVector().length; i++)
		{
			sumatoria = sumatoria + modelo.getVector()[i];
		}		
		
		assertEquals(sumatoria,45);
	}
	
	public void vector(Modelo modelo)
	{
		for(int i=0; i< modelo.getVector().length; i++)
		{
			System.out.print(modelo.getVector()[i] + " ");
		}		
		System.out.println("");
	}

}
