import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenuState extends GameState {
    int width;
    int height;
    public MainMenuState(int width,int height) {
        this.height=height;
        this.width=width;
    }
    boolean active;
    Image logo;
    Data data = new Data ();



    public void enter(Object memento) {
        active = true;
    }

    public void processKeyReleased(int aKeyCode) {

        switch (aKeyCode) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_1:
                data.setDiff(1);
                break;
            case KeyEvent.VK_2:
                data.setDiff(2);
                break;
            case KeyEvent.VK_3:
                data.setDiff(3);
                break;
        }

        if(aKeyCode==KeyEvent.VK_ESCAPE||aKeyCode==KeyEvent.VK_1||aKeyCode==KeyEvent.VK_2||aKeyCode==KeyEvent.VK_3)
            active = false;
    }

    public boolean isActive() { return active; }

    public String next() {
        return "Play";
    }

    public void render(GameFrameBuffer aGameFrameBuffer) {

        Graphics g = aGameFrameBuffer.graphics();

        logo = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/logo.png");

        String text = "Choose your difficulty";
        String textDiffEz="1 --> Easy";
        String textDiffMed="2 --> Medium";
        String textDiffHrd="3 --> Hard";

        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawImage(logo,150,100,null);
        g.drawString(text, 465, 550);
        g.drawString(textDiffEz, 540, 600);
        g.drawString(textDiffMed, 540, 630);
        g.drawString(textDiffHrd, 540, 660);
        g.drawString(textDiffHrd, 540, 660);

    }
    @Override
    public Object memento() {
        return data;
    }
}
