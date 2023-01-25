public class Data {
    int score;
    int diff;
    int lives;
    int level;

    public Data() {
        this.score=0;
        this.diff=1;
        this.lives=3;
        this.level=1;
    }
    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getLevel() {
		return level;
	}
    
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    public void resetData(){
        this.score=0;
        this.diff=1;
        this.lives=3;
        this.level=1;
    }

}
