package utils;

import java.util.List;

import models.Observation;
import models.Organization;

public class Jsonin {
	
	
	public static String observations2json(List<Observation> collection) {
		StringBuilder sb = new StringBuilder ();
		sb.append("{ \"observations\": [");
		
		for (Observation ob : collection)
			sb.append(ob.toJson()).append(",");
		
		sb.deleteCharAt(sb.length()-1).append("]}");
		return sb.toString();
		
	}
	
	public static String organizations2json(List<Organization> collection) {
		StringBuilder sb = new StringBuilder ();
		sb.append("{ \"organizations \": [");
		
		for (Organization ob : collection)
			sb.append(ob.toJson()).append(",");
		
		sb.deleteCharAt(sb.length()-1).append("]}");
		return sb.toString();
		
	}

}
