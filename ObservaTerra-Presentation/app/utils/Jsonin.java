package utils;

import java.util.List;

import models.Observation;

public class Jsonin {
	
	
	public static String observations2json(List<Observation> collection) {
		StringBuilder sb = new StringBuilder ();
		sb.append("{ \"observations\": [");
		
		for (Observation ob : collection)
			sb.append(ob.toJson()).append(",");
		
		sb.deleteCharAt(sb.length()-1).append("]}");
		return sb.toString();
		
	}

}
