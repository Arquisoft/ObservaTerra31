package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.i18n.Messages;
import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;



/**
 * Representa la suscripccion de un usuario a cierto indicador.
 * 
 * @author Sergio
 * 
 */

@Entity
@Table(name="Follow")
public class Follow extends Model {

	private static final long serialVersionUID = -4318047286773613305L;
	
	// // // // //
	// ATRIBUTOS
	// // // // //
	
	public static Finder<Long, Follow> find = 
			new Finder<Long, Follow>(Long.class, Follow.class);
	
	@Id @GeneratedValue
	public Long id;
	@ManyToOne
	private Indicator indicator;
	@ManyToOne
	private User user;

	// // // // // // //
	// CONSTRUCTORES
	// // // // // // //
	
	public Follow(){}
	
	public Follow(Indicator indicator, User user) {
		this.indicator = indicator;
		this.user = user;
		link();
	}

	// // // // //
	// METODOS
	// // // // //
	
	private void link() {
		indicator._getFollows().add(this);
		user._getFollows().add(this);
	}

	public void unlink() {
		indicator._getFollows().remove(this);
		user._getFollows().remove(this);
	}
	
	// // // // // // // // // // // // //
	// METODOS PERSISTENCIA ACTIVE RECORD
	// // // // // // // // // // // // //
	
	public static List<Follow> all() {
		return find.all();
	}

	public static Follow create(Long indicatorId, Long userId) {
		Indicator ind = Indicator.findById(indicatorId);
		User user = User.findById(userId);
		Follow follow = new Follow(ind, user);
		follow.save();
		return follow;
	}

	public static void remove(Long indicatorId, Long userId) {
	      Indicator ind = Indicator.findById(indicatorId);
	      User user = User.findById(userId);
	      find.where()
	      	.eq("indicator", ind)
	      	.eq("user", user).findUnique().delete();
	}

	public static void deleteAll() {
		for (Follow f : all())
			f.delete();
	}

	public static List<Follow> filterByIndicatorName(String indicatorName,
			List<Follow> follows) {
		List<Follow> result = new ArrayList<Follow>();
		for (Follow follow : follows) {
			if (follow.indicator.getName() == indicatorName)
				result.add(follow);
		}
		return result;
	}

	public static List<Follow> findByIndicatorId(Long indicatorId) {
		Indicator ind = Indicator.findById(indicatorId);
		List<Follow> result = find.where().eq("indicator", ind).findList();
		return result;
	}
	
	public static List<Follow> findByUserId(Long userId) {
		User user = User.findById(userId);
		List<Follow> result = find.where().eq("user", user).findList();
		return result;
	}
	
	// // // // // // // // // //
	// RELACION ENTRE ENTIDADES
	// // // // // // // // // //
	
	/* RelaciOn entre entidades:
	 * 1 Indicator <--> * Follows <--> 1 User 
	 */
	void _setIndicator(Indicator i) {
		indicator = i;
	}
	public Indicator getIndicator() {
		return indicator;
	}
	void _setUser(User u) {
		user = u;
	}
	public User getUser() {
		return user;
	}
	
	// // // // // // // //
	// HASHCODE & EQUALS
	// // // // // // // //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((indicator == null) ? 0 : indicator.hashCode());
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
		Follow other = (Follow) obj;
		if (indicator == null) {
			if (other.indicator != null)
				return false;
		} else if (!indicator.equals(other.indicator))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	// // // // // // // //
	// TO_STRING & TO_JSON
	// // // // // // // //
	
	public String toString() {
		return Messages.get("Indicator") + ": " + indicator + ", "
				+ Messages.get("User") + ": " + user;
	}
	
	public static JsonNode toJson(Follow follow) {
		return Json.toJson(follow);
	}
	
	public String toJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{")
		  .append("\"indicator\": \"").append(indicator).append("\",")
		  .append("\"user\":").append(user.toJson())
		  .append("}");
		
		return sb.toString();
	}
}
