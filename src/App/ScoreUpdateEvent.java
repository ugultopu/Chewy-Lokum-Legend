package App;


public class ScoreUpdateEvent extends GameEvent {

	int scoreIncrement;
	
	public ScoreUpdateEvent(int scoreIncrement){
		this.scoreIncrement = scoreIncrement;
	}
	
	@Override
	public void executeEvent() {
		InformationPanel.increaseScore(scoreIncrement);
		InformationPanel.getInstance().repaint();
	}

}
