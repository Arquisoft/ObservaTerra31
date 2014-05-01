package domain;
/**
 * Representa la membresia de un usuario en una organizacion.
 * @author Sergio
 *
 */
public class Membership {
	
	private User user;
	private Organization organization;
	
	
	public Membership(User user, Organization organization) {
		this.user = user;
		this.organization = organization;
		link();
	}


	public User getUser() {
		return user;
	}


	public Organization getOrganization() {
		return organization;
	}
	
	private void link () {
		user._getMemberships().add(this);
		organization._getMemberships().add(this);
	}


	public void unlink() {
		user._getMemberships().remove(this);
		organization._getMemberships().remove(this);
	}
	
	
	
	

}
