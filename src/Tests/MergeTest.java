package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import App.BoardLogic;
import App.Merge;
import App.Score;
import Tests.BoardLogicTest;

public class MergeTest {
	BoardLogic mergeTestBoard;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mergeTestBoard = BoardLogic.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDestroyMerge(Merge testMerge) {
		System.out.println("Board before combo destroy: \n");
		System.out.println("Score before combo destroy: " + Score.getInstance().getCurrentScore());
		System.out.println(BoardLogicTest.toString(mergeTestBoard));
		testMerge.destroyMerge();
//		Check if destroyed lokums are replaced with emptyLogicField
//		Check if the Board is changed
		System.out.println("Board after combo destroy: \n");
		System.out.println("Score before after destroy: " + Score.getInstance().getCurrentScore());
		System.out.println(BoardLogicTest.toString(mergeTestBoard));
	}

}
