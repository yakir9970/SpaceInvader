import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class PlayState extends GameState {

	int width, height;
	  
	boolean active;
	float deltaTimeAverage;
	Image spaceShip;//need to enter to the class
	Image enemyImage;//need to enter to the class
	
	Player player;
    private List<Enemy> enemies;
	

	String message;

	public PlayState(int width, int height) {
		this.width=width;
		this.height=height;
	}

	public void enter(Object memento) {
		active = true;
		deltaTimeAverage = 0;
		spaceShip = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/halalit.png");
		enemyImage = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/enemy.png");

		player=new Player((width/2)+25,height-50);
		enemies=new ArrayList<Enemy>();
		
		for (int i = 0; i < 4; i++) {//4 rows of enemies
            for (int j = 0; j < 8; j++) {//6 cols of enemies

                Enemy alien = new Enemy((width/3) + 60 * j,
                        (height/6) + 60 * i);
                enemies.add(alien);
            }
        }
		//enemy=new Enemy((width/2)+25,height-500);
	}

	public void processKeyReleased(int aKeyCode) {
		if (aKeyCode == KeyEvent.VK_ESCAPE)
			System.exit(0);

		if (aKeyCode == KeyEvent.VK_Q)
			active = false;

		if (aKeyCode == KeyEvent.VK_LEFT) { // move to the left
			player.setDirection(1);
			//stay = false;
		}

		if (aKeyCode == KeyEvent.VK_RIGHT) { // move to the right
			player.setDirection(0);
			//stay = false;
		}
		if (aKeyCode == KeyEvent.VK_SPACE) { // move to the right
			player.setShot(true);
		}


	}

	public void update(long deltaTime) {
		deltaTimeAverage = deltaTimeAverage* 0.9f + 0.1f*(float)deltaTime;

		player.update(deltaTime,width,height);
		
		
		
//		if ((x_player > 0 && x_player < 590)) {
//
//			if (arrow == 1) {
//				x_player = x_player - 0.2f*deltaTime;
//				if(!shot) 
//					x_rocket = x_rocket - 0.2f*deltaTime;
//			}
//			else if(arrow == 0){
//				x_player = x_player + 0.2f*deltaTime;
//				if(!shot) 
//					x_rocket = x_rocket + 0.2f*deltaTime;
//			}
//
//			if(shot) {
//				y_rocket = y_rocket - 0.3f*deltaTime;
//			}
//			
//			if(y_rocket <= 0) {
//				y_rocket = 430;
//				shot = false;
//				x_rocket = x_player + 25; // centered
//			}
//
//		} else if(x_player<=0) {
//			if(arrow == 0)
//				x_player = x_player + 0.2f*deltaTime;
//			if(shot) {
//				y_rocket = y_rocket - 0.3f*deltaTime;
//			}
//			
//			if(y_rocket <= 0) {
//				y_rocket = 430;
//				shot = false;
//				x_rocket = x_player + 25; // centered
//			}
//		} else if(x_player>=590) {
//			if (arrow == 1) 
//				x_player = x_player - 0.2f*deltaTime;
//			if(shot) {
//				y_rocket = y_rocket - 0.3f*deltaTime;
//			}
//			
//			if(y_rocket <= 0) {
//				y_rocket = 430;
//				shot = false;
//				x_rocket = x_player + 25; // centered
//			}
//		}
		

		//TODO
		// we need to fix when the player is in the edges

	}

	public boolean isActive() { return active; }

	public String next() {
		return "Welcome";
	}

	public void render(GameFrameBuffer aGameFrameBuffer) {
		Graphics g = aGameFrameBuffer.graphics();

		g.setColor(Color.WHITE);
		g.fillRect((int)player.getRocketX(),(int)player.getRocketY(),2,5);
		g.drawRect((int)player.getRocketX(),(int)player.getRocketY(),2,5);
		g.drawImage(spaceShip,(int)player.getX_player(),(int)player.getY_player(),null);
		
        for (Enemy enemy : enemies) {
        	g.drawImage(enemyImage,(int)enemy.getX_enemy(),(int)enemy.getY_enemy(),null);
        }

		message = "" + (int)deltaTimeAverage;
		
		g.drawString(message, 10, 10);

	}

}

/*TODO:
	change the image and draw func to be in the object class
*/
