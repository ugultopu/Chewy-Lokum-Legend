package App;


public class StripedStripedMerge extends Merge {
	private Lokum l1;
	private Lokum l2;
	private BoardLogic board;
	
	public StripedStripedMerge(MergeDestroyable l1, MergeDestroyable l2){
		this.l1 = (Lokum)l1;
		this.l2 = (Lokum)l2;
		board = BoardLogic.getInstance();
	}
	
	public void destroyMerge(){
		int x2 = l2.getRowIndex();
		int y2 = l2.getColumnIndex();
		int x = l1.getRowIndex();
		int y = l1.getColumnIndex();
		LogicField removeComboLokum = new EmptyLogicField(x, y);
		board.introduceLogicField(removeComboLokum);
		VerticalStripedLokum verticalDestroyer = new VerticalStripedLokum(x2, y2, "red");
		HorizontalStripedLokum horizontalDestroyer = new HorizontalStripedLokum(x2, y2, "red");
		verticalDestroyer.comboDestroy();
		horizontalDestroyer.comboDestroy();
	}
}
