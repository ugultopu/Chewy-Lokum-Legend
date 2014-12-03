package App;

import java.util.ArrayList;
import java.util.Objects;


public class DestroyLokumEvent extends GameEvent {

	EmptyLogicField destroyedLokum;
	
	public DestroyLokumEvent(EmptyLogicField destroyedLokum){
		this.destroyedLokum = destroyedLokum;
	}
	
	@Override
	public void executeEvent() {
		GameBoardPanel.changeLokum(destroyedLokum);
		GameBoardPanel.getInstance().repaint();
	}
}
