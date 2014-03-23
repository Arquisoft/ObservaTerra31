package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa una organizacion simple. Las organizaciones simples tienen un
 * conjunto de usuarios.
 * 
 * @author Sergio
 * 
 */
public class SampleOrganization extends Organization {

	private Set<User> users = new HashSet<User>();

	public SampleOrganization(String name, String site, String acronym) {
		super(name, site, acronym);
	}

	@Override
	public Organization addOrganization(String name, String site,
			String acronym, Organization organization) {
		Organization newOrganization = organization.appendOrganization(this);
		if (newOrganization != null)
			return newOrganization.setName(name).setAcronym(acronym)
					.setSite(site);
		return null;
	}

	@Override
	protected Organization appendOrganization(
			SampleOrganization sampleOrganization) {
		Set<Organization> organizations = new HashSet<Organization>();
		organizations.add(sampleOrganization);
		if (organizations.add(this))
			return new ComplexOrganization("", "", "", organizations);
		return null;
	}

	@Override
	protected Organization appendOrganization(
			ComplexOrganization complexOrganization) {
		return complexOrganization.appendOrganization(this);
	}

	@Override
	public Organization removeOrganization(Organization organization) {
		return null;
	}

	@Override
	public Set<Organization> getOrganizations() {
		return new HashSet<Organization>();
	}

	@Override
	public Set<User> getUsers() {
		return Collections.unmodifiableSet(users);
	}

	@Override
	public Organization addUser(User user) {
		user.setOrganization(this);
		this.users.add(user);
		return this;
	}

	@Override
	public Organization removeUser(User user) {
		if (this.users.contains(user)) {
			this.users.remove(user);
			user.setOrganization(null);
		}
		return this;
	}

}
