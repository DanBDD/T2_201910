package model.data_structures;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * Clase que contiene lo com�n entre las listas encadenadas.
 * @param <E> Elemento que se almacenar� en la lista, el elemento debe ser �nicamente identificado.
 */
public abstract class ListaEncadenadaAbstracta<E> implements List<E>, Serializable
{

	/**
	 * Constante de serializaci�n.
	 */
	private static final long serialVersionUID = 4L;

	/**
	 * Atributo que indica la cantidad de elementos que han sido almacenados en la lista.
	 */
	protected int cantidadElementos;

	/**
	 * Primer nodo de la lista.
	 */
	//TODO Inicialice el primer nodo de la lista como primerNodo
	protected NodoListaSencilla<E> primerNodo;
	/**
	 * M�todo que retorna los elementos de la lista en forma de un arreglo de objetos.
	 */
	@SuppressWarnings("unchecked")
	public Object[] toArray() 
	{
		E[] arreglo = (E[]) new Object[size()];
		NodoListaSencilla<E> actual = primerNodo;
		int pos = 0;
		while(actual != null)
		{
			arreglo[pos] = actual.darElemento();
			actual = actual.darSiguiente();
			pos ++;
		}

		return arreglo;
	}

	/**
	 * M�todo que devuelve una lista de elementos de la lista como un arreglo de U.
	 * @param array El arreglo donde se deben guardar los elementos a menos que no quepan.
	 * @return Un arreglo con todos los elementos de la lista.
	 */
	@SuppressWarnings("unchecked")
	public<U> U[] toArray(U[] array) 
	{
		if(array.length < size())
		{
			return (U[]) toArray();
		}
		else
		{
			NodoListaSencilla<E> actual = primerNodo;
			int pos =0;
			while(actual != null)
			{
				array[pos] = (U) actual.darElemento();
				actual = actual.darSiguiente();
				pos ++;
			}
			if(array.length > size())
			{
				array[size()] = null;
			}
			return array;
		}
	}


	/**
	 * Indica el tama�o de la lista.
	 * @return La cantidad de nodos de la lista.
	 */
	public int size() 
	{
		return cantidadElementos;
	}

	/**
	 * Reemplaza el elemento de la posici�n por el elemento que llega por par�metro.
	 * @param index La posici�n en la que se desea reemplazar el elemento.
	 * @param element El nuevo elemento que se quiere poner en esa posici�n
	 * @return el m�todo que se ha retirado de esa posici�n.
	 * @throws IndexOutOfBoundsException si la posici�n es < 0 o la posici�n es >= size()
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException 
	{
		E anterior=null;
		int contador=0;
		if(index<0 ||index>= cantidadElementos){
			throw new IndexOutOfBoundsException("La posicion no es valida");
		}
		else{
			NodoListaSencilla<E> actual = primerNodo;
			while(actual!=null){
				if(contador==index){
					anterior=actual.darElemento();
					actual.cambiarElemento(element);
				}
				actual=actual.darSiguiente();
				contador++;
			}

		}
		return anterior;

	}

	/**
	 * Borra de la lista todos los elementos en la colecci�nn que llega por par�metro
	 * @param coleccion la colecci�n de elmentos que se desea eliminar. coleccion != null
	 * @return true en caso que se elimine al menos un elemento o false en caso contrario
	 */
	public boolean removeAll(Collection<?> c) 
	{
		boolean modificado = false;
		for(Object objeto: c)
		{
			modificado |= remove(objeto);
		}
		return modificado;
	}

	/**
	 * Indica la  �ltima posici�n  donde aparece el objeto por par�metro en la lista
	 * @param objeto el objeto buscado en la lista. objeto != null
	 * @return la  �ltima posici�n del objeto en la lista o -1 en caso que no exista
	 */
	public int lastIndexOf(Object o)
	{
		int ultimaPosicion = -1;
		NodoListaSencilla<E> actual = primerNodo;
		int posActual = 0;
		while(actual != null)
		{
			if(actual.darElemento().equals((o)))
			{
				ultimaPosicion = posActual;
			}
			posActual ++;
			actual = actual.darSiguiente();
		}

		return ultimaPosicion;
	}

	/**
	 * Devuelve un iterador sobre la lista
	 * El iterador empieza en el primer elemento
	 * @return un nuevo iterador sobre la lista
	 */
	public Iterator<E> iterator() 
	{
		return new IteradorSencillo<E>(primerNodo);
	}

	/**
	 * Indica si la lista est� vacia
	 * @return true si la lista est� vacia o false en caso contrario
	 */
	public boolean isEmpty() 
	{
		return primerNodo==null?true:false;
	}

	/**
	 * Indica la posici�n en la lsita del objeto que llega por par�metro
	 * @param objeto el objeto que se desea buscar en la lista. objeto != null
	 * @return la posici�n del objeto o -1 en caso que no se encuentre en la lista
	 */
	public int indexOf(Object o) 
	{
		int indice=-1;
		NodoListaSencilla<E> actual=primerNodo;
		boolean fin=false;
		int contador=0;
		while(actual!=null && !fin){
			if(actual.darElemento().equals(o)){
				indice=contador;
				fin=true;
			}
			else{
				actual=actual.darSiguiente();
				contador++;
			}
			
		}
		return indice;
	}

	/**
	 * Devuelve el elemento de la posici�n dada
	 * @param pos la posici�n  buscada
	 * @return el elemento en la posici�n dada 
	 * @throws IndexOutOfBoundsException si index < 0 o index >= size()
	 */
	public E get(int index) throws IndexOutOfBoundsException
	{
		E elemento=null;
		int contador=0;
		if(index<0 ||index>= cantidadElementos){
			throw new IndexOutOfBoundsException("La posicion no es valida");
		}
		else{
			NodoListaSencilla<E> actual = primerNodo;
			while(actual!=null){
				if(contador==index){
					elemento=actual.darElemento();
				}
				actual=actual.darSiguiente();
				contador++;
			}
		}
		return elemento;

	}

	/**
	 * Devuelve el nodo de la posici�n dada
	 * @param pos la posici�n  buscada
	 * @return el nodo en la posici�n dada 
	 * @throws IndexOutOfBoundsException si index < 0 o index >= size()
	 */
	public NodoListaSencilla<E> darNodo(int index)
	{
		if(index < 0 || index > cantidadElementos)
		{
			throw new IndexOutOfBoundsException("Se est� pidiendo el indice: " + index + " y el tama�o de la lista es de " + cantidadElementos);
		}

		NodoListaSencilla<E> actual = primerNodo;
		int posActual = 0;
		while(actual != null && posActual < index)
		{
			actual = actual.darSiguiente();
			posActual ++;
		}

		return actual;
	}

	/**
	 * Indica si la lista contiene todos los objetos de la colecci�n dada
	 * @param coleccion la colecci�n de objetos que se desea buscar. coleccion !=null
	 * @return true en caso que todos los objetos est�n en la lista o false en caso contrario
	 */
	public boolean containsAll(Collection<?> c) 
	{
		boolean contiene = true;
		for(Object objeto: c)
		{
			contiene &= contains(objeto);
		}
		return contiene;
	}

	/**
	 * Indica si la lista contiene el objeto indicado
	 * @param objeto el objeto que se desea buscar en la lista. objeto != null
	 * @return true en caso que el objeto est� en la lista o false en caso contrario
	 */
	public boolean contains(Object o) 
	{
		boolean esta=false;
		NodoListaSencilla<E> actual=primerNodo;;
		while(actual!=null && !esta){
			if(actual.darElemento().equals(o)){
				esta=true;
			}
			actual=actual.darSiguiente();
		}
		return esta;
	}

	/**
	 * Borra todos los elementos de la lista. Actualiza la cantidad de elementos en 0
	 * <b>post:</b> No hay elementos en la lista
	 */
	public void clear() 
	{
		primerNodo=null;
		cantidadElementos=0;
	}

	/**
	 * Agrega todos los elementos de la colecci�n a la lista a partir de la posici�n indicada
	 * Un elemento no se agrega si la lista ya tiene un elemento con el mismo id
	 * @param pos la posici�n a partir de la cual se desean agregar los elementos
	 * @param coleccion la colecci�n de elementos que se desea agregar
	 * @return true si al menos uno de los elementos se agrega o false en caso contrario
	 * @throws NullPointerException Si alguno de los elementos que se quiere agregar es null
	 * @throws IndexOutOfBoundsException si indice < 0 o indice > size()
	 */
	public boolean addAll(int pos, Collection<? extends E> c) throws IndexOutOfBoundsException, NullPointerException
	{
		int size = cantidadElementos;
		for(E actual: c)
		{
			add(pos, actual);
			pos++;
		}

		return cantidadElementos > size;
	}

	/**
	 * Agrega a la lista todos los elementos de la colecci�n
	 * Un elemento no se agrega si la lista ya tiene un elemento con el mismo id
	 * @param coleccion la colecci�n  de elementos que se desea agregar
	 * @return true en caso que se agregue al menos un elemento false en caso contrario
	 * @throws NullPointerException si alguno de los elementos que se desea agregar es null
	 */
	public boolean addAll(Collection<? extends E> c) throws NullPointerException
	{
		boolean modificado = false;
		for(E actual: c)
		{
			modificado |= add(actual);
		}
		return modificado;
	}

}
