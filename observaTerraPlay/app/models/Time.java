package models;

import javax.persistence.Embeddable;

/**
 * Clase abstracta que representa un instante temporal, bien puede ser un a�o
 * concreto o un intervalo.
 * 
 * @author Sergio
 * 
 */

/**
 * Necesitamos una entidad Time porque la entidad Observation
 * posee un atributo de este tipo. 
 * Sin embargo, queremos evitar que Time tenga una tabla propia,
 * y por tanto en lugar de anotarla como @Entity la anotamos como @Embeddable
 */
@Embeddable
public abstract class Time {
	
	public Time(){}
	
	abstract Time getStart();
	
	abstract Time getEnd();
}
