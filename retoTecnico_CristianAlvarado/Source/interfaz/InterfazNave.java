package interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import mundo.Nave;
import mundo.Fecha;

/**
 *Ventana principal de la aplicación
 */
@SuppressWarnings("serial")
public class InterfazNave extends JFrame
{
	//------------------------
	//Atributos
	//------------------------
	
	/**
	 * Clase principal del mundo.
	 */
	private Nave nave;
	
	//------------------------
	//Atributos de la interfaz
	//------------------------

	/**
	 * Panel con la imagen
	 */
	private PanelImagen panelImagen;
	
	/**
	 * Panel para mostrar los datos de la nave.
	 */
	private PanelDatos panelDatos;
	
	/**
	 * Panel para realizar consultas sobre la nave.
	 */
	private PanelConsultas panelConsultas;
	
	/**
	 * Panel para ejecutar las extensiones a la aplicación.
	 */
	private PanelOpciones panelOpciones;
	
	//------------------------
	//Constructores
	//------------------------	
	
	/**
	 * Construye una nueva interfaz inicializada con los datos de una nave particular. <br>
	 * <b> post: </b> La interfaz principal y sus paneles quedaron inicializados. 
	 */
	public InterfazNave ()
	{
		setTitle("Diccionario de naves espaciales, Reto Técnico SofkaU");
		setSize(950,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Construir la nave
		
		nave=new Nave();
		
		//Construir los paneles
		JPanel panelCentral=new JPanel();
		panelDatos=new PanelDatos(this);
		panelConsultas=new PanelConsultas(this);
		panelOpciones=new PanelOpciones(this);
		panelImagen=new PanelImagen();
		
		//organizar el panel principal
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panelImagen,BorderLayout.NORTH);
		getContentPane().add(panelCentral,BorderLayout.CENTER);
		getContentPane().add(panelOpciones,BorderLayout.SOUTH);
		
		//organizar el panel central
		panelCentral.setLayout(new BorderLayout());
		panelCentral.add(panelDatos,BorderLayout.NORTH);
		panelCentral.add(panelConsultas,BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		actualizar();	
	}
	
	//------------------------
	//Métodos
	//------------------------
	
	/**
	 * Calcula el tiempo de servicio de la nave y la muestra
	 */
	public void calcularAntiguedad()
	{
		
	}
	
	public void modificarPotencia()
	{
		String strPotencia=JOptionPane.showInputDialog(this, "Introduzca la nueva potencia de la nave.","Modificar potencia", JOptionPane.QUESTION_MESSAGE);
	
		if(strPotencia !=null)
		{
			try
			{
				double nuevaPotencia=Double.parseDouble(strPotencia);
				
				if(nuevaPotencia<=0)
				{
					JOptionPane.showMessageDialog(this,"La potencia debe ser un número positivo.","Modificar potencia",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					nave.cambiarPotencia(nuevaPotencia);
					panelDatos.actualizarPotencia(nave.darPotencia());
				}
			}
			catch (NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(this,"La potencia debe ser un número.","Modificar potencia",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void actualizar()
	{
		String nombre, tipo, propietario, fechaInicio, fechaRetiro, imagen;
		double potencia;
		
		nombre=nave.darNombre();
		tipo=nave.darTipo();
		propietario=nave.darPropietario();
		fechaInicio=nave.darFechaInicio();
		fechaRetiro=nave.darFechaRetiro();
		potencia=nave.darPotencia();
		imagen=nave.darImagen();
		
		panelDatos.actualizarCampos(nombre, tipo, propietario, fechaInicio,fechaRetiro, imagen);
		panelDatos.actualizarPotencia(potencia);
		
		panelConsultas.limpiarCampos();
		
		validate();
	}
	
	/**
	 * Cambia los datos de la nave.
	 * @param pNombre
	 * @param pTipo
	 * @param pPropietario
	 * @param pFechaInicio
	 * @param pFechaRetiro
	 * @param pPotencia
	 * @param pImagen
	 */
	public void cambiarNave(String pNombre,String pTipo,String pPropietario,Fecha pFechaInicio,Fecha pFechaRetiro,int pPotencia,String pImagen)
	{
		nave=new Nave();
		nave.cambiarNave(pNombre, pTipo, pPropietario, pFechaInicio, pFechaRetiro, pPotencia, pImagen);
		actualizar();
	}
	
	public void mostrarDialogoCambiarNave()
	{
		//DialogoCambiarNave dialogo=new DialogoCambiarNave(this);
		//dialogo.setVisible(true);
	}
	
	//------------------------
	//Main
	//------------------------
	
	/**
	 * Ejecuta la aplicación
	 * @param pArgs Parámetros de la ejecución. 
	 */
	public static void main(String[] pArgs)
	{
		try
		{
			//Unifica la interfaz para Mac y Windows.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			
			InterfazNave interfaz=new InterfazNave();
			interfaz.setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
