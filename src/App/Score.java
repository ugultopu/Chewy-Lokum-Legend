package App;

public class Score {
	private int currentScore;
	private static Score instance;
	private ScoreUpdateEvent sue;
	
	private Score(){
		currentScore = 0;
		
	}
	
	public static Score getInstance(){
		if(instance == null)
			instance = new Score();
		return instance;
	}
	
	public int getCurrentScore(){
		return currentScore;
	}
	
	public void scoreUpdateStripedForm(){
		currentScore += 120;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
		
	}
	
	public void scoreUpdateWrappedForm(){
		currentScore += 200;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
	}
	
	public void scoreUpdateBombForm(){
		currentScore += 200;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
	}
	
	public void scoreUpdateStripedUse(int numberOfLokumsDestroyed){
		currentScore += numberOfLokumsDestroyed * 60;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
	}
	
	public void scoreUpdateWrappedUse(){
		currentScore += 1080;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
	}
	
	public void scoreUpdateBombUse(int numberOfLokumsDestroyed){
		currentScore += numberOfLokumsDestroyed * numberOfLokumsDestroyed * 60;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
	}
	
	public void scoreUpdateWrappedWrappedMerge(){
		currentScore += 3600;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
	}
	
	public void scoreUpdateBombMerge(int numberOfLokumsOnTheBoard){
		currentScore += numberOfLokumsOnTheBoard * numberOfLokumsOnTheBoard * 100;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
	}
	
	public void scoreUpdateThreeCombo(){
		currentScore += 60;
		sue = new ScoreUpdateEvent(currentScore);
		EventDispatchQueue.getInstance().addEvent(sue);
	}

	public void setScore(int currentScore) {
		this.currentScore = currentScore;
	}
}
