package persistence;

import java.util.List;

public class ComplexOrganization implements Organization {
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private List<Organization> organizations;
	
	/* Clase que crea las organizaciones complejas.
	 * Pueden constar de varias organizaciones,agrupadas bajo un
	 * mismo nombre
	 */
	
	public ComplexOrganization(String name, List<Organization> organizations){
		this.name=name;
		this.organizations=organizations;
	}
}
