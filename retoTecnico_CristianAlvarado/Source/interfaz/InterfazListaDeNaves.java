package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


import mundo.ListaDeNaves;
import mundo.Nave;
import mundo.Fecha;


/**
 *Ventana principal de la aplicación
 */
@SuppressWarnings("serial")
public class InterfazListaDeNaves extends JFrame

{
	//------------------------
	//Constantes
	//------------------------
	
	/**
	 * Constante para seleccionar la nueva imagen.
	 */
	private final static String SELECCIONAR_IMAGEN="SELECCIONAR_IMAGEN";
	
	/**
	 * Constante para aceptar la nueva imagen.
	 */
	private final static String ACEPTAR="ACEPTAR";
	
	/**
	 * Constante para cancelar la nueva imagen.
	 */
	private final static String CANCELAR="CANCELAR";
	
	//------------------------
	//Atributos
	//------------------------
	/**
	 * Lista de naves.
	 */
	private ListaDeNaves lista;
	
	//------------------------
	//Atributos de la interfaz
	//------------------------

	/**
	 * Panel con la imagen
	 */
	private PanelImagen panelImagen;
	
	/**
	 * Panel para desplegar la lista de naves.
	 */
	private PanelLista panelLista;
	
	/**
	 * Panel para mostrar los datos de la nave.
	 */
	private PanelNave panelNave;
	
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
	 * Construye una nueva interfaz. <br>
	 * <b> post: </b> La interfaz principal y sus paneles quedaron inicializados. 
	 */
	public InterfazListaDeNaves ()
	{
		setTitle("Diccionario de naves espaciales, Reto Técnico SofkaU");
		setSize(960,730);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lista=new ListaDeNaves();
		
		setLayout(new BorderLayout());
		
		//Construir los paneles
		panelImagen=new PanelImagen();
		panelLista=new PanelLista(this);
		panelNave=new PanelNave(this);
		panelConsultas=new PanelConsultas(this);
		panelOpciones=new PanelOpciones(this);
		
		JPanel centro=new JPanel();
		centro.setLayout(new BorderLayout());
		
		add(panelImagen,BorderLayout.NORTH);
		add(centro, BorderLayout.CENTER);
		centro.add(panelLista,BorderLayout.NORTH);
		centro.add(panelNave,BorderLayout.CENTER);
		//centro.add(panelConsultas,BorderLayout.SOUTH);
		add(panelOpciones,BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setResizable(false);		
	}
		
	//------------------------
	//Métodos
	//------------------------
	
	/**
	 * Retorna la lista de los nombres de todas las naves.
	 * @return Lista de nombres de todas las naves.
	 */
	public ArrayList<String> darNaves()
	{
		return lista.darTodasLasNaves();
	}
	
	/**
	 *Muestra la información de la nave seleccionada.
	 *
	 */
	public void visualizarNave()
	{
		String nombre=panelLista.darNombreSeleccionado();
		if(nombre==null)
		{
			JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna nave","Lista de Naves", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Nave c=lista.buscarNave(nombre);
			if(c!=null)
			{
				panelNave.mostrarNave(c);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "La nave no existe","Lista de Naves", JOptionPane.ERROR_MESSAGE);	
			}
		}	
	}
	
	
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
//					nave.cambiarPotencia(nuevaPotencia);
//					panelDatos.actualizarPotencia(nave.darPotencia());
				}
			}
			catch (NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(this,"La potencia debe ser un número.","Modificar potencia",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	
	/**
	 * Busca y despliega todas las naves encontradas por una palabra
	 */
	public void buscarNavesPalabra()
	{
		String palabra=JOptionPane.showInputDialog(this,"Escriba el nombre de la nave a buscar","Lista de naves",JOptionPane.PLAIN_MESSAGE);
		if (palabra!=null)
		{
			if(palabra.equals(""))
			{
				JOptionPane.showMessageDialog(this,"Debe ingresar una palabra","Lista de Naves",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				ArrayList<String> listaC=lista.buscarNavesPalabraClave(palabra);
			    if(listaC.size()==0)
			    {
			    	JOptionPane.showMessageDialog(this,"No se encontraron naves con esa palabra","Lista de Naves",JOptionPane.INFORMATION_MESSAGE);
			    }
			    else
			    {
			    	panelLista.actualizarLista(listaC);
			    }
			}
		}
	}
	
	/**
	 * Agrega una nueva nave a la lista, si no existe otra nave con el mismo nombre.<br>
	 * <b>post:</b> Se agrega una nueva nave a la lista en caso de que esta no exista aún en ella.
	 */
	public void agregarNave()
	{
		String nombre=panelNave.darNombre();
		if(nombre.equals(""))
		{
			JOptionPane.showMessageDialog(this,"El nombre de la nave es requerido","Lista de Naves",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			String tipo=panelNave.darTipo();
			String propietario=panelNave.darPropietario();
			String fechaInicio=panelNave.darFechaInicio();
			String fechaRetiro=panelNave.darFechaRetiro();
			String potencia=panelNave.darPotencia();
		
			boolean accion=lista.agregarNave(nombre, tipo, propietario, fechaInicio, fechaRetiro, potencia);
			if(!accion)
			{
				JOptionPane.showMessageDialog(this,"ya existe una nave con el mismo nombre","Lista de Naves",JOptionPane.ERROR_MESSAGE);	
			}
			else
			{
				panelLista.actualizarLista(lista.darTodasLasNaves());
				panelNave.limpiarCampos();
			}		
		}
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
			
			InterfazListaDeNaves interfaz=new InterfazListaDeNaves();
			interfaz.setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
