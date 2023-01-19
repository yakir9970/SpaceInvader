import java.util.ArrayList;
import java.util.List;

public class Player {
	private float x_player;
	private float y_player;
	private int direction;
	//player is width-50, height-20

	public Player(float x,float y) {
		x_player = x;
		y_player=y;
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





	public void update(float deltaTime,int width, int height) {
		if ((x_player > 0 && x_player < width-50)) {//change 50 to rocket size var

			if (direction == 1) {
				x_player = x_player - 0.2f*deltaTime;
			}
			else if(direction == 0){
				x_player = x_player + 0.2f*deltaTime;
			}


		} else if(x_player<=0) {
			if(direction == 0)
				x_player = x_player + 0.2f*deltaTime;

		} else if(x_player>=width-50) {
			if (direction == 1) 
				x_player = x_player - 0.2f*deltaTime;

		}
	}


}
