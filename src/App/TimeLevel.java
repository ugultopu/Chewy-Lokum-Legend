package App;

import java.util.Timer;
import java.util.TimerTask;


public class TimeLevel extends Level {
	
	private int timeLeft;
	private Timer timer;
	private TimerTask timerTask;

	
	public TimeLevel(){
		this.levelNumber = Options.currentLevel;
		updateTime(90 - 3*levelNumber);
		System.out.println("started!");
		timer = new Timer ();
		timerTask = new TimerTask(){

			@Override
			public void run() {
				updateTime(timeLeft-1);
				System.out.println(timeLeft);
				if(timeLeft == 0){
					EventDispatchQueue.getInstance().addEvent(new LoseGameEvent());
					stopTimer();
					resetInstance();
				}
			}

		};
		timer.schedule(timerTask, 1000, 1000);
	}
	
	public int getTime(){
		return timeLeft;
	}
	public void updateTime(int newTime){
		timeLeft = newTime;
		EventDispatchQueue.getInstance().addEvent(new TimeUpdateEvent(newTime));
	}
	
	public void pauseTimer() throws InterruptedException{
		timer.cancel();
	}
	public void startTimer(){
		timer.schedule(timerTask,1000,1000);
	}
	public void stopTimer(){
		timer.cancel();
	}
}
