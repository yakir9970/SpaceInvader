import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverState extends GameState{
    Image logo;
    int width;
    int height;
    Data data;
	boolean active;


    public GameOverState(int width,int height) {
        this.height=height;
        this.width=width;
    }
    
    public void enter(Object memento) {
		active = true;
        data=(Data) memento;
    }
    
    public void processKeyReleased(int aKeyCode) {
    	if (aKeyCode == KeyEvent.VK_ESCAPE)
			System.exit(0);
    	active=false;
    }
    
	public boolean isActive() { return active; }

    public String next() {
    	data.resetData();
        return "Welcome";
    }

    public void render(GameFrameBuffer aGameFrameBuffer) {

        Graphics g = aGameFrameBuffer.graphics();

        logo = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/GameOver.png");

        String text = "Score:";
        String score=data.getScore()+"";
        String choice="Press any key to continue to main menu";

        int textWidth = g.getFontMetrics().stringWidth(text);
        int textWidthScore = g.getFontMetrics().stringWidth(score);
        g.setColor(Color.white);
        g.drawImage(logo,400,0,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString(text, 560, 500);
        g.drawString(score, 670, 500);
        g.drawString(choice, 390, 630);






    }
  
    @Override
    public Object memento() {
        return data;
    }

}
