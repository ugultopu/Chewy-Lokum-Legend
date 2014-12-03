

public class Run {

	public static void main(String[] args) {
		NormalLokum nl = new NormalLokum(0,0,"red");
		
		System.out.println(nl.toString());
		NormalLokum testNormal = new NormalLokum(1, 2, "red");
		BombLokum testBomb = new BombLokum(2, 5, null);
		WrappedLokum testWrapped = new WrappedLokum(4, 5, "brown");
		VerticalStripedLokum testVStriped = new VerticalStripedLokum(2, 3, "white");
		HorizontalStripedLokum testHStriped = new HorizontalStripedLokum(1, 3, "white");
		
		
		
		System.out.println(Factory.createRandomLokum(3, 4).toString());
		System.out.println(BoardLogic.getInstance().toString());
		testVStriped.comboDestroy();
		System.out.println(BoardLogic.getInstance().toString());
	}

}
