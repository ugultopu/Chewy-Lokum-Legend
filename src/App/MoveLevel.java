package App;


public class MoveLevel extends Level {
	private int movesLeft;
	private MoveLevel instance;

	private MoveLevel(int moves){
		this.movesLeft = moves;
	}
	
	public void decreaseMove(){
		movesLeft--;
		MoveUpdateEvent mue = new MoveUpdateEvent(movesLeft);
		mue.executeEvent();
	}
	
	public int getMovesLeft(){
		return movesLeft;
	}
	
	public MoveLevel getInstance(){
		if(instance == null)
			instance = new MoveLevel(50 - (3 * Options.currentLevel));
		return instance;
	}
	
	public void resetInstance(){
		instance = new MoveLevel(50 - (3 * Options.currentLevel));
	}
}


