package Models;

import java.io.Serializable;

public class BaseSocketModel implements Serializable{

	private static final long serialVersionUID = 1L;
	public String message;
	
	public BaseSocketModel(String message){
		this.message = message;
	}
}
