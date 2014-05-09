package models.types;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Representa los diferentes tipos (ambitos) de areas. - Region: Representa una
 * region (p.e Maryland State) - Country: Representa un pais (p.e USA) - Group
 * of Countries: Representa una varios pa�ses (p.e Reino Unido) - Continent:
 * Representa un continente (p.e America)
 * 
 * @author Sergio
 * 
 */
public enum ScopeEnum {
	REGION, COUNTRY, GROUPOFCOUNTRIES, CONTINENT;

    public static Map<String, String> options() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (ScopeEnum scope : ScopeEnum.values()) {
            Integer ordinal = scope.ordinal();
            options.put(ordinal.toString(), scope.toString());
        }
        return options;
    }
}
