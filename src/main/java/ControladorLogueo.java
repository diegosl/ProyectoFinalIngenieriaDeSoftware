
public class ControladorLogueo implements ControladorInterface 
{
	private ModeloInterface modelo;
	private VistaInterface vistaLogueo;
	
	public ControladorLogueo(ModeloInterface modelo)
	{
		this.modelo = modelo;
		vistaLogueo = new VistaLogueo(this, modelo);
		vistaLogueo.crearVista();
	}
	
	public void iniciarLogueo(String nombre)
	{
		modelo.inicioLogueo(nombre);
	}
	
	public void salirLogueo()
	{
		modelo.finLogueo();
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
}
