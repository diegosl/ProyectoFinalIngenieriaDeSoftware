
public class ControladorJuego implements ControladorInterface 
{
	private ModeloInterface modelo;
	private VistaInterface vistaJuego;
	
	public ControladorJuego(ModeloInterface modelo)
	{
		this.modelo = modelo;
		vistaJuego = new VistaJuego(this, modelo);
		vistaJuego.crearVista();
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
		modelo.inicioJuego();
	}
	
	public void salirJuego()
	{
		modelo.finJuego();
	}
	
	public void logicaJuego(String boton, int valor)
	{
		modelo.secuenciaJuego(boton, valor);
	}
}
