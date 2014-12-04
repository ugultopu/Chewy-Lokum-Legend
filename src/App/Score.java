package App;

public class Score {
	private int currentScore;
	private static Score instance;
	
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
	}
	
	public void scoreUpdateWrappedForm(){
		currentScore += 200;
	}
	
	public void scoreUpdateBombForm(){
		currentScore += 200;
	}
	
	public void scoreUpdateStripedUse(int numberOfLokumsDestroyed){
		currentScore += numberOfLokumsDestroyed * 60;
	}
	
	public void scoreUpdateWrappedUse(){
		currentScore += 1080;
	}
	
	public void scoreUpdateBombUse(int numberOfLokumsDestroyed){
		currentScore += numberOfLokumsDestroyed * numberOfLokumsDestroyed * 60;
	}
	
	public void scoreUpdateWrappedWrappedMerge(){
		currentScore += 3600;
	}
	
	public void scoreUpdateBombMerge(int numberOfLokumsOnTheBoard){
		currentScore += numberOfLokumsOnTheBoard * numberOfLokumsOnTheBoard * 100;
	}
	
}
