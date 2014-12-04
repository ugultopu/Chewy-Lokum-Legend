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
	
	public void scoreUpdateThreeCombo(){
		
	}
	
	
}
