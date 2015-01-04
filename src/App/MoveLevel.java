package App;


public class MoveLevel extends Level {
	private int movesLeft;
	private static MoveLevel instance;

	private MoveLevel(int moves){
		this.movesLeft = moves;
	}
	
	public void decreaseMove(){
		movesLeft--;
		MoveUpdateEvent mue = new MoveUpdateEvent(movesLeft);
		mue.executeEvent();
		if(movesLeft == 0){
			if(Score.getInstance().getCurrentScore() < Score.getInstance().getGoalScore(Options.currentLevel)){
				LoseGameEvent lge = new LoseGameEvent();
				lge.executeEvent();
			}else{
				WinGameEvent wge = new WinGameEvent();
				wge.executeEvent();
			}
		}
		
	}
	
	public int getMovesLeft(){
		return movesLeft;
	}
	
	public static MoveLevel getInstance(){
		if(instance == null)
			instance = new MoveLevel(50 - (3 * Options.currentLevel));
		return instance;
	}
	
	public static void resetInstance(){
		instance = new MoveLevel(50 - (3 * Options.currentLevel));
	}
}


