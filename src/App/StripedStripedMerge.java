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
		((StripedLokum)l1).comboDestroy();
		((StripedLokum)l2).comboDestroy();
	}
}
