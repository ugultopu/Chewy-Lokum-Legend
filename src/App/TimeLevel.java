package App;

import java.util.Timer;
import java.util.TimerTask;


public class TimeLevel extends Level {
	
	private int timeLeft;
	private Timer timer;

	
	public TimeLevel(int levelNumber){
		updateTime(90 - 3*levelNumber);
		this.levelNumber = levelNumber;
		timer = new Timer ();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				updateTime(timeLeft-1);
				if(timeLeft == 0){
					EventDispatchQueue.getInstance().addEvent(new LoseGameEvent());
					stopTimer();
				}
			}

		}, 1000, 1000);
	}
	
	public int getTime(){
		return timeLeft;
	}
	public void updateTime(int newTime){
		timeLeft = newTime;
		EventDispatchQueue.getInstance().addEvent(new TimeUpdateEvent(newTime));
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
