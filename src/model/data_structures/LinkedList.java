package model.data_structures;

import java.util.Iterator;

public class LinkedList<T> implements ILinkedList<T> {

	private int numElementos;

	private Nodo<T> primerNodo;

	private Nodo<T> ultimoNodo;

	public LinkedList(){
		primerNodo = null;
		ultimoNodo = null;
		numElementos = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(numElementos);
	}

	@Override
	public Integer getSize() {
		return numElementos;
	}

	/**
	 * Metodo que agrega el elemento que entra por parametro en la ultima posicion de la lista
	 * Verifica los casos que haya: Si la lista es vacía, hace que el elemento nuevo sea el primero. Si la lista contiene ese elemento, no lo agrega.
	 * @param elem: Elemento a agregar
	 *  * @return false si no se agrego el elemento, true de lo contrario.
	 */
	@Override
	public boolean agregarElemento(T elem) {
		boolean agrego = false;

		if(elem == null){
			throw new NullPointerException();
		}
		if(contiene(elem)){
			agrego = false;
		}
		else{

			if(primerNodo == null){
				primerNodo = new Nodo<T>(elem);
				numElementos++;
				agrego = true;
			}

			else{

				if(!contiene(elem)){
					Nodo<T> nuevo = new Nodo<T>(elem);
					ultimoNodo.cambiarSiguiente(nuevo);
					nuevo.cambiarAnterior(ultimoNodo);
					nuevo.cambiarSiguiente(null);
					numElementos++;
					agrego = true;
				}
			}
		}
		return agrego;
	}

	/**
	 * Método que agrega un elemento en una posicion determinada de la lista
	 * No se agrega el elemento si ya existe en la lista
	 * @param elem elemento a agregar en la lista
	 * @param pos posicion en la que se quiere agregar el elemento 
	 * @throws IndexOutOfBoundsException si la posicion deseada es menor que cero o si es mayor o igual al tamano de la lista
	 * @throws NullPointerException si el elemento a agregar es nulo
	 * @return true si se agrego, false en caso contrario
	 */
	@Override
	public void agregarElementoPosicion(T elem, int pos) {
		

		if(elem == null){

			throw new NullPointerException();
		}

		if(pos < 0 || pos >= numElementos){
			throw new IndexOutOfBoundsException();
		}

		if(primerNodo == null){
			primerNodo = new Nodo<T>(elem);
			numElementos++;
		}

		else if(primerNodo.darSiguiente() == null){

			Nodo<T> nuevo = new Nodo<T>(elem);
			primerNodo.cambiarSiguiente(nuevo);
			nuevo.cambiarAnterior(primerNodo);
			nuevo.cambiarSiguiente(null);
			numElementos++;
		}

		else if(pos == 0){
			Nodo<T> nuevo = new Nodo<T>(elem);
			Nodo<T> siguienteNuevo = primerNodo;
			primerNodo = nuevo;
			nuevo.cambiarSiguiente(siguienteNuevo);
			nuevo.cambiarAnterior(null);
			siguienteNuevo.cambiarSiguiente(null);
			siguienteNuevo.cambiarAnterior(nuevo);
			numElementos++;
		}

		else if(pos == numElementos-1){
			Nodo<T> nuevo = new Nodo<T>(elem);
			agregarElemento(nuevo.darElementoNodo());
		}
		
		else{
			
			Nodo<T>actual = primerNodo;
			
			int i = 0;
			
			while(i<pos-1){
				actual = actual.darSiguiente();
				i++;
			}
			
			Nodo<T>siguienteNuevo = actual.darSiguiente();
			Nodo<T>nuevo = new Nodo<T>(elem);
			actual.cambiarSiguiente(nuevo);
			nuevo.cambiarAnterior(actual);
			nuevo.cambiarSiguiente(siguienteNuevo);
			siguienteNuevo.cambiarAnterior(nuevo);
			numElementos++;
			
		}
		
	}

	/**
	 * Método que consulta el elemento en la posicion deseada.
	 * @param indice: posicion en la cual se busca el elemento
	 * @throws IndexOutOfBoundsException si el indice es menor que cero o es mayor o igual al tamano de la lista.
	 * @return El elemento en la posicion deseada
	 */
	@Override
	public T consultarElem(int indice) {
		T elementoBuscado = null;
		if(indice < 0 || indice >= numElementos){
			throw new IndexOutOfBoundsException();
		}
		else{

			Nodo<T> actual = primerNodo;

			int i = 0;

			while(i<indice){
				actual = actual.darSiguiente();
			}

			elementoBuscado = actual.darElementoNodo();
		}
		return elementoBuscado;
	}
	
	/**
	 * Metodo que verifica si el elemento ya existe en la lista
	 * @param objeto: el elemento que se bussca verificar
	 * @return true si el elemento existe en la lista, false de lo contrario
	 */
	@Override
	public boolean contiene(Object objeto) {
		boolean contiene = false;
		Nodo<T> actual = primerNodo;

		while(actual != null && !contiene){

			if(actual.darElementoNodo().equals(objeto)){
				contiene = true;
			}

			if(actual.equals(objeto)){
				contiene = true;
			}

			else{
				actual = actual.darSiguiente();
			}
		}

		return contiene;
	}



}
