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

	private static final long serialVersionUID = -7840639764467108127L;
	
	@OneToMany(mappedBy = "complexOrganization")
	private Set<Organization> organizations = new HashSet<Organization>();

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public ComplexOrganization(){}
	
	public ComplexOrganization(String name, String site, 
			String acronym, Set<Organization> organizations) {
		super(name, site, acronym);
		this.organizations = organizations;
		/*for( Organization sampleOrg : organizations ){
			sampleOrg._setComplexOrganization(this);
		}*/
	}

	// // // // //
	// METODOS
	// // // // //
	
	@Override
	public Organization addOrganization(String name, String site,
			String acronym, Organization organization) {
		Organization newOrganization = organization.appendOrganization(this);
		if (newOrganization != null){
			newOrganization.setName(name).setAcronym(acronym)
					.setSite(site);
			//newOrganization._setComplexOrganization(this);
			//organization._setComplexOrganization(this);
			return newOrganization; 
		}
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
