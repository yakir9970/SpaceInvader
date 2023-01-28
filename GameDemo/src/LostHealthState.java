
import java.awt.*;
import java.awt.event.KeyEvent;

public class LostHealthState extends GameState{
    Image logo;
    int width;
    int height;
    Data data;
	boolean active;


    public LostHealthState(int width,int height) {
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
        return "Play";
    }

    public void render(GameFrameBuffer aGameFrameBuffer) {

        Graphics g = aGameFrameBuffer.graphics();

        logo = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/lostHeart.png");

        String text = "You lost 1 health";
        String choice="Press any key to continue to play";

        int textWidth = g.getFontMetrics().stringWidth(text);
        g.setColor(Color.white);

        g.drawImage(logo,400,100,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString(text, 500, 550);
        g.drawString(choice, 400, 600);




    }
  
    @Override
    public Object memento() {
        return data;
    }

}
