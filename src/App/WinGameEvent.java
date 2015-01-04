package App;

public class WinGameEvent extends GameEvent{
	
	
	@Override
	public void executeEvent() {
		GameOverPanel.getInstance().setWin(true);
		GamePanel.getInstance().endGame();
		
	}

}
