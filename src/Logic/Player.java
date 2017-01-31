package Logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.SocketException;
import java.util.ArrayList;

import Handlers.MoveValidationHandler;
import Models.BaseSocketModel;
import Models.PlayerSide;
import Models.PlayerTurnModel;
import Models.Stone;

/**
 * Klasa reprezentuj¹ca gracza
 */
public class Player implements IPlayer, Serializable{

	private static final long serialVersionUID = 1L;
	private PlayerSide playerSide;
	private String playerName;
	private transient ObjectInputStream objectInputStream;
	private transient ObjectOutputStream objectOutputStream;
	
	/**
	 * Kontruktor
	 * @param playerName Nazwa gracza
	 * @param objectInputStream Strumieñ wejœcia do komuniakcji z serwerem
	 * @param objectOutputStream Strumieñ wyjœcia do komunikacji z serwerem
	 */
	public Player(String playerName, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream){
		this.playerName = playerName;
		this.objectInputStream = objectInputStream;
		this.objectOutputStream = objectOutputStream; 
	}
	
	/**
	 * Do klienta tego gracza wysy³any jest komuniakt "yourTurn". W pêtli nastêpuje oczekiwanie na ruch gracza.
	 * Nastêpnie po sprawdzeniu ruchu, wysy³any jest komunikat zwrotny informuj¹cy o poprawnoœci ruchu.
	 */
	public void MakeMove(ArrayList<Stone> board) throws IOException, ClassNotFoundException, SocketException{
		objectOutputStream.reset();
		objectOutputStream.writeObject(new PlayerTurnModel("yourTurn", board));
		
		while(true){
			PlayerTurnModel moveModel = (PlayerTurnModel) objectInputStream.readObject();
			Stone playerMove = moveModel.board.get(0);
			playerMove.color = playerSide;
			
			if(MoveValidationHandler.IsValid(board, playerMove)){
				board.add(playerMove);
				objectOutputStream.reset();
				objectOutputStream.writeObject(new BaseSocketModel("validMove"));
				break;
			}
			else{
				objectOutputStream.reset();
				objectOutputStream.writeObject(new BaseSocketModel("invalidMove"));
			}
		}
	}

	/**
	 * Do klienta tego gracza wysy³any jest komuniakt "opponentTurn"
	 */
	public void WaitForAction(ArrayList<Stone> board) throws IOException, ClassNotFoundException, SocketException {
		objectOutputStream.reset();
		objectOutputStream.writeObject(new PlayerTurnModel("opponentTurn", board));
	}

	
	
	
	public PlayerSide GetPlayerSide() {
		return playerSide;
	}
	
	public void SetPlayerSide(PlayerSide playerSide){
		this.playerSide = playerSide;
	}
	
	public String GetPlayerName(){
		return playerName;
	}
	
	public ObjectOutputStream getObjectOutputStream(){
		return objectOutputStream;
	}
}
