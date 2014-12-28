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
import App.EmptyLogicField;
import App.HorizontalStripedLokum;
import App.NormalLokum;
import App.StripedLokum;
import App.VerticalStripedLokum;
import App.WrappedLokum;

public class JUnitTest_BombMerge {
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
		
		System.out.println("--------------------------------------------------Test Start--------------------------------------------------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("--------------------------------------------------Test End--------------------------------------------------");
	}

	@Test
	public void testDestroyMerge() {
		System.out.println("Board just BEFORE calling Bomb - Normal merge:");
		System.out.println(boardLogic);
		
		this.normalTest = new NormalLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2, "White");
		boardLogic.introduceLogicField(normalTest);
		
		BombMerge bombMerge = new BombMerge(bombLokum, normalTest);
		bombMerge.destroyMerge();
		System.out.println("Board just AFTER calling Bomb - Normal merge:");
		System.out.println(boardLogic);
		
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board just BEFORE calling Bomb - Horizontal Striped merge:");
		System.out.println(boardLogic);
		
		this.horizontalStripedTest = new HorizontalStripedLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2, "White");
		boardLogic.introduceLogicField(horizontalStripedTest);
		
		bombMerge = new BombMerge(bombLokum, horizontalStripedTest);
		bombMerge.destroyMerge();
		System.out.println("Board just AFTER calling Bomb - Horizontal Striped merge:");
		System.out.println(boardLogic);
		
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board just BEFORE calling Bomb - Vertical Striped merge:");
		System.out.println(boardLogic);
		
		this.verticalStripedTest = new VerticalStripedLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2, "White");
		boardLogic.introduceLogicField(verticalStripedTest);
		
		bombMerge = new BombMerge(bombLokum, verticalStripedTest);
		bombMerge.destroyMerge();
		System.out.println("Board just AFTER calling Bomb - Vertical Striped merge:");
		System.out.println(boardLogic);
		
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board just BEFORE calling Bomb - Wrapped merge:");
		System.out.println(boardLogic);
		
		this.wrappedTest = new WrappedLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2, "White");
		boardLogic.introduceLogicField(wrappedTest);
		
		bombMerge = new BombMerge(bombLokum, wrappedTest);
		bombMerge.destroyMerge();
		System.out.println("Board just AFTER calling Bomb - Wrapped merge:");
		System.out.println(boardLogic);
		
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board just BEFORE calling Bomb - Bomb merge:");
		System.out.println(boardLogic);
		
		this.bombTest = new BombLokum(boardLogic.getRowSize()/2-1, boardLogic.getColumnSize()/2);
		boardLogic.introduceLogicField(bombTest);
		
		bombMerge = new BombMerge(bombLokum, bombTest);
		bombMerge.destroyMerge();
		System.out.println("Board just AFTER calling Bomb - Bomb merge:");
		System.out.println(boardLogic);
	}

}
