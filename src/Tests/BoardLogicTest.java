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
					String color = lok.getLokumColor();
					String type = lok.getType();
					boardString += type + "|" + color + " ";
				}else{
					boardString += "empty ";
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
}