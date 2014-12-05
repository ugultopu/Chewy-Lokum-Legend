package App;

import java.util.HashMap;



public class FallingLokumsEvent extends GameEvent {
	
	HashMap<LogicField,Integer> fallingLokums;
	
	public FallingLokumsEvent(HashMap<LogicField, Integer> fallingLogicFields){
		
		this.fallingLokums = fallingLogicFields;
		
	}
	
	@Override
	public void executeEvent() {
		while(fallingLokums.keySet().size()>0){
			for(LogicField lokum: fallingLokums.keySet()){
				int lokumShift = fallingLokums.get(lokum);
				if(lokumShift>0){
					lokum.setRowIndex(lokum.getRowIndex()-1);
					fallingLokums.put(lokum, (Integer)lokumShift-1);
					if(lokum.getRowIndex()<Constants.BOARD_HEIGHT){
						GameBoard.getInstance().changeLokum(lokum);
					}
				}else
					fallingLokums.remove(lokum);
			}
			GameBoard.getInstance().repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception on event waiting.");
			}
		}
	}
}
