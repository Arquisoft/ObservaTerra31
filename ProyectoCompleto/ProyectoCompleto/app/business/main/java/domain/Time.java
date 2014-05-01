package domain;

/**
 * Clase abstracta que representa un instante temporal, bien puede ser un a–o
 * concreto o un intervalo.
 * 
 * @author Sergio
 * 
 */
public interface Time {

	Time getStart();

	Time getEnd();

}
