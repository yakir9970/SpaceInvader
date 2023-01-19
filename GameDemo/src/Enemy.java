import java.awt.Image;

public class Enemy {
	private float x_enemy;
	private float y_enemy;
	private int direction;
	private boolean isVisible;
	private boolean isAlive;
	private Image image;
	//player is width-50, height-50

	
	public Enemy(float x,float y) {
		x_enemy = x;
		y_enemy=y;
		isVisible = true;
		isAlive = true;
	}
	


	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
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
	
	public boolean getIsVisible() {
		return this.isVisible;
	}
	
	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public void update(int direction) {
			x_enemy = x_enemy + direction;
		
	}
	
	
}
