package App;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	private LokumBox[][] boardArray;
	private int width = Constants.ANIMATION_WINDOW_WIDTH;
	private int height = Constants.ANIMATION_WINDOW_HEIGHT;
	private static GameBoard instance;
	
	private GameBoard(){
		boardArray = new LokumBox[height][width];
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				boardArray[i][j] = new LokumBox(new EmptyLogicField(i,j));
			}
		}
		requestFocusInWindow();
		addMouseListener(ClickListener.getInstance());
	}
	
	public static GameBoard getInstance(){
		if(instance == null){
			instance = new GameBoard();
		}
		return instance;
	}
	
	public static void resetInstance(LogicField[][] logicFieldArray){
		instance = new GameBoard();
	}
	
	public void changeLokum(LogicField logicField){
		boardArray[logicField.getRowIndex()][logicField.getColumnIndex()].changeLogicField(logicField);
	}
	
}
