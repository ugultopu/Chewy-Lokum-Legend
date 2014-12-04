package App;

public class NewBoardEvent extends GameEvent {

	LogicField[][] newBoard;
	
	public NewBoardEvent(LogicField[][] newBoard){
		this.newBoard = newBoard;
		
	}
	@Override
	public void executeEvent() {
		for(int i=0; i<newBoard.length;i++){
			for(int j = 0; j<newBoard[i].length;j++){
				GameBoard.getInstance().changeLokum(newBoard[i][j]);
			}
		}

	}

}
