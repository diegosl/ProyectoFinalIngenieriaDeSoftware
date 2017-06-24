
public class Main 
{
	public static void main(String[] args) 
	{
		Modelo modelo = new Modelo();
		ControladorLogueo controladorLogueo = new ControladorLogueo(modelo);
		ControladorJuego controladorJuego = new ControladorJuego(modelo);
		//ControladorPuntuacion controladorPuntuacion = new ControladorPuntuacion(modelo);
	}
}
