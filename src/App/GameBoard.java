package App;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	private LokumBox[][] boardArray;
	private int width = Constants.ANIMATION_WINDOW_WIDTH;
	private int height = Constants.ANIMATION_WINDOW_HEIGHT;
	private int blockSize = Constants.ANIMATION_WINDOW_WIDTH/9;
	private static GameBoard instance;
	
	private GameBoard(LogicField[][] logicFieldArray){
		
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				boardArray[i][j] = new LokumBox(logicFieldArray[i][j]);
			}
		}
	}
	
	public static GameBoard getInstance(){
		return instance;
	}
	
	public static void resetInstance(LogicField[][] logicFieldArray){
		instance = new GameBoard(logicFieldArray);
	}
	
	public void changeLokum(LogicField logicField){
	}
	
}
