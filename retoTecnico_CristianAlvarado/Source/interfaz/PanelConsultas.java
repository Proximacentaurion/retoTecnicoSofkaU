package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel para las consultas y operaciones de la aplicacón
 *
 */
@SuppressWarnings("serial")
public class PanelConsultas extends JPanel implements ActionListener

{
	//------------------------
	//Constantes
	//------------------------
		
	/**
	* Constante para calcular la antiguedad de la nave
	*/
	private final static String CALCULAR_ANTIGUEDAD="CALCULAR ANTIGUEDAD";
		
	//------------------------
	//Atributos		
	//------------------------
	private InterfazNave principal;
		
	//------------------------
	//Atributos de la interfaz
	//------------------------
		
	/**
	 * Campo donde se muestra la antiguedad de la nave
	 */
	private JTextField txtAntiguedad;
	
	/**
	 * Botón para calcular la antiguedad de la nave
	 */
	private JButton btnAntiguedad;
		
	//------------------------
	//Constructores
	//------------------------
		
	/**
	 * Construye el panel de datos a consultar. <br>
	 * <b>post:</b> Panel quedó inicializado.
	 * @param pPrincipal Interfaz principal de la aplicación. pPrincipal !=null.
	 */		
	public PanelConsultas(InterfazNave pPrincipal)
	{
		principal=pPrincipal;
		setLayout(new BorderLayout());
		setBorder(new CompoundBorder(new EmptyBorder(0,0,5,0), new TitledBorder("Cálculos")));
		
		btnAntiguedad=new JButton();
		btnAntiguedad.setText("Calcular Antigüedad");
		btnAntiguedad.setActionCommand(PanelConsultas.CALCULAR_ANTIGUEDAD);
		btnAntiguedad.addActionListener(this);
		
		txtAntiguedad=new JTextField(10);
		txtAntiguedad.setEditable(false);
		
		JPanel panelCalculos= new JPanel(new GridLayout(3,2));
		
		add(panelCalculos,BorderLayout.CENTER);
		panelCalculos.add(btnAntiguedad);
		panelCalculos.add(txtAntiguedad);
	}
	
	//------------------------
	//Métodos
	//------------------------
	/**
	 * Limpia los cambpos. <br>
	 * <b>post:</b> Todos los campos del panel están limpios.
	 */
	public void limpiarCampos()
	{
		txtAntiguedad.setText("");
	}
	
	/**
	 * Manejo de lso eventos de los botones.
	 * @param pEvento Acción ge generó el event. pEvento !=null.
	 */
	public void actionPerformed(ActionEvent pEvento)
	{
		String command=pEvento.getActionCommand();
		
		if(command.equals(CALCULAR_ANTIGUEDAD))
		{
			principal.calcularAntiguedad();
		}
	}
	
}
