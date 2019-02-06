package view;

import java.util.Scanner;

import controller.Controller;
import model.data_structures.ILinkedList;
import model.data_structures.LinkedList;
import model.vo.VOMovingViolations;

public class MovingViolationsManagerView 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		while(!fin)
		{
			printMenu();
			
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					Controller.loadMovingViolations();
					break;
					
				case 2:
					System.out.println("Ingrese el c�digo de la infracci�n:");
					String violationCode = sc.next();
					LinkedList<VOMovingViolations> violationsByCodeList = Controller.getMovingViolationsByViolationCode (violationCode);
					System.out.println("Se encontraron "+ violationsByCodeList.getSize() + " elementos");
					for (VOMovingViolations violations : violationsByCodeList) 
					{
						System.out.println(violations.objectId() + " " + violations.getLocation() + " " + violations.getTicketIssueDate()+ " " + violations.getTotalPaid() + " " + violations.getAccidentIndicator()+ " " + violations.getViolationDescription());;
					}
					break;
					
				case 3:
					System.out.println("Ingrese el indicador de Accidente que quiere consulta (No/Yes):");
					String accidentIndicator = sc.next();
					LinkedList<VOMovingViolations> violationsByAccidentsList = Controller.getMovingViolationsByAccident (accidentIndicator);
					System.out.println("Se encontraron "+ violationsByAccidentsList.getSize() + " elementos");
					for (VOMovingViolations violations : violationsByAccidentsList) 
					{
						System.out.println(violations.objectId() + " " + violations.getLocation() + " " + violations.getTicketIssueDate()+ " " + violations.getTotalPaid() + " " + violations.getAccidentIndicator()+ " " + violations.getViolationDescription());;
					}
					break;
											
				case 4:	
					fin=true;
					sc.close();
					break;
			}
		}
	}

	private static void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Taller 2----------------------");
		System.out.println("1. Cree una nueva coleccion de infracciones en movimiento");
		System.out.println("2. Dar listado de infracciones reportadas dado un c�digo de infracci�n");
		System.out.println("3. Dar listado de infracciones reportadas de acuerdo a si hay o no accidente reportado");
		System.out.println("4. Salir");
		System.out.println("Digite el n�mero de opci�n para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}
}
