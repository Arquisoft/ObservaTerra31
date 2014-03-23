package parser;

import persistence.Observation;
import persistence.Organization;

public interface Parser {
	
	public Observation parse();
	public void setUser(String user);
	public void setOrganization(Organization organization);
	public void setAreaKeyWord(String areaKeyWord);
	public void setTimeKeyWord(String areaTimeKeyWord);
	public void setCountryKeyWord(String countryKeyWord);
	public void setIndicatorKeyWord(String indicatorKeyWord);
	public void setMeasureKeyWord(String measureKeyWord);
	public void setObservationKeyWord(String observationKeyWord);


}
