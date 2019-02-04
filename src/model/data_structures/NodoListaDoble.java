package model.data_structures;

public class NodoListaDoble<E> extends NodoListaSencilla<E>
{
	/**
	 * Constante de serializaci�n
	 */
	private static final long serialVersionUID = 7L;
	
	/**
	 * Nodo anterior.
	 */
	private NodoListaDoble<E> anterior;
	/**
	 * M�todo constructor del nodo doblemente encadenado
	 * @param elemento elemento que se almacenar� en el nodo.
	 */
	public NodoListaDoble(E elemento) 
	{
		super(elemento);
		anterior = null;
	}
	
	/**
	 * M�todo que retorna el nodo anterior.
	 * @return Nodo anterior.
	 */
	public NodoListaDoble<E> darAnterior()
	{
		return anterior;
	}
	
	/**
	 * M�todo que cambia el nodo anterior por el que llega como par�metro.
	 * @param anterior Nuevo nodo anterior.
	 */
	public void cambiarAnterior(NodoListaDoble<E> anterior)
	{
		this.anterior= anterior;
	}
}
