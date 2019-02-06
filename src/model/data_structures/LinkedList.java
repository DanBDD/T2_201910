package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E>  extends ListaEncadenadaAbstracta<E> {

	/**
	 * Construye una lista vacia
	 * <b>post:< /b> se ha inicializado el primer nodo en null
	 */
	public LinkedList() 
	{
		primerNodo = null;
		cantidadElementos = 0;
	}

	/**
	 * Se construye una nueva lista cuyo primer nodo  guardar� al elemento que llega por par�mentro
	 * @param nPrimero el elemento a guardar en el primer nodo
	 * @throws NullPointerException si el elemento recibido es nulo
	 */
	public LinkedList(E nPrimero)throws NullPointerException
	{
		if(primerNodo == null)
		{
			throw new NullPointerException("Se recibe un elemento nulo");
		}
		primerNodo = new NodoListaDoble<E>(nPrimero);
		cantidadElementos++;
	}

	/**
	 * Agrega un elemento al final de la lista
	 * Un elemento no se agrega si la lista ya tiene un elemento con el mismo id.
	 * Se actualiza la cantidad de elementos.
	 * @param e el elemento que se desea agregar.
	 * @return true en caso que se agregue el elemento o false en caso contrario. 
	 * @throws NullPointerException si el elemento es nulo
	 */
	public boolean add(E e) throws NullPointerException
	{
		boolean bien=false;
		if(e==null){
			throw new NullPointerException("El elemento es nulo");
		}
		else{
			if(contains(e)){
			}
			else{
				if(primerNodo==null){
					primerNodo= new NodoListaDoble<E>(e);
					primerNodo.cambiarElemento(e);
					cantidadElementos++;
					bien=true;
				}
				else{
					NodoListaDoble<E> ultimo = (NodoListaDoble<E>) darNodo(cantidadElementos-1);
					NodoListaDoble<E> nodo = new NodoListaDoble<E>(e);
					nodo.cambiarAnterior(ultimo);
					ultimo.cambiarSiguiente(nodo);
					bien=true;
					cantidadElementos++;
				}
			}
		}
		return bien;
	}
	/**
	 * Agrega un elemento al final de la lista. Actualiza la cantidad de elementos.
	 * Un elemento no se agrega si la lista ya tiene un elemento con el mismo id
	 * @param elemento el elemento que se desea agregar.
	 * @return true en caso que se agregue el elemento o false en caso contrario. 
	 * @throws NullPointerException si el elemento es nulo
	 */
	public void add(int index, E elemento) throws NullPointerException, IndexOutOfBoundsException
	{
		if(elemento==null){
			throw new NullPointerException("El elemento es nulo");
		}
		else if(index<0 || index>size()){
			throw new IndexOutOfBoundsException("La posicion no es valida");
		}
		else{
			if (contains(elemento)){

			}
			else{
				NodoListaDoble<E> nodo= new NodoListaDoble<E>(elemento);
				if(index==0){
					nodo.cambiarSiguiente(primerNodo);
					primerNodo= nodo;

				}
				else if(index==size()){
					this.add(elemento);
					cantidadElementos--;
				}
				else{
					NodoListaDoble<E> antes= (NodoListaDoble<E>) darNodo(index-1);
					NodoListaDoble<E> despues= (NodoListaDoble<E>) darNodo(index);
					nodo.cambiarSiguiente(despues);
					nodo.cambiarAnterior(antes);
					despues.cambiarAnterior(nodo);
					antes.cambiarSiguiente(nodo);
				}
				cantidadElementos++;
			}
		}
	}

	/**
	 * M�todo que retorna el iterador de la lista.
	 * @return el iterador de la lista.
	 */
	public ListIterator<E> listIterator() 
	{
		return new IteradorLista<E>((NodoListaDoble<E>) primerNodo);
	}

	/**
	 * M�todo que retorna el iterador de la lista desde donde se indica.
	 * @param index �ndice desde se quiere comenzar a iterar.
	 * @return el iterador de la lista.
	 * @throws IndexOutOfBoundsException si index < 0 o index >= size()
	 */
	public ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException
	{
		if(index< 0 || index >= size()){
			throw new IndexOutOfBoundsException("El �ndice buscado est� por fuera de la lista.");
		}
		return new IteradorLista<E>((NodoListaDoble<E>) darNodo(index));
	}

	/**
	 * Elimina el nodo que contiene al objeto que llega por par�metro.
	 * Actualiza la cantidad de elementos.
	 * @param objeto el objeto que se desea eliminar. objeto != null
	 * @return true en caso que exista el objeto y se pueda eliminar o false en caso contrario
	 */
	public boolean remove(Object o) 
	{
		boolean eliminado=false;
		if(isEmpty()){
			eliminado=false;
		}
		else if(!contains(o)){
			eliminado=false;
		}
		else{
			if(indexOf(o)==0){
				primerNodo=primerNodo.darSiguiente();
			}
			else if(indexOf(o)==cantidadElementos|| indexOf(o)+1==cantidadElementos){
				NodoListaDoble<E> antes = (NodoListaDoble<E>) darNodo(indexOf(o)-1);
				antes.cambiarSiguiente(null);
			}
			else{
				NodoListaDoble<E> antes = (NodoListaDoble<E>) darNodo(indexOf(o)-1);
				NodoListaDoble<E> despues = (NodoListaDoble<E>) darNodo(indexOf(o)+1);
				antes.cambiarSiguiente(despues);
				despues.cambiarAnterior(antes);
			}
			eliminado=true;
			cantidadElementos--;

		}			
		return eliminado;
	}

	/**
	 * Elimina el nodo en la posici�n por par�metro.
	 * Actualiza la cantidad de elementos.
	 * @param pos la posici�n que se desea eliminar
	 * @return el elemento eliminado
	 * @throws IndexOutOfBoundsException si index < 0 o index >= size()
	 */
	public E remove(int index) 
	{
		if(index<0 || index>=size()){
			throw new IndexOutOfBoundsException("La posicion no es valida");
		}
		E elemento=null;
		if(isEmpty()){
			elemento=null;
		}
		else{
			if(index==0){
				elemento=primerNodo.darElemento();
				primerNodo=primerNodo.darSiguiente();
			}
			else if(index==size()-1){
				elemento=darNodo(index).darElemento();
				NodoListaDoble<E> antes = (NodoListaDoble<E>) darNodo(index-1);
				antes.cambiarSiguiente(null);
			}
			else{
				NodoListaDoble<E> nodo = (NodoListaDoble<E>) darNodo(index);
				elemento=nodo.darElemento();
				NodoListaDoble<E> antes = (NodoListaDoble<E>) darNodo(index-1);
				NodoListaDoble<E> despues = (NodoListaDoble<E>) darNodo(index+1);
				antes.cambiarSiguiente(despues);
				despues.cambiarAnterior(antes);
			}
			cantidadElementos--;
		}
		return elemento;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return cantidadElementos;
	}



}
