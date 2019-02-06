// Este codigo fue basado en el codigo encongtrado en ....
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

	private LinkedList<VOMovingViolations> lista;

	public MovingViolationsManager()
	{
		lista=new LinkedList<VOMovingViolations>();
	}
	public void loadMovingViolations(String movingViolationsFile){
		// TODO Auto-generated method stub
		try {
			FileReader f= new FileReader(movingViolationsFile);
			CSVReader reader = new CSVReaderBuilder(f).withSkipLines(1).build();
			List<String[]> lineas=reader.readAll();
			for(int i=0;i<lineas.size();++i)
			{
				String datos = null;
				for(int j=0;j<lineas.get(i).length;++j)
				{
					datos+=lineas.get(i)[j];
				}
				String [] s =datos.split(",");
				int id= Integer.parseInt(s[14]);
				String loc= s[2];
				String date=s[13];
				int total=Integer.parseInt(s[9]);
				String indicator=s[12];
				String des=s[15];

				lista.add(new VOMovingViolations(id, loc, date, total, indicator, des));

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


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

	@Override
	public LinkedList <VOMovingViolations> getMovingViolationsByAccident(String accidentIndicator) {
		// TODO Auto-generated method stub
		return null;
	}	


}
