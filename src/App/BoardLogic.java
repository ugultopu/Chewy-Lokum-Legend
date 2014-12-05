package App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import Tests.BoardLogicTest;

import com.sun.org.apache.bcel.internal.generic.DALOAD;


public class BoardLogic {

	private LogicField[][] logicFields;
	private int rowSize;
	private int columnSize;
	private ArrayList<Combo> boardCombos;
	private static BoardLogic instance;


	/*
	 * CHECK!
	 */
	public static BoardLogic getInstance(){
		if(instance == null)
			instance = new BoardLogic();
		return instance;
	}
	
	public static void loadBoard(LogicField[][] logicFields){
		instance = new BoardLogic(logicFields);
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



	public ArrayList<Combo> findBoardCombos(){

		/*
		 * Clear current board combos before beginning a new search.
		 */
		boardCombos.clear();
		/*
		 * Then, create a temporary set, where each found combo will first be put in this set. This is done for automatically eliminating any duplicate combos.
		 */
		HashSet<Combo> combosAsSet = new HashSet<Combo>();
		/*
		 * Then, start searching for combos.
		 */
		for(int currentRowIndex=0;currentRowIndex<rowSize;currentRowIndex++){
			for(int currentColumnIndex=0;currentColumnIndex<columnSize;currentColumnIndex++){
				LogicField currentLogicField = logicFields[currentRowIndex][currentColumnIndex];
				/*
				 * In order to be subject to the combo search, currentLogicField must be an instance of Lokum AND it MUST NOT be an instance of BombLokum.
				 */
				if( (currentLogicField instanceof Lokum) && !(currentLogicField instanceof BombLokum) ){
					Lokum currentLokum = (Lokum) currentLogicField;
					ArrayList<Combo> currentLokumCombos = currentLokum.getCombosThisLokumIn();
					for(int currentLokumComboIndex=0;currentLokumComboIndex<currentLokumCombos.size();currentLokumComboIndex++){
						combosAsSet.add(currentLokumCombos.get(currentLokumComboIndex));
					}
				}
			}
		}
		/*
		 * After the search for combos is finished, convert the Set into an Object array, by using the built in method: toArray().
		 */
		Object[] combosAsObjectArray = combosAsSet.toArray();
		/*
		 * After that, finally put every element in this array to the boardCombos field of the BoardLogic.
		 */
		for(int i=0;i<combosAsObjectArray.length;i++){
			boardCombos.add((Combo) combosAsObjectArray[i]);
		}
		return this.boardCombos;
	}

	private BoardLogic(){
		this.rowSize = Constants.BOARD_WIDTH;
		this.columnSize= Constants.BOARD_HEIGHT;
		logicFields = new LogicField[Constants.BOARD_WIDTH][Constants.BOARD_HEIGHT];
		boardCombos = new ArrayList<Combo>();
		initializeBoard();	// initializes the board to all EmptyLogicField objects.
		populateBoard();	// populates the board at the beginning. (or at any time. Decide on this.)
		NewBoardEvent newBoardEvent = new NewBoardEvent(copyLogicFieldArray());
		EventDispatchQueue.getInstance().addEvent(newBoardEvent);
		this.boardCombos = new ArrayList<Combo>();
	}
	
	/**
	 * This constructor is only used on Load game
	 */
	private BoardLogic(LogicField[][] logicFields){
		this.rowSize = Constants.BOARD_WIDTH;
		this.columnSize = Constants.BOARD_HEIGHT;
		this.logicFields = logicFields;
		NewBoardEvent newBoardEvent = new NewBoardEvent(copyLogicFieldArray());
		EventDispatchQueue.getInstance().addEvent(newBoardEvent);
		this.boardCombos = new ArrayList<Combo>();
	}
	
	
	/**
	 * This method firstly populates the board with random lokums. Then, it checks the board
	 * to observe if there are any combos in it. If there are, it destroys them and refills
	 * the board. If there are still combos, this operation is iterated until there are no
	 * combos left.
	 */
	private void initializeBoard(){
		for(int i=0;i<columnSize;i++)
			initializeColumn(i);
	}
	
	void readjustAfterInitialize(){
		destroyCombos();
		readjustBoardAfterDestroy();
	}
	
	private void destroyCombos(){
		findBoardCombos();
		for(int currentComboIndex=0;currentComboIndex<boardCombos.size();currentComboIndex++){
			Combo currentCombo = boardCombos.get(currentComboIndex);
			ArrayList<Lokum> currentComboLokums = currentCombo.getComboLokums();
			for(int currentComboLokumIndex=0;currentComboLokumIndex<currentComboLokums.size();currentComboLokumIndex++){
				Lokum currentCombosCurrentLokum = currentComboLokums.get(currentComboLokumIndex);
				currentCombosCurrentLokum.comboDestroy();
			}
			if(currentCombo instanceof LokumGeneratingCombo){
				introduceLogicField(currentCombo.getGeneratedLokum());
				currentCombo.addGeneratedLokumtoQueue();
			}
		}
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
	public void readjustBoardAfterDestroy(){
		HashMap<LogicField, Integer> fallingLogicFields = new HashMap<LogicField, Integer>();
		levelBoard(fallingLogicFields);
		populateAfterDestroy(fallingLogicFields);
		GameEvent fallingLokumsEvent = new FallingLokumsEvent(fallingLogicFields);
		EventDispatchQueue.getInstance().addEvent(fallingLokumsEvent);
		NewBoardEvent newBoardEvent = new NewBoardEvent(copyLogicFieldArray());
		EventDispatchQueue.getInstance().addEvent(newBoardEvent);
		// send fallingLogicFields to Kugi.
		/*
		 * If board is not yet stabilized, call the method again.
		 */
		if ( !isBoardStabilized() ){
			destroyCombos();
			readjustBoardAfterDestroy();
		}
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
	 * calculates if there are more contiguously empty fields that are above the given position and
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
			if(currentRowIndex == rowSize)
				break;
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
			if( !(getLogicFieldAt(i+dropCounter, columnIndex) instanceof EmptyLogicField) ){
				fallingLogicFields.put(getLogicFieldAt(i+dropCounter, columnIndex).copyLogicField(), dropCounter);
			}
			logicFields[i+dropCounter][columnIndex].setRowIndex(i);
			introduceLogicField(logicFields[i+dropCounter][columnIndex]);
			clearLocation(i + dropCounter, columnIndex);
		}
		return currentRowIndex == rowSize;
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
			if(currentRowIndex == -1)
				break;
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
	public boolean swap(LogicField f0, LogicField f1){
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
			mergeDestroy( f0,  f1 );
			readjustBoardAfterDestroy();
		}
		// if here, then not merge swap. So combo swap.
		else{
			/*
			 * If here, then this means that this swap is a swap that requires the swapping of LogicFields on logicFields array. So perform it.
			 */
			locationSwap(f0, f1);
			/*
			 * Then, send a swap event to Kugi.
			 */
			EventDispatchQueue.getInstance().addEvent(new SwapEvent((Lokum)f0.copyLogicField(), (Lokum)f1.copyLogicField()));
			/*
			 * Then, check for combos.
			 */

			//findBoardCombos();
			destroyCombos();
			readjustBoardAfterDestroy();
			/*
			 * After checking for combos, check if there are any combos actually. If not, revert the swap and return from the method.
			 */
			if(boardCombos.size() == 0){
				/*
				 * If here, then swap did not yield any combos. So revert the swap and return from the method.
				 */
				locationSwap(f0, f1);
				/*
				 * Send a swap event to Kugi.
				 */
				EventDispatchQueue.getInstance().addEvent(new SwapEvent((Lokum)f0.copyLogicField(), (Lokum)f1.copyLogicField()));
				return false;
			}
			/*
			 * If here, then there were indeed combos present. So find them and execute them. 
			 */

			for(int currentComboIndex=0;currentComboIndex<boardCombos.size();currentComboIndex++){
				Combo currentCombo = boardCombos.get(currentComboIndex);
				ArrayList<Lokum> currentCombosLokums = currentCombo.getComboLokums();
				for(int currentCombosLokumIndex=0;currentCombosLokumIndex<currentCombosLokums.size();currentCombosLokumIndex++){
					Lokum currentLokum = currentCombosLokums.get(currentCombosLokumIndex);
					((ComboDestroyable) currentLokum).comboDestroy();
				}
			}
			// send comboDestroyedFields to Kugi.
			// How does kugi get new generated lokums in this implementation?
			// We are changing this sending all destroyed lokums approach to sending one destroyed lokum at a time approach.
			// Hence, the line below is deprecated now, I commented out it just as a remainder
			// EventDispatchQueue.getInstance().addEvent(new NonLokumGeneratingEvent(convertLogicFieldListToEmptyLogicFieldList(comboDestroyedFields)));
		}
		InformationBoard.getInstance().decreaseMoves();
		return true;
	}

	/**
	 * This method performs the immediate swapping of the given two LogicFields. 
	 * @param f0
	 * @param f1
	 */
	private void locationSwap(LogicField f0, LogicField f1){
		int f0sInitialRowIndex = f0.getRowIndex();
		int f0sInitialColumnIndex = f0.getColumnIndex();
		f0.setRowIndex(f1.getRowIndex());
		f0.setColumnIndex(f1.getColumnIndex());
		f1.setRowIndex(f0sInitialRowIndex);
		f1.setColumnIndex(f0sInitialColumnIndex);
		introduceLogicField(f0);
		introduceLogicField(f1);
	}

	/**
	 * @requires:
	 * R.0 Either of the arguments is instanceof MergeDestroyable.
	 */
	public void mergeDestroy( LogicField f0, LogicField f1 ){
		Merge merge = Factory.createMerge( (Lokum) f0, (Lokum) f1);
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

	private boolean isSwapPossible(LogicField f0, LogicField f1){
		if( (f0 == null) || (f1 == null) )
			return false;
		if(!locationsSuitableForSwap(f0, f1))
			return false;
		if(!typesSuitableForSwap(f0, f1))
			return false;
		return true;
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

	public LogicField getLogicFieldAt(int rowIndex, int columnIndex){
		if( isRowIndexInBoundaries(rowIndex) && isColumnIndexInBoundaries(columnIndex) )
			return logicFields[rowIndex][columnIndex];
		else
			return null;
	}

	private boolean isRowIndexInBoundaries(int rowIndex){
		if( (rowIndex >= 0) && (rowIndex < this.rowSize) )
			return true;
		return false;
	}

	private boolean isColumnIndexInBoundaries(int columnIndex){
		if( (columnIndex >= 0) && (columnIndex < this.columnSize) )
			return true;
		return false;
	}

	public boolean isBoardStabilized(){
		findBoardCombos();
		return ( boardCombos.size() == 0 ) ;
	}

	public boolean isMoveAvailable(){
		int currentRowIndex;
		int currentColumnIndex;
		LogicField currentLogicField;
		LogicField currentNorthWestLogicField;
		LogicField currentNorthLogicField;
		LogicField currentNorthEastLogicField;
		LogicField currentEastLogicField;

		for(currentRowIndex=0;currentRowIndex<rowSize;currentRowIndex++){
			for(currentColumnIndex=0;currentColumnIndex<columnSize;currentColumnIndex++){

				currentLogicField = getLogicFieldAt(currentRowIndex, currentColumnIndex);
				currentNorthWestLogicField = getLogicFieldAt(currentRowIndex + 1, currentColumnIndex - 1);
				currentNorthLogicField = getLogicFieldAt(currentRowIndex + 1, currentColumnIndex);
				currentNorthEastLogicField = getLogicFieldAt(currentRowIndex + 1, currentColumnIndex + 1);
				currentEastLogicField = getLogicFieldAt(currentRowIndex, currentColumnIndex + 1);

				if(isSwapPossible(currentLogicField, currentNorthWestLogicField)){
					locationSwap(currentLogicField, currentNorthWestLogicField);
					findBoardCombos();
					locationSwap(currentLogicField, currentNorthWestLogicField);
					if(boardCombos.size() != 0)
						return true;
				}

				if(isSwapPossible(currentLogicField, currentNorthLogicField)){
					locationSwap(currentLogicField, currentNorthLogicField);
					findBoardCombos();
					locationSwap(currentLogicField, currentNorthLogicField);
					if(boardCombos.size() != 0)
						return true;
				}

				if(isSwapPossible(currentLogicField, currentNorthEastLogicField)){
					locationSwap(currentLogicField, currentNorthEastLogicField);
					findBoardCombos();
					locationSwap(currentLogicField, currentNorthEastLogicField);
					if(boardCombos.size() != 0)
						return true;
				}

				if(isSwapPossible(currentLogicField, currentEastLogicField)){
					locationSwap(currentLogicField, currentEastLogicField);
					findBoardCombos();
					locationSwap(currentLogicField, currentEastLogicField);
					if(boardCombos.size() != 0)
						return true;
				}
			}
		}
		return false;
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
		swap(logicFields[selectedRow][selectedColumn], logicFields[otherRow][otherColumn]);
	}

	private LogicField[][] copyLogicFieldArray(){
		LogicField[][] copyLogicFields = new LogicField[Constants.BOARD_WIDTH][Constants.BOARD_HEIGHT];
		for(int i=0; i<logicFields.length; i++)
			for(int j=0; j<logicFields[i].length;j++)
				copyLogicFields[i][j] = logicFields[i][j].copyLogicField();

		return copyLogicFields;
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
