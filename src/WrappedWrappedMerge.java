
public class WrappedWrappedMerge extends Merge {
	private Lokum l1;
	private Lokum l2;
	private BoardLogic board;
	
	public WrappedWrappedMerge(MergeDestroyable l1, MergeDestroyable l2){
		this.l1 = (Lokum)l1;
		this.l2 = (Lokum)l2;
		board = BoardLogic.getInstance();
	}
	
	public void destroyMerge(){
		l1.destroy();
		l2.destroy();
	}

}
