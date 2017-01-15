package Models;

public class PlayerMoveModel extends BaseSocketModel{
	private static final long serialVersionUID = 1L;
	public Stone move;
	
	public PlayerMoveModel(String message, Stone move) {
		super(message);
		this.move = move;
	}
}
