
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
		BoardLogic.getInstance().introduceLogicField(this);
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
	
}
