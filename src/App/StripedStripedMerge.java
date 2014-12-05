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
		int x = l2.getRowIndex();
		int y = l2.getColumnIndex();
		VerticalStripedLokum verticalDestroyer = new VerticalStripedLokum(x, y, "red");
		HorizontalStripedLokum horizontalDestroyer = new HorizontalStripedLokum(x, y, "red");
		verticalDestroyer.comboDestroy();
		horizontalDestroyer.comboDestroy();
	}
}
