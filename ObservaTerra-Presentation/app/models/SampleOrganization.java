package models;

import java.util.HashSet;
import java.util.Set;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Representa una organizacion simple. Las organizaciones simples tienen un
 * conjunto de usuarios.
 * 
 * @author Sergio
 * 
 */
public class SampleOrganization extends Organization {


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
		if (organizations.add(this)) {
			Organization org = new ComplexOrganization("", "", "", organizations);
			this.setParent(org);
			sampleOrganization.setParent(org);
		}
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
		Set<User> users = new HashSet<User>();
		for (Membership mmb : this.memberships)
			users.add(mmb.getUser());
		return users;

	}
	
	public static JsonNode toJson(SampleOrganization organization) {
		return Json.toJson(organization);
	  }
	

}
