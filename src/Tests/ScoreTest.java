package Tests;

import java.util.ArrayList;

import org.junit.*;

import App.BoardLogic;
import App.BombLokum;
import App.BombMerge;
import App.EmptyLogicField;
import App.FiveCombo;
import App.FourCombo;
import App.HorizontalStripedLokum;
import App.LCombo;
import App.LogicField;
import App.Lokum;
import App.NormalLokum;
import App.Score;
import App.StripedLokum;
import App.StripedStripedMerge;
import App.StripedWrappedMerge;
import App.ThreeCombo;
import App.VerticalStripedLokum;
import App.WrappedLokum;
import App.WrappedWrappedMerge;
import static org.junit.Assert.*;

public class ScoreTest {
	
	private BoardLogic bl = App.BoardLogic.getInstance();
	
    @Before
    public void setUp() {
    	Score.resetInstance();
        for(int i = 0; i < bl.getColumnSize(); i++){
        	for(int j = 0; j < bl.getRowSize(); j++){
        		EmptyLogicField elf = new EmptyLogicField(i, j);
        		bl.introduceLogicField(elf);
        	}
        }
        
    }


    @After
    public void tearDown() {
      System.out.println("---------Test End--------");
    }
    
    @Test
    public void threeComboTest() {
        System.out.println("-------Three Combo Score Test------");
        NormalLokum n1 = new NormalLokum(0, 0, "red");
        NormalLokum n2 = new NormalLokum(0, 1, "red");
        NormalLokum n3 = new NormalLokum(0, 2, "red");
       
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        
        for(int i = 0; i < 3; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        ThreeCombo testThree = new ThreeCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(60, Score.getInstance().getCurrentScore());
    }

    @Test
    public void LComboTest() {
    	System.out.println("-------L Combo Score Test------");
    	NormalLokum n1 = new NormalLokum(0, 0, "red");
        NormalLokum n2 = new NormalLokum(0, 1, "red");
        NormalLokum n3 = new NormalLokum(0, 2, "red");
        NormalLokum n4 = new NormalLokum(1, 2, "red");
        NormalLokum n5 = new NormalLokum(2, 2, "red");
        
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        comboLokums.add(n4);
        comboLokums.add(n5);
        
        for(int i = 0; i < 5; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        LCombo testThree = new LCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(200, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void TComboTest() {
    	System.out.println("-------T Combo Score Test------");
    	NormalLokum n1 = new NormalLokum(1, 0, "red");
        NormalLokum n2 = new NormalLokum(1, 1, "red");
        NormalLokum n3 = new NormalLokum(1, 2, "red");
        NormalLokum n4 = new NormalLokum(0, 2, "red");
        NormalLokum n5 = new NormalLokum(2, 2, "red");
        
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        comboLokums.add(n4);
        comboLokums.add(n5);
        
        for(int i = 0; i < 5; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        LCombo testThree = new LCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(200, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void fourComboTest() {
    	System.out.println("-------Four Combo Score Test------");
    
    	NormalLokum n1 = new NormalLokum(1, 0, "red");
        NormalLokum n2 = new NormalLokum(1, 1, "red");
        NormalLokum n3 = new NormalLokum(1, 2, "red");
        NormalLokum n4 = new NormalLokum(1, 3, "red");
        
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        comboLokums.add(n4);
        
        for(int i = 0; i < 4; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        FourCombo testThree = new FourCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(120, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void fiveComboTest() {
    	System.out.println("-------Five Combo Score Test------");
    
    	NormalLokum n1 = new NormalLokum(1, 0, "red");
        NormalLokum n2 = new NormalLokum(1, 1, "red");
        NormalLokum n3 = new NormalLokum(1, 2, "red");
        NormalLokum n4 = new NormalLokum(1, 3, "red");
        NormalLokum n5 = new NormalLokum(1, 4, "red");
        
        ArrayList<Lokum> comboLokums = new ArrayList<Lokum>();
        comboLokums.add(n1);
        comboLokums.add(n2);
        comboLokums.add(n3);
        comboLokums.add(n4);
        comboLokums.add(n5);
        
        for(int i = 0; i < 5; i++){
        	bl.introduceLogicField(comboLokums.get(i));
        }
        
        System.out.println(BoardLogicTest.toString(bl));
        
        FiveCombo testThree = new FiveCombo(comboLokums);
        testThree.updateScore();
        
        assertEquals(200, Score.getInstance().getCurrentScore());
    }
    
    @Test
    
    public void verticalStripedUseTest(){
    	System.out.println("-----Vertical Striped Use Score Test-----");
    	VerticalStripedLokum vsl = new VerticalStripedLokum(0, 0, "red");
  
    	bl.introduceLogicField(vsl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	vsl.comboDestroy();
    	
    	assertEquals(bl.getRowSize() * 60, Score.getInstance().getCurrentScore());
    	
    }
    
    @Test
    
    public void horizontalStripedUseTest(){
    	System.out.println("-----Horizontal Striped Use Score Test-----");
    	HorizontalStripedLokum vsl = new HorizontalStripedLokum(0, 0, "red");
  
    	bl.introduceLogicField(vsl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	vsl.comboDestroy();
    	
    	assertEquals(bl.getColumnSize() * 60, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void wrappedUseTest(){
    	System.out.println("-----Wrapped Use Score Test-----");
    	WrappedLokum wl = new WrappedLokum(0, 0, "red");
  
    	bl.introduceLogicField(wl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	wl.comboDestroy();
    	
    	assertEquals(1080, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void bombUseTest(){
    	System.out.println("----Bomb + Normal Lokum Use Score Update Test-----");
    	for(int i = 0; i < bl.getColumnSize(); i++){
    		for(int j = 0; j < bl.getRowSize(); j++){
    			NormalLokum nl = new NormalLokum(i, j, "red");
    			bl.introduceLogicField(nl);
    		}
    	}
    	
    	BombLokum bombLokum = new BombLokum(0, 0);
    	bl.introduceLogicField(bombLokum);
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	BombMerge bm = new BombMerge(bombLokum, bl.getLogicFieldAt(0, 1));
    	bm.destroyMerge();
    	
    	assertEquals(384000, Score.getInstance().getCurrentScore());
    	
    	
    	
    	
    }
    
    
    
    @Test
    public void bombBombMergeTest() {
    	System.out.println("-------Bomb + Bomb Merge Score Test------");
    	
    	BombLokum bomb1 = new BombLokum(0, 0);
    	BombLokum bomb2 = new BombLokum(0, 1);
    	
    	bl.introduceLogicField(bomb1);
    	bl.introduceLogicField(bomb2);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	BombMerge bm = new BombMerge(bomb1, bomb2);
    	bm.destroyMerge();
    	
    	assertEquals(81 * 81 * 100, Score.getInstance().getCurrentScore());
    }
    
    @Test
    
    public void wrappedWrappedMergeTest(){
    	System.out.println("------Wrapped+Wrapped Merge Score Test-------");
    	
    	WrappedLokum wl1 = new WrappedLokum(0, 0, "red");
    	WrappedLokum wl2 = new WrappedLokum(0, 1, "red");
    	
    	bl.introduceLogicField(wl1);
    	bl.introduceLogicField(wl2);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	WrappedWrappedMerge wwm = new WrappedWrappedMerge(wl1, wl2);
    	wwm.destroyMerge();
    	
    	assertEquals(3600, Score.getInstance().getCurrentScore());
    }
    
    
    
    @Test
    public void stripedStripedMergeTest() {
    	System.out.println("-------Striped Striped Score Test------");
    	
    	VerticalStripedLokum vsl = new VerticalStripedLokum(0, 0, "red");
    	HorizontalStripedLokum hsl = new HorizontalStripedLokum(0, 1, "red");
    	
    	bl.introduceLogicField(vsl);
    	bl.introduceLogicField(hsl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	StripedStripedMerge ssm = new StripedStripedMerge(vsl, hsl);
    	ssm.destroyMerge();
    	
    	assertEquals(60 * (bl.getRowSize() + bl.getColumnSize()), Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void stripedWrappedMergeTest() {
    	System.out.println("-------Wrapped + Striped Score Test------");
    	
    	VerticalStripedLokum vsl = new VerticalStripedLokum(3, 3, "red");
    	WrappedLokum wl = new WrappedLokum(3, 4, "red");
    	
    	bl.introduceLogicField(vsl);
    	bl.introduceLogicField(wl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	StripedWrappedMerge ssm = new StripedWrappedMerge(vsl, wl);
    	ssm.destroyMerge();
    	
    	assertEquals(3 * (60 * (bl.getRowSize() + bl.getColumnSize())), Score.getInstance().getCurrentScore());
    }
    
    @Test 
    public void wrappedBombMergeTest(){
    	System.out.println("-------Wrapped + Bomb Score Test------");
    	
    	BombLokum bomb = new BombLokum(3, 3);
    	WrappedLokum wl = new WrappedLokum(3, 4, "red");
    	
    	bl.introduceLogicField(bomb);
    	bl.introduceLogicField(wl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	BombMerge bm = new BombMerge(bomb, wl);
    	bm.destroyMerge();
    	
    	assertEquals(0, Score.getInstance().getCurrentScore());
    }
    
    @Test
    public void stripedBombMergeTest(){
    	System.out.println("-------Striped + Bomb Score Test------");
    	
    	BombLokum bomb = new BombLokum(3, 3);
    	VerticalStripedLokum vsl = new VerticalStripedLokum(3, 4, "red");
    	
    	for(int i = 5; i < 7 ; i++){
    		for(int j = 5; j < 7; j++){
    			NormalLokum nl = new NormalLokum(i, j, "red");
    			bl.introduceLogicField(nl);
    		}
    	}

    	bl.introduceLogicField(bomb);
    	bl.introduceLogicField(vsl);
    	
    	System.out.println(BoardLogicTest.toString(bl));
    	
    	BombMerge bm = new BombMerge(bomb, vsl);
    	bm.destroyMerge();
    	
    	assertEquals(0 , Score.getInstance().getCurrentScore());
    }
}