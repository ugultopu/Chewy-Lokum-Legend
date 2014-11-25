import java.util.HashMap;


public class FallingLokumEvent extends GameEvent {
	
	HashMap<Lokum,Integer> fallingLokums;
	
	public FallingLokumEvent(HashMap<Lokum,Integer> fallingLokums){
		
		this.fallingLokums = fallingLokums;
		
	}
	
	@Override
	public void executeEvent() {
		while(fallingLokums.getKeySet().size()>0){
			for(Lokum lokum: fallingLokums.getKeySet()){
				int lokumShift = fallingLokums.get(lokum);
				if(lokumShift>0){
					lokum.setY(lokum.getY()+1);
					fallingLokums.set(lokum, lokumShift-1);
					if(lokum.getLocation().getY()>=0){
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
