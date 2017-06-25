import java.awt.Color;

import javax.swing.JProgressBar;

public class TiempoJuego extends Thread
{
	private ModeloInterface modelo;
	private ControladorInterface controlador;
	private JProgressBar barraProgreso;
	private static TiempoJuego instancia = null;
	private int reset;
	
	private TiempoJuego()
	{
		barraProgreso = new JProgressBar();
		barraProgreso.setForeground(new Color(30, 144, 255));
		barraProgreso.setBackground(new Color(255, 255, 255));
		barraProgreso.setBounds(124, 73, 218, 26);
		barraProgreso.setVisible(true);
		reset=0;
	}
	
	public static TiempoJuego Instancia() 
	{ 
	    if (instancia == null) 
	    {
	    	instancia = new TiempoJuego();
	    } 
	    return instancia; 
	} 
	
	public void run()
	{
		reset=0;
		int tiempo = 100;
		
		barraProgreso.setValue(tiempo);
		
		while(tiempo>0)
		{
			//SE REALIZA ESTE BUCLE CUANDO SE INICIA POR PRIMERA VEZ LA APLICACION
			//Y TAMBIEN CUANDO EL USUARIO DECIDE IRSE A MITAD DE PARTIDA
			while(modelo.getEstadoLogueo() == 0 || modelo.getEstadoLogueo() == 4)
			{
			}
			
			tiempo = getTiempo(tiempo);
			
			//CUANDO SE INICIE SESION (VENTANA LOGUEO) VUELVE A REALIZAR SU TAREA run()
			if(reset==1)
			{
				run();
			}
		}
		
		//ESPERA PARA QUE EL HILO NO TERMINE SU TAREA
		while(reset==0)
		{
		}
		
		//CUANDO SE INICIE SESION (VENTANA LOGUEO) VUELVE A REALIZAR SU TAREA run()
		run();
	}
	
	public int getTiempo(int tiempo)
	{
		try 
		{
			Thread.sleep(100);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		tiempo--;
		barraProgreso.setValue(tiempo);
		
		//ESPERA DE EVENTO DEL SISTEMA
		if(tiempo == 0)
		{
			controlador.tiempoLimite();
		}
		
		return tiempo;
	}
	
	public JProgressBar Barra()
	{
		return barraProgreso;
	}
	
	public void Reset(int reset)
	{
		this.reset=reset;
	}
	
	public void setColor(int opcion)
	{
		if(opcion == 0)
		{
			barraProgreso.setForeground(new Color(30, 144, 255));
		}
		else if(opcion == 1)
		{
			barraProgreso.setForeground(new Color(255, 140, 0));
		}
	}
	
	public void setControlador(ControladorInterface controlador)
	{
		this.controlador = controlador;
	}
	
	public void setModelo(ModeloInterface modelo)
	{
		this.modelo = modelo;
	}
}
