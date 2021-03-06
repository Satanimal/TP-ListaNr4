package Models;

import java.io.Serializable;

/**
 * Bazowy model w systemie komunikacji pomiędzy klientem a serwerem. Zawiera on jedynie wiadomość.
 * Dziedziczące po nim modele zawierają dodatkowe pola i informacje.
 * Implementuje interfejs Serializable w celu serializacji obiektu przed wysłaniem przez Socketa
 */
public class BaseSocketModel implements Serializable{

	private static final long serialVersionUID = 1L;
	public String message;
	
	public BaseSocketModel(String message){
		this.message = message;
	}
}
