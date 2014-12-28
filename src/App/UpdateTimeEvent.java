package App;

public class UpdateTimeEvent extends GameEvent {
	
	private int newTime;
	
	public UpdateTimeEvent(int newTime){
		this.newTime = newTime;
	}

	@Override
	public void executeEvent() {
		TimeLevelPanel.getInstance().setTime(newTime);
	}

}
