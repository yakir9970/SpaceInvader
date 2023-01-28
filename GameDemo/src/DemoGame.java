import java.awt.*;

public class DemoGame extends Game {

	public DemoGame() {
		GameState welcome = new WelcomeState();
		GameState play = new PlayState(WIDTH,HEIGHT);
		GameState mainMenu = new MainMenuState(WIDTH,HEIGHT);
		GameState gameOver = new GameOverState(WIDTH,HEIGHT);
		GameState lostHealth = new LostHealthState(WIDTH,HEIGHT);
		GameState levelFinished = new LevelFinished(WIDTH,HEIGHT);
		GameState gameFinished = new WinState(WIDTH,HEIGHT);

		stateMachine.installState("Play", play);
		stateMachine.installState("Welcome", welcome);
		stateMachine.installState("MainMenu", mainMenu);
		stateMachine.installState("GameOver", gameOver);
		stateMachine.installState("LostHealth", lostHealth);
		stateMachine.installState("LevelFinished", levelFinished);
		stateMachine.installState("GameFinished", gameFinished);

		stateMachine.setStartState(welcome);
	}

	public static void main( String[] args ) {
		Game app = new DemoGame();
		app.setTitle( "Space Invaders" );
		app.setIconImage(Toolkit.getDefaultToolkit().getImage("GameDemo/src/Images/enemy.png"));
		app.setVisible( true );
		app.run();
		System.exit( 0 );
	}
}
