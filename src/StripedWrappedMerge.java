
public class StripedWrappedMerge extends Merge {
	private Lokum l1;
	private Lokum l2;
	private BoardLogic board;
	
	public StripedWrappedMerge(Lokum l1, Lokum l2){
		this.l1 = l1;
		this.l2 = l2;
		board = BoardLogic.getInstance();
	}
	
	public void destroyMerge(){
		int xl1 = l1.getX();
		int yl1 = l1.getY();
		//IMPORTANT: CHECK THE BOUNDS OF BOARD.
		for(int i = -1; i < 2; i++){
			int y = yl1 + i;
			VerticalStripedLokum lokumDestroyer = new VerticalStripedLokum();	
			lokumDestroyer.comboDestroy();
		}
		
		for(int i = -1; i < 2; i++){
			int x = xl1 + i;
			HorizontalStripedLokum lokumDestroyer = new HorizontalStripedLokum();
			lokumDestroyer.comboDestroy();
		}
	}
}
