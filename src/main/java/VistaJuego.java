import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaJuego implements VistaInterface
{
	private ModeloInterface modelo;
	private ControladorInterface controlador;
	
	private JFrame marcoJuego;
	private JPanel panelJuego;
	private JLabel etiquetaTiempo;
	private JButton botonIniciar;
	private JButton botonSalir;
	private JButton botonUno;
	private JButton botonDos;
	private JButton botonTres;
	private JButton botonCuatro;
	private JButton botonCinco;
	private JButton botonSeis;
	private JButton botonSiete;
	private JButton botonOcho;
	private JButton botonNueve;
	
	private TiempoJuego tiempo;
	
	public VistaJuego(ControladorInterface controlador, ModeloInterface modelo)
	{
		this.controlador = controlador;
		this.modelo = modelo;
		modelo.registrarObservador((ObservadorInterface)this);
	}
	
	public void crearVista()
	{
		//CREA MARCO DE VENTANA DE JUEGO
		marcoJuego = new JFrame();
		marcoJuego.setForeground(Color.WHITE);
		marcoJuego.setTitle("VENTANA JUEGO");
		marcoJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoJuego.setBounds(100, 100, 367, 463);
		marcoJuego.setVisible(false);
		
		//CREA PANEL DE VENTANA DE JUEGO
		panelJuego = new JPanel();
		panelJuego.setForeground(Color.BLACK);
		panelJuego.setBackground(new Color(105, 105, 105));
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		marcoJuego.setContentPane(panelJuego);
		panelJuego.setLayout(null);
		
		//CREA ETIQUETA TIEMPO DE VENTANA DE JUEGO
		etiquetaTiempo = new JLabel("Tiempo:");
		etiquetaTiempo.setForeground(new Color(255, 255, 255));
		etiquetaTiempo.setFont(new Font("Calibri", Font.BOLD, 16));
		etiquetaTiempo.setBounds(10, 73, 104, 26);
		etiquetaTiempo.setVisible(true);
		panelJuego.add(etiquetaTiempo);
		
		//CREA INSTANCIA TIEMPO DEL JUEGO
		tiempo = TiempoJuego.Instancia();
		panelJuego.add(tiempo.Barra());
		tiempo.setControlador(controlador);
		tiempo.setModelo(modelo);
		tiempo.start();
		
		//CREA BOTON INICIAR DE VENTANA DE JUEGO
		botonIniciar = new JButton("Iniciar");
		botonIniciar.setBackground(Color.LIGHT_GRAY);
		botonIniciar.setForeground(Color.WHITE);
		botonIniciar.setFont(new Font("Calibri", Font.BOLD, 16));
		botonIniciar.setBounds(10, 11, 162, 28);
		panelJuego.add(botonIniciar);
		
		//CREA BOTON SALIR DE VENTANA DE JUEGO
		botonSalir = new JButton("Salir");
		botonSalir.setBackground(Color.LIGHT_GRAY);
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setFont(new Font("Calibri", Font.BOLD, 16));
		botonSalir.setBounds(180, 11, 162, 28);
		panelJuego.add(botonSalir);
		
		//CREA BOTON UNO DE VENTANA DE JUEGO
		botonUno = new JButton("1");
		botonUno.setForeground(Color.WHITE);
		botonUno.setFont(new Font("Calibri", Font.BOLD, 60));
		botonUno.setBackground(new Color(30, 144, 255));
		botonUno.setBounds(238, 217, 104, 96);
		botonUno.setEnabled(true);
		botonUno.setVisible(true);
		panelJuego.add(botonUno);
		
		//CREA BOTON DOS DE VENTANA DE JUEGO
		botonDos = new JButton("2");
		botonDos.setForeground(Color.WHITE);
		botonDos.setFont(new Font("Calibri", Font.BOLD, 60));
		botonDos.setBackground(new Color(30, 144, 255));
		botonDos.setBounds(10, 110, 104, 96);
		botonDos.setEnabled(true);
		botonDos.setVisible(true);
		panelJuego.add(botonDos);
		
		//CREA BOTON TRES DE VENTANA DE JUEGO
		botonTres = new JButton("3");
		botonTres.setForeground(Color.WHITE);
		botonTres.setFont(new Font("Calibri", Font.BOLD, 60));
		botonTres.setBackground(new Color(30, 144, 255));
		botonTres.setBounds(10, 217, 104, 96);
		botonTres.setEnabled(true);
		botonTres.setVisible(true);
		panelJuego.add(botonTres);
		
		//CREA BOTON CUATRO DE VENTANA DE JUEGO
		botonCuatro = new JButton("4");
		botonCuatro.setForeground(Color.WHITE);
		botonCuatro.setFont(new Font("Calibri", Font.BOLD, 60));
		botonCuatro.setBackground(new Color(30, 144, 255));
		botonCuatro.setBounds(124, 324, 104, 96);
		botonCuatro.setEnabled(true);
		botonCuatro.setVisible(true);
		panelJuego.add(botonCuatro);
		
		//CREA BOTON CINCO DE VENTANA DE JUEGO
		botonCinco = new JButton("5");
		botonCinco.setForeground(Color.WHITE);
		botonCinco.setFont(new Font("Calibri", Font.BOLD, 60));
		botonCinco.setBackground(new Color(30, 144, 255));
		botonCinco.setBounds(238, 324, 104, 96);
		botonCinco.setEnabled(true);
		botonCinco.setVisible(true);
		panelJuego.add(botonCinco);
		
		//CREA BOTON SEIS DE VENTANA DE JUEGO
		botonSeis = new JButton("6");
		botonSeis.setForeground(Color.WHITE);
		botonSeis.setFont(new Font("Calibri", Font.BOLD, 60));
		botonSeis.setBackground(new Color(30, 144, 255));
		botonSeis.setBounds(124, 217, 104, 96);
		botonSeis.setEnabled(true);
		botonSeis.setVisible(true);
		panelJuego.add(botonSeis);
		
		//CREA BOTON SIETE DE VENTANA DE JUEGO
		botonSiete = new JButton("7");
		botonSiete.setForeground(Color.WHITE);
		botonSiete.setFont(new Font("Calibri", Font.BOLD, 60));
		botonSiete.setBackground(new Color(30, 144, 255));
		botonSiete.setBounds(124, 110, 104, 96);
		botonSiete.setEnabled(true);
		botonSiete.setVisible(true);
		panelJuego.add(botonSiete);
		
		//CREA BOTON OCHO DE VENTANA DE JUEGO
		botonOcho = new JButton("8");
		botonOcho.setFont(new Font("Calibri", Font.BOLD, 60));
		botonOcho.setForeground(Color.WHITE);
		botonOcho.setBounds(238, 110, 104, 96);
		botonOcho.setBackground(new Color(30, 144, 255));
		botonOcho.setEnabled(true);
		botonOcho.setVisible(true);
		panelJuego.add(botonOcho);
		
		//CREA BOTON NUEVE DE VENTANA DE JUEGO
		botonNueve = new JButton("9");
		botonNueve.setBackground(new Color(30, 144, 255));
		botonNueve.setFont(new Font("Calibri", Font.BOLD, 60));
		botonNueve.setForeground(Color.WHITE);
		botonNueve.setBounds(10, 324, 104, 96);
		botonNueve.setEnabled(true);
		botonNueve.setVisible(true);
		panelJuego.add(botonNueve);
		
		//ESPERA DE EVENTO USUARIO
		evento();
	}
	
	public void evento()
	{
		//ESPERANDO EVENTO DE BOTON INICIAR DE VENTANA DE JUEGO
		botonIniciar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				controlador.iniciarJuego();
			}
		});
				
		//ESPERANDO EVENTO DE BOTON SALIR DE VENTANA DE JUEGO
		botonSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				controlador.salirJuego();
			}
		});
		
		//ESPERANDO EVENTO DE BOTON UNO DE VENTANA DE JUEGO
		botonUno.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonUno.getText(), 1);
			}
		});
		
		//ESPERANDO EVENTO DE BOTON DOS DE VENTANA DE JUEGO
		botonDos.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonDos.getText(), 2);
			}
		});
		
		//ESPERANDO EVENTO DE BOTON TRES DE VENTANA DE JUEGO
		botonTres.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonTres.getText(), 3);
			}
		});
		
		//ESPERANDO EVENTO DE BOTON CUATRO DE VENTANA DE JUEGO
		botonCuatro.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonCuatro.getText(), 4);
			}
		});
		
		//ESPERANDO EVENTO DE BOTON CINCO DE VENTANA DE JUEGO
		botonCinco.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonCinco.getText(), 5);
			}
		});
		
		//ESPERANDO EVENTO DE BOTON SEIS DE VENTANA DE JUEGO
		botonSeis.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonSeis.getText(), 6);
			}
		});
		
		//ESPERANDO EVENTO DE BOTON SIETE DE VENTANA DE JUEGO
		botonSiete.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonSiete.getText(), 7);
			}
		});
		
		//ESPERANDO EVENTO DE BOTON OCHO DE VENTANA DE JUEGO
		botonOcho.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonOcho.getText(), 8);
			}
		});
		
		//ESPERANDO EVENTO DE BOTON NUEVE DE VENTANA DE JUEGO
		botonNueve.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				controlador.logicaJuego(botonNueve.getText(), 9);
			}
		});
	}
	
	public void actualizar()
	{
		switch(modelo.getEstadoJuego())
		{
			case 1:
			{
				//MUESTRA VENTANA DE JUEGO
				marcoJuego.setVisible(true);
				
				//CADA BOTON SE LE ASIGNA UN VALOR ALEATORIO
				botonUno.setText(Integer.toString(modelo.getVector()[0]));
				botonDos.setText(Integer.toString(modelo.getVector()[1]));
				botonTres.setText(Integer.toString(modelo.getVector()[2]));
				botonCuatro.setText(Integer.toString(modelo.getVector()[3]));
				botonCinco.setText(Integer.toString(modelo.getVector()[4]));
				botonSeis.setText(Integer.toString(modelo.getVector()[5]));
				botonSiete.setText(Integer.toString(modelo.getVector()[6]));
				botonOcho.setText(Integer.toString(modelo.getVector()[7]));
				botonNueve.setText(Integer.toString(modelo.getVector()[8]));
				
				//CAMBIA A COLOR AZUL O NARANJA
				switch(modelo.getColor())
				{
					case 1:
					{
						botonUno.setBackground(new Color(30, 144, 255));
						botonDos.setBackground(new Color(30, 144, 255));
						botonTres.setBackground(new Color(30, 144, 255));
						botonCuatro.setBackground(new Color(30, 144, 255));
						botonCinco.setBackground(new Color(30, 144, 255));
						botonSeis.setBackground(new Color(30, 144, 255));
						botonSiete.setBackground(new Color(30, 144, 255));
						botonOcho.setBackground(new Color(30, 144, 255));
						botonNueve.setBackground(new Color(30, 144, 255));
						tiempo.setColor(0);
						break;
					}
					case 2:
					{
						botonUno.setBackground(new Color(255, 140, 0));
						botonDos.setBackground(new Color(255, 140, 0));
						botonTres.setBackground(new Color(255, 140, 0));
						botonCuatro.setBackground(new Color(255, 140, 0));
						botonCinco.setBackground(new Color(255, 140, 0));
						botonSeis.setBackground(new Color(255, 140, 0));
						botonSiete.setBackground(new Color(255, 140, 0));
						botonOcho.setBackground(new Color(255, 140, 0));
						botonNueve.setBackground(new Color(255, 140, 0));
						tiempo.setColor(1);
						break;
					}
				}
				
				//BLOQUEA O DESBLOQUEA BOTONES
				switch(modelo.getTecla())
				{
					case 1:
					{
						botonUno.setEnabled(false);
						break;
					}
					case 2:
					{
						botonDos.setEnabled(false);
						break;
					}
					case 3:
					{
						botonTres.setEnabled(false);
						break;
					}
					case 4:
					{
						botonCuatro.setEnabled(false);
						break;
					}
					case 5:
					{
						botonCinco.setEnabled(false);
						break;
					}
					case 6:
					{
						botonSeis.setEnabled(false);
						break;
					}
					case 7:
					{
						botonSiete.setEnabled(false);
						break;
					}
					case 8:
					{
						botonOcho.setEnabled(false);
						break;
					}
					case 9:
					{
						botonNueve.setEnabled(false);
						break;
					}
					case 10:
					{
						botonUno.setEnabled(true);
						botonDos.setEnabled(true);
						botonTres.setEnabled(true);
						botonCuatro.setEnabled(true);
						botonCinco.setEnabled(true);
						botonSeis.setEnabled(true);
						botonSiete.setEnabled(true);
						botonOcho.setEnabled(true);
						botonNueve.setEnabled(true);
						break;
					}
				}
				
				//SE INICIA NUEVAMENTE LA BARRA DE TIEMPO
				if(modelo.getReinicioTiempo() == 0)
				{
					tiempo.Reset(1);
				}
				
				break;
			}
			case 2:
			{
				//NO MUESTRA VENTANA DE JUEGO
				marcoJuego.setVisible(false);
				break;
			}
			case 3:
			{
				//SALE DE VENTANA DE JUEGO
				System.exit(0);
				break;
			}
		}
	}
}
