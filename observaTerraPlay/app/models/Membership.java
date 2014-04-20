package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;

/**
 * Representa la membresia de un usuario en una organizacion.
 * @author Sergio
 *
 */

@Entity
@Table(name="Membership")
public class Membership extends Model {
	
	private static final long serialVersionUID = -8178334583929910521L;
	
	public static Finder<Long, Membership> find = 
			new Finder<Long, Membership>(Long.class, Membership.class);
	
	@Id @GeneratedValue
	public Long id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Organization organization;
	
	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public Membership(){}
	
	public Membership(User user, Organization organization) {
		/* El nuevo "membership" necesita que 
		 * el "user" y la "organization" sean identificables.
		 * Para eso tienen un campo id autogenerado...,
		 * pero en este momento de la ejecucion ese id aun no ha sido calculado.
		 * Por tanto ambas clases (User y Organization) requieren algun
		 * otro campo que los identifique, aparte del id.
		 * Y por tanto, en sus "hashcode" y "equals", usamos (ademas del id)
		 * el campo "email" para User y el campo "name" para Organization
		*/
		this.user = user;
		this.organization = organization;
		link();
	}

	// // // // // // //
	// METODOS TIPICOS
	// // // // // // //
	
	private void link () {
		user._getMemberships().add(this);
		organization._getMemberships().add(this);
	}

	public void unlink() {
		user._getMemberships().remove(this);
		organization._getMemberships().remove(this);
	}
	
	// // // // // // //
	// METODOS PLAY
	// // // // // // //
	
	public static List<Membership> all() {
		return find.all();
	}

	public static Membership create(Long userId, Long organizationId) {
		User user = User.findById(userId);
		Organization org = Organization.findById(organizationId);
		Membership membership = new Membership(user, org);
		membership.save();
		return membership;
	}

	public static void remove(Long userId, Long organizationId) {
		User user = User.findById(userId);
		Organization org = Organization.findById(organizationId);
		find.where()
			.eq("user", user)
			.eq("org", org).findUnique().delete();
	}

	public static void deleteAll() {
		for (Membership m : all())
			m.delete();
	}

	public static List<Membership> filterByOrganizationName(
			String organizationName, List<Membership> memberships) {
		List<Membership> result = new ArrayList<Membership>();
		for (Membership membership : memberships) {
			if (membership.organization.getName() == organizationName)
				result.add(membership);
		}
		return result;
	}

	public static List<Membership> findByIndicatorId(Long indicatorId) {
		Indicator ind = Indicator.findById(indicatorId);
		List<Membership> result = find.where().eq("indicator", ind).findList();
		return result;
	}
	
	public static List<Membership> findByUserId(Long userId) {
		User user = User.findById(userId);
		List<Membership> result = find.where().eq("user", user).findList();
		return result;
	}
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //
	
	/* Relacion entre entidades:
	 * 1 User <--> * Memberships <--> 1 Organization 
	 */
	void _setUser(User u) {
		user = u;
	}
	public User getUser() {
		return user;
	}
	void _setOrganization(Organization o) {
		organization = o;
	}
	public Organization getOrganization() {
		return organization;
	}
	
	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Membership other = (Membership) obj;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
