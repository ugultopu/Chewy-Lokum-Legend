package App;

public class Score {
	private int currentScore;
	private static Score instance;
	private boolean updated;
	
	private Score(){
		currentScore = 0;
		updated = false;
	}
	
	public static Score getInstance(){
		if(instance == null)
			instance = new Score();
		return instance;
	}
	
	public int getCurrentScore(){
		return currentScore;
	}
	
	public boolean isUpdated(){
		return updated;
	}
	
	public void setUpdated(boolean upt){
		updated = upt;
	}
	
	public void scoreUpdateStripedForm(){
		currentScore += 120;
		updated = true;
	}
	
	public void scoreUpdateWrappedForm(){
		currentScore += 200;
		updated = true;
	}
	
	public void scoreUpdateBombForm(){
		currentScore += 200;
		updated = true;
	}
	
	public void scoreUpdateStripedUse(int numberOfLokumsDestroyed){
		currentScore += numberOfLokumsDestroyed * 60;
		updated = true;
	}
	
	public void scoreUpdateWrappedUse(){
		currentScore += 1080;
		updated = true;
	}
	
	public void scoreUpdateBombUse(int numberOfLokumsDestroyed){
		currentScore += numberOfLokumsDestroyed * numberOfLokumsDestroyed * 60;
		updated = true;
	}
	
	public void scoreUpdateWrappedWrappedMerge(){
		currentScore += 3600;
		updated = true;
	}
	
	public void scoreUpdateBombMerge(int numberOfLokumsOnTheBoard){
		currentScore += numberOfLokumsOnTheBoard * numberOfLokumsOnTheBoard * 100;
		updated = true;
	}
	
	public void scoreUpdateThreeCombo(){
		currentScore += 60;
	}
	
}
