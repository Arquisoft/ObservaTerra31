package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa un usuario del sistema
 * 
 * @author Sergio
 * 
 */
public class User {

	private String name;
	private String surname;
	private String email;
	private String password;

	private Set<Follow> follows = new HashSet<Follow>();
	private Set<Membership> memberships = new HashSet<Membership>();

	public User(String name, String surname, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Set<Follow> getFollows() {
		return Collections.unmodifiableSet(follows);
	}

	protected Set<Follow> _getFollows() {
		return follows;
	}

	public Set<Membership> getMemberships() {
		return Collections.unmodifiableSet(memberships);
	}

	protected Set<Membership> _getMemberships() {
		return memberships;
	}

	public User follow(Indicator indicator) {
		for (Follow f : follows)
			if (f.getIndicator().equals(indicator))
				return this;
		
		new Follow(indicator, this);
		return this;
	}

	public User unfollow(Indicator indicator) {
		for (Follow follow : follows)
			if (follow.getIndicator().equals(indicator)) {
				follow.unlink();
				return this;
			}
		return this;

	}

	public Set<Organization> getOrganizations() {
		Set<Organization> orgs = new HashSet<Organization>();
		for (Membership mmb : this.memberships)
			orgs.add(mmb.getOrganization());
		return orgs;
	}

}