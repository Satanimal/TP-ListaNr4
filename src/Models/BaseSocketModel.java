package Models;

import java.io.Serializable;

/**
 * Bazowy model w systemie komunikacji pomiêdzy klientem a serwerem. Zawiera on jedynie wiadomoœæ.
 * Dziedzicz¹ce po nim modele zawieraj¹ dodatkowe pola i informacje.
 * Implementuje interfejs Serializable w celu serializacji obiektu przed wys³aniem przez Socketa
 */
public class BaseSocketModel implements Serializable{

	private static final long serialVersionUID = 1L;
	public String message;
	
	public BaseSocketModel(String message){
		this.message = message;
	}
}
