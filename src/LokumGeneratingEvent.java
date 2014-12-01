import java.util.ArrayList;


public class LokumGeneratingEvent extends GameEvent{

	ArrayList<EmptyLogicField> destroyedLokums;
	ArrayList<Lokum> generatedLokums;
	
	public LokumGeneratingEvent(ArrayList<EmptyLogicField> destroyedLokums, ArrayList<Lokum> generatedLokums){
		this.destroyedLokums = destroyedLokums;
		this.generatedLokums = generatedLokums;
	}
	
	@Override
	public void executeEvent(){
		for(EmptyLogicField lokum: destroyedLokums){
			GameBoardPanel.changeLokum(lokum);
		}
		for(Lokum lokum: generatedLokums){
			GameBoardPanel.changeLokum(lokum);
		}
		
		GameBoardPanel.getInstance().repaint();
		
	}
}
