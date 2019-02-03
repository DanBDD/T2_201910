package model.data_structures;

public class Nodo<T> {

	protected T elementoNodo;
	
	protected Nodo<T> siguienteNodo;
	
	protected Nodo<T> anteriorNodo;
	
	public Nodo(T elem){
		
		elementoNodo = elem;
		siguienteNodo = null;
		anteriorNodo = null;
		
	}
	
	public Nodo<T> darAnterior(){
		return anteriorNodo;
	}
	
	public Nodo<T> darSiguiente(){
		return siguienteNodo;
	}
	
	public T darElementoNodo(){
		return elementoNodo;
	}
	
	public void cambiarAnterior(Nodo<T> nuevo){
		anteriorNodo = nuevo;
	}
	
	public void cambiarSiguiente(Nodo<T> nuevo){
		siguienteNodo = nuevo;
	}
}
