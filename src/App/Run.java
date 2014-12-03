package App;

import Tests.BoardLogicTest;
import Tests.LokumTest;
import Tests.MergeTest;
import Tests.NormalLokumTest;
import Tests.StripedLokumTest;


public class Run {

	public static void main(String[] args) {
		
		ApplicationWindow frame = ApplicationWindow.getInstance();
		frame.pack();
		frame.setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
		
		NormalLokum nl = new NormalLokum(0,0,"red");
		
		System.out.println(LokumTest.toString(nl));
		NormalLokum testNormal = new NormalLokum(1, 2, "red");
		BombLokum testBomb = new BombLokum(10, 15, null);
		WrappedLokum testWrapped = new WrappedLokum(10, 5, "brown");
		VerticalStripedLokum testVStriped = new VerticalStripedLokum(1, 3, "white");
		HorizontalStripedLokum testHStriped = new HorizontalStripedLokum(1, 1, "white");
		
		
		//MergeTest.mergeTest(Factory.createMerge(testBomb, testNormal)); --> Works
		//BoardLogicTest.shuffleBoardTest(); --> Works
		//MergeTest.mergeTest(Factory.createMerge(testWrapped, testVStriped)); --> Works
		//MergeTest.mergeTest(Factory.createMerge(testBomb, testWrapped)); --> !!Problem!!
		//MergeTest.mergeTest(Factory.createMerge(testWrapped, testWrapped)); --> Works Good But Merge is wrong
		//MergeTest.mergeTest(Factory.createMerge(testBomb, testBomb)); --> Works
		//MergeTest.mergeTest(Factory.createMerge(testHStriped, testBomb));//--> Works
		//Combo test classes are in the Combo classes. It will only useful when tested in swap.
		
	}

}
