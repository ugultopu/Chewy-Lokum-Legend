package Tests;
import App.*;

import java.util.ArrayList;

public class BoardLogicTest{
	
	public static String toString(BoardLogic BL){
		String boardString = "";
		LogicField[][] logicFields = BL.getLogicFields();

		for(int i = 0; i < BL.getRowSize(); i++){
			for(int j = 0; j < BL.getColumnSize(); j++){
				if(logicFields[i][j] instanceof Obstacle){
					Obstacle obs = (Obstacle) logicFields[i][j];
					String color = Character.toString(obs.getObstacleColor().charAt(0));
					boardString += "O"+ color + "|";
				}else if(!(logicFields[i][j] instanceof EmptyLogicField)){
					Lokum lok = (Lokum)logicFields[i][j];
					String color = Character.toString(lok.getLokumColor().charAt(0));
					String type = Character.toString(lok.getType().charAt(0));
					boardString += type + color + "|";
				}else{
					boardString += "EE";
				}
			}
			boardString += "\n";
		}
		return boardString;
	}
	
	public static void shuffleBoardTest(){
		BoardLogic BL = BoardLogic.getInstance();
		System.out.println("Before shuffle: ");
		System.out.println(toString(BL));
		System.out.println("After shuffle: ");
		BL.shuffleBoard();
		System.out.println(toString(BL));
		
	}
	
	public static void fallLokumsTest(){
		BoardLogic BL = BoardLogic.getInstance();
		System.out.println("Before fall: ");
		System.out.println(toString(BL));
		System.out.println("After fall: ");
		BL.readjustBoardAfterDestroy();
		System.out.println(toString(BL));
	}
	
	public static void testForStability(){
		BoardLogic BL = BoardLogic.getInstance();
		if(BL.isBoardStabilized()){
			System.out.println("Board is stable");
		}else{
			System.out.println("Board is not stable");
		}
	}
	
	public static void swapTest(LogicField lokum1, LogicField lokum2){
		BoardLogic BL = BoardLogic.getInstance();
		int currentScore = Score.getInstance().getCurrentScore();
		System.out.println("Board Before swap: ");
		System.out.println("Score Before Swap: " + currentScore);
		System.out.println(toString(BL));
		int x1 = lokum1.getRowIndex();
		int y1 = lokum1.getColumnIndex();
		int x2 = lokum2.getRowIndex();
		int y2 = lokum2.getColumnIndex();
		System.out.println("Swapping: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")");
		BL.swap(lokum1, lokum2);
		currentScore = Score.getInstance().getCurrentScore();
		System.out.println("Score after swap: " + currentScore);
		System.out.println("Board After swap: ");
		System.out.println(toString(BL));
	}
	
	/* This test is deprecated it needs to be modified
	public static void findBoardCombosTest(){
		BoardLogic BL = BoardLogic.getInstance();
		System.out.println("Before Combo:");
		System.out.println(toString(BL));
		ArrayList<Combo> boardCombos = BoardLogic.getInstance().findBoardCombos();
		if(boardCombos.size() == 0){
			System.out.println("No combos.");
		}
		else{
			for(int currentComboIndex=0;currentComboIndex<boardCombos.size();currentComboIndex++){
				// System.out.println(boardCombos.get(i).toString());
				Combo currentCombo = boardCombos.get(currentComboIndex);
				ArrayList<Lokum> currentCombosLokums = currentCombo.getComboLokums();
				for(int currentCombosLokumIndex=0;currentCombosLokumIndex<currentCombosLokums.size();currentCombosLokumIndex++){
					Lokum currentLokum = currentCombosLokums.get(currentCombosLokumIndex);
					((ComboDestroyable) currentLokum).comboDestroy();
				}
			}
		}
		
		System.out.println("After Combo:");
		System.out.println(toString(BL));
	}
	*/
}