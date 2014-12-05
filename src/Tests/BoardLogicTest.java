package Tests;
import App.*;

import java.util.ArrayList;

public class BoardLogicTest{
	
	public static String toString(BoardLogic BL){
		String boardString = "";
		LogicField[][] logicFields = BL.getLogicFields();

		for(int i = 0; i < BL.getRowSize(); i++){
			for(int j = 0; j < BL.getColumnSize(); j++){
				if(!(logicFields[i][j] instanceof EmptyLogicField)){
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
		System.out.println("Before swap: ");
		System.out.println(toString(BL));
		System.out.println("After swap: ");
		BL.swap(lokum1, lokum2);
		System.out.println(toString(BL));
	}
	
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
}