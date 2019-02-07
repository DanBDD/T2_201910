// Este codigo fue basado en el codigo encongtrado en ....
package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import api.IMovingViolationsManager;
import model.vo.VOMovingViolations;
import model.data_structures.LinkedList;

public class MovingViolationsManager implements IMovingViolationsManager {

	private LinkedList<VOMovingViolations> lista;

	public MovingViolationsManager()
	{
		lista=new LinkedList<VOMovingViolations>();
	}
	public void loadMovingViolations(String movingViolationsFile){

		try {
			CSVReader lector = new CSVReader(new FileReader(movingViolationsFile));
			String [] nextLine = lector.readNext();
			while((nextLine = lector.readNext()) != null){
				String id = nextLine[0];
				int idObjeto = Integer.parseInt(id);
				String location = nextLine[2];
				String fecha = nextLine[14];
				String total = nextLine[9];
				int totalObjeto = Integer.parseInt(total);
				String indicator = nextLine[12];
				String description = nextLine[15];
				lista.add(new VOMovingViolations(idObjeto, location, fecha, totalObjeto, indicator, description));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que recolecta objetos VOMovingViolations según el código de violacion. (Columna VIOLATIONCODE del archivo CSV)
	 * @param violationCode: el codigo para buscar los objetos VOMovingViolations
	 * @return una lista con todos los objetos VOMovingViolations que tengan el código a buscar
	 */
	@Override
	public LinkedList <VOMovingViolations> getMovingViolationsByViolationCode (String violationCode) {
		
		LinkedList<VOMovingViolations> l= new LinkedList<VOMovingViolations>();
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).objectId()==Integer.parseInt(violationCode))
			{
				l.add(lista.get(i));
			}
		}
		return l;
	}
	
	/**
	 * Metodo que recolecta objetos VOMovingViolations según el indicador de accidente. (Columna ACCIDENTINDICATOR del archivo CSV)
	 * @param accidentIndicator: el indicador para buscar los objetos VOMovingViolations
	 * @return una lista con todos los objetos VOMovingViolations que tengan el indicador a buscar
	 */
	@Override
	public LinkedList <VOMovingViolations> getMovingViolationsByAccident(String accidentIndicator) {
		LinkedList<VOMovingViolations> l= new LinkedList<VOMovingViolations>();
		for(int i=0;i<lista.size();i++)
		{
			if(lista.get(i).getAccidentIndicator().equals(accidentIndicator))
			{
				l.add(lista.get(i));
			}
		}
		return l;
	}	


}
