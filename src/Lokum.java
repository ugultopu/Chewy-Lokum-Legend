
public abstract class Lokum extends LogicField{

	private String lokumColor;

	/**
	 * Whenever a lokum is instantiated, the location in BoardLogic corresponding to Lokum's location is set to this instance.
	 * @param lokumColor
	 * @param logicFieldXPosition
	 * @param logicFieldYPosition
	 */
	public Lokum(int rowIndex, int columnIndex, String lokumColor){
		super(rowIndex, columnIndex);
		this.lokumColor = lokumColor;
		BoardLogic.getInstance().introduceLogicField(this);
	}

	public String getLokumColor() {
		return lokumColor;
	}

	public void setLokumColor(String lokumColor) {
		this.lokumColor = lokumColor;
	}
	/**
	 * For a given lokum, this method checks the LogicField above this lokum. Then for current lokum,
	 * two options are possible:
	 * 1) Current lokum is an instance of BombLokum. In this case, current lokum's color is irrelevant.
	 * For that, the method has a parameter to indicate the color of the currently being checked combo.
	 * 1) If this lokum is at the border of the board, the above field does not exist. In this case,
	 * false is returned.
	 * 2) If #1 is not the case, then above field exists. Then it may not be a lokum. If that is the
	 * case, false is returned.
	 * 3) If the above field is a lokum, then it's color needs to be checked. One exception is if the
	 * lokum above is a bomb lokum, then it's color is irrelevant and hence, it is in the combo.
	 * 3.1) Regarding #3, also, if the current lokum is a BombLokum, then the color of the lokum above
	 * has no significance as well. NO IT DOES!!! 
	 * @return
	 */
	public boolean isAboveLogicFieldInTheCombo(String colorOfThePreviousLokum){
		int thisLokumsRowIndex = getRowIndex();
		int aboveLokumsRowIndex = thisLokumsRowIndex + 1;
		if(aboveLokumsRowIndex == BoardLogic.getInstance().rowSize)
			return false;
		
	}
	
	
//	/**
//	 * @requires
//	 * 
//	 * <nothing>
//	 * 
//	 * @ensures
//	 * 
//	 * E.1) (implicit? because we actually need to call repOK() of this field.) color != null.
//	 * E.2) (implicit? because we actually need to call repOK() of this field.) location != null.
//	 * E.3) color.repOK() == true.
//	 * E.4) location.repOK() == true.
//	 * E.5) color's value is indeed a valid color.
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
//		 * -Change type of lokumColor to enum. (or do a similar solution, but you got the idea.)
//		 */
//		if(lokumColor == null)
//			return false;
//		if(!lokumColor.repOK())
//			return false;
//		if(location == null)
//			return false;
//		if(!location.repOK())
//			return false;
//		/*
//		 * Following if statement may be changed if we change the way the lokumColor of a Lokum is represented.
//		 */
//		if(!islokumColorValid(lokumColor))
//			return false;
//		return true;
//	}
//	
//	/**
//	 * @requires
//	 * 
//	 * <nothing>
//	 * 
//	 * @ensures
//	 * 
//	 * E.1) An accurate string representation of this instance of Lokum is returned.
//	 * 
//	 * @modifies
//	 * 
//	 * <nothing>
//	 */
//	public String toString(){
//		/*
//		 * To Do:
//		 * -Check privacy scope.
//		 * -Check return type.
//		 * -Check @requires, @ensures and @modifies.
//		 */
//		return lokumColor.toString() + " at " + getRowIndex() + ", " + getColumnIndex() + ".";
//	}
		
}
