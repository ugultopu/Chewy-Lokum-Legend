package App;

import java.util.ArrayList;


public class VerticalStripedLokum extends StripedLokum {

	public VerticalStripedLokum(int rowIndex, int columnIndex, String lokumColor) {
		super(rowIndex, columnIndex, lokumColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comboDestroy() {
		// TODO Auto-generated method stub
		BoardLogic boardLogic = BoardLogic.getInstance();
		
		/*
		 * Set the striped lokum's position to empty.
		 */
		boardLogic.introduceLogicField(new EmptyLogicField(getRowIndex(), getColumnIndex()));
		
		int lokumsDestroyed = 0;
		int currentRowIndex;

		for( currentRowIndex = 0; currentRowIndex<boardLogic.getRowSize(); currentRowIndex++ ){
			LogicField currentLogicField = boardLogic.getLogicFieldAt( currentRowIndex , getColumnIndex() ); 
			if( currentLogicField instanceof ComboDestroyable ){
				((ComboDestroyable) currentLogicField).comboDestroy();
				
			}
			// if here, then currentLogicField is not combo destroyable. So simply clear it's position.
			else{
				EmptyLogicField destroyed = new EmptyLogicField( currentRowIndex, getColumnIndex());
				boardLogic.introduceLogicField(destroyed);
				lokumsDestroyed++;
				/*
				 * CHECK THE LINE BELOW!!!
				 */
				EventDispatchQueue.getInstance().addEvent(new DestroyLokumEvent(destroyed.copyLogicField()));
				
			}
		}
		Score.getInstance().scoreUpdateStripedUse(lokumsDestroyed);
	}

	@Override
	public LogicField copyLogicField() {
		// TODO Auto-generated method stub
		return new VerticalStripedLokum(getRowIndex(), getColumnIndex(), getLokumColor());
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "VerticalStripedLokum";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if( !(super.equals(obj)) )
			return false;
		if( !(obj instanceof VerticalStripedLokum) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "VSL@" + super.toString();
	}
	
//	@Override
//	public void comboDestroy() {
//		// TODO Auto-generated method stub
//		BoardLogic boardLogic = BoardLogic.getInstance();
//
//		/*
//		 * Set the striped lokum's position to empty.
//		 */
//		boardLogic.introduceLogicField(new EmptyLogicField(getRowIndex(), getColumnIndex()));
//		int currentRowIndex;
//
//		for( currentRowIndex = 0; currentRowIndex<boardLogic.getRowSize(); currentRowIndex++ ){
//			LogicField currentLogicField = boardLogic.getLogicFieldAt( currentRowIndex , getColumnIndex() ); 
//			if( currentLogicField instanceof ComboDestroyable )
//				((ComboDestroyable) currentLogicField).comboDestroy();
//			// if here, then currentLogicField is not combo destroyable. So simply clear it's position.
//			boardLogic.introduceLogicField(new EmptyLogicField( currentRowIndex, getColumnIndex() ));
//		}
//	}

}