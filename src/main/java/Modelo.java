import java.util.ArrayList;

public class Modelo implements ModeloInterface 
{
	private ArrayList<ObservadorInterface> listaObservador;
	private ArrayList<Usuario> listaUsuario;
	
	private int estadoLogueo;
	private int estadoJuego;
	private int estadoPuntuacion;
	
	public Modelo()
	{
		listaObservador = new ArrayList<ObservadorInterface>();
		listaUsuario = new ArrayList<Usuario>();
		
		estadoLogueo = 0;
		estadoJuego = 0;
		estadoPuntuacion = 0;
	}
	
	public void registrarObservador(ObservadorInterface o)
	{
		listaObservador.add(o);
	}
	
	public void removerObservador(ObservadorInterface o)
	{
		int i = listaObservador.indexOf(o);
		
		if(i >= 0)
		{
			listaObservador.remove(i);
		}
	}
	
	public void notificarObservador()
	{
		for(int i=0; i<listaObservador.size(); i++)
		{
			ObservadorInterface observador = (ObservadorInterface)listaObservador.get(i);
			observador.actualizar();
		}
	}
	
	public void inicioLogueo(String nombre)
	{
		int repetido = 0;
		
		for(int i=0; i<listaUsuario.size(); i++)
		{
			if(listaUsuario.get(i).getNombre().equals(nombre))
			{
				estadoLogueo = 1;
				repetido = 1;
				break;
			}
		}
		
		if(repetido == 0)
		{
			estadoLogueo = 0;
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			listaUsuario.add(usuario);
		}
		
		notificarObservador();
	}
	
	public void finLogueo()
	{
		estadoLogueo = 2;
		notificarObservador();
	}
	
	public int getEstadoLogueo()
	{
		return estadoLogueo;
	}
	
	public int getEstadoJuego()
	{
		return estadoJuego;
	}
	
	public int getEstadoPuntuacion()
	{
		return estadoPuntuacion;
	}
}
