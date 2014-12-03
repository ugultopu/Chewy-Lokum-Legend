

public class StripedWrappedMerge extends Merge {
	private Lokum l1;
	private Lokum l2;
	private BoardLogic board;
	
	public StripedWrappedMerge(MergeDestroyable l1, MergeDestroyable l2){
		this.l1 = (Lokum) l1;
		this.l2 = (Lokum) l2;
		board = BoardLogic.getInstance();
	}
	
	public void destroyMerge(){
		int xl1 = l1.getRowIndex();
		int yl1 = l1.getColumnIndex();
		String color = l1.getLokumColor();
		//IMPORTANT: CHECK THE BOUNDS OF BOARD.
		for(int i = -1; i < 2; i++){
			int y = yl1 + i;
			VerticalStripedLokum lokumDestroyer = new VerticalStripedLokum(xl1, y, color);	
			lokumDestroyer.comboDestroy();
		}
		
		for(int i = -1; i < 2; i++){
			int x = xl1 + i;
			HorizontalStripedLokum lokumDestroyer = new HorizontalStripedLokum(x, yl1, color);
			lokumDestroyer.comboDestroy();
		}
	}
}
