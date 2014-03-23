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
	private Organization organization;

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

	public Organization getOrganization() {
		return organization;
	}

	public User setOrganization(Organization organization) {
		if (this.organization != null)
			this.organization.removeUser(this);
		this.organization = organization;
		return this;
	}

	public Set<Follow> getFollows() {
		return Collections.unmodifiableSet(follows);
	}

	protected Set<Follow> _getFollows() {
		return follows;
	}

	public User follow(Indicator indicator) {
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

}
