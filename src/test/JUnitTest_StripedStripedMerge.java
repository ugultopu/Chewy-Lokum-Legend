package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import App.BoardLogic;
import App.BombLokum;
import App.BombMerge;
import App.HorizontalStripedLokum;
import App.NormalLokum;
import App.StripedStripedMerge;
import App.VerticalStripedLokum;
import App.WrappedLokum;

public class JUnitTest_StripedStripedMerge {
	BoardLogic boardLogic;
	BombLokum bombLokum;
	NormalLokum normalTest;
	HorizontalStripedLokum horizontalStripedTest;
	VerticalStripedLokum verticalStripedTest;
	WrappedLokum wrappedTest;
	BombLokum bombTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.boardLogic = BoardLogic.getInstance();

		this.bombLokum = new BombLokum(boardLogic.getRowSize()/2, boardLogic.getColumnSize()/2);
		boardLogic.introduceLogicField(bombLokum);

		this.normalTest = new NormalLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2, "White");
		boardLogic.introduceLogicField(normalTest);

		this.horizontalStripedTest = new HorizontalStripedLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2, "White");
		boardLogic.introduceLogicField(horizontalStripedTest);

		this.verticalStripedTest = new VerticalStripedLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2, "White");
		boardLogic.introduceLogicField(verticalStripedTest);

		this.wrappedTest = new WrappedLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2, "White");
		boardLogic.introduceLogicField(wrappedTest);

		this.bombTest = new BombLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2);
		boardLogic.introduceLogicField(bombTest);

		System.out.println("--------------------------------------------------Test Start--------------------------------------------------");

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("--------------------------------------------------Test End--------------------------------------------------");
	}

	@Test
	public void testDestroyMerge() {
		System.out.println("Board just BEFORE calling Striped - Striped merge:");
		boardLogic.toString();
		StripedStripedMerge stripedStripedMerge = new StripedStripedMerge(bombLokum, horizontalStripedTest);
		stripedStripedMerge.destroyMerge();
		System.out.println("Board just AFTER calling Striped - Striped merge:");
		boardLogic.toString();
	}

}
