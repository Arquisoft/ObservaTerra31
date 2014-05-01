package utils;

import java.util.List;

import models.Follow;
import models.Observation;
import models.Organization;

public class Jsonin {

	public static String observations2json(List<Observation> collection) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ \"observations\": [");

		if (!collection.isEmpty()) {
			for (Observation ob : collection)
				sb.append(ob.toJson()).append(",");

			sb.deleteCharAt(sb.length() - 1);
		}

		sb.append("]}");
		return sb.toString();

	}

	public static String organizations2json(List<Organization> collection) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ \"organizations\": [");
		if (!collection.isEmpty()) {
			for (Organization ob : collection)
				sb.append(ob.toJson()).append(",");

			sb.deleteCharAt(sb.length() - 1);
		}

		sb.append("]}");
		return sb.toString();

	}

	public static String follow2json(List<Follow> collection) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ \"follows\": [");
		if (!collection.isEmpty()) {
			for (Follow ob : collection)
				sb.append(ob.toJson()).append(",");
			sb.deleteCharAt(sb.length() - 1);
		}

		sb.append("]}");
		return sb.toString();
	}
	
	

}
