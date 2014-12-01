import java.util.HashMap;


public class FallingLokumsEvent extends GameEvent {
	
	HashMap<Lokum,Integer> fallingLokums;
	
	public FallingLokumsEvent(HashMap<Lokum,Integer> fallingLokums){
		
		this.fallingLokums = fallingLokums;
		
	}
	
	@Override
	public void executeEvent() {
		while(fallingLokums.keySet().size()>0){
			for(Lokum lokum: fallingLokums.keySet()){
				int lokumShift = fallingLokums.get(lokum);
				if(lokumShift>0){
					lokum.setRowIndex(lokum.getRowIndex()-1);
					fallingLokums.put(lokum, (Integer)lokumShift-1);
					if(lokum.getColumnIndex()>=0){
						GameBoardPanel.changeLokum(lokum);
					}
				}else
					fallingLokums.remove(lokum);
			}
			GameBoardPanel.getInstance().repaint();
			Thread.sleep(1000);
		}
	}
}
