package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * Panel que muestra la lista de naves
 */
@SuppressWarnings("serial")
public class PanelLista extends JPanel implements ActionListener
{
	//------------------------
	//Constantes
	//-----------------------
	
	/**
	 * Constante usada para indicar que se quieren ver todas las naves.
	 */
	private final static String TODAS="TODAS";
	
	/**
	 * Constante usada para indicar que se quiere ver la información de la nave con la palabra.
	 */
	private final static String PALABRA="PALABRA";
	
	/**
	 * Constante usada para indicar que se quieren ver todos los datos de una nave.
	 */
	private final static String VER="VER";
	
	//------------------------
	//Atributos
	//-----------------------
	
	/**
	 * La ventana principal de la aplicación.
	 */
	private InterfazListaDeNaves principal;
	
	//------------------------
	//Atributos de la interfaz
	//-----------------------
	
	/**
	 * Panel de desplazamiento de la lista de naves.
	 */
	private JScrollPane panelLista;
	
	/**
	 * Lista de naves.
	 */
	private JList listaNaves;
	
	/**
	 * Botón al que se le asignará la acción para mostrar los datos de una nave.
	 */
	private JButton btnVer;
	
	/**
	 * Botón para la acción de ver todas las naves.
	 */
	private JButton btnTodas;
	
	/**
	 * Botón para hacer búsqueda de nave por palabra clave.
	 */
	private JButton btnPalabra;
	
	//------------------------
	//Constructores
	//------------------------
	
	/**
	 * Crea el panel de visualización de la lista de naves.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal !=null.
	 */
	public PanelLista(InterfazListaDeNaves pPrincipal)
	{
		principal=pPrincipal;
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Lista de Naves"));
		
		//Inicializa la lista
		listaNaves=new JList();
		panelLista=new JScrollPane();
		panelLista.setViewportView(listaNaves);
		panelLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelLista.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		listaNaves.setModel(new DefaultListModel());
		
		//Inicializa los botones
		btnVer=new JButton();
		btnVer.setText("Ver");
		btnVer.setActionCommand(VER);
		btnVer.addActionListener(this);
		
		btnTodas=new JButton();
		btnTodas.setText("Ver todas las naves");
		btnTodas.setActionCommand(TODAS);
		btnTodas.addActionListener(this);
		
		btnPalabra=new JButton();
		btnPalabra.setText("Buscar por palabra");
		btnPalabra.setActionCommand(PALABRA);
		btnPalabra.addActionListener(this);
		
		//Ubica los elementos inicializados anteriormente
		add(panelLista,BorderLayout.CENTER);
		
		JPanel panelBotones=new JPanel();
		panelBotones.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		panelBotones.setLayout(new GridLayout(3,1,2,2));
		panelBotones.add(btnTodas);
		panelBotones.add(btnPalabra);
		panelBotones.add(btnVer);
		
		add(panelBotones,BorderLayout.EAST);
	}
	//------------------------
	//Métodos
	//------------------------
	
	/**
	 * Actualiza la lista con los elementos del arrayList.
	 * @param pLista La nueva lista de nombres de naves para mostrar.
	 */
	public void actualizarLista(ArrayList pLista)
	{
		listaNaves.setListData(pLista.toArray());
	}
		
	/**
	 * Retorna el nombre de la nave seleccionada.
	 * @return Nombre de la nave seleccioanda. Si no hay una nave seleccionada retorna null.
	 */
	public String darNombreSeleccionado()
	{
		String nombreN=((String)listaNaves.getSelectedValue());
		if(nombreN!=null)
		{
			nombreN=nombreN.substring(0,nombreN.indexOf(" "));	
		}

		return nombreN;		
	}
	
	/**
	 * Recibe los eventos realizados en los elementos de la interfaz y realiza acciones.
	 * @param pEvento El evento realizado por el usuario. pEvento!=null.
	 */
	public void actionPerformed(ActionEvent pEvento)
	{
		String comando=pEvento.getActionCommand();
		if(comando.equals(VER))
		{
			principal.visualizarNave();
		}
		else if(comando.equals(TODAS))
		{
			actualizarLista(principal.darNaves());
		}
		else if(comando.equals(PALABRA))
		{
			principal.buscarNavesPalabra();
		}	
	}
}
