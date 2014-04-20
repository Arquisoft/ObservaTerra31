package models;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

/**
 * Representa un usuario del sistema
 * 
 * @author Sergio
 * 
 */

@Entity
@Table(name="User")
public class User extends Model {

	private static final long serialVersionUID = 7743947880552276479L;
	
	public static Finder<Long,User> find = 
			new Finder<Long,User>(Long.class, User.class);
	
	@Id @GeneratedValue
	public Long id;
	private String name;
	private String surname;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user")
	private Set<Follow> follows = new HashSet<Follow>();
	@OneToMany(mappedBy = "user")
	private Set<Membership> memberships = new HashSet<Membership>();
	
	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public User(){}
	
	public User(String name, String surname, String email, 
			String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	
	// // // // // // //
	// METODOS PLAY
	// // // // // // //
	
	public static List<User> all(){
		return find.all();
	}

	public static void create(User user){
		if (User.findByEmail(user.email) == null) {
			user.save();
		}
	}

	public static void remove(long id){
		find.ref(id).delete();
	}

	public static void deleteAll(){
		for (User u : all())
			u.delete();
	}

	public static User findById(Long id){
		return find.byId(id);
	}
	
	public static User findByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}
	
	// // // // //
	// METODOS
	// // // // //
	
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

	/** Por cada Membership, obtiene su Organization  */
	public Set<Organization> getOrganizations() {
		Set<Organization> orgs = new HashSet<Organization>();
		for (Membership mmb : this.memberships)
			orgs.add(mmb.getOrganization());
		return orgs;
	}
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //
	
	/*
	 * Relacion entre entidades:
	 * 1 User <--> * Follows
	 */
	protected Set<Follow> _getFollows() {
		return follows;
	}
	public Set<Follow> getFollows() {
		return Collections.unmodifiableSet(follows);
	}
	public void setFollows(Set<Follow> f) {
		follows = f;
	}

	/*
	 * Relacion entre entidades:
	 * 1 User <--> * Memberships
	 */
	protected Set<Membership> _getMemberships() {
		return memberships;
	}
	public Set<Membership> getMemberships() {
		return Collections.unmodifiableSet(memberships);
	}
	public void setMemberships(Set<Membership> m) {
		memberships = m;
	}
	
	// // // // // // // //
	// GETTERS & SETTERS
	// // // // // // // //
	
	public Long getId() {
		return id;
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

	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
