package App;

import java.util.ArrayList;


public class WrappedWrappedMerge extends Merge {
	private Lokum l1;
	private Lokum l2;
	private BoardLogic board;
	private Score score = Score.getInstance();
	
	public WrappedWrappedMerge(MergeDestroyable l1, MergeDestroyable l2){
		this.l1 = (Lokum)l1;
		this.l2 = (Lokum)l2;
		board = BoardLogic.getInstance();
	}
	
	public void destroyMerge(){
		NormalLokum destroyer1 = new NormalLokum(l1.getRowIndex(), l1.getColumnIndex(), l1.getLokumColor());
		NormalLokum destroyer2 = new NormalLokum(l2.getRowIndex(), l2.getColumnIndex(), l2.getLokumColor());
		destroyer1.comboDestroy();
		destroyer2.comboDestroy();
		score.scoreUpdateWrappedWrappedMerge();
	}
}
