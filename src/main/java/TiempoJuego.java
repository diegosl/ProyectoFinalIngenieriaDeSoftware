import java.awt.Color;

import javax.swing.JProgressBar;

public class TiempoJuego extends Thread
{
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
		start();
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
			tiempo = getTiempo(tiempo);
			if(reset==1)
			{
				run();
			}
		}
		
		while(reset==0)
		{
			
		}
		run();
	}
	
	public int getTiempo(int tiempo)
	{
		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		tiempo--;
		barraProgreso.setValue(tiempo);
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
}
