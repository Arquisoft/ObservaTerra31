package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Representa una organizacion compuesta de otras organizaciones.
 * 
 * @author Sergio
 * 
 */

@Entity
@DiscriminatorValue(value="ComplexOrganization")
public class ComplexOrganization extends Organization {

	private static final long serialVersionUID = 1589149541664096732L;
	
	// // // // //
	// ATRIBUTOS
	// // // // //
	
	@OneToMany(mappedBy = "parent")
	private Set<Organization> organizations = new HashSet<Organization>();

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public ComplexOrganization(){}
	
	public ComplexOrganization(String name, String site, String acronym,
			Set<Organization> organizations) {
		super(name, site, acronym);
		this.organizations = organizations;
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
		
		if(newOrganization == null)
			return null;
		else if (newOrganization.equals(this))
			return this;
		else
			return newOrganization.setName(name).setAcronym(acronym)
					.setSite(site);
		
	}

	@Override
	protected Organization appendOrganization(
			SampleOrganization sampleOrganization) {
		if (sampleOrganization.getParent() == null) {
			sampleOrganization.setParent(this);
			organizations.add(sampleOrganization);
			return this;
		}
		return null;
	}

	@Override
	protected Organization appendOrganization(
			ComplexOrganization complexOrganization) {
		Set<Organization> organizations = new HashSet<Organization>();
		organizations.addAll(complexOrganization.organizations);
		if (organizations.addAll(this.organizations)) {
			Organization org = new ComplexOrganization("", "", "",
					organizations);
			this.setParent(org);
			complexOrganization.setParent(org);
			return org;
		}
		return null;

	}

	@Override
	public Organization removeOrganization(Organization organization) {
		for (Organization org : organization.getOrganizations())
			organizations.remove(org);
		organizations.remove(organization);
		organization.setParent(null);
		return this;
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
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //
	
	/*
	 * Relacion entre entidades:
	 * 1 ComplexOrganization <--> * Organizations
	 */
	public Set<Organization> _getOrganizations() {
		return organizations;
	}
	@Override
	public Set<Organization> getOrganizations() {
		return Collections.unmodifiableSet(organizations);
	}
	public void setOrganizations(Set<Organization> orgs) {
		organizations = orgs;
	}
}
