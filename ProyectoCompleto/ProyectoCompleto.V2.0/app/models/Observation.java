package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;
import play.i18n.Messages;

/**
 * Representa una observacion.
 * 
 * @author Sergio
 * 
 */

@Entity
@Table(name="Observation")
public class Observation extends Model {

	private static final long serialVersionUID = -1861880649383824350L;
	
	// // // // //
	// ATRIBUTOS
	// // // // //
	
	public static Finder<Long,Observation> find = 
			new Finder<Long,Observation>(Long.class, Observation.class);
	
	@Id @GeneratedValue
	private Long id;
	private String value;
	private String measure;
	@ManyToOne
	private Time time;
	@ManyToOne
	private Indicator indicator;
	@ManyToOne
	private Area area;
	@ManyToOne
	private Organization provider;
	@Temporal(TemporalType.DATE)
	private Date publishDate;

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public Observation(){}
	
	public Observation(Time time, String value, String measure,
			Indicator indicator, Area area, Organization provider,
			Date publishDate) {
		super();
		this.time = time;
		this.value = value;
		this.measure = measure;
		this.indicator = indicator;
		this.area = area;
		this.provider = provider;
		this.publishDate = publishDate;
		link();
	}

	// // // // //
	// METODOS
	// // // // //
	
	private void link() {
		time._getObservations().add(this);
		provider._getObservations().add(this);
		area._getObservations().add(this);
		indicator._getObservations().add(this);
	}

	public void unlink() {
		time._getObservations().remove(this);
		provider._getObservations().remove(this);
		area._getObservations().remove(this);
		indicator._getObservations().remove(this);
	}
	
	// // // // // // // // // //
	// METODOS PERSISTENCIA PLAY
	// // // // // // // // // //
	
	public static List<Observation> all() {
		return find.all();
	}

	public static void create(Observation obs) {
		if ( find.where()
				.eq("area", obs.getArea())
				.eq("indicator", obs.getIndicator())
				.eq("provider", obs.getProvider())
				.eq("publishDate", obs.getPublishDate())
				.findUnique() == null ){
			obs.save();
		}
	}

	public static void remove(long id) {
		find.ref(id).delete();
	}

	public static void deleteAll() {
		for (Observation o : all())
			o.delete();
	}
	
	public static Observation findById(Long id) {
		return find.byId(id);
	}

	/**
	 * Devuelve una lista de Observations que pertenecen
	 * al Indicator recibido por parametro
	 */
	public static List<Observation> findByIndicator(Indicator indicator) {
		return find.where().eq("indicator", indicator).findList();
	}
	
	/**
	 * Devuelve una lista de Observations que pertenecen
	 * a la Area recibida por parametro
	 */
	public static List<Observation> findByArea(Area area) {
		return find.where().eq("area", area).findList();
	}
	
	/**
	 * Devuelve una lista de Observations originados por
	 * la Organization recibida por parametro
	 */
	public static List<Observation> findByProvider(Organization provider) {
		return find.where().eq("provider", provider).findList();
	}
	
	/**
	 * Devuelve una lista de Observations originados
	 * en la Date recibida por parametro
	 */
	public static List<Observation> findByPublishDate(Date publishDate) {
		return find.where().eq("publishDate", publishDate).findList();
	}
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //
	
	/* Relacion entre entidades:
	 *  * Observations <--> 1 Time
	 */
	void _setTime(Time t) {
		time = t;
	}
	public Time getTime() {
		return time;
	}
	
	/* Relacion entre entidades:
	 *  * Observations <--> 1 Indicator
	 */
	void _setIndicator(Indicator i) {
		indicator = i;
	}
	public Indicator getIndicator() {
		return indicator;
	}
	
	/* Relacion entre entidades:
	 *  * Observations <--> 1 Area
	 */
	void _setArea(Area a) {
		area = a;
	}
	public Area getArea() {
		return area;
	}
	
	/* Relacion entre entidades:
	 *  * Observations <--> 1 Organization
	 */
	void _setOrganization(Organization providerOrg) {
		provider = providerOrg;
	}
	public Organization getProvider() {
		return provider;
	}
	
	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //

	public Long getId() {
		return id;
	}

	public String getMeasure() {
		return measure;
	}

	public String getValue() {
		return value;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Observation other = (Observation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	// // // // // // // //
	// TO_STRING & TO_JSON
	// // // // // // // //
	
	@Override
	public String toString() {
		
		String measureString = measure;
		if( measure.compareToIgnoreCase("none")==0 )
			measureString = "";
		
		return indicator + " " + Messages.get("at") + " " 
				+ time.toString() + " "
				+ Messages.get("in") + " " + area.getName() + " "
				+ Messages.get("was") + " " + value
				+ (measureString.length() == 1 ? "" : " ") + measureString
				+ " " + Messages.get("by") + " " + provider.getName() + ".";
	}

	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"" + id + "\"");
		sb.append(",\"time\": ").append("\"" + time.toString() + "\"");
		sb.append(",\"value\": ").append("\"" + value + "\"");
		sb.append(",\"measure\": ").append("\"" + measure + "\"");
		sb.append(",\"indicator\": ")
				.append("\"" + indicator.toString() + "\"");
		sb.append(",\"area\": ").append("\"" + area.toString() + "\"");
		sb.append(",\"provider\": ").append("\"" + provider.toString() + "\"");
		sb.append(",\"publishDate\": ").append(
				"\"" + publishDate.toString() + "\"");
		sb.append("}");
		return sb.toString();
	}
}
