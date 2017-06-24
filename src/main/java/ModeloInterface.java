
public interface ModeloInterface 
{
	void registrarObservador(ObservadorInterface o);
	void removerObservador(ObservadorInterface o);
	void notificarObservador();
	void inicioLogueo(String nombre);
	int getEstadoLogueo();
	void finLogueo();
}
