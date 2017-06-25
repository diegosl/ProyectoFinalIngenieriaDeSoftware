import java.util.ArrayList;
import java.util.Random;

public class Modelo implements ModeloInterface 
{
	private ArrayList<ObservadorInterface> listaObservador;
	private ArrayList<Usuario> listaUsuario;
	
	private int estadoLogueo;
	private int estadoJuego;
	private int estadoPuntuacion;
	
	private int alternativa;
	private int ascendente;
	private int descendente;
	private int color;
	private int tecla;
	
	private int acierto;
	private int desacierto;
	private int puntuacion;
	
	private int[] vector = {1,2,3,4,5,6,7,8,9};
	
	private int tiempo;
	
	public Modelo()
	{
		listaObservador = new ArrayList<ObservadorInterface>();
		listaUsuario = new ArrayList<Usuario>();
		
		estadoLogueo = 0;
		estadoJuego = 0;
		estadoPuntuacion = 0;
		
		alternativa = 0;
		ascendente = 0;
		descendente = 0;
		color = 0;
		tecla = 0;
		
		acierto = 0;
		desacierto = 0;
		puntuacion = 0;
		
		tiempo = 0;
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
				estadoLogueo = 2;
				repetido = 1;
				break;
			}
		}
		
		if(repetido == 0)
		{
			estadoLogueo = 1;
			estadoJuego = 1;
			
			alternativa = 1;
			ascendente = 1;
			descendente = 9;
			color = 1;
			tecla = 10;
			
			acierto = 0;
			desacierto = 0;
			puntuacion = 0;
			
			tiempo = 0;
			
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			listaUsuario.add(usuario);
		}
		
		notificarObservador();
	}
	
	public void finLogueo()
	{
		estadoLogueo = 3;
		notificarObservador();
	}
	
	public void inicioJuego()
	{
		estadoJuego = 2;
		estadoLogueo = 4;
		
		listaUsuario.get(listaUsuario.size()-1).setAcierto(acierto);
		listaUsuario.get(listaUsuario.size()-1).setDesacierto(desacierto);
		listaUsuario.get(listaUsuario.size()-1).setPuntuacion(puntuacion);
		
		notificarObservador();
	}
	
	public void finJuego()
	{
		estadoJuego = 3;
		
		notificarObservador();
	}
	
	public void secuenciaJuego(String boton, int valor)
	{
		int numero = Integer.parseInt(boton);
		
		tiempo = 1;
		
		if(alternativa == 1)
		{
			if(numero == ascendente)
			{
				tecla = valor;
				acierto++;
				ascendente++;
				if(ascendente==10)
				{
					alternativa = 2;
					ascendente = 1;
					color = 2;
					tecla = 10;
					puntuacion++;
					setRandom();
				}
			}
			else
			{
				desacierto++;
			}
		}
		else
		{
			if(numero == descendente)
			{
				tecla = valor;
				acierto++;
				descendente--;
				if(descendente == 0)
				{
					alternativa = 1;
					descendente = 9;
					color = 1;
					tecla = 10;
					puntuacion++;
					setRandom();
				}
			}
			else
			{
				desacierto++;
			}
		}
		
		estadoJuego = 1;
		notificarObservador();
	}
	
	public void setRandom()
	{
		int[] v = {0,0,0,0,0,0,0,0,0};
		
		Random rand = new Random(System.nanoTime());
		
		for(int i=0; i<v.length; i++)
		{
			v[i]= rand.nextInt(9) + 1;
			for(int j=0; j<i; j++)
			{
				if(v[i]==v[j])
				{
					i--;
				}
			}
		}
		
		for(int i=0; i<v.length; i++)
		{
			vector[i] = v[i];
		}
	}
	
	public void finTiempo()
	{
		estadoJuego = 2;
		estadoPuntuacion = 2;
		
		listaUsuario.get(listaUsuario.size()-1).setAcierto(acierto);
		listaUsuario.get(listaUsuario.size()-1).setDesacierto(desacierto);
		listaUsuario.get(listaUsuario.size()-1).setPuntuacion(puntuacion);
		
		notificarObservador();
	}
	
	public void inicioPuntuacion()
	{
		estadoPuntuacion = 1;
		estadoLogueo = 4;
		
		notificarObservador();
	}
	
	public void finPuntuacion()
	{
		estadoPuntuacion = 3;
		
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
	
	public int getReinicioTiempo()
	{
		return tiempo;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public int getTecla()
	{
		return tecla;
	}
	
	public int[] getVector()
	{
		return vector;
	}
	
	public ArrayList getListaUsuario()
	{
		return listaUsuario;
	}
}
