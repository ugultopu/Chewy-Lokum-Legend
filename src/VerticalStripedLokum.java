import java.util.ArrayList;


public class VerticalStripedLokum extends StripedLokum {

	public VerticalStripedLokum(int rowIndex, int columnIndex, String lokumColor) {
		super(rowIndex, columnIndex, lokumColor);
		// TODO Auto-generated constructor stub
		BoardLogic.getInstance().introduceLogicField(this);
	}

	@Override
	public void comboDestroy(ArrayList<ComboDestroyable> comboDestroyedFields) {
		// TODO Auto-generated method stub
		BoardLogic boardLogic = BoardLogic.getInstance();

		/*
		 * Set the striped lokum's position to empty.
		 */
		boardLogic.introduceLogicField(new EmptyLogicField(getRowIndex(), getColumnIndex()));
		comboDestroyedFields.add(this);

		int currentRowIndex;

		for( currentRowIndex = 0; currentRowIndex<boardLogic.getRowSize(); currentRowIndex++ ){
			LogicField currentLogicField = boardLogic.getLogicFieldAt( currentRowIndex , getColumnIndex() ); 
			if( currentLogicField instanceof ComboDestroyable )
				((ComboDestroyable) currentLogicField).comboDestroy(comboDestroyedFields);
			// if here, then currentLogicField is not combo destroyable. So simply clear it's position.
			else{
				boardLogic.introduceLogicField(new EmptyLogicField( currentRowIndex, getColumnIndex() ));
				/*
				 * CHECK THE LINE BELOW!!!
				 */
				comboDestroyedFields.add((ComboDestroyable) boardLogic.getLogicFieldAt( currentRowIndex, getColumnIndex() ));
			}
		}
	}

	@Override
	public LogicField copyLogicField() {
		// TODO Auto-generated method stub
		return new VerticalStripedLokum(getRowIndex(), getColumnIndex(), getLokumColor());
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