package parser;

import persistence.Observation;
import persistence.Organization;

public abstract class AbstractParser implements Parser {

	protected String getAreaKeyWord() {
		return areaKeyWord;
	}

	protected String getTimeKeyWord() {
		return timeKeyWord;
	}

	protected String getCountryKeyWord() {
		return countryKeyWord;
	}

	protected String getIndicatorKeyWord() {
		return indicatorKeyWord;
	}

	protected String getMeasureKeyWord() {
		return measureKeyWord;
	}

	protected String getDataKeyWord() {
		return dataKeyWord;
	}

	private String areaKeyWord;
	private String timeKeyWord;
	private String countryKeyWord;
	private String indicatorKeyWord;
	private String measureKeyWord;
	private String dataKeyWord;

	private String area;

	protected String getArea() {
		return area;
	}

	protected void setArea(String area) {
		this.area = area;
	}

	protected String getCountry() {
		return country;
	}

	protected void setCountry(String country) {
		this.country = country;
	}

	protected String getIndicator() {
		return indicator;
	}

	protected void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	protected String getTime() {
		return time;
	}

	protected void setTime(String time) {
		this.time = time;
	}

	protected String getMeasure() {
		return measure;
	}

	protected void setMeasure(String measure) {
		this.measure = measure;
	}

	protected String getData() {
		return data;
	}

	protected void setData(String data) {
		this.data = data;
	}

	protected Organization getOrganization() {
		return organization;
	}

	protected String getUser() {
		return user;
	}

	private String country;
	private String indicator;
	private String time;
	private String measure;
	private Organization organization;
	private String user;
	private String data;

	public void setUser(String user) {
		this.user = user;

	}

	public void setOrganization(Organization organization) {
		this.organization = organization;

	}

	public void setAreaKeyWord(String areaKeyWord) {
		this.areaKeyWord = areaKeyWord;

	}

	public void setTimeKeyWord(String timeKeyWord) {
		this.timeKeyWord = timeKeyWord;

	}

	public void setCountryKeyWord(String countryKeyWord) {
		this.countryKeyWord = countryKeyWord;

	}

	public void setIndicatorKeyWord(String indicatorKeyWord) {
		this.indicatorKeyWord = indicatorKeyWord;

	}

	public void setMeasureKeyWord(String measureKeyWord) {
		this.measureKeyWord = measureKeyWord;

	}

	public void setObservationKeyWord(String observationKeyWord) {
		this.dataKeyWord = observationKeyWord;
	}

	public Observation parse() {
		this.parseDocument();
		this.validateDocument();
		return this.returnOrganization();
	}

	private void validateDocument() {
		if(area==null||country==null||measure==null||time==null||indicator==null||data==null){
			throw new IllegalStateException("Documento con formato incorrecto, o palabras clave definidas incorrectamente.");
		}
		if(user==null||organization==null){
			throw new IllegalStateException("No se han definido organización o usuario para el documento");
		}
		
	}

	public abstract void parseDocument();

	public Observation returnOrganization() {
		return new Observation(this.area, this.country, this.indicator,
				this.time, this.measure, this.organization, this.data,
				this.user);
	}

}
