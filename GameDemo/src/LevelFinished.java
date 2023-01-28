import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class LevelFinished extends GameState{
    Image winLogo;
    int width;
    int height;
    Data data;
    boolean active;


    public LevelFinished(int width,int height) {
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

        winLogo = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/levelWon.png");

        String text = "You Finished Level 1";
        String choice="Press any key to continue to the next level";

        int textWidth = g.getFontMetrics().stringWidth(text);
        g.setColor(Color.white);
        g.drawImage(winLogo,400,100,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(text, 570, 550);
        g.drawString(choice, 500, 600);


    }

    @Override
    public Object memento() {
        return data;
    }
}
