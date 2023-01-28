import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class WinState extends GameState{
    Image winLogo;
    int width;
    int height;
    Data data;
    boolean active;


    public WinState(int width,int height) {
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

        winLogo = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/youwin.png");


        String choice="Press any key to continue to the main menu";
        String score="Score: "+data.getScore();


        g.setColor(Color.white);
        g.drawImage(winLogo,340,-50,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        g.drawString(choice, 360, 560);
        g.drawString(score, 570, 450);


    }

    @Override
    public Object memento() {
        return data;
    }
}
