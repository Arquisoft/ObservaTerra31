package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa una organizacion compuesta de otras organizaciones.
 * 
 * @author Sergio
 * 
 */

public class ComplexOrganization extends Organization {
	
	private Set<Organization> organizations = new HashSet<Organization>();

	public ComplexOrganization(String name, String site, String acronym,
			Set<Organization> organizations) {
		super(name, site, acronym);
		this.organizations = organizations;
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
		organizations.add(sampleOrganization);
		return this;
	}

	@Override
	protected Organization appendOrganization(
			ComplexOrganization complexOrganization) {
		Set<Organization> organizations = new HashSet<Organization>();
		organizations.addAll(complexOrganization.organizations);
		if (organizations.addAll(this.organizations))
			return new ComplexOrganization("", "", "", organizations);
		return null;

	}

	@Override
	public Organization removeOrganization(Organization organization) {
		organizations.remove(organization);
		return this;
	}

	@Override
	public Set<Organization> getOrganizations() {
		return Collections.unmodifiableSet(this.organizations);
	}

	@Override
	public Set<User> getUsers() {
		Set<User> users = new HashSet<User>();
		
		for (Membership mmb : this.memberships)
			users.add(mmb.getUser());
		
		for (Organization org : this.organizations)
			users.addAll(org.getUsers());
		
		return users;
	}


}
