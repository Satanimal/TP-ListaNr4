package Models;

import java.io.Serializable;

/**
 * Bazowy model w systemie komunikacji pomi�dzy klientem a serwerem. Zawiera on jedynie wiadomo��.
 * Dziedzicz�ce po nim modele zawieraj� dodatkowe pola i informacje.
 * Implementuje interfejs Serializable w celu serializacji obiektu przed wys�aniem przez Socketa
 */
public class BaseSocketModel implements Serializable{

	private static final long serialVersionUID = 1L;
	public String message;
	
	public BaseSocketModel(String message){
		this.message = message;
	}
}
