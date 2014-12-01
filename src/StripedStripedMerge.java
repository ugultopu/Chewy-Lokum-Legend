
public class StripedStripedMerge extends Merge {
	private Lokum l1;
	private Lokum l2;
	private BoardLogic board;
	
	public StripedStripedMerge(Lokum l1, Lokum l2){
		this.l1 = l1;
		this.l2 = l2;
		board = BoardLogic.getInstance();
	}
	
	public void destroyMerge(){
		l1.destroyCombo();
		l1.destroyCombo();
	}
}
