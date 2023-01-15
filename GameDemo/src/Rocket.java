
public class Rocket {
	private float x_rocket;
	private float y_rocket;
	//player is width-2, height-5

	public Rocket(float x, float y) {
		x_rocket = x+25;
		y_rocket = y;
	}

	public float getX_rocket() {
		return x_rocket;
	}

	public void setX_rocket(float x_rocket) {
		this.x_rocket = x_rocket;
	}

	public float getY_rocket() {
		return y_rocket;
	}

	public void setY_rocket(float y_rocket) {
		this.y_rocket = y_rocket;
	}
	
	
}
