package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de la aplicación.
 */

@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
	//------------------------
	//Constantes
	//------------------------
	
	/**
	 * Constante para cambiar la nave
	 */
	private final String CAMBIAR_NAVE="cambiarNave";
	
	//------------------------
	//Atributos
	//------------------------
	/**
	 * Ventana principal de la aplicación;
	 */
	private InterfazNave principal;
	
	//------------------------
	//Atributos de la interfaz
	//------------------------
	
	/**
	 * Botón para cambiar la nave.
	 */
	private JButton btnCambiarNave;
	
	//------------------------
	//Constructores
	//------------------------
	/**
	 * Construye el panel de opciones. <br>
	 * <b>post:</b> Construyó el panel.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
	 */
	
	public PanelOpciones(InterfazNave pPrincipal)
	{
		principal=pPrincipal;
		
		setBorder(new CompoundBorder(new EmptyBorder(0,0,5,0),new TitledBorder("Opciones")));
		
		setLayout(new GridLayout(1,3));
		
		btnCambiarNave=new JButton("Cambiar Nave");
		btnCambiarNave.setActionCommand(CAMBIAR_NAVE);
		btnCambiarNave.addActionListener(this);
		
		add(btnCambiarNave);
	}
	
	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Acción que generó el evento.pEvento !=null.
	 */
	public void actionPerformed(ActionEvent pEvento)
	{
		String comando=pEvento.getActionCommand();
		if(CAMBIAR_NAVE.equals(comando))
		{
			principal.mostrarDialogoCambiarNave();
		}
	}

}
