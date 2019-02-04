package model.data_structures;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase que representa el iterador sencillo (s�lo avanza hacia adelante).
 * @param <E> Tipo de informaci�n que almacena el iterador.
 */
public class IteradorSencillo<E> implements Iterator<E>, Serializable 
{

	/**
	 * Constante de serializaci�n
	 */
	private static final long serialVersionUID = 2L;
	
	/**
	 * El nodo donde se encuentra el iterador.
	 */
	private NodoListaSencilla<E> actual;

	
	public IteradorSencillo(NodoListaSencilla<E> primerNodo) 
	{
		actual = primerNodo;
	}
	
	/**
     * Indica si a�n hay elementos por recorrer
     * @return true en caso de que  a�n haya elemetos o false en caso contrario
     */
	public boolean hasNext() 
	{
		return actual != null;
	}
	
	/**
     * Devuelve el siguiente elemento a recorrer
     * <b>post:</b> se actualizado actual al siguiente del actual
     * @return objeto en actual
     * @throws NoSuchElementException Si se encuentra en el final de la lista y se pide el siguiente elemento.
     */
	public E next() throws NoSuchElementException
	{
		if(actual == null)
			throw new NoSuchElementException("Se ha alcanzado el final de la lista");
		E valor = actual.darElemento();
		actual = actual.darSiguiente();
		return valor;
	}

}
