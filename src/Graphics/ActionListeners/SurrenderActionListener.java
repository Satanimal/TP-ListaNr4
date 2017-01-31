package Graphics.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener odpowiedzialny za poddanie si�.
 * Ko�czy dzia�anie programu z kodem -1.
 */
public class SurrenderActionListener implements ActionListener{
	
	public SurrenderActionListener(){
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(-1);
	}

}
