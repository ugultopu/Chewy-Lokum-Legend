import java.util.ArrayList;


public class HorizontalStripedLokum extends StripedLokum {

	public HorizontalStripedLokum(int rowIndex, int columnIndex,
			String lokumColor) {
		super(rowIndex, columnIndex, lokumColor);
		// TODO Auto-generated constructor stub
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

		int currentColumnIndex;

		for( currentColumnIndex = 0; currentColumnIndex<boardLogic.getColumnSize(); currentColumnIndex++ ){
			LogicField currentLogicField = boardLogic.getLogicFieldAt( getRowIndex() , currentColumnIndex ); 
			if( currentLogicField instanceof ComboDestroyable )
				((ComboDestroyable) currentLogicField).comboDestroy(comboDestroyedFields);
			// if here, then currentLogicField is not combo destroyable. So simply clear it's position.
			else{
				boardLogic.introduceLogicField(new EmptyLogicField( getRowIndex() , currentColumnIndex ));
				/*
				 * CHECK THE LINE BELOW!!!
				 */
				comboDestroyedFields.add((ComboDestroyable) boardLogic.getLogicFieldAt( getRowIndex(), currentColumnIndex ));
			}
		}
	}

	@Override
	public LogicField copyLogicField() {
		// TODO Auto-generated method stub
		return new HorizontalStripedLokum(getRowIndex(), getColumnIndex(), getLokumColor());
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "HorizontalStripedLokum";
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
//		int currentColumnIndex;
//
//		for( currentColumnIndex = 0; currentColumnIndex<boardLogic.getColumnSize(); currentColumnIndex++ ){
//			LogicField currentLogicField = boardLogic.getLogicFieldAt( getRowIndex() , currentColumnIndex ); 
//			if( currentLogicField instanceof ComboDestroyable )
//				((ComboDestroyable) currentLogicField).comboDestroy();
//			// if here, then currentLogicField is not combo destroyable. So simply clear it's position.
//			boardLogic.introduceLogicField(new EmptyLogicField( getRowIndex() , currentColumnIndex ));
//		}
//	}
}