
public class Run {

	public static void main(String[] args) {
		
		ApplicationWindow frame = ApplicationWindow.getInstance();
		frame.pack();
		frame.setSize(Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
		
		NormalLokum nl = new NormalLokum(0,0,"red");
		
		System.out.println(nl.toString());
		NormalLokum testNormal = new NormalLokum(1, 2, "red");
		BombLokum testBomb = new BombLokum(2, 5, null);
		WrappedLokum testWrapped = new WrappedLokum(4, 5, "brown");
		VerticalStripedLokum testVStriped = new VerticalStripedLokum(2, 3, "white");
		HorizontalStripedLokum testHStriped = new HorizontalStripedLokum(1, 3, "white");
		
		Merge testMergeNormalBomb = Factory.createMerge(testNormal, testBomb);
		Merge testMergeWrappedBomb = Factory.createMerge(testWrapped, testBomb);
		Merge testMergeVStripedBomb = Factory.createMerge(testVStriped, testBomb);
		Merge testMergeHStripedBomb = Factory.createMerge(testHStriped, testBomb);
		Merge testMergeWrappedStriped = Factory.createMerge(testVStriped, testWrapped);
		
		System.out.println(Factory.createRandomLokum(3, 4).toString());
		System.out.println(BoardLogic.getInstance().getBoard());
		System.out.println(BoardLogic.getInstance().toString());
	}

}
