package App;

import java.util.ArrayList;


public class NormalLokum extends Lokum implements ComboDestroyable, MergeDestroyable{
	
	public NormalLokum(int rowIndex, int columnIndex, String lokumColor) {
		super(rowIndex, columnIndex, lokumColor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comboDestroy() {
		/*
		 * To Do:
		 * -Check privacy scope.
		 */
		// TODO Auto-generated method stub
		EmptyLogicField destroyed = new EmptyLogicField(getRowIndex(), getColumnIndex());
		BoardLogic.getInstance().introduceLogicField(destroyed);
		EventDispatchQueue.getInstance().addEvent(new DestroyLokumEvent(destroyed.copyLogicField()));
	
	}

	@Override
	public LogicField copyLogicField() {
		// TODO Auto-generated method stub
		return new NormalLokum(getRowIndex(), getColumnIndex(), getLokumColor());
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "NormalLokum";
	}
	
	public String toString(){
		return "Normal Lokum at (" + getRowIndex() + ", " + getColumnIndex() + ") with color: " + getLokumColor();
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
