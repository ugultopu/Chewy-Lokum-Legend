package Tests;

import App.*;


public class NormalLokumTest{

	public static BoardLogic comboDestroyBoard = BoardLogic.getInstance();

	public static void comboDestroyTest(NormalLokum comboLokum){
		System.out.println("Board before combo destroy: \n");
		System.out.println(BoardLogicTest.toString(comboDestroyBoard));
		comboLokum.comboDestroy();
//		Check if destroyed lokums are replaced with emptyLogicField
//		Check if the Board is changed
		System.out.println("Board after combo destroy: \n");
		System.out.println(BoardLogicTest.toString(comboDestroyBoard));	
	}
}



