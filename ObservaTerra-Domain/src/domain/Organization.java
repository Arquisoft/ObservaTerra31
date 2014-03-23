package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase abstracta que representa una organizacion (tanto simple como
 * compuesta).
 * 
 * @author Sergio
 * 
 */
public abstract class Organization {

	private String name;
	private String site;
	private String acronym;

	private Set<Observation> observations = new HashSet<Observation>();

	public Organization(String name, String site, String acronym) {
		super();
		this.name = name;
		this.site = site;
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public String getSite() {
		return site;
	}

	public String getAcronym() {
		return acronym;
	}

	protected Organization setName(String name) {
		this.name = name;
		return this;
	}

	protected Organization setSite(String site) {
		this.site = site;
		return this;
	}

	protected Organization setAcronym(String acronym) {
		this.acronym = acronym;
		return this;
	}

	public Set<Observation> getObservations() {
		return Collections.unmodifiableSet(observations);
	}

	protected Set<Observation> _getObservations() {
		return observations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Agrupa dos organizaciones en otra. Resuelve el problema mediante
	 * double-dispatch y sobrecarga de metodos.
	 * 
	 * @param name
	 *            nombre de la nueva organizacion
	 * @param site
	 *            pagina web de la nueva organizacion
	 * @param acronym
	 *            acronimo de la nueva organizacion
	 * @param organization
	 *            otra organizacion dada
	 * @return nueva organizacion
	 */
	public abstract Organization addOrganization(String name, String site,
			String acronym, Organization organization);

	protected abstract Organization appendOrganization(
			SampleOrganization sampleOrganization);

	protected abstract Organization appendOrganization(
			ComplexOrganization sampleOrganization);

	public abstract Organization removeOrganization(Organization organization);

	public abstract Set<Organization> getOrganizations();

	public abstract Organization addUser(User user);

	public abstract Organization removeUser(User user);

	public abstract Set<User> getUsers();

}
