package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

/**
 * Representa una organizacion (tanto simple como compuesta).
 * 
 * @author Sergio
 * 
 */

@Entity
@Table(name="Organization")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="organization_type")
public class Organization extends Model{
	
	/*
	 * Un mejor diseno requiriria que esta clase sea abstracta.
	 * Pero cuando una clase abstracta posee una coleccion de entidades
	 * (en este caso, Set observatons) se produce un error (no entro en detalle),
	 * debido a un bug de Ebean: http://www.avaje.org/bugdetail-408.html
	 * 
	 * El error se produciria al anadir una Observation a la Organization,
	 * como sucede por ejemplo en Observation.link().
	 */
	
	private static final long serialVersionUID = 7960656525676750384L;
	
	// // // // //
	// ATRIBUTOS
	// // // // //
	
	public static Finder<Long,Organization> find = 
			new Finder<Long,Organization>(Long.class, Organization.class);
	
	@Id @GeneratedValue
	public Long id;
	private String name;
	private String site;
	private String acronym;
	@ManyToOne
	private Organization parent;
	@OneToMany(mappedBy = "provider")
	protected Set<Observation> observations = new HashSet<Observation>();
	@OneToMany(mappedBy = "organization")
	protected Set<Membership> memberships = new HashSet<Membership>();

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public Organization(){}
	
	public Organization(String name, String site, String acronym) {
		super();
		this.name = name;
		this.site = site;
		this.acronym = acronym;
	}
	
	public Organization(String name, String site, String acronym, Organization parent) {
		super();
		this.name = name;
		this.site = site;
		this.acronym = acronym;
		this.parent = parent;
	}

	// // // // //
	// METODOS
	// // // // //
	
	public Organization addUser(User user) {
		for (Membership mmb : memberships)
			if (mmb.getUser().equals(user))
				return this;
		new Membership(user, this);
		return this;
	}

	public Organization removeUser(User user) {
		for (Membership mmb : memberships)
			if (mmb.getUser().equals(user)) {
				mmb.unlink();
				return this;
			}
		return this;
	}
	
	// // // // // // // // // // // // //
	// METODOS PERSISTENCIA ACTIVE RECORD
	// // // // // // // // // // // // //
	
	public static List<Organization> all(){
		return find.all();
	}

	/**
	 * Trata de insertar una Organization en la base de datos.
	 * @param newOrganization Organization a insertar
	 * @return Devuelve una Organization. <br>
	 * Si tiene exito, devuelve la Organization insertada.
	 * Si ya exitia, devuelve la Organization existente.
	 */
	public static Organization create(Organization newOrganization){
		Organization alreadyExisting = 
				Organization.findByName(newOrganization.getName());
		if( alreadyExisting == null ){
			newOrganization.save();
			return newOrganization;
		}
		return alreadyExisting;
	}

	public static void remove(long id){
		find.ref(id).delete();
	}

	public static void deleteAll(){
		for (Organization o : all())
			o.delete();
	}

	public static Organization findById(Long id){
		return find.byId(id);
	}
	
	public static Organization findByName(String name) {
		return find.where().eq("name", name).findUnique();
	}
	
	public static List<Organization> findAll() {
		return find.all();
	}
	
	/**
	 * Devuelve una lista de Organizations cuya lista de Observations contenga
	 *  la Observation recibida por parametro
	 */
	public static List<Organization> findByObservation(Long observationId) {
		return find.where().eq("observations.id", observationId).findList();
	}
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //
	
	/*
	 * Relacion entre entidades:
	 * 1 Organization <--> * Observations
	 */
	public Set<Observation> _getObservations() {
		return observations;
	}
	public Set<Observation> getObservations() {
		return Collections.unmodifiableSet(observations);
	}
	public void setObservations(Set<Observation> observations) {
		this.observations = observations;
	}
	
	/*
	 * Relacion entre entidades:
	 * 1 Organization <--> * Memberships
	 */
	public Set<Membership> _getMemberships() {
		return memberships;
	}
	public Set<Membership> getMemberships() {
		return Collections.unmodifiableSet(memberships);
	}
	public void setMemberships(Set<Membership> memberships) {
		this.memberships = memberships;
	}
	
	/* Relacion entre entidades:
	 *  * Organizations <--> 1 ComplexOrganization
	 */
	public void setParent(Organization parent) {
		this.parent = parent;
	}
	public Organization getParent() {
		return parent;
	}
	
	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	protected Organization setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getSite() {
		return site;
	}

	protected Organization setSite(String site) {
		this.site = site;
		return this;
	}
	
	public String getAcronym() {
		return acronym;
	}
	
	protected Organization setAcronym(String acronym) {
		this.acronym = acronym;
		return this;
	}
	
	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Organization other = (Organization) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	// // // // // // // //
	// TO_STRING & TO_JSON
	// // // // // // // //

	@Override
	public String toString() {
		return getName();
	}

	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{")
		  .append("\"name\": \"").append(getName()).append("\",")
		  .append("\"site\": \"").append(getSite()).append("\",")
		  .append("\"acronym\": \"").append(getAcronym()).append("\",")
		  .append("\"parent\": ")
		  .append(getParent() != null ? getParent().toJson() : null)
		  .append("}");
		return sb.toString();
	 }

	
}
