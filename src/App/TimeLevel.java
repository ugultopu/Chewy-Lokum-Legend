package App;

import java.util.Timer;
import java.util.TimerTask;


public class TimeLevel extends Level {
	
	private int timeLeft;
	private Timer timer;
	private static TimeLevel instance;
	
	private TimeLevel(int levelNumber){
		updateTime(90 - 3*levelNumber);
		this.levelNumber = levelNumber;
		timer = new Timer ();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				updateTime(timeLeft-1);
			}

		}, 1000, 1000);
	}
	
	public int getTime(){
		return timeLeft;
	}
	public void updateTime(int newTime){
		timeLeft = newTime;
		EventDispatchQueue.getInstance().addEvent(new TimeUpdateEvent(TimeLevel.getInstance().getTime()));
	}
	public static TimeLevel getInstance(){
		if(instance == null)
			instance = new TimeLevel(Options.currentLevel);
		return (TimeLevel) instance;
	}
	public void pauseTimer() throws InterruptedException{
		timer.wait();
	}
	public void startTimer(){
		timer.notify();
	}
	public void stopTimer(){
		timer.cancel();
	}
}
