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
        if (aKeyCode == KeyEvent.VK_ESCAPE)
            System.exit(0);
        if (aKeyCode == KeyEvent.VK_1)
            data.setDiff(1);
        if (aKeyCode == KeyEvent.VK_2)
            data.setDiff(2);
        if (aKeyCode == KeyEvent.VK_3)
            data.setDiff(20);
        active = false;
    }

    public boolean isActive() { return active; }

    public String next() {
        return "Play";
    }

    public void render(GameFrameBuffer aGameFrameBuffer) {

        Graphics g = aGameFrameBuffer.graphics();

        logo = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/logo.png");

        String text = "Choose you difficulty";
        String textDiffEz="1 --> Easy";
        String textDiffMed="2 --> Medium";
        String textDiffHrd="3 --> Hard";
        int textWidth = g.getFontMetrics().stringWidth(text);
        int textWidthEz = g.getFontMetrics().stringWidth(textDiffEz);
        int textWidthMed = g.getFontMetrics().stringWidth(textDiffEz);
        int textWidthHrd = g.getFontMetrics().stringWidth(textDiffEz);
        g.setColor(Color.white);
        g.drawImage(logo,150,100,null);
        g.drawString(text, 550, 550);
        g.drawString(textDiffEz, 575, 600);
        g.drawString(textDiffMed, 575, 630);
        g.drawString(textDiffHrd, 575, 660);

    }
    @Override
    public Object memento() {
        return data;
    }
}
