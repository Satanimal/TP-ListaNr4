package Logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Graphics.Board;
import Models.BaseSocketModel;
import Models.PlayerTurnModel;
import Models.Stone;

public class MoveActionThread implements Runnable{
	private Board board;
	private PlayerTurnModel message;
	private ObjectInputStream input; 
	private ObjectOutputStream output;
	
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
							board.setListOfPoints(message.board);
							board.moveValue = true;
							MakeMove();
							board.repaint();
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
					System.out.println("Nieprawid³owy ruch!");
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
