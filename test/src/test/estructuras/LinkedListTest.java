package test.estructuras;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.LinkedList;

public class LinkedListTest {

	private LinkedList<Integer> listaPrueba;
	
	@Before
	public void setUpEscenario1(){
		listaPrueba = new LinkedList<>();
	}
	
	@Test
	public void testTamano(){
		assertEquals(0, listaPrueba.getSize());
	}
}
