
public class Usuario 
{
	private String nombre;
	private int acierto;
	private int desacierto;
	private int puntuacion;
	
	public Usuario()
	{
		nombre = "";
		acierto = 0;
		desacierto = 0;
		puntuacion = 0;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setAcierto(int acierto)
	{
		this.acierto = acierto;
	}
	
	public void setDesacierto(int desacierto)
	{
		this.desacierto = desacierto;
	}
	
	public void setPuntuacion(int puntuacion)
	{
		this.puntuacion = puntuacion;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getAcierto()
	{
		return acierto;
	}
	
	public int getDesacierto()
	{
		return desacierto;
	}
	
	public int getPuntuacion()
	{
		return puntuacion;
	}
}
