
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
	 * @requires:
	 * R.1) "this" is an instance of Lokum.
	 * R.2) "this" is NOT an instance of BombLokum.
	 * 
	 * For a given lokum, this method checks the LogicField above this lokum. Then for current lokum,
	 * two options are possible:
	 * 
	 * b.1) There does not exists any lokum above the current lokum. In this case, method immediately
	 * returns false.
	 * b.2) If #1 is not the case, then above field exists. Then it may not be a lokum. If that is the
	 * case, false is returned.
	 * b.3) If #2 is not the case, then above field is a lokum. If the above field is a lokum, then it
	 * must not be an instance of the BombLokum. If that is not the case, false is returned.
	 * b.4) If #3 is not the case, then, the above field is a lokum and is not a BombLokum, then it's
	 * color must be the same with the color of the current lokum. If that's not the case, false is
	 * returned.
	 * 
	 * Otherwise, true is returned.
	 * 
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
