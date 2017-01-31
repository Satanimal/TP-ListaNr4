package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Graphics.Board;
import Models.BaseSocketModel;
import Models.PlayerTurnModel;
import Models.Stone;

/**
 * W�tek odpowiadaj�cy za oczekiwanie na kolejk� garcza, lub wykonywanie ruchu
 */
public class MoveActionThread implements Runnable{
	private Board board;
	private PlayerTurnModel message;
	private ObjectInputStream input; 
	private ObjectOutputStream output;
	
	/**
	 * Konstruktor w�tku
	 * @param board Plansza
	 * @param input Strumie� wej�cia do komuniakcji z serwerem
	 * @param output Strumie� wyj�cia do komunikacji z serwerem
	 */
	public MoveActionThread(Board board, ObjectInputStream input, ObjectOutputStream output) {
		this.board = board;
		this.input = input;
		this.output = output;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				message = (PlayerTurnModel) input.readObject();
				System.out.println(message.message);
				board.text.setText(message.message);
				switch(message.message){
					case  "yourTurn" :
							board.moveValue = true;
							board.playerMove = null;
							board.setListOfPoints(message.board);
							board.repaint();
							MakeMove();
							break;
					case "opponentTurn" : 
							board.moveValue = false;
							board.setListOfPoints(message.board);
							board.repaint();
							break;
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			} 
			catch (ClassNotFoundException e) {}
		}
	}

	/**
	 * Metoda pomocnicza zawieraj�ca p�tl� oczekuj�c� na prawid�owy ruch gracza
	 * @throws ClassNotFoundException
	 */
	private void MakeMove() throws ClassNotFoundException {
		while(board.moveValue == true){
			
			if(board.playerMove == null)
				continue;
			
			ArrayList<Stone> playerMoveList = new ArrayList<Stone>();
			playerMoveList.add(board.playerMove);
			
			try {
				output.reset();
				output.writeObject(new PlayerTurnModel("playerMove", playerMoveList));
				BaseSocketModel validationMessage = (BaseSocketModel) input.readObject();
				if(validationMessage.message.equals("validMove")){
					board.moveValue = false;
					board.playerMove = null;
				}
				else{
					System.out.println("Nieprawid�owy ruch!");
					board.playerMove = null;
					continue;
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

}
