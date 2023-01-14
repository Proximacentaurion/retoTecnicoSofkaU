package mundo;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
*Clase que representa una nave espacial
*/

public class Nave {
	//------------------------
	//Atributos
	//------------------------

	/**
	*Nombre de la nave
	*/
	private String nombre;

	/**
	*Tipo de nave
	*/
	private String tipo;

	/**
	*País propietario de la nave
	*/
	private String propietario;

	/**
	*Peso de la nave
	*/
	private String peso;

	/**
	*Empuje de la nave
	*/
	private double empuje;

	/**
	*Capacidad de transporte de la nave
	*/
	private double capacidad;

	/**
	*Fecha de retiro de servicio de la nave
	*/
	private Fecha fechaRetiro;

	/**
	*Fecha de inicio de operaciones de la nave
	*/
	private Fecha fechaInicio;

	/**
	*Tiempo de servicio de la nave
	*/
	private double tiempoServicio;

	/**
	*Altura de la nave
	*/
	private double altura;

	/**
	*Potencia de la nave
	*/
	private double potencia;

	/**
	*Ruta de la imagen de la nave;
	*/
	private String imagen;

	//------------------------
	//Métodos
	//------------------------

	/**
	*Se construye la nave
	*<b>post: </b> Se creó la nave con los siguientes valores: <br>
	*Nombre: Saturno V, Tipo: Vehículos lanzadera, Propietario: EEUU, fechaInicio:1967, fecha Retiro:1973
	*/
	public Nave()
	{
		nombre="Saturno V";
		tipo="Vehículos lanzadera";
		propietario="EEUU";
		fechaInicio=new Fecha (1967);
		fechaRetiro=new Fecha (1973);
		potencia=5;
	}

	/**
	*Retorna el nombre de la nave.
	*@return Nombre de la nave.
	*/
	public String darNombre()
	{
		return nombre;
	}

	/**
	*Retorna el tipo de la nave.
	*@return Tipo de la nave.
	*/
	public String darTipo()
	{
		return tipo;
	}

	/**
	*Retorna el propietario de la nave.
	*@return Propietario de la nave.
	*/
	public String darPropietario()
	{
		return propietario;
	}

	/**
	*Retorna la fecha de inicio de operaciones de la nave.
	*@return Fecha de inicio de operaciones.
	*/
	public String darFechaInicio()
	{
		String strFechaInicio=fechaInicio.toString();
		return strFechaInicio;
	}

	/**
	*Retorna la fecha de retiro de operaciones de la nave.
	*@return Fecha de retiro de operaciones.
	*/
	public String darFechaRetiro()
	{
		String strFechaRetiro=fechaRetiro.toString();
		return strFechaRetiro;
	}

	/**
	 * Retorna la antiguedad de la nave
	 * @return antiguedad de la nave en años
	 */
	public int calcularAntiguedad()
	{
		Fecha hoy=darFechaActual();
		int antiguedad=fechaInicio.darDiferenciaEnAnios(hoy);
		return antiguedad;
	}
	
	public double darPotencia()
	{
		return potencia;
	}
	
	/**
	*Retorna la ruta de la imagen de la nave.
	*@return ruta de la imagen.
	*/
	public String darImagen()
	{
		return imagen;
	}

	/**
	*Cambia la información del empleado con los valores dados por parámetro
	*@param pNombre
	*@param pTipo
	*@param pPropietario
	*@param pAñoInicio
	*@param pAñoRetiro
	*@param pImagen
	*/
	public void cambiarNave(String pNombre, String pTipo, String pPropietario, Fecha pAñoInicio, Fecha pAñoRetiro,double pPotencia, String pImagen)
	{
		nombre=pNombre;
		tipo=pTipo;
		propietario=pPropietario;
		fechaInicio=pAñoInicio;
		fechaRetiro=pAñoRetiro;
		potencia=pPotencia;
		imagen=pImagen;
	}
	
	public void cambiarPotencia(double pPotencia)
	{
		potencia=pPotencia;
	}

	/**
	*Retorna el año actual.
	*@return Fecha actual.
	*/
	public Fecha darFechaActual()
	{
		GregorianCalendar gc=new GregorianCalendar();
		int anio=gc.get(Calendar.YEAR);
		Fecha hoy=new Fecha(anio);
		return hoy;
	}
	
	
}
