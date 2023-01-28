import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayState extends GameState {
	Data data;

	int width, height;
	int deaths;
	int direction=-1;
	int level;
	boolean active;
	boolean gameOver;
	boolean lostHealth;
	boolean gameWon;
	boolean finishLevelOne;
	float deltaTimeAverage;
	Image spaceShip;
	Image enemyImage;
	Image heart1;
	Image heart2;
	Image heart3;


	Player player;
	private List<Enemy> enemies;
	private Rocket rocket;


	String message;

	public PlayState(int width, int height) {
		this.width=width;
		this.height=height;


	}

	@Override
	public void enter(Object memento) {

		player=new Player((width/2)+25,height-50);
		rocket = new Rocket();
		active = true;
		finishLevelOne=false;
		deltaTimeAverage = 0;
		data=(Data) memento;

		spaceShip = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/halalit.png");
		enemyImage = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/enemy.png");
		heart1=spaceShip;
		heart2=spaceShip;
		heart3=spaceShip;

		if(data.getLevel()==1) {
			if(data.getLives()==3) {
				gameOver=false;
				lostHealth=false;
				enemies=new ArrayList<Enemy>();

				for (int i = 0; i < 6; i++) {//4 rows of enemies
					for (int j = 0; j < 9; j++) {//8 cols of enemies

						Enemy enemy = new Enemy((width/3) + 60 * j,
								(height/6) + 60 * i);
						enemy.setImage(enemyImage);
						enemies.add(enemy);
					}
				}
			}

			else {
				for (int i = 0; i < 6; i++) {//4 rows of enemies
					for (int j = 0; j < 9; j++) {//8 cols of enemies

						enemies.get(i*9+j).setX_enemy((width/3) + 60 * j);
						enemies.get(i*9+j).setY_enemy((height/6) + 60 * i);
					}
				}
			}
		}

		else if(data.getLevel()==2) {
			if(data.getLives()==3) {
				gameOver=false;
				lostHealth=false;
				enemies=new ArrayList<Enemy>();

				for (int i = 0; i < 7; i++) {//4 rows of enemies
					for (int j = 0; j < 10; j++) {//8 cols of enemies

						Enemy enemy = new Enemy((width/3) + 60 * j,
								(height/6) + 60 * i);
						enemy.setImage(enemyImage);
						enemies.add(enemy);
					}
				}
				removeEnemies();
			}

			else {
				for (int i = 0; i < 7; i++) {//4 rows of enemies
					for (int j = 0; j < 10; j++) {//8 cols of enemies

						enemies.get(i*2+j).setX_enemy((width/3) + 60 * j);
						enemies.get(i*2+j).setY_enemy((height/6) + 60 * i);
					}
				}
			}
		}





	}

	private void removeEnemies() {
		for(int i=0;i<4;i++)
		{
			enemies.get(i+i*10).setIsAlive(false);
			enemies.get((9-i)+i*10).setIsAlive(false);
		}
		for(int i=4,counter=2;i<7;i++,counter--)		{
			enemies.get(i*10+counter).setIsAlive(false);
			enemies.get((i+1)*10-(counter+1)).setIsAlive(false);
		}
		enemies.get(25).setIsAlive(false);
		enemies.get(24).setIsAlive(false);
	}

	public void processKeyReleased(int aKeyCode) {

		switch (aKeyCode) {
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			case KeyEvent.VK_Q:
				active = false;
				break;
			case KeyEvent.VK_LEFT: // move to the left
				player.setDirection(1);
				break;
			case KeyEvent.VK_RIGHT: // move to the right
				player.setDirection(0);
				break;
			case KeyEvent.VK_SPACE:
				if (active) {
					if (!rocket.getIsVisible()) {
						rocket = new Rocket(player.getX_player(),player.getY_player());
					}
				}
				break;

			default:

				break;
		}

	}

	public void update(long deltaTime) {
		// i try
		if (deaths==1) {

			if(data.getLevel()==1) {
				data.setLevel(2);
				finishLevelOne=true;
			}
			else if(data.getLevel()==2) {
				gameWon=true;
			}
			active=false;
			deaths=0;
			data.setLives(3);
			lostHealth=false;

		}

		deltaTimeAverage = deltaTimeAverage* 0.9f + 0.1f*(float)deltaTime;
		player.update(deltaTimeAverage,width,height);

		//enemies
		for(Enemy enemy : enemies) {
			float x=enemy.getX_enemy();

			if(x>=width-50&&direction!=-1) {
				direction=-1;
				Iterator<Enemy> enemyIter1=enemies.iterator();
				while(enemyIter1.hasNext()) {
					Enemy enemy1=enemyIter1.next();
					enemy1.setY_enemy(enemy1.getY_enemy()+50);
				}
			}

			if(x<=0&&direction!=1) {
				direction=1;
				Iterator<Enemy> enemyIter2=enemies.iterator();
				while(enemyIter2.hasNext()) {
					Enemy enemy2=enemyIter2.next();
					enemy2.setY_enemy(enemy2.getY_enemy()+50);
				}
			}
		}


		Iterator<Enemy> iter = enemies.iterator();

		while (iter.hasNext()) {

			Enemy enemy = iter.next();

			if (enemy.getIsVisible()) {

				float y = enemy.getY_enemy();

				//check collision with player
				if (y > height-100) {
					//need to reduce live after collision
					active = false;
					//                    gameOver=true;
					lostHealth=true;
					//System.out.println("finish");
					// change screen
				}


				enemy.update(direction*data.getDiff());
			}
		}

		//rocket

		if (rocket.getIsVisible()) {

			float X_rocket = rocket.getX_rocket();
			float Y_rocket = rocket.getY_rocket();

			for (Enemy enemy : enemies) {

				float X_enemy = enemy.getX_enemy();
				float Y_enemy = enemy.getY_enemy();

				if (enemy.getIsVisible() && rocket.getIsVisible()) {
					// we need to see
					if (X_rocket >= (X_enemy)
							&& X_rocket <= (X_enemy + 50)
							&& Y_rocket >= (Y_enemy)
							&& Y_rocket <= (Y_enemy + 50)) {

						Image enemyExplode = Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/enemyExplode.png");

						enemy.setImage(enemyExplode);
						enemy.setIsAlive(false);
						deaths++;
						data.setScore(data.getScore()+100);
						rocket.setIsVisible(false);
					}
				}
			}

			float y = rocket.getY_rocket();
			y -= 6;
			//System.out.println(rocket.getX_rocket() +" " + rocket.getY_rocket());
			if (y < 0) {
				rocket.setIsVisible(false);
			} else {
				rocket.setY_rocket(y);
			}
		}

	}

	public boolean isActive() { return active; }

	public String next() {
		if(gameOver)
			return "GameOver";

		else if(lostHealth) {
			reduceLives();
			return "LostHealth";
		}
		else if (finishLevelOne) {
			return "LevelFinished";
		}
		else if(gameWon)
		{
			data.resetData();
			return "GameFinished";
		}
		else
			return "Welcome";

	}

	private void reduceLives() {
		data.setLives(data.getLives()-1);
		if(data.getLives()==0) {
			gameOver=true;
			lostHealth=false;
			data.setLives(3);
		}
	}

	public void render(GameFrameBuffer aGameFrameBuffer) {
		Graphics g = aGameFrameBuffer.graphics();

		g.setColor(Color.WHITE);
		if (rocket.getIsVisible()) {
			g.fillRect((int)rocket.getX_rocket(),(int)rocket.getY_rocket(),2,5);
			g.drawRect((int)rocket.getX_rocket(),(int)rocket.getY_rocket(),2,5);

		}

		g.drawImage(spaceShip,(int)player.getX_player(),(int)player.getY_player(),null);

		for (Enemy enemy : enemies) {
			if (enemy.getIsVisible()) {
				g.drawImage(enemy.getImage(),(int)enemy.getX_enemy(),(int)enemy.getY_enemy(),null);
			}

			if (!enemy.getIsAlive()) {
				enemy.setIsVisible(false);
			}
		}
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

		message = "Score: " + data.getScore();

		g.drawString(message, 20, 50);

		g.drawString("Level "+data.getLevel(), 600, 50);

		if(data.getLives()>=1)
			g.drawImage(heart1,1050,30,null);
		if(data.getLives()>=2)
			g.drawImage(heart2,1120,30,null);
		if(data.getLives()>=3)
			g.drawImage(heart3,1190,30,null);

	}

	@Override
	public Object memento() {
		return data;
	}
}
