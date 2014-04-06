package parser;

import java.util.Date;

import domain.Area;
import domain.Indicator;
import domain.Organization;
import domain.Time;
import domain.User;

public abstract class AbstractParser implements Parser {


	protected Time time;
	protected String value;
	protected String measure;
	protected Indicator indicator;
	protected Area area;
	protected Organization provider;
	protected Date publishDate;
	
	

	protected void setTime(Time time) {
		this.time = time;
	}



	protected void setValue(String value) {
		this.value = value;
	}



	protected void setMeasure(String measure) {
		this.measure = measure;
	}



	protected void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}



	protected void setArea(Area area) {
		this.area = area;
	}



	public void setProvider(Organization provider) {
		this.provider = provider;
	}



	protected void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}



//	private void validateDocument() {
//		if(area==null||country==null||measure==null||time==null||indicator==null||data==null){
//			throw new IllegalStateException("Documento con formato incorrecto, o palabras clave definidas incorrectamente.");
//		}
//		if(user==null||organization==null){
//			throw new IllegalStateException("No se han definido organización o usuario para el documento");
//		}
//		
//	}



}
