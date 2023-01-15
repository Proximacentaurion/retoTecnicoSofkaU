package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mundo.Nave;
/**
 *Panel donde se muestran los datos de la nave.
 */
@SuppressWarnings("serial")
public class PanelNave extends JPanel implements ActionListener
{
	//------------------------
	//Constantes
	//------------------------
	
	/**
	 * Constante para seleccionar la nueva imagen.
	 */
	private final static String SELECCIONAR_IMAGEN="SELECCIONAR_IMAGEN";
	
	/**
	 * Constante usada para indicar que se quiere limpiar la pantalla.
	 */
	private final static String LIMPIAR="LIMPIAR";
	
	/**
	 * Constante usada para indicar que se quiere agregar una nave
	 */
	private final static String AGREGAR="AGREGAR";
	
	/**
	 * Constante para modificar el año de retiro
	 */
	private final static String MODIFICAR_POTENCIA="MODIFICAR POTENCIA";
	
	//------------------------
	//Atributos
	//------------------------
	/**
	 * La ventana principal de la aplicación.
	 */
	private InterfazListaDeNaves principal;
	//------------------------
	//Atributos de interfaz
	//------------------------

	
	/**
	 * Etiqueta del nombre de la nave.
	 */
	private JLabel lblNombre;
	
	/**
	 * Etiqueta del tipo de nave.
	 */
	private JLabel lblTipo;
	
	/**
	 * Etiqueta del propietario de la nave.
	 */
	private JLabel lblPropietario;
	
	/**
	 * Etiqueta de la fecha de inicio de operaciones de la nave.
	 */
	private JLabel lblFechaInicio;
	
	/**
	 * Etiqueta de la fecha de retiro de la nave.
	 */
	private JLabel lblFechaRetiro;
	
	/**
	 * Etiqueta de la potencia de la nave.
	 */
	private JLabel lblPotencia;
	
	/**
	 * Etiqueta donde se muestra la imagen.
	 */
	private JLabel lblImagen;
	
	
	/**
	 * Campo de texto para el nombre de la nave.
	 */
	private JTextField txtNombre;
	
	/**
	 * Campo de texto para el tipo de nave.
	 */
	private JTextField txtTipo;
	
	/**
	 *Campo de texto para del propietario de la nave.
	 */
	private JTextField txtPropietario;
	
	/**
	 * Campo de texto para la fecha de inicio de operaciones de la nave.
	 */
	private JTextField txtFechaInicio;
	
	/**
	 *Campo de texto para la fecha de retiro de la nave.
	 */
	private JTextField txtFechaRetiro;
	
	/**
	 *Campo de texto para la potencia de la nave.
	 */
	private JTextField txtPotencia;
	
	/**
	 *Campo de texto para la imagen de cada nave
	 */
	private JTextField txtImagen;
	
	/**
	 * Botón para seleccionar la imagen.
	 */
	private JButton btnSelectImagen;
	
	/**
	 * Botón para agregar una nave.
	 */
	private JButton btnAgregar;
	
	/**
	 * Botón para modificar la potencia de una nave.
	 */
	private JButton btnModificarPotencia;
	
	/**
	 * Botón para limpiar el formulario.
	 */
	private JButton btnLimpiar;
	
	//------------------------
	//Constructores
	//------------------------	
	
	/**
	 * Construye el panle con la información de la nave. <br>
	 * <b>post:</b> Panel quedó inicializado.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal !=null.
	 */
	
	public PanelNave(InterfazListaDeNaves pPrincipal)
	{
		principal=pPrincipal;
		
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Datos de la nave"));
		//setBorder(new CompoundBorder(new EmptyBorder(0,0,6,0),new TitledBorder("Datos de la nave")));
		
		//Se organizan los datos
		JPanel panelDatos=new JPanel();
		//panelDatos.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
		panelDatos.setLayout(new GridLayout(7,2));
		
		lblNombre=new JLabel("Nombre");
		txtNombre=new JTextField(15);
		lblTipo=new JLabel("Tipo");
		txtTipo=new JTextField(15);
		lblPropietario=new JLabel("Propietario");
		txtPropietario=new JTextField(15);
		lblFechaInicio=new JLabel("FechaInicio");
		txtFechaInicio=new JTextField(15);
		lblFechaRetiro=new JLabel("FechaRetiro");
		txtFechaRetiro=new JTextField(15);
		lblPotencia=new JLabel("Potencia");
		txtPotencia=new JTextField(15);
		
		panelDatos.add(lblNombre);
		panelDatos.add(txtNombre);
		panelDatos.add(lblTipo);
		panelDatos.add(txtTipo);
		panelDatos.add(lblPropietario);
		panelDatos.add(txtPropietario);
		panelDatos.add(lblFechaInicio);
		panelDatos.add(txtFechaInicio);
		panelDatos.add(lblFechaRetiro);
		panelDatos.add(txtFechaRetiro);
		panelDatos.add(lblPotencia);
		panelDatos.add(txtPotencia);
		panelDatos.add(new JLabel());
		
		add(new JLabel("Imagen:"));
		JPanel panelAux=new JPanel();
		panelAux.setLayout( new BorderLayout());
		txtImagen=new JTextField();
		txtImagen.setEditable(false);
		panelAux.add(txtImagen,BorderLayout.CENTER);
		btnSelectImagen=new JButton("Seleccionar");
		btnSelectImagen.setActionCommand(SELECCIONAR_IMAGEN);
		btnSelectImagen.addActionListener(this);
		panelAux.add(btnSelectImagen,BorderLayout.EAST);
		add(panelAux);
		
		lblImagen=new JLabel();
		add(panelDatos,BorderLayout.CENTER);
		add(lblImagen,BorderLayout.EAST);
		
		//Se organizan los botones
		JPanel panelBotones=new JPanel();
		
		btnAgregar=new JButton();
		btnAgregar.setText("Agregar Nave");
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);
		
		btnModificarPotencia=new JButton();
		btnModificarPotencia.setText("Modificar potencia");
		btnModificarPotencia.setActionCommand(MODIFICAR_POTENCIA);
		btnModificarPotencia.addActionListener(this);
		
		btnLimpiar=new JButton();
		btnLimpiar.setText("Limpiar");
		btnLimpiar.setActionCommand(LIMPIAR);
		btnLimpiar.addActionListener(this);
		
		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificarPotencia);
		panelBotones.add(btnLimpiar);
		
		add(panelBotones,BorderLayout.SOUTH);
	}
	
	//------------------------
	//Métodos
	//------------------------		
	
	/**
	 * Actualiza los campos del panel conla información de la nave. <br>
	 * <b>post:</b> Los campos muestran la nueva información.
	 * @param pNombre Nombre de la nave. pNombre!=null && pNombre!=""
	 * @param pImagen Ruta donde se encuentra la imagen.pImagen !=null.
	 */
	
	public void actualizarCampos(String pNombre, String pTipo, String pPropietario, String pFechaInicio, String pFechaRetiro)
	{
		txtNombre.setText(pNombre);
		txtTipo.setText(pTipo);
		txtPropietario.setText(pPropietario);
		txtFechaInicio.setText(pFechaInicio);
		txtFechaRetiro.setText(pFechaRetiro);
		remove(lblImagen);
		//lblImagen=new JLabel(new ImageIcon("./data/imagenes/"+pImagen));
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		lblImagen.setVerticalAlignment(JLabel.CENTER);
		lblImagen.setPreferredSize(new Dimension(170,0));
		add(lblImagen,BorderLayout.EAST);
	}
	
	/**
	 * Actualiza la potencia. <br>
	 * <b>post:</b> Se cambió la potencia mostrada.
	 * @param pPotencia Potencia de la nave. pPotencia!=null && pNombre!=""
	 */
	public void actualizarPotencia(double pPotencia)
	{
		DecimalFormat df=(DecimalFormat)NumberFormat.getInstance();
		df.applyPattern("$###,###.##");
		txtPotencia.setText(df.format(pPotencia));
	}
	
	/**
	 * Limpia los campos del panel
	 */
	public void limpiarCampos()
	{
		txtNombre.setText("");
		txtTipo.setText("");
		txtPropietario.setText("");
		txtFechaInicio.setText("");
		txtFechaRetiro.setText("");
		txtPotencia.setText("");
	}
	
	/**
	 * Muestra la información de la nave seleccionada
	 */
	public void mostraNave(Nave pNave)
	{
		txtNombre.setText(pNave.darNombre());
		txtTipo.setText(pNave.darTipo());
		txtPropietario.setText(pNave.darPropietario());
		txtFechaInicio.setText(pNave.darFechaInicio());
		txtFechaRetiro.setText(pNave.darFechaRetiro());
		txtPotencia.setText(pNave.darPotencia());
	}
	
	/**
	 * Retorna el nombre ingresado por el usuario
	 */
	public String darNombre()
	{
		return txtNombre.getText().trim();
	}
	
	public String darTipo()
	{
		return txtTipo.getText().trim();
	}
	
	public String darPropietario()
	{
		return txtPropietario.getText().trim();
	}
	
	public String darFechaInicio()
	{
		return txtFechaInicio.getText().trim();
	}
	
	public String darFechaRetiro()
	{
		return txtFechaRetiro.getText().trim();
	}
	
	public String darPotencia()
	{
		return txtPotencia.getText().trim();
	}
	
	//public String darImagen()
	//{
		//return "./data/imagenes/"+pImagen
	//}
	
	
	/**
	 * Muestra la información de la nave dada.
	 * @param pNave Nave a mostrar
	 */
	public void mostrarNave(Nave pNave)
	{
		txtNombre.setText(pNave.darNombre());
	}
	
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento!=null.
	 */
	public void actionPerformed(ActionEvent pEvento)
	{
		String comando=pEvento.getActionCommand();
		if(comando.equals(AGREGAR))
		{
			principal.agregarNave();
		}
		else if (comando.equals(MODIFICAR_POTENCIA))
		{
			principal.modificarPotencia();
		}
		else if (comando.equals(LIMPIAR))
		{
			limpiarCampos();
		}
	}
}
