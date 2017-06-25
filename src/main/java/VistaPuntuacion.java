import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class VistaPuntuacion implements VistaInterface
{
	private ModeloInterface modelo;
	private ControladorInterface controlador;
	
	private JFrame marcoPuntuacion;
	private JPanel panelPuntuacion;
	private JLabel etiquetaFinJuego;
	private JLabel etiquetaTabla;
	private JButton botonIniciar;
	private JButton botonSalir;
	private JTable tablaPuntuacion;
	private JScrollPane scrollPuntuacion;
	
	private String columna[]={"Usuario", "Aciertos", "Desaciertos", "Puntuacion Maxima"};
	private String fila[][] = new String[100][4];
	
	public VistaPuntuacion(ControladorInterface controlador, ModeloInterface modelo)
	{
		this.controlador = controlador;
		this.modelo = modelo;
		modelo.registrarObservador((ObservadorInterface)this);
	}
	
	public void crearVista()
	{
		//CREA MARCO DE VENTANA DE PUNTUACION
		marcoPuntuacion = new JFrame();
		marcoPuntuacion.setForeground(Color.WHITE);
		marcoPuntuacion.setTitle("VENTANA PUNTUACION");
		marcoPuntuacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoPuntuacion.setBounds(100, 100, 367, 263);
		marcoPuntuacion.setVisible(false);
				
		//CREA PANEL DE VENTANA DE PUNTUACION
		panelPuntuacion = new JPanel();
		panelPuntuacion.setForeground(Color.BLACK);
		panelPuntuacion.setBackground(new Color(105, 105, 105));
		panelPuntuacion.setBorder(new EmptyBorder(5, 5, 5, 5));
		marcoPuntuacion.setContentPane(panelPuntuacion);
		panelPuntuacion.setLayout(null);
		
		//CREA BOTON INICIAR DE VENTANA DE PUNTUACION
		botonIniciar = new JButton("Iniciar");
		botonIniciar.setBackground(Color.LIGHT_GRAY);
		botonIniciar.setForeground(Color.WHITE);
		botonIniciar.setFont(new Font("Calibri", Font.BOLD, 16));
		botonIniciar.setBounds(10, 11, 162, 28);
		panelPuntuacion.add(botonIniciar);
				
		//CREA BOTON SALIR DE VENTANA DE PUNTUACION
		botonSalir = new JButton("Salir");
		botonSalir.setBackground(Color.LIGHT_GRAY);
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setFont(new Font("Calibri", Font.BOLD, 16));
		botonSalir.setBounds(180, 11, 162, 28);
		panelPuntuacion.add(botonSalir);
		
		//CREA ETIQUETA FIN DE JUEGO DE VENTANA DE PUNTUACION
		etiquetaFinJuego = new JLabel("Fin de Juego!!!");
		etiquetaFinJuego.setFont(new Font("Calibri", Font.BOLD, 20));
		etiquetaFinJuego.setForeground(Color.LIGHT_GRAY);
		etiquetaFinJuego.setBounds(110, 39, 150, 80);
		panelPuntuacion.add(etiquetaFinJuego);
		
		//CREA ETIQUETA TABLA DE VENTANA DE PUNTUACION
		etiquetaTabla = new JLabel("Tabla de Puntuacion Mind Game:");
		etiquetaTabla.setForeground(new Color(255, 255, 255));
		etiquetaTabla.setFont(new Font("Calibri", Font.BOLD, 16));
		etiquetaTabla.setBounds(10, 73, 250, 98);
		panelPuntuacion.add(etiquetaTabla);
		
		//CREA TABLA DE PUNTUACION DE VENTANA DE PUNTUACION
		tablaPuntuacion = new JTable(fila,columna);
		
		//CREA SCROLL PARA TABLA DE PUNTUACION DE VENTANA DE PUNTUACION
		scrollPuntuacion = new JScrollPane(tablaPuntuacion);
		scrollPuntuacion.setBounds(10, 130, 330, 80);
		panelPuntuacion.add(scrollPuntuacion);
		
		//ESPERA DE EVENTO USUARIO
		evento();
	}
	
	public void evento()
	{
		//ESPERANDO EVENTO DE BOTON INICIAR DE VENTANA DE PUNTUACION
		botonIniciar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				controlador.iniciarPuntuacion();
			}
		});
						
		//ESPERANDO EVENTO DE BOTON SALIR DE VENTANA DE PUNTUACION
		botonSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				controlador.salirPuntuacion();
			}
		});
	}
	
	public void actualizar()
	{
		switch(modelo.getEstadoPuntuacion())
		{
			case 1:
			{
				//NO MUESTRA VENTANA DE LOGUEO
				marcoPuntuacion.setVisible(false);
				break;
			}
			case 2:
			{
				//MUESTRA VENTANA DE LOGUEO
				marcoPuntuacion.setVisible(true);
				
				for(int i=0; i<modelo.getListaUsuario().size(); i++)
				{	
					tablaPuntuacion.setValueAt(((Usuario) modelo.getListaUsuario().get(i)).getNombre(), i, 0);
					tablaPuntuacion.setValueAt(String.valueOf(((Usuario) modelo.getListaUsuario().get(i)).getAcierto()), i, 1);
					tablaPuntuacion.setValueAt(String.valueOf(((Usuario) modelo.getListaUsuario().get(i)).getDesacierto()), i, 2);
					tablaPuntuacion.setValueAt(String.valueOf(((Usuario) modelo.getListaUsuario().get(i)).getPuntuacion()), i, 3);
				}
				
				break;
			}
			case 3:
			{
				//SALE DE VENTANA DE PUNTUACION
				System.exit(0);
				break;
			}
		}
	}
}
