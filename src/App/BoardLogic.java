package App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class BoardLogic {
	
	private LogicField[][] logicFields;
	private int rowSize;
	private int columnSize;
	private static BoardLogic instance;
	
	/*
	 * CHECK!
	 */
	public static BoardLogic getInstance(){
		if(instance == null)
			instance = new BoardLogic();
		return instance;
	}
	
	public LogicField[][] getLogicFields() {
		return logicFields;
	}

	public int getRowSize() {
		return rowSize;
	}

	public int getColumnSize() {
		return columnSize;
	}
	
	public Lokum[][] getBoard(){
		Lokum[][] lokumArray = new Lokum[rowSize][columnSize];
		for(int i = 0; i < rowSize; i++){
			for(int j = 0; j < columnSize; j++){
				lokumArray[i][j] = (Lokum)logicFields[i][j];			
			}
		}
		return lokumArray;
	}

	/**
	 * Clears the given location. That is: Sets it to a new EmptyLogicField instance. 
	 * @param x
	 * @param y
	 */
	public void clearLocation(int x, int y){
		logicFields[x][y] = new EmptyLogicField(x, y);
	}
	
	/**
	 * Introduces the given LogicField object to logicFields field of this BoardLogic instance. The given LogicField object holds its location information in itself. This
	 * suggests that the logicFields just obtains the location information from the argument and assigns the argument to the given location.
	 * @param lf
	 */
	public void introduceLogicField(LogicField lf){
		logicFields[lf.getRowIndex()][lf.getColumnIndex()] = lf;
	}
	
	private BoardLogic(){
		this.rowSize = Constants.BOARD_WIDTH;
		this.columnSize= Constants.BOARD_HEIGHT;
		logicFields = new LogicField[Constants.BOARD_WIDTH][Constants.BOARD_HEIGHT];
		initializeBoard();	// initializes the board to all EmptyLogicField objects.
		populateBoard();	// populates the board at the beginning. (or at any time. Decide on this.)
	}
	
	private BoardLogic(int rowSize, int columnSize){
		this.rowSize = rowSize;
		this.columnSize= columnSize;
		logicFields = new LogicField[Constants.BOARD_WIDTH][Constants.BOARD_HEIGHT];
		initializeBoard();	// initializes the board to all EmptyLogicField objects.
		populateBoard();	// populates the board at the beginning. (or at any time. Decide on this.)
		
	}
	
	private void initializeBoard(){
		for(int i=0;i<columnSize;i++)
			initializeColumn(i);
	}
	
	private void initializeColumn(int columnIndex){
		for(int i=0;i<rowSize;i++)
			logicFields[i][columnIndex] = new EmptyLogicField(i, columnIndex);
	}
	
	/*
	 * The two populate methods below are for initial population of the board. But maybe these methods may be integrated into populateAfterDestroy and populateEmptiedColumn
	 * as well. 
	 */
	private void populateBoard(){
		for(int i=0;i<columnSize;i++)
			populateColumn(i);
	}
	
	/**
	 * Checks all elements in a given column and if the element is an instance of EmptyLogicField, populates it with a random lokum. 
	 * @param columnIndex
	 */
	private void populateColumn(int columnIndex){
		for(int i=0;i<rowSize;i++){
			if( logicFields[i][columnIndex] instanceof EmptyLogicField )
				logicFields[i][columnIndex] = (LogicField) Factory.createRandomLokum(i, columnIndex);

		}
	}	
	
	/**
	 * After destroys, levels the LogicFields that have emptyLogicFields underneath. After that, populates the emptied locations with new LogicFields falling from above the
	 * board.
	 * @requires:
	 * R.0) Should be called in the method:swap(LogicField, LogicField), after performing the required lokum destroys.
	 * @return
	 */
	private void readjustBoardAfterDestroy(){
		HashMap<LogicField, Integer> fallingLogicFields = new HashMap<LogicField, Integer>();
		levelBoard(fallingLogicFields);
		populateAfterDestroy(fallingLogicFields);
		GameEvent fallingLokumsEvent = new FallingLokumsEvent(fallingLogicFields);
		// send fallingLogicFields to Kugi.
		/*
		 * If board is not yet stabilized, call the method again.
		 */
		if ( !isBoardStabilized() )
			readjustBoardAfterDestroy();
	}
	
	/**
	 * This method levels the board after destroying various combos around the board.
	 */
	private void levelBoard(HashMap<LogicField, Integer> fallingLogicFields){
		for(int i=0;i<columnSize;i++)
			levelColumn(fallingLogicFields, i);
	}	
	
	private void levelColumn(HashMap<LogicField, Integer> fallingLogicFields, int columnIndex){
		int currentRowIndex=0;
		while(currentRowIndex < rowSize){
			if(logicFields[currentRowIndex][columnIndex] instanceof EmptyLogicField){
				/*
				 * Drop the column and return from the method if there are no more elements to drop. 
				 * Please refer to the definition of dropColumn to understand what the following if
				 * statement means.
				 */
				if( dropColumn(fallingLogicFields, currentRowIndex, columnIndex) )
					return;
			}
			currentRowIndex++;
		}
	}
	
	/**
	 * Position of an empty logicFields element is given to this method. Receiving that, the method
	 * calculates if there are more continuously empty fields that are above the given position and
	 * drops the elements. If the method finds out that all positions above the given element's position
	 * until the top are empty, it returns true. Else, it returns false.  
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public boolean dropColumn(HashMap<LogicField, Integer> fallingLogicFields, int rowIndex, int columnIndex){
		int dropCounter = 0;
		int currentRowIndex = rowIndex;
		while(logicFields[currentRowIndex][columnIndex] instanceof EmptyLogicField){
			dropCounter++;
			currentRowIndex++;
		}
		for(int i=rowIndex;i<rowSize-dropCounter;i++){
			/*
			 * What happens in the 3 lines of code below is:
			 * 0) The current LogicField to be dropped is added to the fallingLogicFields HashMap.
			 * 1) The "LogicField to be dropped"s rowIndex has been set to the rowIndex of it's destination. Note that after the completion of this operation, we have a
			 * LogicField object in the "to be dropped" location which holds an inaccurate location information.
			 * 2) To update this information in the board as well, introduceLogicField has been called with the LogicField that is holding its destination's location
			 * information. After completion of this operation, the board is updated with the new location of "to be dropped" object as well.
			 * 3) Finally, the old location of "to be dropped" object is cleared.   
			 */
			fallingLogicFields.put(getLogicFieldAt(i+dropCounter, columnIndex), dropCounter);
			logicFields[i+dropCounter][columnIndex].setRowIndex(i);
			introduceLogicField(logicFields[i+dropCounter][columnIndex]);
			clearLocation(i + dropCounter, columnIndex);
		}
		return currentRowIndex == (rowSize-1);
	}
	
	private void populateAfterDestroy(HashMap<LogicField, Integer> fallingLogicFields){
		for(int i=0;i<columnSize;i++){
			populateEmptiedColumn(fallingLogicFields, i);
		}
	}	
	
	/**
	 * @requires:
	 * R.0 After lokum destroys, board is stabilized. Hence, a column is like partitioned into two pieces
	 * where lower piece is all occupied and upper piece is all empty.
	 * 
	 * NOTE: Note that the code below populates the emptied locations only with Lokums, Since we wrote: "LokumFactory.create...". Change this if you want to allow different
	 * types of populations as well.
	 */
	private void populateEmptiedColumn(HashMap<LogicField, Integer> fallingLogicFields, int columnIndex){
		int emptyLocationCounter = 0;
		int currentRowIndex = rowSize - 1;
		while(logicFields[currentRowIndex][columnIndex] instanceof EmptyLogicField){
			emptyLocationCounter++;
			currentRowIndex--;
		}
		for(int i=0;i<emptyLocationCounter;i++){
			logicFields[rowSize - emptyLocationCounter + i][columnIndex]
					 = Factory.createRandomLokum(rowSize - emptyLocationCounter + i, columnIndex);
			/*
			 * In the two lines above, the current empty place in the column is populated. We need to send this information to graphics. So in the 3 lines below, we get a
			 * copy of the recently populated LogicField. Then we set its rowIndex to its actual row index (that it out of the bounds of the board right now). We do not need
			 * to make any changes in the column index. After that, we add this calibrated LogicField to fallingLogicFields HashMap.
			 */
			LogicField currentLogicFieldToSendGraphics = getLogicFieldAt(rowSize - emptyLocationCounter + i, columnIndex).copyLogicField();
			currentLogicFieldToSendGraphics.setRowIndex(currentLogicFieldToSendGraphics.getRowIndex() + emptyLocationCounter);
			fallingLogicFields.put(currentLogicFieldToSendGraphics, emptyLocationCounter);
		}
	}
	
	/**
	 * @requires:
	 * 
	 * R.1) Lokums are next to each other. That is:
	 * Either
	 * Absolute value of difference between their X values is 1.
	 * Or
	 * Absolute value of difference between their Y values is 1.
	 *
	 * R.2) (implicit by the signature)	l0 and l1 are indeed instances of the class Lokum. (That is:
	 * 									either of them are is not an obstacle).
	 * 
	 *	@ensures:
	 *  
	 *  E.1) l0 is placed in old place of l1.
	 *  E.2) l1 is placed in old place of l0.
	 *  E.3) The rest of the board is untouched.
	 *  
	 *	@modifies:
	 *
	 *	M.1) LogicField[][] lokums.
	 *	M.2) EventDispatchQuenue eventDispatchQuenue.
	 *	M.3) BoardLogic instance.
	 *
	 *	DEFINITION
	 *	This method takes two positions and does the appropriate swapping operation between them.
	 */
	private boolean swap(LogicField f0, LogicField f1){
		/*
		 * NOTE: This method allows swapping of the same lokums (That is: Arguments pointing to the exact same object.). Check if that would cause a problem. 
		 */

		/*
		 * If locations are not suitable for swap, simply return w/o doing anything.
		 */
		if( !locationsSuitableForSwap(f0, f1) )
			return false;
		// if here, then locations are suitable for swap.
		/*
		 * If types are not suitable for swap, simply return w/o doing anything.
		 */
		if( !typesSuitableForSwap(f0, f1) )
			return false;
		// if here, then types are suitable for swap as well.
		/*
		 * ADD LOKUM RETURNING LIST FOR MERGE DESTROY AS WELL.
		 */
		if( isMergeSwap( f0, f1 ) ){
			mergeDestroy( (MergeDestroyable) f0, (MergeDestroyable) f1 );
		}
		// if here, then not merge swap. So combo swap.
		else{
			ArrayList<Combo> combos = getCombos();
			for(int i=0;i<combos.size();i++){
				Combo currentCombo = combos.get(i);
				ArrayList<Lokum> currentCombosComboDestroyables = currentCombo.getComboLokums();
				for(int j=0;j<currentCombosComboDestroyables.size();j++){
					ComboDestroyable comboDestroyer = (ComboDestroyable)currentCombosComboDestroyables.get(i);
					comboDestroyer.comboDestroy();
				}
			}
			// send comboDestroyedFields to Kugi.
			// How does kugi get new generated lokums in this implementation?
			// We are changing this sending all destroyed lokums approach to sending one destroyed lokum at a time approach.
			// Hence, the line below is deprecated now, I commented out it just as a remainder
			// EventDispatchQueue.getInstance().addEvent(new NonLokumGeneratingEvent(convertLogicFieldListToEmptyLogicFieldList(comboDestroyedFields)));
		}
		return true;
	}
	
	/**
	 * @requires:
	 * R.0 Either of the arguments is instanceof MergeDestroyable.
	 */
	public void mergeDestroy( MergeDestroyable f0, MergeDestroyable f1 ){
		Merge merge = Factory.createMerge( f0, f1);
		merge.destroyMerge();
	}
	/**
	 * @requires:
	 * R.0 ( f0 instanceof SwappableLogicField ) && ( f1 instanceof SwappableLogicField ) 
	 */
	private boolean isMergeSwap(LogicField f0, LogicField f1){
		if ( ( f0 instanceof MergeDestroyable ) || ( f1 instanceof MergeDestroyable ) )
			return true;
		return false;
	}
	
	private boolean locationsSuitableForSwap(LogicField f0, LogicField f1){
		/*
		 * NOTE: This checker allows swapping of the same lokums (That is: Arguments pointing to the exact same object.). Check if that would cause a problem. 
		 */
		
		int xDifference = Math.abs(f0.getRowIndex() - f1.getRowIndex());
		int yDifference = Math.abs(f0.getColumnIndex() - f1.getColumnIndex());
		
		if((xDifference + yDifference) > 2)
			return false;
		return true;
	}
	
	private boolean typesSuitableForSwap(LogicField f0, LogicField f1){
		if ( !LogicField.isSwapable(f0) || !LogicField.isSwapable(f1) )
			return false;
		return true;
	}
	
	public LogicField getLogicFieldAt(int x, int y){
		return logicFields[x][y];
	}
	
	public boolean isBoardStabilized(){
		ArrayList<Combo> combos = getCombos();
		return ( combos.size() == 0 ) ;
	}
	
	public boolean isMoveAvailable(){
		return true;
	}
	
	private void scoreUpdate(Combo combo){
		
	}
	
	private ArrayList<Combo> getCombos(){
		return null;
	}
	
	/**
	 * -Shuffles the board. That is: Forms a new board using the existing LogicFields in the board. To do so, we will have a method named "unconditionalSwap" that will swap
	 * the given LogicField with a random LogicField from the board. This operation will be done for all LogicFields in the board. Then the method will return.
	 * 
	 * -Alternatively, at the beginning, you can take a copy of the board and make this copy into a new data structure which holds an additional boolean field named
	 * "isSwapped". And the method would be as follows: In a loop, the upper half of the board will be traversed. In this loop, at each iteration, a random LogicField from
	 * the lower half will be selected. If this element is not swapped, then the current element will be swapped with that. Else, the element that is next to this element
	 * will be checked and if it is not swapped as well, then it will be swapped with that element.
	 * 
	 * -Yet as another alternative, you can pick the lokums to be swapped not in a random fashion, but it a "pseudo - random" fashion.
	 */
	public void shuffleBoard(){
		Random rnd = new Random();
	    for (int i = logicFields.length - 1; i > 0; i--){
	    	int rowIndex = rnd.nextInt(i + 1);
	    	for(int j = logicFields[i].length - 1; j > 0; j--){
	    		int columnIndex = rnd.nextInt(j + 1);
	    		LogicField temp = logicFields[i][j];
	    		logicFields[i][j] = logicFields[rowIndex][columnIndex];
	    		logicFields[rowIndex][columnIndex] = temp;
	    	}
	    }
	}

	public void swap(int selectedColumn, int selectedRow, int otherColumn, int otherRow) {
		swap(logicFields[selectedRow][selectedColumn], logicFields[selectedRow][selectedColumn]);
	}
	
	private ArrayList<LogicField> copyLogicFieldList(ArrayList<LogicField> logicFields){
		ArrayList<LogicField> copyLogicFields = new ArrayList<LogicField>();
		for(LogicField logicField: logicFields)
			copyLogicFields.add(logicField.copyLogicField());
		
		return logicFields;
	}
	
	private ArrayList<EmptyLogicField> convertLogicFieldListToEmptyLogicFieldList(ArrayList<LogicField> logicFields){
		ArrayList<EmptyLogicField> emptyLogicFields = new ArrayList<EmptyLogicField>();
		for(LogicField logicField: logicFields){
			logicField = new EmptyLogicField(logicField.getRowIndex(), logicField.getColumnIndex());
			emptyLogicFields.add((EmptyLogicField)logicField);
		}
		return  emptyLogicFields;
	}

}
