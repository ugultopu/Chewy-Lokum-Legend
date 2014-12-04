package App;

import java.util.ArrayList;


public class LokumGenerateEvent extends GameEvent{

	Lokum generatedLokum;
	
	public LokumGenerateEvent(Lokum generatedLokum){
		this.generatedLokum = generatedLokum;
	}
	
	
	@Override
	public void executeEvent(){
		GameBoardPanel.changeLokum(generatedLokum);
		GameBoardPanel.getInstance().repaint();
		
	}
}
