package model.logic;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import api.IMovingViolationsManager;
import model.vo.VOMovingViolations;
import model.data_structures.LinkedList;

public class MovingViolationsManager implements IMovingViolationsManager {

	private LinkedList lista;

	public MovingViolationsManager()
	{
		lista=new LinkedList<>();
	}
	public void loadMovingViolations(String movingViolationsFile){
		// TODO Auto-generated method stub
		try {
			FileReader f= new FileReader(movingViolationsFile);
			CSVReader reader = new CSVReaderBuilder(f).withSkipLines(1).build();
			List<String []> info=reader.readAll();
			for(String[] linea:info)
			{
				for(String dato:linea)
				{
					lista.add(dato);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public LinkedList <VOMovingViolations> getMovingViolationsByViolationCode (String violationCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList <VOMovingViolations> getMovingViolationsByAccident(String accidentIndicator) {
		// TODO Auto-generated method stub
		return null;
	}	


}
