package App;


public class TimeLevel extends Level {
	
	int timeLeft;
	private static TimeLevel instance;
	
	private TimeLevel(int levelNumber){
		this.timeLeft = 90 - 3*levelNumber;//just for simplicity;
		this.levelNumber = levelNumber;
	}
	
	public int getTime(){
		return timeLeft;
	}
	public void updateTime(int newTime){
		timeLeft = newTime;
	}
	public static TimeLevel getInstance(){
		if(instance == null)
			instance = new TimeLevel(Options.currentLevel);
		return (TimeLevel) instance;
	}
	
}
