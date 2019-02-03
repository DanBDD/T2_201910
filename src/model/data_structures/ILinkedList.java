package model.data_structures;

/**
 * Abstract Data Type for a linked list of generic objects
 * This ADT should contain the basic operations to manage a list
 * add, addAtEnd, AddAtK, getElement, getCurrentElement, getSize, delete, deleteAtK
 * next, previous
 * @param <T>
 */
public interface ILinkedList<T> extends Iterable<T>{

	Integer getSize();
	
	/**
	 * Metodo que agrega el elemento que entra por parametro en la ultima posicion de la lista
	 * Verifica los casos que haya: Si la lista es vacía, hace que el elemento nuevo sea el primero. Si la lista contiene ese elemento, no lo agrega.
	 * @param elem: Elemento a agregar
	 * @return false si no se agrego el elemento, true de lo contrario.
	 */
	public boolean agregarElemento(T elem);

	/**
	 * Método que agrega un elemento en una posicion determinada de la lista
	 * No se agrega el elemento si ya existe en la lista
	 * @param elem elemento a agregar en la lista
	 * @param pos posicion en la que se quiere agregar el elemento 
	 * @throws IndexOutOfBoundsException si la posicion deseada es menor que cero o si es mayor o igual al tamano de la lista
	 * @throws NullPointerException si el elemento a agregar es nulo
	 * @return true si se agrego, false en caso contrario
	 */
	public void agregarElementoPosicion(T elem, int pos);
	

	/**
	 * Método que agrega un elemento en una posicion determinada de la lista
	 * No se agrega el elemento si ya existe en la lista
	 * @param elem elemento a agregar en la lista
	 * @param pos posicion en la que se quiere agregar el elemento 
	 * @throws IndexOutOfBoundsException si la posicion deseada es menor que cero o si es mayor o igual al tamano de la lista
	 * @throws NullPointerException si el elemento a agregar es nulo
	 * @return true si se agrego, false en caso contrario
	 */
	public T consultarElem(int indice);
	
	/**
	 * Metodo que verifica si el elemento ya existe en la lista
	 * @param objeto: el elemento que se bussca verificar
	 * @return true si el elemento existe en la lista, false de lo contrario
	 */
	public boolean contiene(Object objeto);
	
	/**
	 * Metodo que elimina nodo en la posicion deseada.
	 * @param pos: posicion del nodo
	 * @throws IndexOutOfBoundsException si la posicion es menor que cero o si es mayor o igual que el tamano de la lista
	 * @return elemento eliminado
	 */
	public T eliminarEnPosicion(int pos);
	
	/**
	 * Metodo que elimina el objeto que llega por parametro
	 * @param objeto: objeto que se busca eliminar
	 * @return true si se elimio el objeto, false de lo contrario
	 */
	public boolean eliminarObjetoEspecifico(Object objeto);
	
	/**
	 * Metodo que vacia la lista
	 */
	public void vaciarLista();
}
