import java.util.ArrayList;

public interface ModeloInterface 
{
	void registrarObservador(ObservadorInterface o);
	void removerObservador(ObservadorInterface o);
	void notificarObservador();
	void inicioLogueo(String nombre);
	void finLogueo();
	void inicioJuego();
	void finJuego();
	void secuenciaJuego(String boton, int valor);
	void finTiempo();
	void inicioPuntuacion();
	void finPuntuacion();
	int getEstadoLogueo();
	int getEstadoJuego();
	int getEstadoPuntuacion();
	int getReinicioTiempo();
	int getColor();
	int getTecla();
	int[] getVector();
	ArrayList getListaUsuario();
}
