package persistence;

public class Observation {

	private String area;
	private String country;
	private String indicator;
	private String time;
	private String measure;
	private Organization organization;
	private String user;
	private String data;

	public Observation(String area, String country, String indicator, String time, String measure, Organization organization, String data, String user){
		
		this.area=area;
		this.country=country;
		this.indicator=indicator;
		this.time=time;
		this.measure=measure;
		this.organization=organization;
		this.user=user;
		this.data=data;
		
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getUsuario() {
		return user;
	}

	public void setUsuario(String usuario) {
		this.user = usuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
}
