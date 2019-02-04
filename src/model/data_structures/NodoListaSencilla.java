package model.data_structures;

import java.io.Serializable;

public class NodoListaSencilla<E> implements Serializable
{

	/**
	 * Constante de Serializaci�n
	 */
	private static final long serialVersionUID = 8L;
	
	/**
	 * Elemento almacenado en el nodo.
	 */
	private E elemento;
	/**
	 * Siguiente nodo.
	 */
	private NodoListaSencilla<E> siguiente;
	
	/**
	 * Constructor del nodo.
	 * @param elemento El elemento que se almacenar� en el nodo. elemento != null
	 */
	public NodoListaSencilla(E elemento)
	{
		this.elemento = elemento;
	}
	
	/**
	 * M�todo que cambia el siguiente nodo.
	 * <b>post: </b> Se ha cambiado el siguiente nodo
	 * @param siguiente El nuevo siguiente nodo
	 */
	public void cambiarSiguiente(NodoListaSencilla<E> siguiente)
	{
		this.siguiente = siguiente;
	}
	
	/**
	 * M�todo que retorna el elemento almacenado en el nodo.
	 * @return El elemento almacenado en el nodo.
	 */
	public E darElemento()
	{
		return elemento;
	}
	
	/**
	 * Cambia el elemento almacenado en el nodo.
	 * @param elemento El nuevo elemento que se almacenar� en el nodo.
	 */
	public void cambiarElemento(E elemento)
	{
		this.elemento = elemento;
	}
	
	
	/**
	 * M�todo que retorna el siguiente nodo.
	 * @return Siguiente nodo
	 */
	public NodoListaSencilla<E> darSiguiente()
	{
		return siguiente;
	}

}
