
public class ControladorPuntuacion implements ControladorInterface
{
	private ModeloInterface modelo;
	private VistaInterface vistaPuntuacion;
	
	public ControladorPuntuacion(ModeloInterface modelo)
	{
		this.modelo = modelo;
		vistaPuntuacion = new VistaPuntuacion(this, modelo);
		vistaPuntuacion.crearVista();
	}
	
	public void iniciarLogueo(String nombre)
	{
		//CONTROLADOR DE LOGUEO
	}
	
	public void salirLogueo()
	{
		//CONTROLADOR DE LOGUEO
	}
	
	public void iniciarJuego()
	{
		//CONTROLADOR DE JUEGO
	}
	
	public void salirJuego()
	{
		//CONTROLADOR DE JUEGO
	}
	
	public void logicaJuego(String boton, int valor)
	{
		//CONTROLADOR DE JUEGO
	}
	
	public void tiempoLimite()
	{
		//CONTROLADOR DE JUEGO
	}
	
	public void iniciarPuntuacion()
	{
		modelo.inicioPuntuacion();
	}
	
	public void salirPuntuacion()
	{
		modelo.finPuntuacion();
	}
}
