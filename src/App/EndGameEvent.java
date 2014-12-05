package App;

public class EndGameEvent extends GameEvent {

	@Override
	public void executeEvent() {
		InformationBoard.getInstance().finishGame();
	}

}
