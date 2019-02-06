package model.vo;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations {

	private int id;
	private String location;
	private String date;
	private int total;
	private String indicator;
	private String description;
	
	public VOMovingViolations(int id, String l, String d, int t, String i,String de)
	{
		this.id=id;
		location=l;
		date=d;
		total=t;
		indicator=i;
		description=de;
	}
	
	/**
	 * @return id - Identificador único de la infracción
	 */
	public int objectId() {
		// TODO Auto-generated method stub
		return id;
	}	
	
	
	/**
	 * @return location - Dirección en formato de texto.
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infracción .
	 */
	public String getTicketIssueDate() {
		// TODO Auto-generated method stub
		return date;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente pagó el que recibió la infracción en USD.
	 */
	public int getTotalPaid() {
		// TODO Auto-generated method stub
		return total;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return indicator;
	}
		
	/**
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationDescription() {
		// TODO Auto-generated method stub
		return description;
	}
}
