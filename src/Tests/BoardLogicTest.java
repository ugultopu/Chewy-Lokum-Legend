package Tests;
import App.*;
import java.util.ArrayList;

public class BoardLogicTest{
	private static BoardLogic stabilityBoard;
	private static BoardLogic moveAvailableBoard;
	private static BoardLogic fallLokumsBoard;
	private static LogicField l1;
	private static LogicField l2;
	private static BoardLogic swapBoard;
	private static BoardLogic findLokumComboBoard;
	private static ArrayList<Combo> comboList;
	private static BoardLogic destroyLokumCombosBoard;
	private static BoardLogic shuffleBoard;

	public static setUP(){
		/* ... */
	}

   
    public static void boardShuffleTest(){
        setUp();

        String initial = shuffleBoard.toString()
        shuffleBoard.boardShuffle()
        /* Checks if the initial board and shuffled board are same. If they are same the
         shuffleing proccess is failed.*/
        if(initial.equals(shuffledBoard.toString))
            System.out.println("BoardShuffleTest Fail");
        else
            System.out.println("BoardShuffleTest Success");
    }

    public static Boolean isMergeDestroyTest(){
        setUp();
        if(l1.instanceOf(SpecialLokum) || l2.instanceOf(SpecialLokum){
            System.out.println("Test isMergeDestroy Successful");
        }else{
            System.out.println("Test isMergeDestroy Fail");
        }
    }	
		
	public static void destroyComboTest(){
	setUP();
	if(comboList!=null){
		System.out.println("Test succeeded.");
	} else {
		System.out.println("Test failed.");
	}
	
	
	
	System.out.println(destroyLokumCombosBoard.toString());
	System.out.println(EventDispatchQueue.toString());
	
	destroyLokumCombos(comboList);
	
//	We compare the previous and next states of the board and eventDispatchQueue.
	
	System.out.println(destroyLokumCombosBoard.toString());
//	Check if the lokums are destroyed
	
	System.out.println(EventDispatchQueue.toString);
//  Check if the right event is sent to EventDispatchQueue
	
	}
	
	public static void findLokumCombosTest(){
		setUP();
		if(findLokumComboBoard.repOK()){
			System.out.println("Board repOK succeeded.");
		} else{
			System.out.println("Board repOK is not succeeded.");
		}
		
//		Check if the corresponding lokums are selected from the board.		
		System.out.println(findLokumComboBoard.toString());
		System.out.println(findLokumComboBoard.findLokumCombos().toString());

		
	}

	public static void testSwap(){
		setUP();
		if(!l0.repOK() || !l1.repOK()){
			System.out.println("At least 1 lokum's representation is not OK at the beginning of swap(Lokum, Lokum).");
			return;
		}
			// if here, then both lokums' representations are OK.
		Location l0priorLocation = l0.getLocation;
		Location l1priorLocation = l1.getLocation;
		
		if(
				Math.abs(l0priorLocation.getX() - l1priorLocation.getX()) != 1
				&&
				Math.abs(l0priorLocation.getY() - l1priorLocation.getY()) != 1)
		{
			System.out.println("Lokums are not next to each other.");
			return;
		}
		System.out.println(swapBoard.toString());
		swapBoard.swap(l0, l1);
		if(!l0.repOK() || !l1.repOK()){
			System.out.println("At least 1 lokum's representation is not OK at the end of swap(Lokum, Lokum).");
			return;
		}
			
			// if here, then both lokums' representations are OK.
		if(!l0.getLocation.equals(l1priorLocation)){
			System.out.println("l0's new location is not equal to l1's prior location.");
			return;
		}
		if(!l1.getLocation.equals(l0priorLocation)){
			System.out.println("l1's new location is not equal to l0's prior location.");
			return;
		}
		/* See if the change appeared on the board and rest remains the same */
		System.out.println(swapBoard.toString());
	}

}

	public static void testCheckBoardStability(){
		
		setUP();
		/* Pre-conditions */
		stabilityBoard.repOK();
		
		/* Post-conditions */
		/* Look at the current state of the board see if there are any combos*/
		String previousState = stabilityBoard.toString();
		System.out.println(previousState)
		/* Look at the return value it should be true if there are no combos 
		on the previously printed board, else it should be false */ 
		System.out.println("Returned: "+stabilityBoard.checkBoardStability());

		/* Board state shouldn't change */
		String nextState = stabilityBoard.toString();
		if (previousState.equals(nextState))
			System.out.println("OK. Board hasn't changed.");
		else
			System.out.println("Error: Board has modified");
	}

	public static void testIsMoveAvailable(){
		
		setUP();
		/* Pre-conditions */
		moveAvailableBoard.repOK();

		/* Post-conditions */
		/* Look at the current state of the board see if there are any possible combo or merge making swap actions*/
		String previousState = moveAvailableBoard.toString();
		System.out.println(previousState);
		/* Look at the return value it should be false if there are no possible combo or merge making swap actions 
		on the previously printed board, else it should be true */ 
		System.out.println("Returned: "+moveAvailableBoard.isMoveAvailable());

		/* Board state shouldn't change */
		String nextState = moveAvailableBoard.toString();
		if (previousState.equals(nextState))
			System.out.println("OK. Board hasn't changed.");
		else
			System.out.println("Error: Board has modified");
	}

	public static void testFallLokums(){
		setUP();
		/* Pre-conditions */
		fallLokumsBoard.repOK();
		/* Is there at least one EmptyLogicField inside lokums */
		int count = 0;
		for(LogicField field: fallLokumsBoard.getLokums()){
			if (field instanceof EmptyLogicField)
				System.out.println("OK. There is at least one EmptyLogicField.");
				break;
			count++;
		}
		if(count==fallLokumsBoard.getLokums().size()){
			System.out.println("Error: There are no EmptyLogicField.");
		}

		/* initial state of board and eventDispatchQueue */
		System.out.println(fallLokumsBoard.toString());
		System.out.println(fallLokumsBoard.eventDispatchQueue.toString());

		fallLokumsBoard.fallLokums();
		
		/* Post-conditions and modifies */
		int count = 0;
		for(LogicField field: fallLokumsBoard.getLokums()){
			if (field instanceof EmptyLogicField)
				System.out.println("Error: There still is an EmptyLogicField!");
				break;
			count++;
		}
		if(count==fallLokumsBoard.getLokums().size()){
			System.out.println("OK. There are no EmptyLogicFields.");
		}

		/* look at last states of board and eventDispatchQueue, check if the correct lokums are fallen down and a new FallingLokumsEvent
		is adde to the eventDispatchQueue */

		System.out.println(fallLokumsBoard.toString());
		System.out.println(fallLokumsBoard.eventDispatchQueue.toString());
	}
}