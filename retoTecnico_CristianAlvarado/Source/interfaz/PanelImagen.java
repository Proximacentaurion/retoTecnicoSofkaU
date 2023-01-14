package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen del encabezado
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{
	//------------------------
	//Constructores
	//------------------------
	
	/**
	 * Constructor del panel. <br>
	 * <b>post:</b> Panel quedó inicializado.
	 */
	public PanelImagen()
	{
		JLabel imagen=new JLabel();
		ImageIcon icono=new ImageIcon("./data/imagenes/Encabezado.png");
		imagen=new JLabel("");
		imagen.setIcon(icono);
		add(imagen);
		
	}

}
