package Graphics.Tests;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.junit.Before;
import org.junit.Test;

import Graphics.MainFrame;

public class MainFrameTest {
private MainFrame frame;
private Toolkit kit;
Dimension screenSize;
	@Before
	public void setUp() throws Exception {
		try{
		//frame = new MainFrame();
		kit = Toolkit.getDefaultToolkit();
		screenSize = kit.getScreenSize();
		}
		catch(NullPointerException ex){ex.printStackTrace();}
	}

	@Test
	public void testDimentionFrame() {
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		assertEquals((2*screenWidth)/3, frame.getWidth());
		assertEquals((2*screenHeight)/3, frame.getHeight());
	}

}
