import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverState extends GameState{
    Image logo;
    int width;
    int height;
    boolean active;
    Data data;

    public GameOverState(int width,int height) {
        this.height=height;
        this.width=width;
    }

    public void render(GameFrameBuffer aGameFrameBuffer) {

        Graphics g = aGameFrameBuffer.graphics();

        logo = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/GameOver.png");

        String text = "Score:";
        String score="5000";
        String choice="Press any key to continue to main menu";

        int textWidth = g.getFontMetrics().stringWidth(text);
        int textWidthScore = g.getFontMetrics().stringWidth(score);
        g.setColor(Color.white);
        g.drawImage(logo,400,0,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(text, 570, 550);
        g.drawString(score, 700, 550);
        g.drawString(choice, 480, 650);
        //TODO add next state functionality, and also score memento transition , add lives to the player , implement enemy collision with life reduction , reset enemies if all were destroyed




    }
    public void enter(Object memento) {

        data=(Data) memento;
    }

    public void processKeyReleased(int aKeyCode) {

    }


    public String next() {
        return "Welcome";
    }


}
