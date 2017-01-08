package Models;

import java.io.Serializable;

public class BaseSocketModel implements Serializable{
	String message;
	
	public BaseSocketModel(String message){
		this.message = message;
	}
}
