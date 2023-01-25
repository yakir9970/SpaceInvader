import java.awt.*;
import java.awt.event.KeyEvent;

public class WelcomeState extends GameState {

	boolean active;
	Image logo;
	
	public void enter(Object memento) {
		active = true;
	}
	
	public void processKeyReleased(int aKeyCode) {
		if (aKeyCode == KeyEvent.VK_ESCAPE)
			System.exit(0);
		
		active = false;
	}
	
	public boolean isActive() { return active; }
	
	public String next() {
		return "MainMenu";
	}

	public void render(GameFrameBuffer aGameFrameBuffer) {

		Graphics g = aGameFrameBuffer.graphics();

		logo = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/logo.png");
		String text = "PRESS ANY KEY TO CONTINUE";
		int textWidth = g.getFontMetrics().stringWidth(text);
		g.setColor(Color.white);
		g.drawImage(logo,150,100,null);
		g.drawString(text, 550, 600);

	}
}
