package App;


public abstract class LogicField {
	private int rowIndex;
	private int columnIndex;
	
	/**
	 * Creates a new LogicField object and introduces it to the BoardLogic instance. 
	 * @param logicFieldRowIndex
	 * @param logicFieldColumnIndex
	 */
	public LogicField(int rowIndex, int columnIndex){
		super();
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}
	
	public abstract LogicField copyLogicField();

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
	
	public abstract String getType();

	public static boolean isSwapable(LogicField l1) {
		if(l1 instanceof Swapable){
			return true;
		}
		return false;
	}
	public static boolean isIndicesInBounds(int argRowIndex, int argColumnIndex){
		if( (argRowIndex < 0) || (argRowIndex >= BoardLogic.getInstance().getRowSize()) )
			return false;
		if( (argColumnIndex < 0) || (argColumnIndex >= BoardLogic.getInstance().getColumnSize()) )
			return false;
		return true;
	}
}
