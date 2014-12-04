package Tests;
import App.*;

public class MergeTest {
	private static BoardLogic mergeTestBoard = BoardLogic.getInstance();
	public static void mergeTest(Merge testMerge){
		System.out.println("Board before combo destroy: \n");
		System.out.println("Score before combo destroy: " + Score.getInstance().getCurrentScore());
		System.out.println(BoardLogicTest.toString(mergeTestBoard));
		testMerge.destroyMerge();
//		Check if destroyed lokums are replaced with emptyLogicField
//		Check if the Board is changed
		System.out.println("Board after combo destroy: \n");
		System.out.println("Score before after destroy: " + Score.getInstance().getCurrentScore());
		System.out.println(BoardLogicTest.toString(mergeTestBoard));	
	}
}
