package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


/**
 *Panel donde se muestran los datos de la nave.
 */
@SuppressWarnings("serial")
public class PanelDatos extends JPanel implements ActionListener
{
	//------------------------
	//Constantes
	//------------------------
	
	/**
	 * Constante para modificar el año de retiro
	 */
	private final static String MODIFICAR_POTENCIA="MODIFICAR POTENCIA";
	
	//------------------------
	//Atributos de la interfaz
	//------------------------
	
	/**
	 * Ventana principal de la aplicación
	 */
	private InterfazNave principal;
	
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
	 * Botón para modificar la potencia de una nave.
	 */
	private JButton btnModificarPotencia;
	
	//------------------------
	//Constructores
	//------------------------	
	
	/**
	 * Construye el panle con la información de la nave. <br>
	 * <b>post:</b> Panel quedó inicializado.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal !=null.
	 */
	
	public PanelDatos(InterfazNave pPrincipal)
	{
		principal=pPrincipal;
		
		setLayout(new BorderLayout());
		setBorder(new CompoundBorder(new EmptyBorder(0,0,6,0),new TitledBorder("Datos")));
		
		lblNombre=new JLabel("Nombre");
		lblTipo=new JLabel("Tipo");
		lblPropietario=new JLabel("Propietario");
		lblFechaInicio=new JLabel("FechaInicio");
		lblFechaRetiro=new JLabel("FechaRetiro");
		lblPotencia=new JLabel("Potencia");
		
		txtNombre=new JTextField(15);
		txtNombre.setEditable(false);
		txtTipo=new JTextField(15);
		txtTipo.setEditable(false);
		txtPropietario=new JTextField(15);
		txtPropietario.setEditable(false);
		txtFechaInicio=new JTextField(15);
		txtFechaInicio.setEditable(false);
		txtFechaRetiro=new JTextField(15);
		txtFechaRetiro.setEditable(false);
		txtPotencia=new JTextField(15);
		txtPotencia.setEditable(false);
		
		btnModificarPotencia=new JButton();
		btnModificarPotencia.setText("Modificar potencia");
		btnModificarPotencia.setActionCommand(MODIFICAR_POTENCIA);
		btnModificarPotencia.addActionListener(this);
		
		JPanel panelDatos=new JPanel(new GridLayout(7,2));
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
		panelDatos.add(btnModificarPotencia);
		
		lblImagen=new JLabel();
		add(panelDatos,BorderLayout.CENTER);
		add(lblImagen,BorderLayout.EAST);
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
	
	public void actualizarCampos(String pNombre, String pTipo, String pPropietario, String pFechaInicio, String pFechaRetiro, String pImagen)
	{
		txtNombre.setText(pNombre);
		txtTipo.setText(pTipo);
		txtPropietario.setText(pPropietario);
		txtFechaInicio.setText(pFechaInicio);
		txtFechaRetiro.setText(pFechaRetiro);
		remove(lblImagen);
		lblImagen=new JLabel(new ImageIcon("./data/imagenes/"+pImagen));
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		lblImagen.setVerticalAlignment(JLabel.CENTER);
		lblImagen.setPreferredSize(new Dimension(170,0));
		add(lblImagen,BorderLayout.EAST);
	}
	
	/**
	 * Actualiza el potencia. <br>
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
	 * Manejo de los eventos de los botones.
	 * @param pEvento Evento de click sobre un botón. pEvento!=null.
	 */
	public void actionPerformed(ActionEvent pEvento)
	{
		String command=pEvento.getActionCommand();
		
		if (command.equals(MODIFICAR_POTENCIA))
		{
			principal.modificarPotencia();
		}
	}
}
