package Graphics;

import javax.swing.JCheckBox;

import Logic.Game;

public class AdvancedCheckBox extends JCheckBox{
	private Game game;
	private Boolean isSelected;
	public AdvancedCheckBox(Game game){
		super();
		this.game = game;
	}
	
	public void set(Boolean a){
		isSelected = a;
	}
	
	
}
