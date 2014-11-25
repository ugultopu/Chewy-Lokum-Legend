import java.util.Objects;


public class NonLokumGeneratingEvent extends GameEvent {

	ArrayList<EmptyLogicField> destroyedLokums;
	
	public NonLokumGeneratingEvent(ArrayList<EmptyLogicField> destroyedLokums){
		this.destroyedLokums = destroyedLokums;
	}
	
	
	@Override
	public void executeEvent() {
		for(EmptyLogicField lokum: destroyedLokums){
			GameBoardPanel.changeLokum(lokum);
		}
		GameBoardPanel.getInstance().repaint();
	}
}
