
public class Enemy {
	private float x_enemy;
	private float y_enemy;
	private int direction;
	private boolean isVisible=true;
	//player is width-50, height-50

	public Enemy(float x,float y) {
		x_enemy = x;
		y_enemy=y;
	}

	public float getX_enemy() {
		return x_enemy;
	}

	public void setX_enemy(float x_enemy) {
		this.x_enemy = x_enemy;
	}

	public float getY_enemy() {
		return y_enemy;
	}

	public void setY_enemy(float y_enemy) {
		this.y_enemy = y_enemy;
	}
	
	public boolean isVisible() {
		return this.isVisible;
	}
	
	public void update(int direction) {
			x_enemy = x_enemy + direction;
		
	}
	
	
}
