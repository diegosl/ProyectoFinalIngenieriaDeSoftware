import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VistaLogueo implements VistaInterface
{
	private ModeloInterface modelo;
	private ControladorInterface controlador;
	
	private JFrame marcoLogueo;
	private JPanel panelLogueo;
	private JTextField campoLogueo;
	private JButton botonIniciar;
	private JButton botonSalir;
	private JLabel etiquetaMindGame;
	private JLabel etiquetaUsuario;
	
	public VistaLogueo(ControladorInterface controlador, ModeloInterface modelo)
	{
		this.controlador = controlador;
		this.modelo = modelo;
		modelo.registrarObservador((ObservadorInterface)this);
	}
	
	public void crearVista()
	{
		//CREA MARCO DE VENTANA DE LOGUEO
		marcoLogueo = new JFrame();
		marcoLogueo.setBackground(Color.WHITE);
		marcoLogueo.setTitle("VENTANA LOGUEO");
		marcoLogueo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoLogueo.setBounds(100, 100, 320, 180);
		marcoLogueo.setVisible(true);
		
		//CREA PANEL DE VENTANA DE LOGUEO
		panelLogueo = new JPanel();
		panelLogueo.setForeground(Color.BLACK);
		panelLogueo.setBackground(Color.GRAY);
		panelLogueo.setBorder(new EmptyBorder(5, 5, 5, 5));
		marcoLogueo.setContentPane(panelLogueo);
		panelLogueo.setLayout(null);
		
		//CREA CAMPO DE TEXTO DE VENTANA DE LOGUEO
		campoLogueo = new JTextField();
		campoLogueo.setForeground(Color.BLACK);
		campoLogueo.setFont(new Font("Calibri", Font.BOLD, 16));
		campoLogueo.setBackground(Color.WHITE);
		campoLogueo.setBounds(70, 48, 210, 25);
		panelLogueo.add(campoLogueo);
		campoLogueo.setColumns(10);
		
		//CREA ETIQUETA MIND GAME DE VENTANA DE LOGUEO
		etiquetaMindGame = new JLabel("Mind Game");
		etiquetaMindGame.setForeground(Color.WHITE);
		etiquetaMindGame.setFont(new Font("Calibri", Font.BOLD, 20));
		etiquetaMindGame.setBounds(100, 11, 103, 26);
		panelLogueo.add(etiquetaMindGame);
		
		//CREA ETIQUETA USUARIO DE VENTANA DE LOGUEO
		etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setForeground(Color.WHITE);
		etiquetaUsuario.setFont(new Font("Calibri", Font.BOLD, 16));
		etiquetaUsuario.setBounds(10, 54, 56, 14);
		panelLogueo.add(etiquetaUsuario);
		
		//CREA BOTON INICIAR DE VENTANA DE LOGUEO
		botonIniciar = new JButton("Iniciar");
		botonIniciar.setBackground(Color.LIGHT_GRAY);
		botonIniciar.setForeground(Color.WHITE);
		botonIniciar.setFont(new Font("Calibri", Font.BOLD, 16));
		botonIniciar.setBounds(10, 103, 130, 29);
		panelLogueo.add(botonIniciar);
		
		//CREA BOTON SALIR DE VENTANA DE LOGUEO
		botonSalir = new JButton("Salir");
		botonSalir.setBackground(Color.LIGHT_GRAY);
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setFont(new Font("Calibri", Font.BOLD, 16));
		botonSalir.setBounds(150, 103, 130, 28);
		panelLogueo.add(botonSalir);
		
		//ESPERA DE EVENTO USUARIO
		evento();
	}
	
	public void evento()
	{
		//ESPERANDO EVENTO DE BOTON INICIAR DE VENTANA DE LOGUEO
		botonIniciar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				controlador.iniciarLogueo(campoLogueo.getText());
			}
		});
		
		//ESPERANDO EVENTO DE BOTON SALIR DE VENTANA DE LOGUEO
		botonSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				controlador.salirLogueo();
			}
		});
	}
	
	public void actualizar()
	{
		//LIMPIA CAMPO DE TEXTO DE VENTANA DE LOGUEO
		campoLogueo.setText("");
		
		switch(modelo.getEstadoLogueo())
		{
			case 1:
			{
				//INICIA SESION DE VENTANA DE LOGUEO
				//NO MUESTRA VENTANA DE LOGUEO
				marcoLogueo.setVisible(false);
				break;
			}
			case 2:
			{
				//NO INICIA SESION DE VENTANA DE LOGUEO
				//SE TIENE QUE VOLVER A INGRESAR USUARIO
				System.out.println("Ya existe el usuario");
				break;
			}
			case 3:
			{
				//SALE DE VENTANA DE LOGUEO
				System.exit(0);
				break;
			}
			case 4:
			{
				//INICIA SESION DE VENTANA DE LOGUEO
				//MUESTRA VENTANA DE LOGUEO
				marcoLogueo.setVisible(true);
				break;
			}
		}
	}
}
