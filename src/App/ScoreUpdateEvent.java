package App;


public class ScoreUpdateEvent extends GameEvent {

	int scoreIncrement;
	
	public ScoreUpdateEvent(int scoreIncrement){
		this.scoreIncrement = scoreIncrement;
	}
	
	@Override
	public void executeEvent() {
		InformationBoard.getInstance().increaseScore(scoreIncrement);
		InformationBoard.getInstance().repaint();
	}

}
