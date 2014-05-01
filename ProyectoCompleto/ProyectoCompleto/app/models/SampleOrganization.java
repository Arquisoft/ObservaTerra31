package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Representa una organizacion simple. Las organizaciones simples tienen un
 * conjunto de usuarios.
 * 
 * @author Sergio
 * 
 */
@Entity
@DiscriminatorValue(value="SampleOrganization")
public class SampleOrganization extends Organization {

	private static final long serialVersionUID = -3620698322050693466L;

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public SampleOrganization(){}
	
	public SampleOrganization(String name, String site, String acronym) {
		super(name, site, acronym);
	}

	// // // // //
	// METODOS
	// // // // //
	
	@Override
	public Organization addOrganization(String name, String site,
			String acronym, Organization organization) {
		if (this.getParent() != null && organization.getParent() != null)
			return null;
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
			return org;
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
	
	// // // //
	// TO_JSON
	// // // //
	
	public static JsonNode toJson(SampleOrganization organization) {
		return Json.toJson(organization);
	}
}
