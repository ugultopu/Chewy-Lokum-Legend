package App;


public class MoveLevel extends Level {
	private int movesLeft;

	public MoveLevel(int moves){
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
}


