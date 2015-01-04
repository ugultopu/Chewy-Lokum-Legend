package App;


public class MoveLevel extends Level {
	private int movesLeft;

	public MoveLevel(){
		this.movesLeft = (Constants.NUMBER_OF_MOVES - 3 * Options.currentLevel);
		MoveUpdateEvent mue = new MoveUpdateEvent(movesLeft);
		EventDispatchQueue.getInstance().addEvent(mue);
	}
	
	public void decreaseMove(){
		movesLeft--;
		MoveUpdateEvent mue = new MoveUpdateEvent(movesLeft);
		EventDispatchQueue.getInstance().addEvent(mue);
		if(movesLeft == 0){
			if(Score.getInstance().getCurrentScore() < Score.getInstance().getGoalScore(Options.currentLevel)){
				LoseGameEvent lge = new LoseGameEvent();
				EventDispatchQueue.getInstance().addEvent(lge);
			}else{
				WinGameEvent wge = new WinGameEvent();
				EventDispatchQueue.getInstance().addEvent(wge);
			}
		}
	}
	
	public int getMovesLeft(){
		return movesLeft;
	}
	
}


