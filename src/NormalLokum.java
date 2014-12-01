import java.util.ArrayList;


public class NormalLokum extends Lokum implements ComboDestroyable{
	
	public NormalLokum(int rowIndex, int columnIndex, String lokumColor) {
		super(rowIndex, columnIndex, lokumColor);
		// TODO Auto-generated constructor stub
		BoardLogic.getInstance().introduceLogicField(this);
	}

	@Override
	public void comboDestroy(ArrayList<ComboDestroyable> comboDestroyedFields) {
		/*
		 * To Do:
		 * -Check privacy scope.
		 */
		// TODO Auto-generated method stub
		BoardLogic.getInstance().introduceLogicField(new EmptyLogicField(getRowIndex(), getColumnIndex()));
		comboDestroyedFields.add(this);
	}

	@Override
	public LogicField copyLogicField() {
		// TODO Auto-generated method stub
		return new NormalLokum(getRowIndex(), getColumnIndex(), getLokumColor());
	}
	
//	/**
//	 * @requires
//	 * 
//	 * <nothing>
//	 * 
//	 * @ensures
//	 * 
//	 * <nothing> (is this correct?)
//	 * 
//	 * @modifies
//	 * 
//	 * <nothing>
//	 */
//	public boolean repOK(){
//		/*
//		 * To Do:
//		 * -Check privacy scope.
//		 * -Check return type.
//		 * -Check repOK()'s javadoc and implementation. 
//		 *  
//		 */
//		return super.repOK();
//	}
//	
//	/**
//	 * This method is the destroy method for the NormalLokum. This method really just sets the
//	 * location of this lokum to emptyLogicField in BoardLogic. (and maybe removes this NormalLokum
//	 * instance)
//	 * 
//	 * @requires
//	 * 
//	 * <nothing>
//	 * 
//	 * @ensures
//	 * 
//	 * E.1) Location specified by location:Lokum will be set to an (the) 
//	 * emptyLogicField at lokums:BoardLogic.
//	 * 
//	 * @modifies
//	 * 
//	 * M.1) lokums:BoardLogic.
//	 * M.2) (optional?) this instance of NormalLokum is removed.
//	 */

}
