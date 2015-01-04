package App;

public class Options {
	
	public static int currentLevel = 1;
	public static int targetScore = 1;
	
	private static Options instance;
	
	public void setLevel(int level){
		currentLevel = level;
	}
	
	public void setTargetScore(int score){
		targetScore = score;
	}
	
	public int getTargetScore(){
		return targetScore;
	}
	
	public int getLevel(){
		return currentLevel;
	}
	
	public static Options getInstance(){
		if(instance==null){
			instance = new Options();
		}
		return instance;
	}
	
}
