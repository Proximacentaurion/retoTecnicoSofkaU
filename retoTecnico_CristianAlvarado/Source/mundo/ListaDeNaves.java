package mundo;

import java.util.ArrayList;

/**
 * Clase que representa el listado de naves
 */
public class ListaDeNaves {
	
	//------------------------
	//Atributos
	//------------------------

	/**
	 * Lista de naves.
	 */
	private ArrayList<Nave> naves;
	
	//------------------------
	//Constructores
	//------------------------
	/**
	 * Crea una lista de naves vacía. <br>
	 * <b>post:</b> Se inicializa la lista de naves.
	 */
	public ListaDeNaves()
	{
		naves=new ArrayList<Nave>();
	}
	//------------------------
	//Métodos
	//------------------------
	/**
	 * Retorna una lista con el nombre de las naves. <br>
	 * <b>pre:</b> La lista de naves está inicializada.
	 * @return La lista de naves. Si no hay naves la lista se retorna vacía.
	 */
	public ArrayList<String> darTodasLasNaves()
	{
		ArrayList<String> lista=new ArrayList<String>();
		for(int i=0;i<naves.size();i++)
		{
			Nave c=naves.get(i);
			lista.add(c.darNombre());
		}
		return lista;
	}
	
	/**
	 * Retorna una lista con todas las naves que tienen la palabra clave.
	 */
	public ArrayList<String> buscarNavesPalabraClave(String pPalabra)
	{
		ArrayList<String> nombres=new ArrayList<String>();
		for (int i=0;i<naves.size();i++)
		{
			Nave c=naves.get(i);
			if(c.contienePalabraClave(pPalabra))
			{
				nombres.add(c.darNombre());
			}
		}
		return nombres;
	}
	
	
	/**
	 * Agrega una nueva nave a la lista
	 */
	public boolean agregarNave(String pNombre, String pTipo, String pPropietario, String pAñoInicio, String pAñoRetiro,String pPotencia)
	{
		Nave con=buscarNave(pNombre);
		boolean exito=false;
		con=null;
		if(con==null)//se puede agregar la nave
		{
			Nave nueva=new Nave(pNombre,pTipo,pPropietario,pAñoInicio,pAñoRetiro,pPotencia);
            naves.add(nueva);
            exito=true;
		}
		return exito;
	}
		
	
	/**
	 * Busca una nave dado su nombre. <br>
	 */
	public Nave buscarNave(String pNombre)
	{
		int contador=0;
		Nave nav=null;
		boolean encontrada=false;
		while(contador<naves.size() && !encontrada)
		{
			nav=naves.get(contador);
			if(pNombre.equals(nav.darNombre()))
			{
				encontrada=true;
			}
			
			contador++;
		}
		if(!encontrada)
		{
			nav=null;
		}
		return nav;
	}
	
	
}
