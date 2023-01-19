import java.util.ArrayList;
import java.util.List;

public class Player {
	private float x_player;
	private float y_player;
	private int direction;
	private boolean shot;
	private Rocket rocket;//maybe a list of rockets to shot multiple at once
	private List<Rocket> rockets;
	//player is width-50, height-20

	public Player(float x,float y) {
		x_player = x;
		y_player=y;
		rocket=new Rocket(x_player,y_player);
		rockets=new ArrayList<Rocket>();
	}


	public float getX_player() {
		return x_player;
	}


	public void setX_player(float x_player) {
		this.x_player = x_player;
	}
	
	
	public float getY_player() {
		return y_player;
	}


	public void setY_player(float y_player) {
		this.y_player = y_player;
	}


	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public float getRocketX() {
		return rocket.getX_rocket();
	}


	public void setRocketX(float x_rocket) {
		this.rocket.setX_rocket(x_rocket);
	}
	
	public float getRocketY() {
		return rocket.getY_rocket();
	}


	public void setRocketY(float y_rocket) {
		this.rocket.setY_rocket(y_rocket);
	}

	public boolean isShot() {
		return shot;
	}


	public void setShot(boolean shot) {
		this.shot = shot;
	}
	
	public void addShot() {
		rockets.add(new Rocket(x_player,y_player));
		System.out.println(rockets.size());
	}
	
	public List<Rocket> getRockets() {
		return this.rockets;
	}


	public void update(float deltaTime,int width, int height) {
		if ((x_player > 0 && x_player < width-50)) {//change 50 to rocket size var

			if (direction == 1) {
				x_player = x_player - 0.2f*deltaTime;
				if(!shot) 
					rocket.setX_rocket(rocket.getX_rocket()- 0.2f*deltaTime);
			}
			else if(direction == 0){
				x_player = x_player + 0.2f*deltaTime;
				if(!shot) 
					rocket.setX_rocket(rocket.getX_rocket()+ 0.2f*deltaTime);
			}

			if(shot) {
				rockets.get(rockets.size()-1).setY_rocket(rockets.get(rockets.size()-1).getY_rocket()- 0.3f*deltaTime);
			}
			
			if(rocket.getY_rocket() <= 0) {
				rocket.setY_rocket(height-50);
				shot = false;
				rocket.setX_rocket(x_player + 25); // centered
			}

		} else if(x_player<=0) {
			if(direction == 0)
				x_player = x_player + 0.2f*deltaTime;
			if(shot) {
				rocket.setY_rocket(rocket.getY_rocket()- 0.3f*deltaTime);
			}
			
			if(rocket.getY_rocket() <= 0) {
				rocket.setY_rocket(height-50);
				shot = false;
				rocket.setX_rocket(x_player + 25); // centered
			}
		} else if(x_player>=width-50) {
			if (direction == 1) 
				x_player = x_player - 0.2f*deltaTime;
			if(shot) {
				rocket.setY_rocket(rocket.getY_rocket()- 0.3f*deltaTime);
			}
			
			if(rocket.getY_rocket() <= 0) {
				rocket.setY_rocket(height-50);
				shot = false;
				rocket.setX_rocket(x_player + 25); // centered
			}
		}
	}
	
	
}
